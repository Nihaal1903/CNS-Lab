#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main() {
    int key[3][3];
    printf("Enter key matrix:\n");
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            scanf("%d", &key[i][j]);
        }
    }

    getchar(); // To consume the newline character left by scanf
    char plaintext[100];
    printf("Enter plaintext: ");
    scanf("%[^\n]",plaintext);
     // Remove trailing newline
    for (int i = 0; i < strlen(plaintext); i++) {
        plaintext[i] = toupper(plaintext[i]);
    }

    char ct[100] = "";
    for (int k = 0; k < strlen(plaintext); k += 3) {
        int vector[3];
        for (int i = 0; i < 3; i++) {
            vector[i] = plaintext[k + i] - 'A';
        }
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += key[i][j] * vector[j];
            }
            char encryptedChar = (sum % 26) + 'A';
            strncat(ct, &encryptedChar,1);
        }
    }

    printf("Plain text: %s\n", plaintext);
    printf("Encrypted text: %s\n", ct);

    return 0;
}
