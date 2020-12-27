package tr.com.netas.foys.enums;

public enum City {
    ANKARA(06, "Ankara"),
    ISTANBUL(34, "İstanbul"),
    MERSIN(33, "Mersin");

    private final int index;
    private String name;

    City(int i, String name) {
        this.index = i;
        this.name = name;
    }

    City getCity(int i) {
        for (City c : City.values()) {
            if (i == c.index) {
                return c;

            }
        }
        return ANKARA;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }
}