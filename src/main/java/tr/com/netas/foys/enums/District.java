package tr.com.netas.foys.enums;

public enum District {
    YENIMAHALLE(01, 06, "Yenimahalle"),
    CANKAYA(02, 06, "Çankaya"),
    KADIKOY(03, 34, "Kadıköy"),
    PENDIK(04, 34, "Pendik"),
    SILIFKE(05, 33, "Silifke"),
    ERDEMLI(06, 33, "Erdemli");

    private final int index;
    private final String name;
    private final int cityId;

    District(int index, int citId, String name) {
        this.index = index;
        this.name = name;
        this.cityId = citId;
    }

    public String getName() {
        return name;
    }

    public int getCityId() {
        return cityId;
    }
}
