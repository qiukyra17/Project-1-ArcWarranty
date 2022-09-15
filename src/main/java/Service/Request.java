package Service;

import DAO.RequestRepo;
import Model.customerInformation;
import Model.warrantyInformation;
import org.apache.log4j.Logger;

public class Request {
    RequestRepo rr;

    public Request() {
        rr = new RequestRepo();
        Logger logger = Logger.getLogger(Request.class);
        logger.info("New Warranty Created");
    }

    public void addCustomerInformation(String name, String email, String phone) {
        customerInformation exisitingInformation = rr.getCustomerByEmail(email);
        if (exisitingInformation == null) {
            customerInformation newCustomerInformation = new customerInformation(name, email, phone);
            rr.addCustomerInformation(newCustomerInformation);
        } else {

            //do nothing
        }
    }

    public warrantyInformation addWarrantyInformation(int customerID, int warrantyID, int brandID, int genderID,
                                                      int productTypeID, String productName,
                                                      String productIssue,
                                                      String status) {
        warrantyInformation newWarrantyInformation = new warrantyInformation(customerID, warrantyID, brandID, genderID,
                productTypeID, productName, productIssue, status);
        rr.addWarrantyInformation(newWarrantyInformation);
        return newWarrantyInformation;

    }

    public int getCustomerIdByEmail(String String) {
        return rr.getCustomerIdByEmail(String);
    }


}
