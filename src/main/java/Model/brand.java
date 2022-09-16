package Model;

public class brand {
    public int id;
    public String brand_id;

    public brand(int id, String brand_id) {
        this.id = id;
        this.brand_id = brand_id;
    }

    @Override
    public String toString() {
        return "brand{" +
                "id=" + id +
                ", brand_id='" + brand_id + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }
}
