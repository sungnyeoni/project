package kdata.jdbc;

import java.util.Scanner;

public class StudentManagerTest {

	public static void main(String[] args) {
		
		StudentManager stm = new StudentManager();
		stm.connect();
		
		int i = 0;
		
		while(i != 4){
			System.out.println("1. 학생정보 추가 \n2. 학생정보 출력 \n3. 학생정보 검색\n4. 종료");
			Scanner sc = new Scanner(System.in);
			i = sc.nextInt();
			
			switch(i){
			case 1:
				System.out.println("학번 입력"); 
				Scanner n = new Scanner(System.in);
				String num = n.next();
				System.out.println("이름 입력");
				String name = n.next();
				System.out.println("성별 입력");
				String gender = n.next();
				
				stm.insert(num, name, gender);
				
				break;
			case 2:
				stm.selectAll();
				break;
			case 3:
				Scanner sn = new Scanner(System.in);
				System.out.println("검색할 이름을 입력하세요.");
				String searchName = sn.next();

				stm.selectByName(searchName);
				break;
			}
		}
		System.out.println("프로그램을 종료합니다.");

	}

}
