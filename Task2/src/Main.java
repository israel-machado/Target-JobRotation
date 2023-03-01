import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] fibonacci = new int[100000];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }

        System.out.println("!FIBONACCI CHECK!");

        while(true) {
            System.out.print("Insert a number to be checked if it's in a Fibonacci's sequence of 100k elements: ");
            int number = sc.nextInt();

            for (int i = 0; i < fibonacci.length; i++) {
                if (fibonacci[i] == number) {
                    System.out.println("The number is present in the sequence.");
                    return;
                }
            }

            System.out.println("The number isn't present in the sequence.");
            System.out.println("Try another one.");
            System.out.println();
        }

    }
}