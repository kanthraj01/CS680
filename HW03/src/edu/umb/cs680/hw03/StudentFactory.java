package edu.umb.cs680.hw03;



public class StudentFactory {
	
	public static Student createInStateStudent(String name, String usAddr)
	{
		return  new Student(name, usAddr, 0, 0,null, StudentStatus.INSTATE);
	}

	public static Student createOutStateStudent(String name, String usAddr, int yrsInState)
	{
		return new Student(name, usAddr, yrsInState, 0, null, StudentStatus.OUTSTATE);
	}

	public static Student createIntlStudent(String name, String usAddr, int i20num, String foreignAddr)
	{	
		return new Student(name, usAddr, 0, i20num,foreignAddr, StudentStatus.INTL);
	}

}
