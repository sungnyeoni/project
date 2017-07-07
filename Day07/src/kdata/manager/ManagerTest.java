package kdata.manager;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerTest {

	public static void main(String[] args) throws SQLException {
		
		StudentManager manager = new StudentManager();
		SugangManager suManager = new SugangManager();
		String stuNum = "";
		String stuName = "";
		String stuS = "";
		String suNum = "";
		String suCode = "";
		String suGrade = "";
		List<Student> list = new ArrayList<>();
		List<Sugang> list2 = new ArrayList<>();
		
		int i = 0;
		
		while(i!=8){
			System.out.println("1. Insert 2. SelectAll 3. SearchName "
					+ "4. 수강신청 5. 수강삭제 6. 수강출력 7. 성적입력 8. 종료");
			Scanner sc = new Scanner(System.in);
			i = sc.nextInt();
			switch(i){
			case 1:
				while(stuNum.length()!=9){
					System.out.println("학번 입력 : ");
					stuNum = sc.next();
				}
				
				System.out.println("이름 입력 : ");
				stuName = sc.next();
				while(stuS.equals("남")==false & stuS.equals("여")==false){
					System.out.println("성별 입력 : ");
					stuS = sc.next();
				}
				
				Student s = new Student(stuNum, stuName, stuS);

				int r = manager.insert(s);
				if(r > 0)
					System.out.println(r+"개의 "+"정보가 추가되었습니다.");
				else
					System.out.println("정보가 추가되지 않았습니다.");
				
				break;
			case 2:
				list = manager.selectAll();
				System.out.println("학번\t이름\t성별");
				for (Student p : list)
					System.out.println(p.toString());
				break;
					
			case 3:
				System.out.println("이름 입력 : ");
				stuName = sc.next();
				Student sn = manager.selectByName(stuName);
				System.out.println("학번\t이름\t성별");
				System.out.println(sn.toString());
				break;
				
			case 4:
				System.out.println("학번 입력 : ");
				suNum = sc.next();
				System.out.println("과목 코드 : ");
				suCode = sc.next();

				int u = suManager.insert(suNum, suCode);
				if(u > 0)
					System.out.println(u+"개의 "+"정보가 추가되었습니다.");
				else
					System.out.println("정보가 추가되지 않았습니다.");
				break;
			
			case 5:
				System.out.println("삭제할 학번 입력 : ");
				suNum = sc.next();
				if(suManager.delete(suNum)!=0)
					System.out.println("삭제되었습니다.");
				else
					System.out.println("없는 이름입니다.");
				
			case 6:
				list2 = suManager.selectAll();
				System.out.println("학번\t이름\t강의코드\t강의명\t성적\t날짜");
				for (Sugang p : list2)
					System.out.println(p.toString());
				break;
				
			case 7:
				System.out.println("성적 입력할 학번 입력 : ");
				suNum = sc.next();
				System.out.println("성적 입력할 과목코드 입력 : ");
				suCode = sc.next();
				System.out.println("성적 입력 : ");
				suGrade = sc.next();
				if(suManager.updateGrade(suNum,suCode,suGrade)==1)
					System.out.println("입력되었습니다.");
				else
					System.out.println("없는 학번입니다.");
			}

		}
		System.out.println("프로그램을 종료합니다.");
	}


}
