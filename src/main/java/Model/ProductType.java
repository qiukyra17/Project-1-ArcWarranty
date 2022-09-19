package Model;

public class ProductType {
    public int id;
    public String productType;

    public ProductType(int id, String productType) {
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
