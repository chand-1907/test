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
	String phone, problem;
	Date dateOfJoin;	
	int tokenId;	

	public Doctor (String name, int age, String phone, Date dateOfJoin) {
		super(name, age);
		this.phone = phone;
		this.dateOfJoin = dateOfJoin;
	}

	public String getDoctorDetails () {
		return "\nName : " + name + "\nAge : " + age + "\nPhone : " + phone + "\nDate Of Joining : " + dateOfJoin + "\n";
	}	
}

class PatientManager {
	
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

public class HospitalManagement {
	public static void main (String args[]) {

	}		
}
