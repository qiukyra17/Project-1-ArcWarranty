package DTO;

public record WarrantyRequest (int customerID, int warrantyID, int brandID, int genderID, int productTypeID,
                               String productName,
                               String productIssue, String status){
}
