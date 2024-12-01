package org.example;


//Reference

//Aes Encryption
// https://www.youtube.com/watch?v=LtUU8Q3rgjM

// File encryption
// https://www.youtube.com/watch?v=xhMkrGN3LNY&t=59s

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Main {
    private static final String ALGORITHM = "AES";
    private static SecretKey secretKey;

    public static void main(String[] args) {
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

            if (choice == 1) {
                System.out.print("Enter the file path to encrypt: ");
                String encryptFilePath = keyboard.nextLine();
                encryptFile(encryptFilePath);
            } else if (choice == 2) {
                System.out.print("Enter the file path to decrypt: ");
                String keyString = keyboard.nextLine();
                decryptFilePath(keyString);
            } else if (choice == 3) {
                System.out.println("Exiting the application.");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void generateKey() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
            keyGen.init(128); // This is the AES key size
            secretKey = keyGen.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Encryption
    // https://stackoverflow.com/questions/62883618/encryption-decryption-aes-for-all-type-of-file-in-java
    // https://stackoverflow.com/questions/20796042/aes-encryption-and-decryption-with-java

    private static void encryptFile(String filePath) {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
            keyGen.init(128);
            secretKey = keyGen.generateKey();

            byte[] inputBytes = Files.readAllBytes(Paths.get(filePath));

            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] outputBytes = cipher.doFinal(inputBytes);

            try (FileOutputStream fos = new FileOutputStream("ciphertext.txt")) {
                fos.write(outputBytes);
            }

            String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
            System.out.println("File encrypted successfully.");
            System.out.println("Encryption key (Base64): " + encodedKey);
            System.out.println("Encrypted data written to ciphertext.txt");

        } catch (Exception e) {
            System.out.println("Error during encryption: " + e.getMessage());
        }

        private static void decryptFile (String, FilePath, String keystring )
        try {
            // Decode the key
            byte[] decodedKey = Base64.getDecoder().decode(keyString);
            SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, ALGORITHM);

            byte[] inputBytes = Files.readAllBytes(Paths.get(filePath));

            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, originalKey);
            byte[] outputBytes = cipher.doFinal(inputBytes);

            try (FileOutputStream fos = new FileOutputStream("plaintext.txt")) {
                fos.write(outputBytes);
            }

            System.out.println("File decrypted successfully.");
            System.out.println("Decrypted data written to plaintext.txt");

        } catch (Exception e) {
            System.out.println("Error during decryption: " + e.getMessage());
        }
    }
}

