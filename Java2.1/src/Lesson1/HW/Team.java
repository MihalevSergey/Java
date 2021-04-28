package Lesson1.HW;

public class Team {
    public String nameOfTeam;
    private Competitor[] squad;

    public Team(String nameOfTeam, Competitor... squad){
        this.nameOfTeam = nameOfTeam;
        this.squad = squad;
    }

    public Competitor[] getSquad(){
        return squad;
    }

    public void showWinnerTeam(){
        for (Competitor c: squad){
            if (c.isOnDistance()){
                c.infoTeam();
            }
        }
    }

    public void showInfo(){
        for (Competitor o: squad){
            o.info();
        }
    }
}
