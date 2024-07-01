import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import java.util.Scanner;
public class sha{
    public static String encrypt(String input){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] msgdt = md.digest(input.getBytes());
            BigInteger md1 = new BigInteger(msgdt);
            String hashtext = md1.toString(16);
            while(hashtext.length()<32){
                hashtext = "0"+hashtext;
            }
            return hashtext;
        } catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter msg");
        String msg = sc.nextLine();
        System.out.println("Msg digest: "+encrypt(msg));
        sc.close();
    }
}