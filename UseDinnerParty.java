import java.util.Scanner;

public class UseDinnerParty {
    public static void main(String[] args){
        Party party1 = new Party();
        DinnerParty dinnerParty1 = new DinnerParty();
        BirthdayParty birthdayParty1 = new BirthdayParty();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of guests for the party>>");
        short numberOfGuests = sc.nextShort();
        party1.setNumberOfGuests(numberOfGuests);

        System.out.println("The party has " + party1.getNumberOfGuests() + " guests");
        party1.displayInvitation();

        System.out.print("Enter number of guests for the dinner party>>");
        short numberOfGuestsDinner = sc.nextShort();
        dinnerParty1.setNumberOfGuests(numberOfGuestsDinner);

        System.out.print("Enter the menu option -- 1 for chicken or 2 for Veggie>>");
        String menuOption = sc.next();
        dinnerParty1.setDinnerChoice(menuOption);

        System.out.println("The dinner party has " + dinnerParty1.getNumberOfGuests() + " guests");
        System.out.println("Menu Option " + dinnerParty1.getDinnerChoice() + " will be served");
        dinnerParty1.displayInvitation();

        System.out.print("Enter number of guests for the birthday party>>");
        short numberOfGuestsBirthday = sc.nextShort();
        birthdayParty1.setNumberOfGuests(numberOfGuestsBirthday);

        System.out.print("Enter the cake option -- 1 for chocolate or 2 for vanilla>>");
        String cakeOption = sc.next();
        birthdayParty1.setCakeChoice(cakeOption);

        System.out.println("The birthday party has " + birthdayParty1.getNumberOfGuests() + " guests");
        System.out.println("Cake Option " + birthdayParty1.getCakeChoice() + " will be served");
        dinnerParty1.displayInvitation();

    }
}
