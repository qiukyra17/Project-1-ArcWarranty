package Model;

public class productType {
    public int id;
    public String productType;

    public productType(int id, String productType) {
        this.id = id;
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "productType{" +
                "id=" + id +
                ", productType='" + productType + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
