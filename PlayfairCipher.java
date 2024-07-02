import java.awt.Point;
import java.util.Scanner;

public class PlayfairCipher {

    private int length = 0;
    private String[][] table;

    public static void main(String[] args) {
        PlayfairCipher pf = new PlayfairCipher();
        pf.runCipher();
    }

    private void runCipher() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the key for playfair cipher: ");
        String key = parseString(sc);
        while (key.equals("")) {
            key = parseString(sc);
        }
        table = this.cipherTable(key);

        System.out.print("Enter the plaintext to be enciphered: ");
        String input = parseString(sc);
        while (input.equals("")) {
            input = parseString(sc);
        }
        String output = cipher(input);
        String decodedOutput = decode(output);

        this.keyTable(table);
        this.printResults(output, decodedOutput);

        sc.close();
    }

    private String parseString(Scanner sc) {
        String parse = sc.nextLine().toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        return parse;
    }

    private String[][] cipherTable(String key) {
        String[][] playfairTable = new String[5][5];
        String keyString = key + "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        boolean[] used = new boolean[26];
        int index = 0;

        for (char c : keyString.toCharArray()) {
            if (c == 'J') continue;
            int pos = c - 'A';
            if (!used[pos]) {
                playfairTable[index / 5][index % 5] = String.valueOf(c);
                used[pos] = true;
                index++;
            }
        }

        return playfairTable;
    }

    private String cipher(String in) {
        StringBuilder input = new StringBuilder(in);
        length = input.length() / 2 + input.length() % 2;

        for (int i = 0; i < (length - 1); i++) {
            if (input.charAt(2 * i) == input.charAt(2 * i + 1)) {
                input.insert(2 * i + 1, 'X');
                length = input.length() / 2 + input.length() % 2;
            }
        }

        if (input.length() % 2 != 0) {
            input.append('X');
            length++;
        }

        String[] digraph = new String[length];
        for (int j = 0; j < length; j++) {
            digraph[j] = input.charAt(2 * j) + "" + input.charAt(2 * j + 1);
        }

        StringBuilder out = new StringBuilder();
        String[] encDigraphs = encodeDigraph(digraph);
        for (String s : encDigraphs) {
            out.append(s);
        }

        return out.toString();
    }

    private String[] encodeDigraph(String[] di) {
        String[] encipher = new String[length];
        for (int i = 0; i < length; i++) {
            char a = di[i].charAt(0);
            char b = di[i].charAt(1);
            int r1 = (int) getPoint(a).getX();
            int r2 = (int) getPoint(b).getX();
            int c1 = (int) getPoint(a).getY();
            int c2 = (int) getPoint(b).getY();

            if (r1 == r2) {
                c1 = (c1 + 1) % 5;
                c2 = (c2 + 1) % 5;
            } else if (c1 == c2) {
                r1 = (r1 + 1) % 5;
                r2 = (r2 + 1) % 5;
            } else {
                int temp = c1;
                c1 = c2;
                c2 = temp;
            }

            encipher[i] = table[r1][c1] + "" + table[r2][c2];
        }
        return encipher;
    }

    private String decode(String out) {
        StringBuilder decoded = new StringBuilder();
        for (int i = 0; i < out.length() / 2; i++) {
            char a = out.charAt(2 * i);
            char b = out.charAt(2 * i + 1);
            int r1 = (int) getPoint(a).getX();
            int r2 = (int) getPoint(b).getX();
            int c1 = (int) getPoint(a).getY();
            int c2 = (int) getPoint(b).getY();

            if (r1 == r2) {
                c1 = (c1 + 4) % 5;
                c2 = (c2 + 4) % 5;
            } else if (c1 == c2) {
                r1 = (r1 + 4) % 5;
                r2 = (r2 + 4) % 5;
            } else {
                int temp = c1;
                c1 = c2;
                c2 = temp;
            }

            decoded.append(table[r1][c1]).append(table[r2][c2]);
        }
        return decoded.toString();
    }

    private Point getPoint(char c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (c == table[i][j].charAt(0)) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    private void keyTable(String[][] printTable) {
        System.out.println("Playfair Cipher Key Matrix: ");
        for (String[] row : printTable) {
            for (String s : row) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    private void printResults(String encipher, String dec) {
        System.out.println("Encrypted Message: " + encipher);
        System.out.println("Decrypted Message: " + dec);
    }
}
