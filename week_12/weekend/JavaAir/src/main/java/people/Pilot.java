package people;

public class Pilot extends CrewMember {
    public String licenseNum;

    public Pilot(String name, CrewRank rank, String licenseNum) {
        super(name, rank);
        this.licenseNum = licenseNum;
    }

    public String getLicenseNumber() {
        return licenseNum;
    }

    public String fly(){
        return "I Believe I Can Fly";
    }
}
