package Service;

import DTO.LoginRequest;
import Model.AdminInformation;
import io.javalin.http.HttpCode;

import java.util.List;

public interface AdminService {

    List<AdminInformation> getLoginInfo(String userName, String password);

    HttpCode validateLogin(LoginRequest loginRequest);

}
