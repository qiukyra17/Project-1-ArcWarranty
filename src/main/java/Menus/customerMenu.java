//package Menus;
//
//import Service.View;
//import org.apache.log4j.Logger;
//
//import java.util.Scanner;
//
//import Service.Cancel;
//import Service.Request;
//
//
//public class customerMenu {
//
//    Request r = new Request();
//    Cancel c = new Cancel();
//    View v = new View();
//    Scanner input = new Scanner(System.in);
//
//    public customerMenu() {
//        Logger logger = Logger.getLogger(customerMenu.class);
//        logger.info("Customer Menu Selected");
//
//        boolean menu = true;
//        while (menu) {
//            System.out.println("Please Select: Request - Status - Back");
//            String userInput = input.nextLine();
//            if (userInput.equals("Back")) {
//                menu = false;
//                logger.info("Customer has exited back to main menu");
//            } else if (userInput.equals("Request")) {
//                //customer information
//                System.out.println("Please type Name");
//                String name = input.nextLine();
//                System.out.println("Please type Email");
//                String email = input.nextLine();
//                System.out.println("Please type Phone");
//                String phone = input.nextLine();
//                r.addCustomerInformation(name, email, phone);
//
//                logger.info("Customer Information has been added");
//
//                //Warranty Information
//                System.out.println("Please type enter the number corresponding to the brand: 1:Arcteryx - 2:Veilance " +
//                        "- 3:System_A");
//                int brandID = Integer.parseInt(input.nextLine());
//                System.out.println("Gender of Product: 1:Unisex - 2:Men's - 3:Women's");
//                int genderID = Integer.parseInt(input.nextLine());
//                System.out.println("Product Type: 1:Shell Jacket - 2:Insulated Jacket - 3:Pants - 4:Tops - 5:Packs - " +
//                        "6:Footwear - 7:Accesories");
//                int productTypeID = Integer.parseInt(input.nextLine());
//                Scanner input = new Scanner(System.in);
//                System.out.println("Name of Product");
//                String productName = input.nextLine();
//                System.out.println("Issue with Product");
//                String productIssue = input.nextLine();
//                int customerID = r.getCustomerIdByEmail(email);
//                String status = "New";
//                r.addWarrantyInformation(customerID, brandID, genderID, productTypeID, productName, productIssue, status);
//                int warrantyNo = v.getWarrantyIDFromWarrantyInfo(customerID, brandID, productTypeID, productIssue,
//                        status);
//                System.out.println("Your Warranty Number: " + warrantyNo);
//                logger.info(warrantyNo + "has been requested");
//            }
//
//            //Status Check
//            else if (userInput.equals("Status")) {
//                System.out.println("Please Type in Warranty Number");
//                int warrantyNo = Integer.parseInt(input.nextLine());
//                if (v.getAllWarrantyInfoByWarrantyNo(warrantyNo) == null) {
//                    System.out.println("This warranty does not exist");
//                } else
//                    System.out.println(v.getAllWarrantyInfoByWarrantyNo(warrantyNo));
//
//                logger.info(warrantyNo + " has been searched for status");
//            }
//
//            //Deleting the Warranty
//            else if (userInput.equals("Cancel")) {
//                System.out.println("Please enter Warranty Number");
//                int warrantyNo = Integer.parseInt(input.nextLine());
//                c.deleteWarrantyInformation(warrantyNo);
//
//                logger.info(warrantyNo + "has been canceled");
//            }
//
//            //Going Back to Main Menu
//
//
//        }
//    }
//}
