import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File; 
import java.io.FileWriter;// Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

/*
 * Rename to Project 3 
 * Created by Sebastian Anda
 * Assisted by Marcos Chacon, Sara Erika De Mesa and Vanessa Salas
 *
 * */
abstract class Person{
	private String name;
	private String ID;
	
	public Person() {}
		public Person(String name, String ID) 
		{
			this.name = name;
			this.ID = ID;
		}
		public abstract void printInfo();
		
		public String getName() 
		{
			return name;
		}
		public void setName(String name) 
		{
			this.name = name;
		}
		public String getID() 
		{
			return ID;
		}
		public void setID(String ID) 
		{
			this.ID = ID;
		}
	 //abstract String getRank();
		
	
}

abstract class Employee extends Person{
	private String name;
	private String ID;
	
	public Employee() {}
		public Employee(String name, String ID) {
			this.name = name;
			this.ID = ID;
		}
		public abstract void printInfo();
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getID() {
			return ID;
		}
		public void setID(String ID) {
			this.ID = ID;
		}
}

class Student extends Person{
	private double gpa;
	private int credit;
	public double discount = 0;
	public Student(double gpa, int credit) {
		this.gpa = gpa;
		this.credit = credit;
	}
	
	public Student(String name, String ID, double gpa, int credit) {
		super(name, ID);
		this.gpa = gpa;
		this.credit = credit;
	}
	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	
	@Override
	public String getName() {
		return super.getName();
	}

	@Override
	public void setName(String name) {
		super.setName(name);
	}

	@Override
	public String getID() {
		return super.getID();
	}
	@Override
	public void setID(String ID) {
		super.setID(ID);
	}
	
	public double tuitionInvoice(){	
		
		Double totalPayment = (credit * 236.45) + 52.00;
		if(this.gpa >= 3.85){
				discount =   ((((totalPayment)*0.25)*100) / 100);
				totalPayment -= discount;
		}
		
		return Math.round(totalPayment*100.0)/100.0;
	}

		@Override
		public void printInfo() {
			 System.out.println("Here is the tuition invoice for " + getName() + ": ");
			 System.out.println("---------------------------------------------------------------------------");
			 System.out.print(getName());
		     System.out.println("\t\t " + getID());
		     System.out.println("Credit Hours: " + getCredit() + "($236.45/ credit hour)");
		     System.out.println("Fees: $52" +  "\n\n");
		     System.out.println("Total payment (after discount): $" + tuitionInvoice()+"\t"+"($"+discount+" discount applied)");
		     System.out.println("---------------------------------------------------------------------------\n");
		     
		}

}


class Staff extends Employee{

	// attributes
	private String department;
	private String status;

	// Constructors

	public Staff(String department, String status) {
		this.department = department;
		this.status = status;
	}

	public Staff(String name, String ID, String department, String status) {
		super(name, ID);
		this.department = department;
		this.status = status;
	}


	//Getters & setters

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	// Overriding methods

	@Override
	public String getName(){
		return super.getName();
	}

	@Override
	public void setName(String name) {
		super.setName(name);
	}

	@Override
	public String getID() {
		return super.getID();
	}

	@Override
	public void setID(String ID) {
		super.setID(ID);
	}

	@Override
	public void printInfo(){
		System.out.println("---------------------------------------------------------------------------");
		System.out.print(getName());
	    System.out.println("\t\t " + getID());
		System.out.print(getDepartment()+"\t\t");
		if((getStatus().equalsIgnoreCase("p"))){
			System.out.println(" Part time");
		}
		else if((getStatus().equalsIgnoreCase("f"))){
	        System.out.println(" Full time");
		}
		System.out.println("---------------------------------------------------------------------------\n");
	}
}

class Faculty extends Employee {
	  private String rank = "";
	  private String department;

	  public Faculty (String rank) {
	    this.rank = rank;
	  }
	  public Faculty (String name, String ID, String rank, String department) {
	    super(name, ID);
	    this.rank = rank;
	    this.department = department;
	    System.out.println("Faculty added!");
	  }
	  
	 
	  public String getDepartment (){
	    return department;
	  }
	  public void setDepartment (String department){
	    this.department = department;
	  }
	  public String getRank (){
	    return rank;
	  }
	  public void setRank (String rank){
	    this.rank = rank;
	  }

