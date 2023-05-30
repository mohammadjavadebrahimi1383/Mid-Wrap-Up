import java.util.Random;

public class Lecture5Exercises {
    /*
     *   implement a function to create a random password with
     *   given length using lower case letters
     *   lecture 5 page 14
     */

    public static String weakPassword(int length) {
        String password = "";
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            int t = rand.nextInt(23);
            password += (char) (t + 97);
        }
        return password;
    }

    /*
     *   implement a function to create a random password with
     *   given length and at least 1 digit and 1 special character
     *   lecture 5 page 14
     */

    public static String strongPassword(int length) throws Exception {
        String password = "";
        if (length < 3){
            throw new Exception("Length should be longer than 2!");
        }
        else {
            Random rand = new Random();
            String specials = "~!@#$%^&*()_-/";
            int digits = rand.nextInt(length - 2) + 1;
            int sps = rand.nextInt(length - digits - 1) + 1;
            int r = length - sps - digits;
            for (int i = 0; i < digits; i++) {
                password += rand.nextInt(9) + 1;
            }
            System.out.println(password);
            for (int i = 0; i < sps; i++) {
                password += specials.charAt(rand.nextInt(14));
            }
            System.out.println(password);
            for (int i = 0; i < r; i++) {
                password += (char) (rand.nextInt(26) + 97);
            }
        }
        return password;
    }

    /*
     *   implement a function that checks if a integer is a fibobin number
     *   integer n is fibobin is there exist an i where:
     *       n = fib(i) + bin(fib(i))
     *   where fib(i) is the ith fibonacci number and bin(i) is the number
     *   of ones in binary format
     *   lecture 5 page 17
     */

    public static boolean isFiboBin(int n) {
        int i = 1;
        while (true) {
            if (fibonacci(i) > n) {
                break;
            } else {
                if (n == fibonacci(i) + countOnes(Long.toBinaryString(i))) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public static long fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static int countOnes(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}