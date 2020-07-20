package mobileApp;

import javax.swing.JOptionPane;

public class TaxForm {

	public static void main(String[] args) { 
		// TODO Auto-generated method stub

		String firstName, lastName, userAddress, userDOB, userLanguage, userMaritalStatus;
		int userSIN;
		
		try {
		firstName = JOptionPane.showInputDialog(null, "Enter your first name");
		lastName = JOptionPane.showInputDialog(null, "Enter your last name");
		userAddress = JOptionPane.showInputDialog(null, "Enter your address");
		userSIN = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your SIN"));
		userDOB = JOptionPane.showInputDialog(null, "Enter your Date of Birth");
		userLanguage = JOptionPane.showInputDialog(null, "Enter your preferred language");
		userMaritalStatus = JOptionPane.showInputDialog(null, "Enter your marital status");
		
		UserInput user = new UserInput(firstName, lastName, userAddress, userSIN, userDOB, userLanguage, userMaritalStatus);
		Database data = new Database (user.getFirstName(), user.getLastName());
		
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
		
	}

}
