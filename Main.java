import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Main extends JFrame {
    JPanel panel1, panel2, panel3, panel4, panel5, panel6, finalPanel;
    JTextField teamField, cityField, salaryField, playerField, findField;
    JLabel teamLabel, cityLabel, salaryLabel, playerLabel;
    JButton addButton, findButton, removeButton, copyButton, removeDupe, findMax, leagueButton;
    public JTextArea area;
    public static LinkedList list = new LinkedList();

    public void TeamApp() {
        setTitle("Baseball Team List");
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //makes the GUI, defines the variables
        JLabel teamLabel = new JLabel("Team:");
        JLabel cityLabel = new JLabel("City:");
        JLabel salaryLabel = new JLabel("Salary:");
        JLabel playerLabel = new JLabel("Players:");

        JTextField teamField = new JTextField(10);
        JTextField cityField = new JTextField(10);
        JTextField salaryField = new JTextField(10);
        JTextField playerField = new JTextField(10);
        JTextField findField = new JTextField(10);

        JButton addButton = new JButton("Add Team:");
        JButton findButton = new JButton("Find team:");
        JButton removeButton = new JButton("Remove Team After:");
        JButton copyButton = new JButton("Create Copy League:");
        JButton removeDupe = new JButton("Remove Dupe:");
        JButton findMax = new JButton("Find Max Salary");
        JButton leagueButton = new JButton("Display League");

        JTextArea area = new JTextArea(10,30);
        JScrollPane scrollPane = new JScrollPane(area);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // adds action listeners to all the button, gets info from text field for methods and displays in TextArea
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BaseballTeam team = new BaseballTeam(teamField.getText(), cityField.getText(), Integer.parseInt(playerField.getText()), Integer.parseInt(salaryField.getText()));
                list.insertNode(team);
                area.append("The " + team.getCity() + " " + team.getName() + " have been added to the league" + "\n");
                System.out.println(team.getName());
            }
        });

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BaseballTeam team = list.findNode((findField.getText())).getTeam();
                area.append("Team Name: " + team.getName() + "\n");
                area.append("City: " + team.getCity() + "\n");
                area.append("Number of Players: " + team.getPlayers() + "\n");
                area.append("Team Salary: " + team.getSalaryCap() + "$ (Millions)" + "\n");
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            TeamNode team = list.findNode((findField.getText()));
            area.append("The " + team.getNext().getTeam().getName() + "have been removed" + "\n");
            list.removeAfter(team);
            }
        });
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LinkedList listCopy = list.copy();
                area.append("League copy has been generated with " + listCopy.length() + " teams." + "\n");
            }
        });
        removeDupe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.removeDuplicate(findField.getText());
                area.append(findField.getText() + "has been removed" + "\n");
            }
        });
        findMax.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int maxSalary = list.max(list.head);
                area.append("Top team salary: $" + maxSalary + " Million" + "\n");
            }
        });
        leagueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String league = list.printLeague();
                area.append("League Teams: " + league + "\n");
            }
        });

        //puts everything into variables
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JPanel finalPanel = new JPanel();

        panel1.add(teamLabel);
        panel1.add(teamField);
        panel1.add(cityLabel);
        panel1.add(cityField);
        panel2.add(salaryLabel);
        panel2.add(salaryField);
        panel2.add(playerLabel);
        panel2.add(playerField);
        panel3.add(addButton);
        panel4.add(scrollPane);
        panel5.add(findButton);
        panel5.add(findField);
        panel5.add(removeButton);
        panel6.add(copyButton);
        panel6.add(findMax);
        panel6.add(removeDupe);
        panel6.add(leagueButton);

        finalPanel.add(panel1);
        finalPanel.add(panel2);
        finalPanel.add(panel3);
        finalPanel.add(panel4);
        finalPanel.add(panel5);
        finalPanel.add(panel6);
        add(finalPanel);
    }

    public static void main(String[] args) {
        Main teamGUI = new Main();
        teamGUI.TeamApp();
        teamGUI.setVisible(true);
    }
}