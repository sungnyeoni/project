package kdata.switchtest;

public class SwitchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int a=10;
	
	switch(a%2){
	case 0:
		System.out.println("¦��");
		break;
	case 1:
		System.out.println("Ȧ��");
	}
	int b=70;
	switch(b/10){
	case 10:
	case 9:
	case 8:
		System.out.println("A����");
		break;
	case 7:
	case 6:
		System.out.println("B����");
		break;
	case 5:
	case 4:
		System.out.println("C����");
		break;
	case 3:
		System.out.println("D����");
		break;
	default:
		System.out.println("F����");
	}
	}
}