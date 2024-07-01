#include<stdio.h>
#include<stdlib.h>
void encrypt(int plain[8],int key[8],int ip[8]){
    int new_plain[8];
    for(int i=0;i<8;i++){new_plain[i]=plain[ip[i]];}

    printf("Initial permuation: ");
    for(int i=0;i<8;i++) {printf("%d",new_plain[i]);}
    printf("\n");

    int left[4],right[4];
    for(int i=0;i<4;i++) {left[i]=new_plain[i];}
    for(int i=0,j=0;i<8;i++,j++) {right[j]=new_plain[i];}
    printf("Left half of permuation: ");
    for(int i=0;i<4;i++) {printf("%d",left[i]);}
    printf("\nRight half of permuation: ");
    for(int i=0;i<4;i++) {printf("%d",right[i]);}
    printf("\n");

    int ep[8];
    printf("Enter expanded permutation\n");
    for(int i=0;i<8;i++) {scanf("%d",&ep[i]);}
    int new_right[8];
    for(int i=0;i<8;i++) {new_right[i]=right[ep[i]];}
    printf("Expanded right half: ");
    for(int i=0;i<8;i++) {printf("%d",new_right[i]);}
    printf("\n");

    int right_xor[8];
    for(int i=0;i<8;i++) {right_xor[i]=new_right[i]^key[i];}
    printf("XOR result: ");
    for(int i=0;i<8;i++) {printf("%d",right_xor[i]);}
    printf("\n");

    int szero[4][4],sone[4][4];
    printf("Enter s0 matrix\n");
    for(int i=0;i<4;i++){
        for(int j=0;j<4;j++){
            scanf("%d",&szero[i][j]);
        }
    }
    printf("Enter s1 matrix\n");
    for(int i=0;i<4;i++){
        for(int j=0;j<4;j++){
            scanf("%d",&sone[i][j]);
        }
    }

    int r1[2],c1[2];
    r1[0]=right_xor[3];
    r1[1]=right_xor[0];
    c1[0]=right_xor[2];
    c1[1]=right_xor[1];
    int r1value=(1*r1[0])+(2*r1[1]);
    int c1value=(1*c1[0])+(2*c1[1]);

    int r2[2],c2[2];
    r2[0]=right_xor[7];
    r2[1]=right_xor[4];
    c2[0]=right_xor[6];
    c2[1]=right_xor[5];
    int r2value=(1*r2[0])+(2*r2[1]);
    int c2value=(1*c2[0])+(2*c2[1]);
    printf("r1:%d, c1:%d, r2:%d, c2:%d\n",r1value,c1value,r2value,c2value);
    
    int s0value=szero[r1value][c1value];
    int s1value=sone[r2value][c2value];
    int combine_s0_s1[4];
    combine_s0_s1[0]=(s0value>>1)&1;
    combine_s0_s1[1]=s0value&1;
    combine_s0_s1[2]=(s1value>>1)&1;
    combine_s0_s1[3]=s1value&1;

    int p4[4];
    printf("Enter p4 permutation\n");
    for(int i=0;i<4;i++){scanf("%d",&p4[i]);}
    int finalcombine[4];
    for(int i=0;i<4;i++){finalcombine[i]=combine_s0_s1[p4[i]];}

    int finalleft[4];
    for(int i=0;i<4;i++){finalleft[i]=finalcombine[i]^left[i];}
    int swapped[8];
    for(int i=0;i<4;i++){
        swapped[i]=finalleft[i];
        swapped[i+4]=right[i];
    }

    int ipinverse[8];
    printf("Enter ip inverse permutation\n");
    for(int i=0;i<8;i++){scanf("%d",&ipinverse[i]);}
    int ciphertxt[8];
    for(int i=0;i<4;i++){ciphertxt[i]=swapped[ipinverse[i]];}
    printf("\nCipher message: ");
    for(int i=0;i<8;i++){printf("%d",ciphertxt[i]);}
}
void main(){
int plain[8],key[8];
printf("enter 8 bit plaintext:");
for(int i=0;i<8;i++) { scanf("%d",&plain[i]);}

printf("enter 8 bit key:");
for(int i=0;i<8;i++){ scanf("%d",&key[i]);}

int ip[8];
printf("enter the 8 numbers of initial permutation:");
for(int i=0;i<8;i++){ scanf("%d",&ip[i]);}

encrypt(plain,key,ip);
}