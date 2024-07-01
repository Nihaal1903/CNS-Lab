import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import java.util.Scanner;
public class md5 {
    public static String encrypt(String input){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] msgdt = md.digest(input.getBytes());
            BigInteger md1 = new BigInteger(msgdt);
            String hashtxt = md1.toString(16);
            while(hashtxt.length()<32){
                hashtxt = "0"+hashtxt;
            }
            return hashtxt;
        } catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter msg");
        String msg = sc.nextLine();
        System.out.println("MD5 msg digest: "+encrypt(msg));
        sc.close();
    }
}
