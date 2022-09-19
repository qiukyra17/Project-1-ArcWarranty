package Service;

import DAO.RequestRepo;
import DTO.WarrantyRequest;
import Model.CustomerInformation;
import Model.WarrantyInformation;
import org.apache.log4j.Logger;

public class Request {
    RequestRepo rr;

    public Request() {
        rr = new RequestRepo();
        Logger logger = Logger.getLogger(Request.class);
        logger.info("New Warranty Created");
    }

    public void addCustomerInformation(int id, String name, String email, String phone) {
        CustomerInformation exisitingInformation = rr.getCustomerByEmail(email);
        if (exisitingInformation == null) {
            CustomerInformation newCustomerInformation = new CustomerInformation(id, name, email, phone);
            rr.addCustomerInformation(newCustomerInformation);
        } else {

            //do nothing
        }
    }

    public WarrantyInformation addWarrantyInformation(WarrantyRequest warrantyRequest) {
        int warrantyID = rr.addWarrantyInformation(warrantyRequest);
        return new WarrantyInformation(
                warrantyRequest.customerID(),
                warrantyID,
                warrantyRequest.brandID(),
                warrantyRequest.genderID(),
                warrantyRequest.productTypeID(),
                warrantyRequest.productName(),
                warrantyRequest.productIssue(),
                warrantyRequest.status());
    }

    public int getCustomerIdByEmail(String String) {
        return rr.getCustomerIdByEmail(String);
    }

    public CustomerInformation getCustomerByEmail(String email) {
        return rr.getCustomerByEmail(email);
    }

    ;


}


