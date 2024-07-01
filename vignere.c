#include<stdio.h>
#include<ctype.h>
#include<string.h>
#include<stdlib.h>
void vigneretable(){
    printf("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    for(int i=0;i<26;i++){
        printf("%c",'A'+i);
        for(int j=0;j<26;j++){
            printf("%c",'A'+(i+j)%26);
        }
        printf("\n");
    }
}
void encrypt(){
    char plaintext[128];
    char key[16];
    printf("Enter plaintext (upto 128 char): ");
    scanf(" %[^\n]", plaintext);
    printf("Enter key (upto 16 char): ");
    scanf(" %[^\n]", 
    
    key);
    for(int i=0,j=0;i<strlen(plaintext);i++,j++){
        if(j>=strlen(key)){
            j=0;
        }
        int shift = toupper(key[j]-'A');
        char encryptedchr = ((toupper(plaintext[i])-'A'+shift)%26)+'A';
        printf("%c",encryptedchr);
        j++;
    }
    printf("\n");
}
void decrypt(){
    char ciphertext[128];
    char key[16];
    printf("Enter plaintext (upto 128 char): ");
    scanf(" %[^\n]", ciphertext);
    printf("Enter key (upto 16 char): ");
    scanf(" %[^\n]", key);
    for(int i=0,j=0;i<strlen(ciphertext);i++,j++){
        if(j>=strlen(key)){
            j=0;
        }
        int shift = toupper(key[j]-'A');
        char decryptedchr = ((toupper(ciphertext[i])-'A'-shift+26)%26)+'A';
        printf("%c",decryptedchr);
        j++;
    }
    printf("\n");
}
void main(){
    int ch;
    vigneretable();
    while(1){
        printf("1.Encrypt\n2.Decrypt\n3.Display");
        printf("\nEnter your choice: ");
        scanf("%d",&ch);
        switch(ch){
            case 1:
              encrypt();
              break;
            case 2:
              decrypt();
              break;
            case 3:
              printf("Exiting code\n");
              exit(0);
            default:
              printf("Invalid choice\n");
              break;
        }
    }
}