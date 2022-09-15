package Service;

import DAO.ViewRepo;
import org.apache.log4j.Logger;

import java.util.List;

public class View {
    ViewRepo vr;

    public View(){
        vr = new ViewRepo();
        Logger logger = Logger.getLogger(View.class);
        logger.info("Status Search");
    }

    public List<String> getAllWarrantyInformation (){
            return vr.getAllWarrantyInformation();
    }
    public int getWarrantyIDFromWarrantyInfo(int customerID, int brandID, int productTypeID, String productIssue,
                                             String status) {
        return vr.getWarrantyIDFromWarrantyInfo(customerID, brandID, productTypeID, productIssue, status);
    }

    public String getAllWarrantyInfoByWarrantyNo(int warrantyNo) {
        return vr.getAllWarrantyInfoByWarrantyNo(warrantyNo);
    }

}
