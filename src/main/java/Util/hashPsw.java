package Util;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class hashPsw {
    public static String hashPassword(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    public boolean pswVerfiy(String inPutPsw, String dbPsw) {
        return BCrypt.verifyer().verify(inPutPsw.toCharArray(), dbPsw).verified;
    }


}
