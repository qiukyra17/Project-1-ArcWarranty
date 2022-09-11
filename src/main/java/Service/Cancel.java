package Service;

import DAO.CancelRepo;
import org.apache.log4j.Logger;

public class Cancel {
    CancelRepo cr;

    public Cancel(){
        cr = new CancelRepo();
        Logger logger = Logger.getLogger(Cancel.class);
        logger.info("Deleted Warranty");
    }

    public void deleteWarrantyInformation(int warrantyNo) {
        cr.deleteWarrantyRequestByWarrantyNo(warrantyNo);
    }
}
