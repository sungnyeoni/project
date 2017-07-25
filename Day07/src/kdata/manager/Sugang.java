package kdata.manager;

import java.sql.Date;

public class Sugang {
	private String suNum;
	private String stuName;
	private String suCode;
	private String subName;
	private String suGrade;
	private Date suDate;


	public String getSuNum() {
		return suNum;
	}


	public void setSuNum(String suNum) {
		this.suNum = suNum;
	}


	public String getStuName() {
		return stuName;
	}


	public void setStuName(String stuName) {
		this.stuName = stuName;
	}


	public String getSuCode() {
		return suCode;
	}


	public void setSuCode(String suCode) {
		this.suCode = suCode;
	}


	public String getSubName() {
		return subName;
	}


	public void setSubName(String subName) {
		this.subName = subName;
	}


	public String getSuGrade() {
		return suGrade;
	}


	public void setSuGrade(String suGrade) {
		this.suGrade = suGrade;
	}


	public Date getSuDate() {
		return suDate;
	}


	public void setSuDate(Date suDate) {
		this.suDate = suDate;
	}


	public Sugang(String suNum, String stuName, String suCode, String subName, String suGrade, Date suDate) {
		super();
		this.suNum = suNum;
		this.stuName = stuName;
		this.suCode = suCode;
		this.subName = subName;
		this.suGrade = suGrade;
		this.suDate = suDate;
	}


	@Override
	public String toString() {
		return suNum + "\t" + stuName + "\t" + suCode + "\t" + subName + "\t" + suGrade + "\t" + suDate;
	}


}