	  @Override
	  public String getName(){
	    return super.getName();
	  } 

	  @Override
	  public void setName (String name){
	    super.setName(name);
	  }

	  @Override
	  public String getID (){
	    return super.getID();
	  }

	  @Override
	  public void setID (String ID){
	    super.setID(ID);
	  }

	  @Override
	  public void printInfo (){
	    System.out.println("-------------------------------------------------------");
	        System.out.print(getName());
	        System.out.println("\t\t " + getID());
	        System.out.print(getDepartment().substring(0,1).toUpperCase()+ getDepartment().substring(1).toLowerCase() +  " Department, ");
	        System.out.println(getRank().substring(0,1).toUpperCase() + getRank().substring(1).toLowerCase());
	        System.out.println("-------------------------------------------------------\n");

	  }
	}

	class IdException extends Exception{
		public IdException(String s) {
			super(s);
		}
		//Check line 332
	}
	
	
public class Project3 {
	
	static void IdCheck(String id) throws IdException{
		if(id.length()!=6) {
			throw new IdException("");
		}
		if(!Character.isLetter(id.charAt(0))) {
			throw new IdException("");
		}
		if(!Character.isLetter(id.charAt(1))) {
			throw new IdException("");
		}
		if(!Character.isDigit(id.charAt(2))) {
			throw new IdException("");
		}
		if(!Character.isDigit(id.charAt(3))) {
			throw new IdException("");
		}
		if(!Character.isDigit(id.charAt(4))) {
			throw new IdException("");
		}
		if(!Character.isDigit(id.charAt(5))) {
			throw new IdException("");
		}

	}
	
	public static void prompt() {
		System.out.println("1. Enter the information of the faculty");
		System.out.println("2. Enter the information of a student");
		System.out.println("3. Print tuition invoice");
		System.out.println("4. Print faculty information");
		System.out.println("5. Enter the information of the staff member");
		System.out.println("6. Print the information of the staff member");
		System.out.println("7. Exit Program \n");
		System.out.print("Enter your selection: \n");
	}

