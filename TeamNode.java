public class TeamNode {
    private BaseballTeam team;
    private TeamNode teamNode;
    //makes a node that includes a baseball team created in another class, makes it so it can be added to liked list.
    public TeamNode(BaseballTeam team){
        this.team = team;
        this. teamNode = null;
    }
    // get and set for method
    public TeamNode getTeamNode() {
        return teamNode;
    }

    public void setTeamNode(TeamNode teamNode) {
        this.teamNode = teamNode;
    }

    public BaseballTeam getTeam() {
        return team;
    }

    public void setTeam(BaseballTeam team) {
        this.team = team;
    }
    public void setNext(TeamNode teamNode){
        this.teamNode = teamNode;
    }
    public TeamNode getNext(){
        return teamNode;
    }
}
