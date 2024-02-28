public class Wedding {
    private Couple couple;
    private String weddingDate;
    private String location;
    private String guests;

    public Wedding(Couple couple, String weddingDate, String location, String guests){
        this.couple = couple;
        this.weddingDate = weddingDate;
        this.location = location;
        this.guests = guests;

    }

    public Couple getCouple(){
        return couple;
    }
    public String getWeddingDate(){
        return weddingDate;
    }
    public String getLocation(){
        return location;
    }
    public String getGuests(){
        return guests;
    }


}
