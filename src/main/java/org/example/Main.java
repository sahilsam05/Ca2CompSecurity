package org.example;
//Reference

//Aes Encryption
//https://www.youtube.com/watch?v=LtUU8Q3rgjM

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Scanner;

public class Main {

    private static final String ALGORITHM = "AES";
    private static SecretKey secretKey;

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int choice = 0;

        while (choice != 3) {
            System.out.println("Menu:");
            System.out.println("1. Encrypt a File");
            System.out.println("2. Decrypt a File");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");
            choice = keyboard.nextInt();
            keyboard.nextLine();

            if (choice == 1)
            {
                System.out.print("Enter the file path to encrypt: ");
                String encryptFilePath = keyboard.nextLine();
            }
            else if (choice == 2)
            {
                System.out.print("Enter the file path to decrypt: ");
                String decryptFilePath = keyboard.nextLine();
            }
            else if (choice == 3)
            {
                System.out.println("Exiting the application.");
            }
            else
            {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void generateKey() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
            keyGen.init(128); // AES key size
            secretKey = keyGen.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
