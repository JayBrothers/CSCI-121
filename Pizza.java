import java.util.ArrayList;

public class Pizza {
    private ArrayList<String> toppingsList;
    private int numberToppings, price;
    private String description;
    public Pizza(ArrayList<String> toppingsList, int numberToppings){
        this.toppingsList = toppingsList;
//        numberToppings = toppingsList.length;
        this.numberToppings = numberToppings;
        this.price = 14 + (numberToppings * 2);
        this.description = String.valueOf(toppingsList);
    }
    public ArrayList<String> getToppingsList() {
        return toppingsList;
    }
    public int getNumberToppings() {
        return numberToppings;
    }
    public int getPrice() {
        return price;
    }
    public String getDescription(){
        return description;
    }
}
