import java.security.SecureRandom;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the password: ");
        int length = sc.nextInt();

        if (length < 4) {
            System.out.println("Password length must be at least 4 characters.");
            return;
        }

        String password = generatePassword(length);
        System.out.println("Generated Password: " + password);
    }

    private static String generatePassword(int length) {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        password.append(lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length())));
        password.append(capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length())));
        password.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));
        password.append(numbers.charAt(random.nextInt(numbers.length())));

        for (int i = 4; i < length; i++) {
            password.append(combinedChars.charAt(random.nextInt(combinedChars.length())));
        }
        
        return password.toString();
    }
}
