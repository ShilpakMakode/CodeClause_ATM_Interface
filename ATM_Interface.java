import java.util.ArrayList;
import java.util.Scanner;
// this is a code!!
// SHILPAK SANJAY MAKODE

public class ATM_Interface {
            static int[] accNumbers = {504301, 504302, 504303, 504304};
            static int[] pin = {5431, 5432, 5433, 5434};
            static double[] money /* IN Rupees */ = {515000, 610000, 974000, 1065000};
            static ArrayList <String> transactionHist = new ArrayList<String>();
    public static void AtmMachine() {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Welcome to THE Bank!\nPlease Enter your account number:");
            int AccNum = sc.nextInt();
            System.out.print("Pin:");
            int AccPin = sc.nextInt();

            int a = accNumbers.length+1;
            for (int i = 0; i < accNumbers.length; i++){
                if (accNumbers[i] == AccNum && pin[i] == AccPin ){
                    System.out.println("WELCOME " + accNumbers[i] + "!");
                    a = i;
                    System.out.println("Your Balance is Rs. " + money[a]);
                    break;
                }
            } 
            if (a == accNumbers.length+1){
                System.out.println("INVALID ACCOUNT NUMBER OR PIN!!\nLOGIN AGAIN:-\n");
                AtmMachine();
            }
            while (true) {
            System.out.println("What do you want to do?\nPress Options to do as per given Instructions.");
            System.out.println("Press 1: WITHDRAW");
            System.out.println("Press 2: DEPOSIT");
            System.out.println("Press 3: TRANSFER");
            System.out.println("Press 4: TRANSACTION HISTORY");
            System.out.println("Press 5: QUIT");

            int option = sc.nextInt();

                switch (option) {

                    case 1:
                    System.out.println("Enter Amount To WITHDRAW:");
                    Double amount1;
                    amount1 = sc.nextDouble();
                    if (amount1 > money[a]){
                        System.out.println("Insufficient Balance in Account!!");
                    } else {
                        money[a] -= amount1;
                        String x = ("You have Withdrawn " + amount1 + " from your account number " + accNumbers[a] + ".");
                        System.out.println(x + "\nYour balance is " + money[a]);
                        transactionHist.add(x);
                    }
                    System.out.println();
                    break;

                    case 2:
                    System.out.println("Enter Amount To DEPOSIT:");
                    Double amount2;
                    amount2 = sc.nextDouble();
                        money[a] += amount2;
                        String y = ("You have deposited " + amount2 + " to your account number " + accNumbers[a] + ".");
                        System.out.println(y + "\nYour balance is " + money[a]);
                        transactionHist.add(y);
                        System.out.println();
                    break;

                    case 3:
                    System.out.println("Enter the account number of the benificiary:");
                    int benificiary;
                    benificiary = sc.nextInt();
                    int b;
                    for (int i=0; i<=accNumbers.length; i++) {
                        if (benificiary == accNumbers[i]) {
                            if (benificiary != accNumbers[a]) {
                                b = i;
                                System.out.println("Enter the amount to TRANSFER:");
                                Double Amount3;
                                Amount3 = sc.nextDouble();
                                    if (Amount3 <= money[a]) {
                                        money[b] += Amount3;
                                        money[a] -= Amount3;
                                    } else {
                                        System.out.println("You do not have enough funds to TRANSFER this amount.");
                                        System.out.println("Your Balance is " + money[a]);
                                        break;
                                    }
                                String z = ("The amount " + Amount3 + " is transferred to the account number " + benificiary + ".");
                                System.out.println(z + "\nYour Balance is Rs. " + money[a]);
                                System.out.println();
                                transactionHist.add(z);
                                break;
                            } else {
                                System.out.println("You can not TRANSFER amount to your same Account Number!");
                                System.out.println();
                                break;
                            } 
                        } 
                    }
                    System.out.println();
                    break;

                    case 4:
                    System.out.println("TRANSACTION HISTORY:");
                    for (String transaction : transactionHist) {
                        System.out.println(transaction);
                    }
                    System.out.println();
                    break;

                    case 5:
                    System.out.println("Thank You For Banking with THE Bank!!\nLOGGING OUT!!!");
                    return;

                    default:
                    System.out.println("INVALID INPUT!!\nAUTO LOGGING OUT!!!\nLOGIN AGAIN:-");
                    System.out.println();
                    AtmMachine();
            }
        }
    }
}
        public static void main(String args[]) {
        AtmMachine();
    }
}