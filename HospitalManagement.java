import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

class Person {
	
	String name;
	int age;

	public Person (String name, int age) {
		this.name = name;
		this.age = age;
	}
}

class Patient extends Person {
	
	String phone, problem;
	final Date date = new Date();	
	int tokenId;	

	public Patient (int tokenId, String name, int age, String phone, String problem) {
		super(name, age);
		this.phone = phone;
		this.problem = problem;	
		this.tokenId = tokenId;
	}

	public String getPatientDetails () {
		return "\nToken Id : " + tokenId + "\nName : " + name + "\nAge : " + age + "\nPhone : " + phone + "\nProblem : " + problem + "\nDate : " + date + "\n";
	}
}

class Doctor extends Person {
	String phone;
	Date dateOfJoin;	

	public Doctor (String name, int age, String phone, Date dateOfJoin) {
		super(name, age);
		this.phone = phone;
		this.dateOfJoin = dateOfJoin;
	}

	public String getDoctorDetails () {
		return "\nName : " + name + "\nAge : " + age + "\nPhone : " + phone + "\nDate Of Joining : " + dateOfJoin + "\n";
	}	
}

class Nurse extends Person {
	String phone;
	Date dateOfJoin;
	
	public Nurse (String name, int age, String phone, Date dateOfJoin) {
		super(name, age);
		this.phone = phone;
		this.dateOfJoin = dateOfJoin;
	}

	public String getNurseDetails () {
		return "\nName : " + name + "\nAge : " + age + "\nPhone : " + phone + "\nDate Of Joining : " + dateOfJoin + "\n";
	}
}

class Singleton {
	
}

class PatientManager extends Singleton {
	
	private static PatientManager instance = null;
	
	private int tokenId = 0;
	
	private static ArrayList<Patient> patient = null;

	Calendar cal = Calendar.getInstance();

	public static PatientManager PatientManager () {
		if (instance == null) {
			instance = new PatientManager();
			patient = new ArrayList<>();
		}
		return instance; 
	}
	
	public void addPatient (String name, int age, String phone, String problem) {
		if (cal.get(Calendar.HOUR_OF_DAY) == 0) {
			tokenId = 0;			
		}
		patient.add(new Patient(tokenId++, name, age, phone, problem));		
	}

	public String getAllPatient () {
		String s = "";
		for (Patient p : patient)
			s += p.getPatientDetails();
		return s;
	}	
}

class EmployeeManager {
	private static PatientManager instance = null;
	
	private int tokenId = 0;
	
	private static ArrayList<Doctor> doctor = null;
	private static ArrayList<Nurse> nurse = null;

	public static PatientManager PatientManager () {
		if (instance == null) {
			instance = new PatientManager();
			doctor = new ArrayList<>();
			nurse = new ArrayList<>();
		}
		return instance; 
	}
	
	public void addDoctor (String name, int age, String phone) {
		doctor.add(new Doctor(name, age, phone, new Date()));		
	}

	public String getAllDoctors () {
		String s = "";
		for (Doctor d : doctor)
			s += d.getDoctorDetails();
		return s;
	}

	public void addNurse (String name, int age, String phone) {
		nurse.add(new Nurse(name, age, phone, new Date()));		
	}

	public String getAllNurse () {
		String s = "";
		for (Nurse d : nurse)
			s += d.getNurseDetails();
		return s;
	}
}

public class HospitalManagement {
	public static void main (String args[]) {
		
		Singleton s = PatientManager.PatientManager();
		s.addPatient("ca",12,"64656","Tr");

	}		
}
