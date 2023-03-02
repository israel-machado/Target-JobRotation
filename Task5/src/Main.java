import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a palavra ou frase a ser invertida: ");

        String phrase = sc.nextLine();
        String inverted = "";

        for ( int i = phrase.length() - 1; i >= 0; i--) {
            inverted += phrase.charAt(i);
        }

        System.out.println(inverted);
    }
}