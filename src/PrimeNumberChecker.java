// import statements

import java.util.Scanner;
public class PrimeNumberScanner {
    // A prime is an integer greater than 1 whose only factors are 1 and itself.
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        // Only odd divisors up to sqrt(n) need to be checked.
        for (int i = 3; (long) i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;

        // Keep prompting until the user enters a valid positive integer.
        while (true) {
            System.out.print("Enter a positive integer: ");
            if (input.hasNextInt()) {
                number = input.nextInt();
                if (number > 0) {
                    break;
                }
                System.out.println("Please enter a number greater than 0.");
            } else {
                System.out.println("That is not a valid integer. Try again.");
                input.next(); // discard the bad token
            }
        }

        if (isPrime(number)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }

        input.close();
    }
}
