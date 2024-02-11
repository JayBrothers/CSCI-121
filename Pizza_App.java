import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Pizza_App extends JFrame{
    //creates variables
    private JCheckBox pepCheckBox, exChCheckBox, sausageCheckBox, mushCheckBox;
    private JRadioButton smallButton, mediumButton, largeButton, superButton, deliveryButton, pickUpButton;
    private JButton totalButton;
    private JLabel totalLabel;
    public Pizza_App() {
        setTitle("BigY Pizzeria");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creates sub panels for each category so all items show up
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel sPanel = new JPanel();
        sPanel.setLayout(new BoxLayout(sPanel, BoxLayout.Y_AXIS));

        JPanel dPanel = new JPanel();
        dPanel.setLayout(new BoxLayout(dPanel, BoxLayout.Y_AXIS));

        // creates boxes/ buttons
        JLabel toppingsLabel = new JLabel("Toppings (Add up to Three)");
        pepCheckBox = new JCheckBox("Pepperoni");
        exChCheckBox = new JCheckBox("Extra Cheese");
        mushCheckBox = new JCheckBox("Mushrooms");
        sausageCheckBox = new JCheckBox("Sausage");

        JLabel sizeLabel = new JLabel("Pizza Size");
        smallButton = new JRadioButton("Small (10in)");
        mediumButton = new JRadioButton("Medium (12in)");
        largeButton = new JRadioButton("Large (14in)");
        superButton = new JRadioButton("Super (16in)");

        JLabel deliveryLabel = new JLabel("Delivery:");
        deliveryButton = new JRadioButton("Delivery");
        pickUpButton = new JRadioButton("PickUp");

        //adds items to panels
        panel.add(toppingsLabel);
        panel.add(pepCheckBox);
        panel.add(exChCheckBox);
        panel.add(mushCheckBox);
        panel.add(sausageCheckBox);

        //create button groups for radio buttons so only one can be selected
        ButtonGroup sizeGroup = new ButtonGroup();
        sizeGroup.add(smallButton);
        sizeGroup.add(mediumButton);
        sizeGroup.add(largeButton);
        sizeGroup.add(superButton);

        sPanel.add(sizeLabel);
        sPanel.add(smallButton);
        sPanel.add(mediumButton);
        sPanel.add(largeButton);
        sPanel.add(superButton);

        ButtonGroup dGroup = new ButtonGroup();
        dGroup.add(deliveryButton);
        dGroup.add(pickUpButton);

        dPanel.add(deliveryLabel);
        dPanel.add(deliveryButton);
        dPanel.add(pickUpButton);

        //Create new panels for final layout and add panels to
        JPanel toppingsPanel = new JPanel();
        toppingsPanel.setLayout(new BorderLayout());
        toppingsPanel.add(panel, BorderLayout.CENTER);

        JPanel sizePanel = new JPanel();
        sizePanel.setLayout(new BorderLayout());
        sizePanel.add(sPanel, BorderLayout.CENTER);

        JPanel deliveryPanel = new JPanel();
        deliveryPanel.setLayout(new BorderLayout());
        deliveryPanel.add(dPanel, BorderLayout.CENTER);


        Font pizzaFont = new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 20);


        JPanel bPanel = new JPanel();
        JLabel headerLabel = new JLabel("BigY Pizzeria");
        headerLabel.setFont(pizzaFont);
        bPanel.add(headerLabel);

        //Added ActionListeners that function when total button is clicked, will display a total price after checking what is selected
        JPanel tPanel = new JPanel();
        tPanel.setLayout(new FlowLayout());
        totalButton = new JButton("Total: ");
        totalLabel = new JLabel();
        totalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double toppingPrice = 0;
                double basePrice = 0;
                double deliveryFee = 0;
                int toppingCounter = 0;

                if (pepCheckBox.isSelected()) {
                    toppingPrice += 0.5;
                    toppingCounter += 1;
                }

                if (mushCheckBox.isSelected()) {
                    toppingPrice += 0.5;
                    toppingCounter += 1;
                }

                if (sausageCheckBox.isSelected()) {
                    toppingPrice += 0.5;
                    toppingCounter += 1;
                }

                if (exChCheckBox.isSelected()) {
                    toppingPrice += 0;
                    toppingCounter += 1;
                }

                if (smallButton.isSelected()) {
                    basePrice += 5;
                }

                if (toppingPrice == 1.5) {
                    toppingPrice -= 0.25;
                }

                if (mediumButton.isSelected()) {
                    basePrice += 10;
                }

                if (largeButton.isSelected()) {
                    basePrice += 15;
                }

                if (superButton.isSelected()) {
                    basePrice += 20;
                }

                if (deliveryButton.isSelected()) {
                    deliveryFee += 5;

                }

                double totalPrice = toppingPrice + basePrice + deliveryFee;


                if (toppingCounter <= 3) {
                totalLabel.setText("$" + Double.toString(totalPrice));}
                else {
                    totalLabel.setText("Can only have up to 3 toppings");
                }


            }
        });
        tPanel.add(totalButton);
        tPanel.add(totalLabel);

        //sets the panels to the correct location
        add(bPanel, BorderLayout.NORTH);
        add(tPanel, BorderLayout.SOUTH);
        add(dPanel, BorderLayout.CENTER);
        add(toppingsPanel, BorderLayout.EAST);
        add(sizePanel, BorderLayout.WEST);
        setVisible(true);


    }
    //runs the code
    public static void main(String[] args) {
        new Pizza_App();
    }


}
