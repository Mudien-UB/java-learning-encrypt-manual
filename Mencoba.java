package com.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String key = generateKey();
        System.out.println("Key: " + key);

        String plainText = "Ubay Lahmudien";
        System.out.println("Plain Text: " + plainText);

        String encryptedText = encrypt(plainText, key);
        System.out.println("Encrypted Text: " + encryptedText);
        String decryptedText = decrypt(encryptedText, key);
        System.out.println("Decrypted Text: " + decryptedText);

    }

    public static String generateKey(){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int keyLength = 26;
        StringBuilder key = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < keyLength; i++) {
            int index = random.nextInt(alphabet.length());
            key.append(alphabet.charAt(index));

            alphabet = alphabet.substring(0, index) + alphabet.substring(index + 1);

        }

        return key.toString();
    }

    public static String encrypt(String plainText, String key){

        StringBuilder encryptedText = new StringBuilder();

        plainText = plainText.toLowerCase();

        for(int i = 0; i < plainText.length(); i++){
            char currentChar = plainText.charAt(i);

            if(Character.isLowerCase(currentChar)){
                int index = currentChar - 'a';
                char newChar = key.charAt(index);
                encryptedText.append(newChar);
            }else{
                encryptedText.append(currentChar);
            }
        }
        return encryptedText.toString();
    }

    public static String decrypt(String encryptedText, String key){
        StringBuilder decryptedText = new StringBuilder();

        for(int i = 0; i < encryptedText.length(); i++){
            char currentChar = encryptedText.charAt(i);
            int index = key.indexOf(currentChar);

            if(index != -1){
                char decryptedChar = (char)('a' + index);
                decryptedText.append(decryptedChar);
            }else{
                decryptedText.append(currentChar);
            }
        }
        return decryptedText.toString();

    }



}
