import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestWedding extends JFrame {
    private JLabel brideLabel, groomLabel, dateLabel, locationLabel, guestLabel, couple_statement, location_statement, date_statement, guest_statement;
    private JTextField brideFirstText, brideLastText, groomFirstText, groomLastText,
            dateText, locationText, guestText;
    private JButton invitation;

    public void weddingPlanner() {
        setTitle("Wedding Planner");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel finalPanel = new JPanel();
        finalPanel.setLayout(new GridLayout(6, 1));

        couple_statement = new JLabel("");
        date_statement = new JLabel("");
        location_statement = new JLabel("");
        guest_statement = new JLabel("");

        invitation = new JButton("Create Invitation");
        invitation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String brideFirst = brideFirstText.getText();
                String brideLast = brideLastText.getText();
                Person bride1 = new Person(brideFirst, brideLast);

                String groomFirst = groomFirstText.getText();
                String groomLast = groomLastText.getText();
                Person groom1 = new Person(groomFirst, groomLast);

                Couple couple1 = new Couple(bride1, groom1);

                String guests = guestText.getText();


                String location = locationText.getText();
                String date = dateText.getText();

                Wedding wedding1 = new Wedding(couple1, location, date, guests);

                couple_statement.setText("You are invited to the wedding of " + wedding1.getCouple().getBride().getFirstName() + " " + wedding1.getCouple().getBride().getLastName() + " and " + wedding1.getCouple().getGroom().getFirstName() + " " + wedding1.getCouple().getGroom().getLastName());
                date_statement.setText("The wedding will occur at " + wedding1.getWeddingDate());
                location_statement.setText("The wedding will take place on " + wedding1.getLocation());
                guest_statement.setText("There will be " + wedding1.getGuests() + " guests");
            }
        });

        JPanel bridePanel = new JPanel();
        brideLabel = new JLabel("Bride:");
        brideFirstText = new JTextField(10);
        brideLastText = new JTextField(10);
        bridePanel.add(brideLabel);
        bridePanel.add(brideFirstText);
        bridePanel.add(brideLastText);

        JPanel groomPanel = new JPanel();
        groomLabel = new JLabel("Groom:");
        groomFirstText = new JTextField(10);
        groomLastText = new JTextField(10);
        groomPanel.add(groomLabel);
        groomPanel.add(groomFirstText);
        groomPanel.add(groomLastText);

        JPanel datePanel = new JPanel();
        dateLabel = new JLabel("Enter Wedding Date:");
        dateText = new JTextField(10);
        datePanel.add(dateLabel);
        datePanel.add(dateText);

        JPanel guestPanel = new JPanel();
        guestLabel = new JLabel("Enter number of guests:");
        guestText = new JTextField(10);
        guestPanel.add(guestLabel);
        guestPanel.add(guestText);

        JPanel locationPanel = new JPanel();
        locationLabel = new JLabel("Enter Wedding Location:");
        locationText = new JTextField(20);
        locationPanel.add(locationLabel);
        locationPanel.add(locationText);
        locationPanel.add(invitation);

        finalPanel.add(bridePanel);
        finalPanel.add(groomPanel);
        finalPanel.add(datePanel);
        finalPanel.add(guestPanel);
        finalPanel.add(locationPanel);

        JPanel invPanel = new JPanel(new GridLayout(4, 1));
        invPanel.add(couple_statement);
        invPanel.add(date_statement);
        invPanel.add(location_statement);
        invPanel.add(guest_statement);

        finalPanel.add(invPanel);
        add(finalPanel);
    }

    public static void main(String[] args) {
        TestWedding weddingGUI = new TestWedding();
        weddingGUI.weddingPlanner();
        weddingGUI.setVisible(true);
    }
}
