import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class OrderPizza extends JFrame{
    private JButton deliveryButton, addToppingButton, pickUpButton, createButton;
    private JLabel deliveryLabel, toppingsLabel, addressLabel, headerLabel, tipLabel;
    private JTextArea toppingsArea;
    private JTextField toppingField, addressField, tipField;
    private Boolean deliveryTF;
    private String topping;
    private ArrayList<String> toppingsList;
    private int counter;

    public void Website(){
        Font pizzaFont = new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 20);
        Font deliveryFont = new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 15);

        toppingsList = new ArrayList<>();
        counter = 0;
        setTitle("Shopping List");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel headerLabel = new JLabel("Brothers Pizzeria", SwingConstants.CENTER);
        headerLabel.setFont(pizzaFont);


        JPanel toppingPanel = new JPanel();
        toppingsLabel = new JLabel("Add Toppings");
        toppingField = new JTextField(10);
        addToppingButton = new JButton("Add");
        createButton = new JButton("Create Pizza");

        toppingsArea = new JTextArea(5,10);

        toppingPanel.add(toppingsLabel);
        toppingPanel.add(toppingField);
        toppingPanel.add(addToppingButton);
        toppingPanel.add(createButton);

        deliveryButton = new JButton("Delivery");
        pickUpButton = new JButton("PickUp");
        JPanel panel1 = new JPanel(new GridLayout(2,1));
        panel1.add(deliveryButton);
        panel1.add(pickUpButton);

        JPanel panel2 = new JPanel(new GridLayout(5,1));
        deliveryLabel = new JLabel("  Delivery:  ");
        addressField = new JTextField();
        addressLabel = new JLabel("Enter Address:");
        panel2.add(deliveryLabel, SwingConstants.CENTER);
        deliveryLabel.setFont(deliveryFont);
        tipLabel = new JLabel("Driver tip:");
        tipField = new JTextField(10);
        panel2.add(addressLabel);
        panel2.add(addressField);
        panel2.add(tipLabel);
        panel2.add(tipField);
        panel2.setVisible(false);

        addToppingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (counter <= 9) {
                    topping = toppingField.getText();
                    toppingsArea.append(topping + " has been added to pizza" + "\n");
                    toppingsList.add(topping);
                    counter += 1;
                }
                if (counter > 9){
                    toppingsArea.append("Max toppings have been reached" + "\n");
                }
            }
        });

        deliveryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.setVisible(true);
                deliveryTF = true;
            }
        });
        pickUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.setVisible(false);
                deliveryTF = false;
            }
        });

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (deliveryTF){
                    Pizza pizza = new Pizza(toppingsList, toppingsList.size());
                    DeliveryPizza dpizza = new DeliveryPizza(pizza, addressField.getText(), tipField.getText());
                    toppingsArea.append("\n");
                    toppingsArea.append("Order Placed:" + "\n");
                    toppingsArea.append("Pizza with " + pizza.getNumberToppings() + " toppings \n");
                    toppingsArea.append("Toppings: " + pizza.getToppingsList() + "\n");
                    toppingsArea.append("Price: $" + pizza.getPrice() + "\n");
                    toppingsArea.append("Delivery Fee: $" + dpizza.getDeliveryFee() + "\n");
                    toppingsArea.append("Driver Tip: $" + dpizza.getTip() + "\n");
                    toppingsArea.append("Total: $" + dpizza.getTotalCost() + "\n");
                    toppingsArea.append("Delivered to:" + addressField.getText() + "\n");
                }
                if (!deliveryTF){
                    Pizza pizza = new Pizza(toppingsList, toppingsList.size());
                    toppingsArea.append("\n");
                    toppingsArea.append("Order Placed:" + "\n");
                    toppingsArea.append("Pizza with " + pizza.getNumberToppings() + " toppings \n");
                    toppingsArea.append("Toppings: " + pizza.getToppingsList() + "\n");
                    toppingsArea.append("Price: $" + pizza.getPrice() + "\n");
                }
            }
        });

        JPanel finalPanel = new JPanel(new BorderLayout());

        finalPanel.add(headerLabel, BorderLayout.NORTH);
        finalPanel.add(toppingPanel,BorderLayout.SOUTH);
        finalPanel.add(panel1, BorderLayout.WEST);
        finalPanel.add(panel2, BorderLayout.EAST);
        finalPanel.add(toppingsArea, BorderLayout.CENTER);
        add(finalPanel);
    }
    public static void main(String[] args) {
        OrderPizza pizzaGUI = new OrderPizza();
        pizzaGUI.Website();
        pizzaGUI.setVisible(true);
    }
}
