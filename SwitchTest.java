package kdata.switchtest;

public class SwitchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int a=10;
	
	switch(a%2){
	case 0:
		System.out.println("짝수");
		break;
	case 1:
		System.out.println("홀수");
	}
	int b=70;
	switch(b/10){
	case 10:
	case 9:
	case 8:
		System.out.println("A학점");
		break;
	case 7:
	case 6:
		System.out.println("B학점");
		break;
	case 5:
	case 4:
		System.out.println("C학점");
		break;
	case 3:
		System.out.println("D학점");
		break;
	default:
		System.out.println("F학점");
	}
	}
}