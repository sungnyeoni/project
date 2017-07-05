package kdata.manager;

//학생 정보만 저장하는 클래스
public class Student implements Comparable<Student>{

   private int num;
   private String name;
   private String address;
   private String phone;
   private int kor;
   private int eng;
   private int math;
   
   // 총점 구하기
   public int getTotal() {
	   return this.kor + this.eng + this.math;
   }
   
   public Student(int num, String name, String address, String phone, int kor, int eng, int math) {
	super();
	this.num = num;
	this.name = name;
	this.address = address;
	this.phone = phone;
	this.kor = kor;
	this.eng = eng;
	this.math = math;
   }

   public int getNum() {
      return num;
   }
   
   public void setNum(int num) {
      this.num = num;
   }
   
   public String getName() {
      return name;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public int compareTo(Student o) {
		
		return 0;
	}
   
}