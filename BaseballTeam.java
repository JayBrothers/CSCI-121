public class BaseballTeam {
    private int players, salaryCap;
    public String name, city;
    //creates a baseball team that has a name, home city, player count, and total player salary
    public BaseballTeam(String name, String city, int players, int salaryCap){
        this.name = name;
        this.city = city;
        this.players = players;
        this.salaryCap = salaryCap;
    }
    //get and set for all baseball team parts
    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    public int getSalaryCap() {
        return salaryCap;
    }

    public void setSalaryCap(int salaryCap) {
        this.salaryCap = salaryCap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
