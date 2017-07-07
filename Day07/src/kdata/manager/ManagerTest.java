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
					+ "4. ������û 5. �������� 6. ������� 7. �����Է� 8. ����");
			Scanner sc = new Scanner(System.in);
			i = sc.nextInt();
			switch(i){
			case 1:
				while(stuNum.length()!=9){
					System.out.println("�й� �Է� : ");
					stuNum = sc.next();
				}
				
				System.out.println("�̸� �Է� : ");
				stuName = sc.next();
				while(stuS.equals("��")==false & stuS.equals("��")==false){
					System.out.println("���� �Է� : ");
					stuS = sc.next();
				}
				
				Student s = new Student(stuNum, stuName, stuS);

				int r = manager.insert(s);
				if(r > 0)
					System.out.println(r+"���� "+"������ �߰��Ǿ����ϴ�.");
				else
					System.out.println("������ �߰����� �ʾҽ��ϴ�.");
				
				break;
			case 2:
				list = manager.selectAll();
				System.out.println("�й�\t�̸�\t����");
				for (Student p : list)
					System.out.println(p.toString());
				break;
					
			case 3:
				System.out.println("�̸� �Է� : ");
				stuName = sc.next();
				Student sn = manager.selectByName(stuName);
				System.out.println("�й�\t�̸�\t����");
				System.out.println(sn.toString());
				break;
				
			case 4:
				System.out.println("�й� �Է� : ");
				suNum = sc.next();
				System.out.println("���� �ڵ� : ");
				suCode = sc.next();

				int u = suManager.insert(suNum, suCode);
				if(u > 0)
					System.out.println(u+"���� "+"������ �߰��Ǿ����ϴ�.");
				else
					System.out.println("������ �߰����� �ʾҽ��ϴ�.");
				break;
			
			case 5:
				System.out.println("������ �й� �Է� : ");
				suNum = sc.next();
				if(suManager.delete(suNum)!=0)
					System.out.println("�����Ǿ����ϴ�.");
				else
					System.out.println("���� �̸��Դϴ�.");
				
			case 6:
				list2 = suManager.selectAll();
				System.out.println("�й�\t�̸�\t�����ڵ�\t���Ǹ�\t����\t��¥");
				for (Sugang p : list2)
					System.out.println(p.toString());
				break;
				
			case 7:
				System.out.println("���� �Է��� �й� �Է� : ");
				suNum = sc.next();
				System.out.println("���� �Է��� �����ڵ� �Է� : ");
				suCode = sc.next();
				System.out.println("���� �Է� : ");
				suGrade = sc.next();
				if(suManager.updateGrade(suNum,suCode,suGrade)==1)
					System.out.println("�ԷµǾ����ϴ�.");
				else
					System.out.println("���� �й��Դϴ�.");
			}

		}
		System.out.println("���α׷��� �����մϴ�.");
	}


}
