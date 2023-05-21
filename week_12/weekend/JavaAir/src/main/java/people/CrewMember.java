package people;

public class CrewMember extends Person {
    CrewRank rank;

    public CrewMember(String name, CrewRank rank) {
        super(name);
        this.rank = rank;
    }

    public CrewRank getRank() {
        return rank;
    }
}
