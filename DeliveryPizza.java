public class DeliveryPizza {
    private Pizza pizza;
    private int deliveryFee, totalCost;
    private String deliveryAddress, tip;
    public DeliveryPizza(Pizza pizza, String deliveryAddress, String tip){
        this.pizza = pizza;
        this.deliveryAddress = deliveryAddress;
        this.tip = tip;
        if (pizza.getPrice() > 18){
            this.deliveryFee = 3;
        }
        else {
            this.deliveryFee = 5;
        }
        this.totalCost = deliveryFee + pizza.getPrice() + Integer.parseInt(tip);
    }
    public Pizza getPizza(){
        return pizza;
    }
    public int getDeliveryFee(){
        return deliveryFee;
    }
    public String getDeliveryAddress(){
        return deliveryAddress;
    }
    public int getTotalCost(){
        return totalCost;
    }
    public String getTip(){
        return tip;
    }
}

