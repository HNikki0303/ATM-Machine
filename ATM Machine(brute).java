
// recursion 
//time and space complexity
//code of reverse string
import java.util.*;

class ATM {
    // creating global variables to use in different cases
    public static int a;
    public static int b;
    public static int c;
    public static int d;
    public static int e;
    public static int f;
    public static int g;
    public static int h;
    public static int i;
    public static int j;
    public static int k;
    public static int l;
    public static int bankbalance = 0;

    public static void main(String[] args) {
        // main function
        Scanner sc = new Scanner(System.in);
        instructions();
        int user = sc.nextInt();
        while (true) {
            switch (user) {
                case 1:
                    deposit();
                    instructions();
                    user = sc.nextInt();
                    break;
                case 2:
                    withdraw();
                    instructions();
                    user = sc.nextInt();
                    break;
                case 3:
                    System.out.println("exit");
                    instructions();
                    user = sc.nextInt();
                    break;
            }

        }
    }

    // function to deposit money
    public static void deposit() {
        System.out.println("fill the amount to be deposited ");
        Scanner input = new Scanner(System.in);
        int amount = input.nextInt();// amount to be deposited
        // upgrading the bank balance after every deposit
        bankbalance = bankbalance + amount;
        f = (bankbalance) / 500;
        int p = (bankbalance) % 500;
        e = p / 200;
        int q = p % 200;
        d = q / 100;
        int r = q % 100;
        c = r / 50;
        int s = r % 50;
        b = s / 20;
        int t = s % 20;
        a = t / 10;
        int left = t % 10;
        // the global variables are used here and some local variables ave been used
        // a 2d array to store denominations of each note
        int[][] denominations = new int[2][6];
        denominations[0][0] = 500;
        denominations[0][1] = 200;
        denominations[0][2] = 100;
        denominations[0][3] = 50;
        denominations[0][4] = 20;
        denominations[0][5] = 10;
        denominations[1][0] = f;
        denominations[1][1] = e;
        denominations[1][2] = d;
        denominations[1][3] = c;
        denominations[1][4] = b;
        denominations[1][5] = a;
        System.out.println("denomination of each note for this deposited amount is:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(denominations[i][j] + " ");
            }
            System.out.println();
        }

    }

    // function to withdraw an amount
    public static void withdraw() {
        System.out.println(" fill the amount to be withdrawn");
        Scanner out = new Scanner(System.in);
        int withdraw = out.nextInt();
        // withdrawl depends upon the deposited money and bank balance
        if (withdraw > bankbalance) {
            System.out.println("insufficient  bank balance");
        } else {
            l = (withdraw) / 500;// shall be made a function
            int p = (withdraw) % 500;
            k = p / 200;
            int q = p % 200;
            j = q / 100;
            int r = q % 100;
            i = r / 50;
            int s = r % 50;
            h = s / 20;
            int t = s % 20;
            g = t / 10;
            int left = t % 10;
            // best case scenerio when larger deominations are available
            if (a < g || b < g || c < i || d < j || e < k || f < l) {
                withdrawl_denominations();
                // upgrading the bank balance
                bankbalance = bankbalance - withdraw;
            } else {
                // not the best case when the required large denominations are not available
                int token = 1;
                switch (token) {
                    case 1:
                        if (l < f) {
                            l = withdraw / 500;
                            p = withdraw % 500;
                            withdraw = p;
                        }

                    case 2:
                        if (k < e) {
                            k = withdraw / 200;
                            q = p % 200;
                            withdraw = q;
                        }
                    case 3:
                        if (j < d) {
                            j = withdraw / 100;
                            r = q % 100;
                            withdraw = r;
                        }
                    case 4:
                        if (i < c) {
                            i = withdraw / 50;
                            s = r % 50;
                            withdraw = s;
                        }
                    case 5:
                        if (h < b) {
                            h = withdraw / 20;
                            t = s % 20;
                            withdraw = t;
                        }
                    case 6:
                        if (g < a) {
                            g = withdraw / 10;
                        }
                        // left= q%10;
                    case 7:
                        withdrawl_denominations();

                }
                // upgrading the bank balance
                bankbalance = bankbalance - withdraw;
            }
        }
    }

    public static void withdrawl_denominations() {
        int[][] denominations = new int[2][6];
        denominations[0][0] = 500;
        denominations[0][1] = 200;
        denominations[0][2] = 100;
        denominations[0][3] = 50;
        denominations[0][4] = 20;
        denominations[0][5] = 10;
        denominations[1][0] = l;
        denominations[1][1] = k;
        denominations[1][2] = j;
        denominations[1][3] = i;
        denominations[1][4] = h;
        denominations[1][5] = g;
        System.out.println("denomination of each note of the withdrawn amount");
        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 6; y++) {
                System.out.print(denominations[x][y] + " ");
            }
            System.out.println();
        }
    }

    public static void instructions() {
        System.out.println(" press 1 for deposit");
        System.out.println(" press 2 for withdraw");
        System.out.println(" press 3 for exit");

    }
}