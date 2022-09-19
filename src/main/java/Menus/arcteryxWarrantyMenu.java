//package Menus;
//
//import Util.ReadFile;
//import org.apache.log4j.Logger;
//
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//public class arcteryxWarrantyMenu {
//
//    public static void main(String[] args) throws FileNotFoundException {
//
//        Logger logger = Logger.getLogger(arcteryxWarrantyMenu.class);
//        logger.info("App Started");
//
//        ReadFile rf = new ReadFile("src/main/resources/Welcome");
//        rf.ReadFiletoMenu();
//
//        boolean usingApp = true;
//        while (usingApp) {
//            Scanner input = new Scanner(System.in);
//            System.out.println("Hello, Please Select One: Admin - Customer - Exit");
//            String userInput = input.nextLine();
//            logger.info(userInput + "Selected");
//            if (userInput.equals("Exit")) {
//                usingApp = false;
//                logger.info("App Exited");
//            } else if (userInput.equals("Admin")) {
//                adminLoginMenu am = new adminLoginMenu();
//                logger.info("Admin Chosen");
//            } else if (userInput.equals("Customer")) {
//                customerMenu cm = new customerMenu();
//                logger.info("Customer Chosen");
//            }
//        }
//    }
//}