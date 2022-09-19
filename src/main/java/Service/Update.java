package Service;

import DAO.UpdateRepo;
import org.apache.log4j.Logger;

public class Update {
    UpdateRepo ur;

    public Update() {
        ur = new UpdateRepo();
        Logger logger = Logger.getLogger(Update.class);
        logger.info("Status Updated");
    }

    public String updateWarrantyInformation(String status,int warrantyNo){
       return ur.updateWarrantyInformation(status,warrantyNo);

    }
}
