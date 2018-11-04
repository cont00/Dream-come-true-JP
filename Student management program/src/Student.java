public class Student {
	private int year;
	private int stu_class;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private String gender;
	private String remark;
	
	@Override
	public String toString() {
		return "Student [year = " + year + ", stu_class = " + stu_class + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ","
				+ "math=" + math + ", gender=" + gender + ", remark=" + remark + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStu_class() {
		return stu_class;
	}
	public void setStu_class(int stu_class) {
		this.stu_class = stu_class;
	}
}
