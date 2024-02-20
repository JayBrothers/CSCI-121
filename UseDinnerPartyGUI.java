import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UseDinnerPartyGUI extends JFrame {
    //creates swing elements
    private JRadioButton birthdayButton, dinnerButton, option1Button, option2Button;
    private JLabel partyLabel, inv1Label, inv2Label, inv3Label, inv4Label, sizeLabel, menuLabel;
    private JButton invButton;
    private JTextField sizeField;
    public void Party_App(){
        //creates panels, adds swing elements to panels.
        //Text field to enter number of guests, buttons to choose type of party and meal option
        //Invitation Generator that takes user input and make invitation.
        setTitle("Party");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel partyPanel = new JPanel();
        partyPanel.setLayout(new BoxLayout(partyPanel, BoxLayout.Y_AXIS));
        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.Y_AXIS));
        JPanel invPanel = new JPanel();
        invPanel.setLayout(new BoxLayout(invPanel, BoxLayout.Y_AXIS));

        partyLabel = new JLabel("Choose a type of party");
        birthdayButton = new JRadioButton("Birthday Party");
        dinnerButton = new JRadioButton("Dinner Party");

        sizeLabel = new JLabel("Enter number of guests:");
        sizeField = new JTextField(10);

        partyPanel.add(sizeLabel);
        partyPanel.add(sizeField);

        ButtonGroup partyGroup = new ButtonGroup();
        partyGroup.add(birthdayButton);
        partyGroup.add(dinnerButton);

        partyPanel.add(partyLabel);
        partyPanel.add(birthdayButton);
        partyPanel.add(dinnerButton);

        menuLabel = new JLabel("Select a Food Type:");
        option1Button = new JRadioButton("Option 1");
        option2Button = new JRadioButton("Option 2");

        ButtonGroup optionGroup = new ButtonGroup();
        optionGroup.add(option1Button);
        optionGroup.add(option2Button);

        optionPanel.add(menuLabel);
        optionPanel.add(option1Button);
        optionPanel.add(option2Button);

        invButton = new JButton("Create Invitation");
        inv1Label = new JLabel();
        inv2Label = new JLabel();
        inv3Label = new JLabel();
        inv4Label = new JLabel();

        Font font = new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 10);
        inv1Label.setFont(font);
        inv2Label.setFont(font);
        inv3Label.setFont(font);
        inv4Label.setFont(font);


        invPanel.add(invButton);
        invPanel.add(inv1Label);
        invPanel.add(inv2Label);
        invPanel.add(inv3Label);
        invPanel.add(inv4Label);

        invButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String partyType = null;
                DinnerParty dinnerParty1 = new DinnerParty();
                BirthdayParty birthdayParty1 = new BirthdayParty();
            //user selects Birthday or Dinner party
            if (birthdayButton.isSelected()) {
                partyType = "birthday";
            }
            if (dinnerButton.isSelected()) {
                partyType = "dinner";
            }

            // adds user input to setNumberOfGuests(), reads if it is a birthday or dinner then sets
            // the food option to the setCakeChoice() or setDinnerChoice() function
            if (partyType.equals("birthday")) {
                birthdayParty1.setNumberOfGuests(Short.valueOf(sizeField.getText()));
                if (option1Button.isSelected()) {
                    birthdayParty1.setCakeChoice("Chocolate Cake ");
                }
                if (option2Button.isSelected()) {
                    birthdayParty1.setCakeChoice("Vanilla Cake ");
                }
            }
            if (partyType.equals("dinner")) {
                dinnerParty1.setNumberOfGuests(Short.valueOf(sizeField.getText()));
                if (option1Button.isSelected()) {
                    dinnerParty1.setDinnerChoice("Fish ");
                }
                if (option2Button.isSelected()) {
                    dinnerParty1.setDinnerChoice("Steak ");
                }
            }

            // Uses the get() functions to retrieve the information
            // adds it to sentences so invitation is generated
            inv1Label.setText("You are invited to a " + partyType + " party!   ");
            if (partyType.equals("birthday")) {
                inv2Label.setText("There will be " + birthdayParty1.getNumberOfGuests() + " people   ");
                inv3Label.setText("We will be serving " + birthdayParty1.getCakeChoice());
                inv4Label.setText(dinnerParty1.displayInvitation());

            }
            if (partyType.equals("dinner")){
                inv2Label.setText("There will be " + dinnerParty1.getNumberOfGuests() + " people   ");
                inv3Label.setText("We will be serving " + dinnerParty1.getDinnerChoice());
                inv4Label.setText(dinnerParty1.displayInvitation());

            }
            }
        });
        add(partyPanel, BorderLayout.WEST);
        add(optionPanel, BorderLayout.CENTER);
        add(invPanel, BorderLayout.EAST);
    }
    //runs the Party_App() function
    public static void main(String[] args){
        UseDinnerPartyGUI partyGUI = new UseDinnerPartyGUI();
        partyGUI.Party_App();
        partyGUI.setVisible(true);
    }
}
