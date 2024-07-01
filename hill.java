import java.util.*;

public class hill{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int[][] key = new int[3][3];
        System.out.println("Enter key matrix");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                key[i][j]=sc.nextInt();
            }
        }
        sc.nextLine();
        System.out.println("Enter plaitext");
        String plaintext = sc.nextLine();
        plaintext = plaintext.toUpperCase();
        StringBuilder ct = new StringBuilder();
        for(int k=0;k<plaintext.length();k+=3){
            int[] vector = new int[3];
            for(int i=0;i<3;i++){
                vector[i] = plaintext.charAt(k+i)-'A';
            }
            for(int i=0;i<3;i++){
                int sum=0;
                for(int j=0;j<3;j++){
                    sum+=key[i][j]*vector[j];
                }
                ct.append((char)((sum%26)+'A'));
            }
        }
        System.out.println("Plain text: "+plaintext);
        System.out.println("Encrypted text: "+ct.toString());
        sc.close();
    }
}