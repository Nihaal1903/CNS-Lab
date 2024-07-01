import java.math.BigInteger;
import java.util.*;
public class rsa {
    public static void main(String[] args) throws Exception{
        int p,q,n,d=0,e,i,z;
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the message");
        long m = sc.nextLong();
        System.out.println("Enter value of p");
        p=sc.nextInt();
        System.out.println("Ener value of q");
        q=sc.nextInt();
        System.out.println("Value of p: "+p);
        System.out.println("Value of q: "+q);
        n=p*q;
        z=(p-1)*(q-1);
        System.out.println("Value of z: "+z);
        for(e=2;e<z;e++){
            if(gcd(z,e)==1)
              break;
        }
        for(i=0;i<=9;i++){
            int x=1+(i*z);
            if(x%e==0){
                d=x/e;
                break;
            }
        }
        sc.close();
        BigInteger mbigint = BigInteger.valueOf(m);
        BigInteger c = mbigint.modPow(BigInteger.valueOf(e),BigInteger.valueOf(d));
        BigInteger M = c.modPow(BigInteger.valueOf(d),BigInteger.valueOf(n));
        System.out.println("original msg: "+m);
        System.out.println("Encrypted message: "+c);
        System.out.println("Decrypted message: "+M);
    }
    static int gcd(int z,int e){
        if(e==0)
          return z;
        gcd(z%e,e);
        return 1;
    }
}
