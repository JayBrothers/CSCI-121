import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShoppingList extends JFrame {
    public ArrayList<ItemOrder> list = new ArrayList<ItemOrder>();
    public void addItemOrder(ItemOrder product){
        list.add(product);
    }
    public void removeItemOrder(ItemOrder product){
        list.remove(product);
    }

    private JTextArea shopping_list;
    private JTextField nameText, quantityText, priceText, searchText;
    private JLabel productLabel, quantityLabel, priceLabel, totalLabel;
    private JButton addButton, removeButton, cartButton, totalButton, searchButton;

    public void Shop() {
        setTitle("Shopping List");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        productLabel = new JLabel("Product:");
        quantityLabel = new JLabel("Quantity:");
        priceLabel = new JLabel("Price:");
        nameText = new JTextField(10);
        quantityText = new JTextField(10);
        priceText = new JTextField(10);

        JPanel panel1 = new JPanel();
        panel1.add(productLabel);
        panel1.add(nameText);
        panel1.add(quantityLabel);
        panel1.add(quantityText);
        panel1.add(priceLabel);
        panel1.add(priceText);

        addButton = new JButton("Add Item");
        removeButton = new JButton("Remove Item");
        cartButton = new JButton("Show Cart");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = nameText.getText();
                String quantity = quantityText.getText();
                String price = priceText.getText();

                Item product = new Item(item, Integer.parseInt(price));
                ItemOrder order = new ItemOrder(product, Integer.parseInt(quantity));

                addItemOrder(order);
                shopping_list.append(quantity + " " + item + " have been added to cart" + "\n");

            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = nameText.getText();
                String quantity = quantityText.getText();
                String price = priceText.getText();
                Boolean check = null;

                for (ItemOrder order : list) {
                    if (order.getItem().getName().equals(item) && order.getQuantity() == Integer.parseInt(quantity)) {
                        removeItemOrder(order);
                        shopping_list.append(quantity + " " + item + " has been removed" + "\n");
                        check = Boolean.TRUE;
                        break;
                    }
                }
                if (check == null){
                    shopping_list.append("Item not in cart" + "\n");
                }
            }
        });

        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shopping_list.append("Cart:" + "\n");
                for(ItemOrder order : list){
                    shopping_list.append(order.getQuantity() + " " + order.getItem().getName() + "\n");
                }
            }
        });

        JPanel panel2 = new JPanel();
        panel2.add(addButton);
        panel2.add(removeButton);
        panel2.add(cartButton);

        searchButton = new JButton("Search Cart:");
        searchText = new JTextField(10);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String search_item = searchText.getText();
                Boolean check = null;
                for(ItemOrder order : list) {
                    if (search_item.equals(order.getItem().getName())){
                        shopping_list.append("you have " + order.getQuantity() + " " + order.getItem().getName() + " in your cart" + "\n");
                        check = Boolean.TRUE;
                        break;
                    }
                }
                if (check == null){
                    shopping_list.append("Item not in cart" + "\n");
                }
            }
        });

        JPanel panel3 = new JPanel();
        panel3.add(searchButton);
        panel3.add(searchText);

        shopping_list = new JTextArea(5,20);
        JScrollPane scrollPane = new JScrollPane(shopping_list);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JPanel orderPanel = new JPanel();
        orderPanel.add(scrollPane);

        totalButton = new JButton("Cart Total:");
        totalLabel = new JLabel();

        totalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int total_cost = 0;
                for(ItemOrder order : list) {
                    total_cost += order.getTotal();
                }
                totalLabel.setText(String.valueOf(total_cost));

            }
        });

        JPanel totalPanel = new JPanel();
        totalPanel.add(totalButton);
        totalPanel.add(totalLabel);

        JPanel finalPanel = new JPanel(new GridLayout(5, 1));
        finalPanel.add(panel1);
        finalPanel.add(panel2);
        finalPanel.add(panel3);
        finalPanel.add(orderPanel);
        finalPanel.add(totalPanel);

        add(finalPanel);

    }
    public static void main(String[] args) {
        ShoppingList cartGUI = new ShoppingList();
        cartGUI.Shop();
        cartGUI.setVisible(true);
    }

}