	public static void main(String[] args) {
	
			System.out.println("Welcome to my Personal Management Program \n");
			Scanner scan = new Scanner(System.in);
			int x=0;
			Person[] person = new Person[100];
			int valid =0;
			boolean selection = true;
			Boolean isFound = false;
			//placeholder strings
			String options;
			
			// the following three variables are used to make sure each data was filled
			
			//loop to show the option prompt
			while (selection) {
				prompt();
				selection = false;
				options = scan.next();
				//selections for the options prompt
				switch(options) {
				case "1":
					String facultyFirstName , lName, fullName, Facultyid , dept, rank;
	
					System.out.println("Enter the faculty�s info:");
	
					System.out.print("\tName of the faculty: ");
					facultyFirstName = scan.next();
					lName = scan.next();
					fullName = facultyFirstName +" "+ lName;
					System.out.print("\tID: ");
					Facultyid = scan.next();
					while(true) {
						try {
							IdCheck(Facultyid);
							break;
						}
						catch (IdException ex) {
							System.out.println("Invalid ID format. Must be LetterLetterDigitDigitDigitDigit ");
							System.out.print("\tID: ");
							Facultyid = scan.next();
						}
					}
					
	
					System.out.print("\t Rank: ");
					rank = scan.next();
					
					while(x==0) {
						if(rank.equalsIgnoreCase("Professor")|| rank.equalsIgnoreCase("Adjunct"))
							x=1;
							
						else {
							System.out.println( "\""+ rank + "\"" + " is Invalid");
							System.out.print("\t Rank: ");
							rank = scan.next();
						}
						
					}
				
					
					
					/*
					while (rank.equalsIgnoreCase("Instructor") || rank.equalsIgnoreCase("Assistant"))
					{
						System.out.println( "\""+ rank + "\"" + "is Invalid");
						System.out.print("\tRank: ");
						rank = scan.next();
					}
					 */
					
					System.out.print("\tDepartment: ");
					dept = scan.next();
	
					// If user enters department , prompt him/her to enter department again until he enters no department word
					while(true) 
					{
						if(dept.toLowerCase().equals("mathematics")  ||dept.toLowerCase().equals("english")||  dept.toLowerCase().equals("engineering") ||  dept.toLowerCase().equals("sciences")) {
	                        break;
	                    }
	                    else
	                    {
	                        System.out.println("Invalid entry, please try again !");
	                        System.out.print("Department: ");
	                        dept = scan.next();
	                    }
					}
					
					Faculty faculty = new Faculty(fullName, Facultyid, rank, dept);
					for(int i=0;i<person.length;i++) {
						if(person[i]== null) {
						person[i] = faculty;
						break;
						}
					}
					 selection = true;
					 break;
				case "2":
					String firstName, lastName, FullName, id;
					int credit = 0;
					double gpa = 0;
					
					System.out.println("Enter the student info: ");
					
					System.out.print("\t Name of Student: ");
					firstName = scan.next();
					lastName = scan.next();
					FullName = firstName +" "+ lastName;
					
					System.out.print("\t ID: ");
					id = scan.next();
					
					while(true) {
						try {
							IdCheck(id);
							break;
						}
						catch (IdException ex) {
							System.out.println("Invalid ID format. Must be LetterLetterDigitDigitDigitDigit ");
							System.out.print("\tID: ");
							id = scan.next();
						}
					}
					//System.out.print("\t GPA: ");
					
					do {
						try {
							System.out.print("\t GPA: ");
							gpa= scan.nextDouble();
							break;
						}
						catch(InputMismatchException e){
							
							scan.next();
						}
					}
					while (true);
					
							

						
				
					do {
						try {
							System.out.print("\t Credit Hours: ");
							credit = scan.nextInt();
							break;
						}
						catch(InputMismatchException e){
							
							scan.next();
						}
					}
					while (true);
					
					Student student = new Student(FullName, id, gpa, credit);
					for(int i=0;i<person.length;i++) {
						if(person[i]==null) {
							person[i] = student;
							break;
						}
					}
					System.out.println("Student Added!");
					selection = true;
					break;
				case "3":
					String ID;
					System.out.println("Enter the student's id: ");
					ID = scan.next();
					while(true) {
						try {
							IdCheck(ID);
							break;
						}
						catch (IdException ex) {
							System.out.println("Invalid ID format. Must be LetterLetterDigitDigitDigitDigit ");
							System.out.print("\tID: ");
							ID = scan.next();
						}
					}
					
					int index = 0;
	
					for(int i=0; i<person.length; i++){
						if(person[i] != null) {
							if(ID.equalsIgnoreCase(person[i].getID()))
							{
								isFound = true;
								index = i;
							}
						}
						else 
							break;
					}
	
					if(isFound && person[index] instanceof Student)	{
						person[index].printInfo();
						index = 0;
						isFound = false;
					}
					else { 	
						System.out.println("Sorry student not found!\n");
						index = 0;
					}
					selection = true;
					break;
				case "4":
					String idfaculty;
					System.out.println("Enter faculty id: ");
					idfaculty = scan.next();
					
					
					
					int place = 0;
	
					for(int i=0; i<person.length; i++){
						if(person[i]!=null) {
							if(idfaculty.equalsIgnoreCase(person[i].getID())){
								isFound = true;
								place = i;
							}
						}
						else break;
					}
	
					if(isFound && person[place]instanceof Faculty){
						person[place].printInfo();
						place = 0;
						isFound = false;
					}
					else{ 	
						System.out.println("Sorry faculty not found!\n");
						place = 0;
					}
					selection = true;
					break;
				case "5": //departments: Engineering, English, and Mathematics
					String staffFirstName, staffLastName, staffFullName, staffid, staffDepartment, staffStatus;
					System.out.println("Name of the Staff member: ");
					staffFirstName = scan.next();
					staffLastName = scan.next();
					staffFullName = staffFirstName +" "+ staffLastName;
					
					System.out.print("\tEnter the staff ID: ");
					staffid = scan.next();
					while(true) {
						try {
							IdCheck(staffid);
							break;
						}
						catch (IdException ex) {
							System.out.println("Invalid ID format. Must be LetterLetterDigitDigitDigitDigit ");
							System.out.print("\tID: ");
							staffid = scan.next();
						}
					}
					System.out.print("\t Enter the Department: ");
					staffDepartment = scan.next();
					while(true) 
					{
						if(staffDepartment.toLowerCase().equals("mathematics")  ||staffDepartment.toLowerCase().equals("english")||  staffDepartment.toLowerCase().equals("engineering")||  staffDepartment.toLowerCase().equals("sciences")) {
	                        break;
	                    }
	                    else
	                    {
	                        System.out.println("Invalid entry, please try again !");
	                        System.out.print("Department: ");
	                        staffDepartment = scan.next();
	                    }
					}
					System.out.print("\tStatus, Enter P for Part Time, F for Full Time: ");
					staffStatus = scan.next();
					
					Staff staff = new Staff(staffFullName, staffid, staffDepartment, staffStatus);
					for(int i=0;i<person.length;i++) {
						if(person[i]==null) {
							person[i] = staff;
							break;
						}
					}
					System.out.println("Staff member added!");
					selection = true;
	                break;
				case "6":
					String staffID;
					System.out.println("Enter staff id: ");
					staffID = scan.next();
					
					int index1 = 0;
	
					for(int i=0; i<person.length; i++){
						if(person[i]!= null) {
							if(staffID.equalsIgnoreCase(person[i].getID())){
								isFound = true;
								index1 = i;
							}
						}
						else break;
					}
	
					if(isFound && person[index1]instanceof Staff){
						person[index1].printInfo();
						index1=0;
						isFound = false;
					}
					else{ 	
						System.out.println("Sorry staff not found!\n");
						index1=0;
					}
					selection = true;
	                break;
				case "7":
					String fil;
					System.out.print("Would you like to create the report? (Y/N): ");
					fil = scan.next();
					int cn = 0;
					Date d1 = new Date();
					if(fil.equalsIgnoreCase("y")) {
						try {
							FileWriter out = new FileWriter("report.dat");
							out.write("Report Created on: " + d1 + "\n");
							out.write("***************\n\n\n");
							out.write("Faculty Members \n");
							out.write("-----------------------------\n");
							for(Person p: person) {
								if(p instanceof Faculty ) {
								out.write("\t"+cn+", " +p.getName()+ "\n");
								cn++;
								out.write("\t"+"ID: " +p.getID()+"\n");
								out.write("\t"+ ((Faculty) p).getRank() +", "+((Faculty)p).getDepartment()+"\n\n\n");
								}
							}
							out.write("Staff Members \n");
							out.write("-----------------------------\n");
							for(Person p: person) {
								if(p instanceof Staff ) {
								out.write("\t"+cn+". " +p.getName()+ "\n");
								cn++;
								out.write("\t"+"ID: " +p.getID()+"\n");
								out.write("\t"+ ((Staff)p).getDepartment()+", "+ ((Staff)p).getStatus() + "\n\n\n");
								}
							}
							out.write("Students \n");
							out.write("-----------------------------\n");
							for(Person p: person) {
								if(p instanceof Student ) {
								out.write("\t"+cn+". " +p.getName()+ "\n");
								cn++;
								out.write("\t"+ "ID: " +p.getID()+"\n");
								out.write("\t"+ "GPA: "+((Student)p).getGpa() +"\n");
								out.write("\t"+ "Credit Hours: "+((Student)p).getCredit() +"\n");
								}
							}
							out.close();
							System.out.println("Report Created");
							System.out.println("Goodbye!");
							System.exit(1);
						}
						catch(IOException e){
							System.out.println("An error has occured");
							
						}
						System.out.println("Goodbye!");
					}
					else {
					System.out.println("Goodbye!");
					System.exit(1);
					break;
					}
				default:
					System.out.println("Invalid Input. Try Again. \n\n");
					selection = true;
				}
				
			}	
			
				scan.close();
		}
	
}
	
	


