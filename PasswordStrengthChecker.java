import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter your password: ");
        String password = scanner.nextLine();


        String strength = checkPasswordStrength(password);
        System.out.println("Password Strength: " + strength);
    }

    public static String checkPasswordStrength(String password) {
        int lengthScore = password.length() >= 8 ? 1 : 0;
        int upperCaseScore = password.chars().anyMatch(Character::isUpperCase) ? 1 : 0;
        int lowerCaseScore = password.chars().anyMatch(Character::isLowerCase) ? 1 : 0;
        int numberScore = password.chars().anyMatch(Character::isDigit) ? 1 : 0;
        int specialCharScore = password.chars().anyMatch(c -> "!@#$%^&*()-_=+<>?".indexOf(c) >= 0) ? 1 : 0;

        int score = lengthScore + upperCaseScore + lowerCaseScore + numberScore + specialCharScore;


        if (score == 5) {
            return "Very Strong";
        } else if (score >= 4) {
            return "Strong";
        } else if (score >= 3) {
            return "Moderate";
        } else {
            return "Weak";
        }
    }
}
