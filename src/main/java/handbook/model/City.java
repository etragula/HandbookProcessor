package handbook.model;

public class City extends Models {
    private String name;
    private String region;
    private String district;
    private int population;
    private int foundation;

    public City(String name, String region, String district) {
        this.name = name;
        this.region = region;
        this.district = district;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        if (population > 0 && population <= 38_000_000)
            this.population = population;
    }

    public int getFoundation() {
        return foundation;
    }

    public void setFoundation(int foundation) {
        if (foundation > 0 && foundation <= 2021)
            this.foundation = foundation;
    }

    @Override
    public String toString() {
        return "model.City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation=" + foundation +
                '}';
    }
}
