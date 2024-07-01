#include<stdio.h>
#include<stdlib.h>
#include<string.h>
void main(){
    int i,j,len,code[100][1000],rails,count;
    char str[1000];
    printf("Enter a secret message\n");
    scanf(" %[^\n]",str);
    len=strlen(str);
    printf("Enter no. of rails\n");
    scanf("%d",&rails);
    for(i=0;i<rails;i++){
        for(j=0;j<len;j++){
            code[i][j]=0;
        }
    }
    count=0;
    j=0;
    while(j<len){
        if(count%2==0){
            for(i=0;i<rails;i++){
                code[i][j]=(int)str[j];
                j++;
            }
        }
        else{
            for(i=rails-2;i>0;i--){
                code[i][j]=(int)str[j]; 
                j++;
            }
        }
        count++;
    }
    for(i=0;i<rails;i++){
        for(j=0;j<len;j++){
            if(code[i][j]!=0){
             printf("%c",code[i][j]);
            }
        }
    }
    printf("\n");
}
