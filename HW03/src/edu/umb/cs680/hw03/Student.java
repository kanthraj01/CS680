package edu.umb.cs680.hw03;

public class Student {
	String name;
	int i20number;
	int yrsInState;
	String usAddr;
	String foreignAddr;
	String priorStateAddr;
	private StudentStatus status = null;
	float tuition;

	Student(String name, String usAddr, int yrsInState, int i20number, String foreignAddr, StudentStatus status) {
		this.name = name;
		this.usAddr = usAddr;
		this.yrsInState = yrsInState;
		this.i20number = i20number;
		this.foreignAddr = foreignAddr;
		this.status = status;
	}

	public float getTuition() {
		return tuition; // returns tuition total
	}

	public void setTuition(float tuition) {
		this.tuition = tuition; // sets tuition total
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int geti20number() {
		return i20number;
	}

	public void seti20number(int i20number) {
		this.i20number = i20number;
	}

	public int getYrsInState() {
		return yrsInState;
	}

	public void setYrsInState(int yrsInState) {
		this.yrsInState = yrsInState;
	}

	public String getUsAddr() {
		return usAddr;
	}

	public void setUsAddr(String usAddr) {
		this.usAddr = usAddr;
	}

	public String getForeignAddr() {
		return foreignAddr;
	}

	public void setForeignAddr(String foreignAddr) {
		this.foreignAddr = foreignAddr;
	}

	public String getPriorStateAddr() {
		return priorStateAddr;
	}

	public void setPriorStateAddr(String priorStateAddr) {
		this.priorStateAddr = priorStateAddr;
	}

	public StudentStatus getStatus() {
		return status;
	}

	public void setStatus(StudentStatus status) {
		this.status = status;
	}

}
