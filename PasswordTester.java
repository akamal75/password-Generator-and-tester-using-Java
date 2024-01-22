class PasswordTester {
    public static boolean testPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
    
        boolean containsUpperCase = false;
        boolean containsLowerCase = false;
        boolean containsDigit = false;
        boolean containsSpecialChar = false;
        String specialChars = "!@#$%^&*()_+-=[]{}\\|;':\",./<>?";

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                containsUpperCase = true;
            } else if (Character.isLowerCase(ch)) {
                containsLowerCase = true;
            } else if (Character.isDigit(ch)) {
                containsDigit = true;
            } else if (specialChars.indexOf(ch) >= 0) {
                containsSpecialChar = true;
            }
        }
    
        return containsUpperCase && containsLowerCase && containsDigit && containsSpecialChar;
    }
}
