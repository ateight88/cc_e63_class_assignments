package people;

public class CabinCrew extends CrewMember {

    public CabinCrew(String name, CrewRank rank) {
        super(name, rank);
    }

    public String messageTannoy(String message){
        return "Ladies and Gentlemen: " + message;
    }

    public String foodBeverages(String time){
        return "Food and drinks service will begin in " + time;
    }

}
