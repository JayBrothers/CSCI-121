import javax.swing.*;
import java.util.Scanner;
public class Main extends JFrame {
    public void bankApp(){
        setTitle("Brothers Banking");
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabPanel = new JTabbedPane();
        JPanel checkingPanel = new JPanel();
        checkingPanel.add(new JLabel("Checking Account"));
        JPanel savingsPanel = new JPanel();
        savingsPanel.add(new JLabel("Savings Account"));

        tabPanel.addTab("Checking Account", checkingPanel);
        tabPanel.addTab("Savings Account", savingsPanel);

        add(tabPanel);
    }
    public static void main(String[] args){
//        Scanner sc1 = new Scanner(System.in);
//        System.out.println("");
        Main bankGUI = new Main();
        bankGUI.bankApp();
        bankGUI.setVisible(true);

    }
}