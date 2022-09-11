package Service;

import DAO.AdminLoginRepo;

import org.apache.log4j.Logger;

public class Admin {
    AdminLoginRepo ar;

    public Admin() {
        ar = new AdminLoginRepo();
        Logger logger = Logger.getLogger(Admin.class);
        logger.info("Admin Login");
    }

//    public String getUserNameByUserPsw(String userPassword){
//        return ar.getUserNameByUserPsw(userPassword);
//    }
    public String getUserPswByUserName(String userName) {
        return ar.getUserPswByUserName(userName);
    }

}
