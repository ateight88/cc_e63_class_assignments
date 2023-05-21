package flights;

public enum Airports {
    EDINBURGH("EDI"),
    DUBLIN("DUB"),
    LONDON("LDN"),
    NEWYORK("NY");

    private final String code;

    Airports(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
