package mobileApp;

import javax.swing.JOptionPane;

public class UserInput implements Validity {

	String firstName, lastName, userAddress, userDOB, userLanguage, userMaritalStatus;
	int userSIN;
	
	public UserInput(String FName, String LName, String Address, int SIN, String DOB, String lang, String marital) {
		
		firstName = FName;
		
		while(!valid(FName)){
			JOptionPane.showMessageDialog(null, "Invalid Input", "", JOptionPane.ERROR_MESSAGE);
			firstName = JOptionPane.showInputDialog(null, "Enter your first name");
		}
		
		lastName = LName;
		
		while(!valid(LName)) {
			JOptionPane.showMessageDialog(null, "Invalid Input", "", JOptionPane.ERROR_MESSAGE);
			lastName = JOptionPane.showInputDialog(null, "Enter your last name");
		}
		
		userAddress = Address;
		userSIN = SIN;
		userDOB = DOB;
		
		userLanguage = lang;
		
		while(!valid(lang)) {
			JOptionPane.showMessageDialog(null, "Invalid Input", "", JOptionPane.ERROR_MESSAGE);
			userLanguage = JOptionPane.showInputDialog(null, "Enter your preferred language");
		}
		
		userMaritalStatus = marital;
		
		while(!valid(marital)) {
			JOptionPane.showMessageDialog(null, "Invalid Input", "", JOptionPane.ERROR_MESSAGE);
			userMaritalStatus = JOptionPane.showInputDialog(null, "Enter your marital status");
		}
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getUserAddress() {
		return userAddress;
	}
	
	public int getUserSIN() {
		return userSIN;
	}
	
	public String getUserDOB() {
		return userDOB;
	}
	
	public String getUserLanguage() {
		return userLanguage;
	}
	
	public String getUserMaritalStatus() {
		return userMaritalStatus;
	}
	
	public boolean valid(String str) {
		boolean isValid = false;
		
		// Check each string for digit
		for(int i = 0; i < str.length(); i++) {
			if(!Character.isDigit(str.charAt(i))) {
				isValid = true;
			}
			else {
				isValid = false;
			}
		}
		
		return isValid;
		
	}

}
