import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.*;
public class aes{
    public static final String key="1234567890123456";
    public static String encrypt(String strToEncrypt){
        try{
           SecretKeySpec secretkey = new SecretKeySpec(key.getBytes(),"AES");
           Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
           cipher.init(Cipher.ENCRYPT_MODE,secretkey);
           return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes()));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static String decrypt(String strToDecrypt){
        try{
            SecretKeySpec secretkey = new SecretKeySpec(key.getBytes(),"AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE,secretkey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println("Enter the plaintext: ");
        Scanner sc = new Scanner(System.in);
        String originalString = sc.nextLine();
        String encryptedString = encrypt(originalString);
        String decryptedString = decrypt(encryptedString);

        System.out.println("Original String: " + originalString);
        System.out.println("Encrypted String: " + encryptedString);
        System.out.println("Decrypted String: " + decryptedString);
        sc.close();
    }
}