package kdata.jdbc;

import java.util.Scanner;

public class StudentManagerTest {

	public static void main(String[] args) {
		
		StudentManager stm = new StudentManager();
		stm.connect();
		
		int i = 0;
		
		while(i != 4){
			System.out.println("1. �л����� �߰� \n2. �л����� ��� \n3. �л����� �˻�\n4. ����");
			Scanner sc = new Scanner(System.in);
			i = sc.nextInt();
			
			switch(i){
			case 1:
				System.out.println("�й� �Է�"); 
				Scanner n = new Scanner(System.in);
				String num = n.next();
				System.out.println("�̸� �Է�");
				String name = n.next();
				System.out.println("���� �Է�");
				String gender = n.next();
				
				stm.insert(num, name, gender);
				
				break;
			case 2:
				stm.selectAll();
				break;
			case 3:
				Scanner sn = new Scanner(System.in);
				System.out.println("�˻��� �̸��� �Է��ϼ���.");
				String searchName = sn.next();

				stm.selectByName(searchName);
				break;
			}
		}
		System.out.println("���α׷��� �����մϴ�.");

	}

}
