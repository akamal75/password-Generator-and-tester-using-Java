class PasswordGenerator {
    public static String generatePassword(int length, boolean uppercase, boolean lowercase, boolean digits, boolean specialChars) {
        StringBuilder password = new StringBuilder();
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String digitsChars = "0123456789";
        String specialCharsList = "!@#$%^&*()_+-=[]{}\\|;':\",./<>?";

        String chars = "";
        if (uppercase) {
            chars += uppercaseLetters;
        }
        if (lowercase) {
            chars += lowercaseLetters;
        }
        if (digits) {
            chars += digitsChars;
        }
        if (specialChars) {
            chars += specialCharsList;
        }

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * chars.length());
            password.append(chars.charAt(index));
        }
        return password.toString();
    }
}
