import java.util.Arrays;
import java.util.Scanner;
public class ArrayLab {
    static double[] numList = new double[20];
    static int counter = 0;
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    for (int i = 0 ; i < numList.length; i++) {
        System.out.println("Enter number>>");
        double num = sc.nextDouble();
        if (num == 9999) {
            break; // if ended early, array will add to a new array so there are no extra 0's
        } else {
            numList[i] = num;// else add to original array and print
            counter++;
        }
    }
    double[] numList2 = new double[counter];

    for (int x = 0 ; x < counter; x++) {
        numList2[x] = numList[x];
    }
    System.out.println(Arrays.toString(numList2));
    }

}
