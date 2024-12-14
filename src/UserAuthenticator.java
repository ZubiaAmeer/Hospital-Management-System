
public class UserAuthenticator {

	// usernames
	public static boolean authenticate(String username, String password) {
		String[] validUsernames = {"marwah_waheed", "yasamin_nargis", "hooria_mashal", "zubia_amir"};
		String ValidPassword = "OOP@2025"; // SAME PASSWORD IS USED FOR LOGIN BY ALL MEMBERS
		
		// process of authenticating the password
		for (String validUsername : validUsernames) {
			if (validUsername.equals(username) && ValidPassword.equals(password)) {
				return true;
				
			}
			
		}
		return false;
		
	}
}
