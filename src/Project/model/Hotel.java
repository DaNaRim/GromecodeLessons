package Project.model;

public class Hotel {
    private Long id;
    private String name;
    private String country;
    private String city;
    private String street;

    public Hotel(Long id, String name, String country, String city, String street) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return id + ", " +
                name + ", " +
                country + ", " +
                city + ", " +
                street;
    }

    //TODO simplify
}