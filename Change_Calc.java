import java.util.Scanner;
public class Change_Calc {
    public static void main(String[] args) {
        System.out.println("Enter The Amount: ");
        Scanner sc = new Scanner(System.in);
        String amount = sc.nextLine();

        // Checks if User input is positive
        if (amount.indexOf('-') != -1){
            System.out.println("Error: Number cannot be negative");
            System.exit(0);
        }

        // checks if user input is change with two decimal places
        int index = amount.indexOf('.');
        int decimalPlaces = amount.length() - index - 1;
        if (decimalPlaces != 2) {
            System.out.println("Error: Change amount must have two decimal places");
            System.exit(0);
        }

        // Converts from str to int and dollars to pennies
        String new_amount = amount.replace(".","");
        int change_amount = Integer.parseInt(new_amount);
        int quarters = change_amount / 25;
        change_amount %= 25;
        int dimes = change_amount / 10;
        change_amount %= 10;
        int nickles = change_amount / 5;
        change_amount %= 5;
        int pennies = change_amount;

        //Prints results only if type of change is given
        System.out.println("Total Amount: $" + amount);
        if (quarters != 0) {
            System.out.println("Change in quarters: " + quarters);}
        if (dimes != 0) {
            System.out.println("Change in dimes: " + dimes);}
        if (nickles != 0) {
            System.out.println("Change in nickles: " + nickles);}
        if (pennies != 0) {
            System.out.println("Change in pennies: " + pennies);}

    }
}
