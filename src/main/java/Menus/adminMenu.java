//package Menus;
//
//import Service.Update;
//import Service.View;
//import org.apache.log4j.Logger;
//
//import java.util.Scanner;
//
//public class adminMenu {
//    public adminMenu() {
//        Logger logger = Logger.getLogger(adminMenu.class);
//        logger.info("Admin Menu Opened");
//
//        Scanner input = new Scanner(System.in);
//
//        View v = new View();
//        Update u = new Update();
//
//        boolean loggedIn = true;
//        while (loggedIn) {
//            System.out.println("Please Select An Option: View All Warranties - Warranty Search - Status Update - Log " +
//                    "Out");
//            String userInput = input.nextLine();
//
//            if (userInput.equals("View All Warranties")) {
//                v.getAllWarrantyInformation();
//
//                logger.info("View All Warranties Selected");
//            } else if (userInput.equals("Warranty Search")) {
//                System.out.println("Please Type in Warranty Number");
//                int warrantyNo = Integer.parseInt(input.nextLine());
//                if (v.getAllWarrantyInfoByWarrantyNo(warrantyNo) == null) {
//                    System.out.println("This warranty does not exist");
//                } else
//                    System.out.println(v.getAllWarrantyInfoByWarrantyNo(warrantyNo));
//
//                logger.info(warrantyNo + " has been searched");
//            } else if (userInput.equals("Status Update")) {
//                System.out.println("Please Type in Warranty Number");
//                int warrantyNo = Integer.parseInt(input.nextLine());
//                System.out.println("Please Type in Status Change");
//                String status = new Scanner(System.in).nextLine();
//                u.updateWarrantyInformation(status, warrantyNo);
//                logger.info (warrantyNo + "status has been updated to " + status);
//            } else if (userInput.equals("Log Out")) {
//                loggedIn = false;
//                logger.info("Admin Logged Out");
//            }
//        }
//    }
//
//}
