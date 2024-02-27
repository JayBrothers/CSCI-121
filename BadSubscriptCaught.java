import java.util.Scanner;
public class BadSubscriptCaught {
    static String[] nameList= new String[10];
    public static void main(String[]args){
        nameList = new String[]{"Jim", "John", "Jason", "James","Jonathan","Brad","Andy","Robert","Henry","Chris"};
        Scanner sc = new Scanner(System.in);
        boolean x = false;
        while (!x) {
            try {
                System.out.println("Enter Number>>");
                int num = sc.nextInt();
                System.out.println(nameList[num]);
                x = true;
            } catch (Exception ArrayIndexOutOfBoundException) {
                System.out.println("Number Out Of Range, Number must be below 10");

            }
        }
    }
}
