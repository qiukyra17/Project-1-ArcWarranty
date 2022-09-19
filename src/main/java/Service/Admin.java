package Service;

import DAO.AdminLoginRepo;
import DTO.LoginRequest;
import Model.AdminInformation;
import Util.HashPsw;
import io.javalin.http.HttpCode;
import org.apache.log4j.Logger;

import java.util.List;

public class Admin implements AdminService {
    AdminLoginRepo ar;

    public Admin() {
        ar = new AdminLoginRepo();
        Logger logger = Logger.getLogger(Admin.class);
        logger.info("Admin Login");
    }

    @Override
    public List<AdminInformation> getLoginInfo(String userName, String password) {
        return ar.getLoginInfo(userName, password);
    }

    @Override
    public HttpCode validateLogin(LoginRequest loginRequest) {
        AdminInformation userFromDB = ar.getUserByUsername(loginRequest.userName());
        if(userFromDB == null){
            return HttpCode.BAD_REQUEST;
        }
        if(!HashPsw.verifyPassword(loginRequest.userPassword(), userFromDB.getUserPassword())){
            return HttpCode.UNAUTHORIZED;
        }
        return HttpCode.ACCEPTED;
    }

}
