public class transaction {
    private int amount;
    public String transType, disc;
    public Date date;
    public transaction(String transType, String disc, int amount, Date dateTime) {
        this.transType = transType;
        this.disc = disc;
        this.amount = amount;
        this.date = dateTime;
    }

    public Date getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public String getDisc() {
        return disc;
    }

    public String getTransType() {
        return transType;
    }
}
