package org.example;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
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
}
