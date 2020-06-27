package labcodeinspection;

import java.util.Locale;

public class Email {

	private transient final String m_firstName;
	private transient final String m_lastName;
	private transient String password;
	private transient String department;
	private transient final int defaultpasswordLength = 8;
	private transient String email;

	/**
	 * Email
	 *
	 * @param  firstName
	 * @param  lastName
	 * 
	 */
	public Email(String firstName, String lastName) {
		this.m_firstName = firstName;
		this.m_lastName = lastName;
	}
	
	/**
	 * Muestra toda la informacion
	 */
	public void showInfo() {
		System.out.println("\nFIRST NAME= " + m_firstName + "\nLAST NAME= " + m_lastName);
		System.out.println("DEPARMENT= " + department + "\nEMAIL= " + email + "\nPASSWORD= " + password);
	}

	/**
	 * Elige el departamento deseado
	 */
	public void setDeparment(int depChoice) {
		switch (depChoice) {
		case 1:
			this.department = "sales";
			break;
		case 2:
			this.department = "dev";
			break;
		case 3:
			this.department = "acct";
			break;
		default:
			break;
		}
	}
	
	/**
	 * Genera un pass aleatorio
	 * @param  longitud
	 */
	private String randomPassword(int length) {
		String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$&@*";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * set.length());
			password[i] = set.charAt(rand);
		}
		return new String(password);
	}
	
	/**
	 * Funcion que genera email
	 * 
	 */
	public void generateEmail() {
		this.password = this.randomPassword(this.defaultpasswordLength);
		this.email = this.m_firstName.toLowerCase(Locale.US) + this.m_lastName.toLowerCase(Locale.US) + "@" + this.department
				+ ".espol.edu.ec";
	}
}
