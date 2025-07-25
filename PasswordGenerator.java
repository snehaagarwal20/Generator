import java.util.*;

public class PasswordGenerator {

    // Characters to choose from
    static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    static final String DIGITS = "0123456789";
    static final String SPECIAL = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== PASSWORD GENERATOR =====");
        System.out.print("Enter desired password length: ");
        int length = scanner.nextInt();

        if (length < 4) {
            System.out.println("Password length should be at least 4.");
            return;
        }

        String password = generatePassword(length);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length) {
        Random rand = new Random();
        String allChars = UPPER + LOWER + DIGITS + SPECIAL;

        StringBuilder password = new StringBuilder();

        // Ensure at least one character from each type
        password.append(UPPER.charAt(rand.nextInt(UPPER.length())));
        password.append(LOWER.charAt(rand.nextInt(LOWER.length())));
        password.append(DIGITS.charAt(rand.nextInt(DIGITS.length())));
        password.append(SPECIAL.charAt(rand.nextInt(SPECIAL.length())));

        // Fill the rest with random characters
        for (int i = 4; i < length; i++) {
            password.append(allChars.charAt(rand.nextInt(allChars.length())));
        }

        // Shuffle the characters
        List<Character> passwordChars = new ArrayList<>();
        for (char c : password.toString().toCharArray()) {
            passwordChars.add(c);
        }
        Collections.shuffle(passwordChars);

        StringBuilder finalPassword = new StringBuilder();
        for (char c : passwordChars) {
            finalPassword.append(c);
        }

        return finalPassword.toString();
    }
}
