import java.util.Scanner;

public class encryption{

    public static String vEncrypt(String message, String key) {
        StringBuilder result = new StringBuilder();
        message = message.toUpperCase();
        key = key.toUpperCase();
        
        int keyPos = 0;
        for (char ch : message.toCharArray()) {
            if (Character.isLetter(ch)) {
                int shiftAmount = key.charAt(keyPos) - 'A';
                char newChar = (char) ((ch - 'A' + shiftAmount) % 26 + 'A'); 
                result.append(newChar);
                keyPos = (keyPos + 1) % key.length();

            }else {
                result.append(ch);
            }
        }   
        return result.toString();     
    
    }

 public static String decrypt(String cipherText, String key) {
        StringBuilder result = new StringBuilder();
        cipherText = cipherText.toUpperCase();
        key = key.toUpperCase();
        
        int keyPos = 0;
        for (char ch : cipherText.toCharArray()) {
            if (Character.isLetter(ch)) {
                int shiftAmount = key.charAt(keyPos) - 'A';
                char newChar = (char) ((ch - 'A' - shiftAmount + 26) % 26 + 'A');
                result.append(newChar);
                keyPos = (keyPos + 1) % key.length();
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("=== Vigenère Cipher Tool ===");
        System.out.println("What do you want to do?");
        System.out.println("1) Encrypt a message");
        System.out.println("2) Decrypt a message");
        System.out.print("Pick 1 or 2: ");
        
        int option = input.nextInt();
        input.nextLine(); // Gotta clear that newline char
        
        System.out.print("Okay, what's your key? (Just letters and no spaces, please): ");
        String theKey = input.nextLine().trim(); // Trim any extra spaces
        
        if (option == 1) {
            System.out.print("Enter the message you want to encrypt: ");
            String plainText = input.nextLine();
            String encryptedMsg = vEncrypt(plainText, theKey);
            System.out.println("\nHere's your encrypted message: " + encryptedMsg);
            
        } else if (option == 2) {
            System.out.print("Enter the encrypted message to decrypt: ");
            String cipherMsg = input.nextLine();
            String plainText = decrypt(cipherMsg, theKey);
            System.out.println("\nDecrypted message: " + plainText);
            
        } else {
            System.out.println("Whoops, that's not 1 or 2. Try again next time!");
        }
        
        input.close();
        System.out.println("\nDone! Thanks for using this.");
    }

}