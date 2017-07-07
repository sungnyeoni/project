package kdata.manager;

public class Student {
	private String stuNum;
	private String stuName;
	private String stuS;
	
	public Student(String stuNum, String stuName, String stuS) {
		super();
		this.stuNum = stuNum;
		this.stuName = stuName;
		this.stuS = stuS;
	}

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuS() {
		return stuS;
	}

	public void setStuS(String stuS) {
		this.stuS = stuS;
	}

	@Override
	public String toString() {
		return stuNum + "\t" + stuName + "\t" + stuS;
	}

}
