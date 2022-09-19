package Util;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class HashPsw {
    public static String hashPassword(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    public static boolean verifyPassword(String inPutPsw, String dbPsw) {
        return BCrypt.verifyer().verify(inPutPsw.toCharArray(), dbPsw).verified;
    }


}
