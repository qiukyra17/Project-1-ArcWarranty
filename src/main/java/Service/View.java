package Service;

import DAO.ViewRepo;
import Model.*;
import org.apache.log4j.Logger;

import java.util.List;

public class View {
    ViewRepo vr;

    public View() {
        vr = new ViewRepo();
        Logger logger = Logger.getLogger(View.class);
        logger.info("Status Search");
    }

    public List<String> getAllWarrantyInformation() {
        return vr.getAllWarrantyInformation();
    }

    public int getWarrantyIDFromWarrantyInfo(int customerID, int brandID, int productTypeID, String productIssue,
                                             String status) {
        return vr.getWarrantyIDFromWarrantyInfo(customerID, brandID, productTypeID, productIssue, status);
    }

    public String getAllWarrantyInfoByWarrantyNo(int warrantyNo) {
        return vr.getAllWarrantyInfoByWarrantyNo(warrantyNo);
    }


    //NEW - ALL TO GET WARRANTY TO LOOK PRESENTABLE
    public List<WarrantyInformation> getAllWarranty() {
       return  vr.getAllWarranty();
    }

    //LOOK UP
    public List<WarrantyInformation> getWarrantyFromWarrantyNo(int warrantyID){
        return vr.getWarrantyFromWarrantyNo(warrantyID);
    }

    public CustomerInformation getCustomerNameFromID(int customerID){
        return vr.getCustomerNameFromID(customerID);
    }

    public Brand getBrandNameFromID(int brandID){
        return vr.getBrandNameFromID(brandID);
    }

    public Gender getGenderFromID(int genderID){
        return vr.getGenderFromID(genderID);
    }

    public ProductType getProductTypeFromID (int productTypeID){
        return vr.getProductTypeFromID(productTypeID);
    }

//    public WarrantyInformation getWarrantyNo(){
//        return vr.getWarrantyNo();
//    }
}