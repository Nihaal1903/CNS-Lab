import java.util.*;
public class Caesar {
    public static final String ALPHABET="abcdefghijklmnopqrstuvwxyz";
    public static String encrypt(String str,int shiftpos){
        str = str.toLowerCase();
        String encryptstr = "";
        for(int i=0;i<str.length();i++){
            int pos = ALPHABET.indexOf(str.charAt(i));
            int encryptpos = (shiftpos+pos)%26;
            char chr = ALPHABET.charAt(encryptpos);
            encryptstr+=chr;
        }
        return encryptstr;
    }
    public static String decrypt(String str,int shiftpos){
        str = str.toLowerCase();
        String decryptstr = "";
        for(int i=0;i<str.length();i++){
            int pos = ALPHABET.indexOf(str.charAt(i));
            int decryptpos = (pos-shiftpos)%26;
            if(decryptpos<0){
                decryptpos+=26;
            }
            char chr = ALPHABET.charAt(decryptpos);
            decryptstr+=chr;
        }
        return decryptstr;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the plaintext");
        String originalstr = sc.nextLine();
        System.out.println("Enter the shift key");
        int shiftpos = sc.nextInt();
        System.out.println("Orginial plaintext: "+originalstr);
        String encryptedstr = encrypt(originalstr,shiftpos);
        System.out.println("Encrypted text: "+encryptedstr);
        String decryptedstr = decrypt(encryptedstr,shiftpos);
        System.out.println("Decrypted text: "+decryptedstr);
        sc.close();
    }
}
