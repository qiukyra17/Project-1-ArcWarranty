package Model;

public class warrantyInformation {

    public int customerID;
    public int warrantyID;
    public int brandID;
    public int genderID;
    public int productTypeID;
    public String productName;
    public String productIssue;
    public String status;

    public warrantyInformation (){};
    public warrantyInformation(int customerID, int warrantyID, int brandID, int genderID, int productTypeID,
                               String productName,
                               String productIssue, String status) {
        this.customerID = customerID;
        this.warrantyID = warrantyID;
        this.brandID = brandID;
        this.genderID = genderID;
        this.productTypeID = productTypeID;
        this.productName = productName;
        this.productIssue = productIssue;
        this.status = status;
    }


    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public int getGenderID() {
        return genderID;
    }

    public void setGenderID(int genderID) {
        this.genderID = genderID;
    }

    public int getProductTypeID() {
        return productTypeID;
    }

    public void setProductTypeID(int productTypeID) {
        this.productTypeID = productTypeID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductIssue() {
        return productIssue;
    }

    public void setProductIssue(String productIssue) {
        this.productIssue = productIssue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getWarrantyID() {
        return warrantyID;
    }

    public void setWarrantyID(int warrantyID) {
        this.warrantyID = warrantyID;
    }
}
