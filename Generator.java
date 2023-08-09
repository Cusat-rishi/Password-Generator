
// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.Scanner;

public class Generator {
    boolean IncludeUpper = false;
    boolean IncludeLower = false;
    boolean IncludeNum = false;
    boolean IncludeSym = false;
    Alphabet Alphabet;

    public Generator(boolean IncludeUpper, boolean IncludeLower, boolean IncludeNum, boolean IncludeSym) {
        this.Alphabet = new Alphabet(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
    }

    public Password GeneratePassword(int Length) {
        String Pass = "";
        int n = this.Alphabet.PoolSize;
        int max = n - 1;
        int min = 0;
        int range = max - min + 1;

        for (int i = 0; i < Length; ++i) {
            int index = (int) (Math.random() * (double) range) + min;
            char Char = this.Alphabet.Pool.charAt(index);
            Pass = Pass + Char;
        }

        return new Password(Pass);
    }

    public static void UsefulInfo() {
        System.out.println();
        System.out.println("Use a minimum password length of 8 or more characters if permitted");
        System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
        System.out.println("Generate passwords randomly where feasible");
        System.out.println(
                "Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)");
        System.out.println(
                "Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences,\nusernames, relative or pet names, romantic links (current or past) and biographical information (e.g., ID numbers, ancestors' names or dates).");
        System.out.println(
                "Avoid using information that the user's colleagues and/or acquaintances might know to be associated with the user");
        System.out.println(
                "Do not use passwords which consist wholly of any simple combination of the aforementioned weak components");
    }

    public static void PasswordRequest() {
        boolean IncludeUpper = false;
        boolean IncludeLower = false;
        boolean IncludeNum = false;
        boolean IncludeSym = false;
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out
                .println("Hello, welcome to the Password Generator :) answer the following questions by Yes or No \n");
        System.out.println("Do you want Lowercase letters \"abcd...\" to be used? ");
        String Input = in.nextLine();
        if (!Input.equals("YES") && !Input.equals("Yes") && !Input.equals("yes")) {
            if (!Input.equals("NO") && !Input.equals("No") && !Input.equals("no")) {
                PasswordRequestError();
                return;
            }
        } else {
            IncludeLower = true;
        }

        System.out.println("Do you want Uppercase letters \"ABCD...\" to be used? ");
        Input = in.nextLine();
        if (!Input.equals("YES") && !Input.equals("Yes") && !Input.equals("yes")) {
            if (!Input.equals("NO") && !Input.equals("No") && !Input.equals("no")) {
                PasswordRequestError();
                return;
            }
        } else {
            IncludeUpper = true;
        }

        System.out.println("Do you want Numbers \"1234...\" to be used? ");
        Input = in.nextLine();
        if (!Input.equals("YES") && !Input.equals("Yes") && !Input.equals("yes")) {
            if (!Input.equals("NO") && !Input.equals("No") && !Input.equals("no")) {
                PasswordRequestError();
                return;
            }
        } else {
            IncludeNum = true;
        }

        System.out.println("Do you want Symbols \"!@#$...\" to be used? ");
        Input = in.nextLine();
        if (!Input.equals("YES") && !Input.equals("Yes") && !Input.equals("yes")) {
            if (!Input.equals("NO") && !Input.equals("No") && !Input.equals("no")) {
                PasswordRequestError();
                return;
            }
        } else {
            IncludeSym = true;
        }

        if (!IncludeUpper && !IncludeLower && !IncludeNum && !IncludeSym) {
            System.out.println(
                    "You have selected no characters to generate your password at least one of your answers should be Yes");
        } else {
            System.out.println("Great! Now enter the length of the password");
            int length = in.nextInt();
            Generator G = new Generator(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
            Password UserPass = G.GeneratePassword(length);
            System.out.println(UserPass);
        }

    }

    public static void PasswordRequestError() {
        System.out.println("You have entered something incorrect let's go over it again \n");
    }

    public static void PasswordCheck() {
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter your password:");
        String Input = in.nextLine();
        Password P = new Password(Input);
        System.out.println(P.CalculateScore());
        // scanner.close();
    }

    public static void Menu() {
        System.out.println();
        System.out.println("Enter 1 - Password Generator");
        System.out.println("Enter 2 - Password Stength Check");
        System.out.println("Enter 3 - Useful Password Info");
        System.out.println("Enter 4 - Quit");
        System.out.println("Choice:");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Our Password Services :)");
        Menu();

        while (in.hasNextLine()) {
            String Input = in.nextLine();
            if (Input.equals("1")) {
                PasswordRequest();
                Menu();
            } else if (Input.equals("2")) {
                PasswordCheck();
                Menu();
            } else if (Input.equals("3")) {
                UsefulInfo();
                Menu();
            } else {
                if (Input.equals("4")) {
                    break;
                }

                System.out.println();
                System.out.println("Kindly select one of the available commands:");
                Menu();
            }
        }

    }
}
