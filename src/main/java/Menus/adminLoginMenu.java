//package Menus;
//
//import Service.Admin;
//import Util.hashPsw;
//import org.apache.log4j.Logger;
//
//import java.util.Scanner;
//
//public class adminLoginMenu {
//    Scanner input = new Scanner(System.in);
//    Admin a = new Admin();
//    hashPsw hp = new hashPsw();
//
//    public adminLoginMenu() {
//        Logger logger = Logger.getLogger(adminLoginMenu.class);
//
//        boolean menu = true;
//        while (menu) {
//            System.out.println("Please Select: Sign In - Back");
//            String userInput = input.nextLine();
//            if (userInput.equals("Sign In")) {
//
//                System.out.println("Username");
//                String username = input.nextLine();
//                System.out.println("Password");
//                String password = input.nextLine();
//                String dbPass = a.getUserPswByUserName(username);
//                if (hp.pswVerfiy(password, dbPass)) {
//                    adminMenu am = new adminMenu();
//                } else System.out.println("Login Failed");
//
//                logger.info("Admin Log In: " + username);
//
//            } else if (userInput.equals("Back")) {
//                menu = false;
//                logger.info("Admin Menu Exited");
//
//            }
//        }
//    }
//}
//
