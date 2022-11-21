import DTO.LoginRequest;
import DTO.WarrantyRequest;
import Model.CustomerInformation;
import Model.WarrantyInformation;
import Service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;

public class DeadbirdWarrantyAPI {
    public static void main(String[] args) {
        Cancel cancel = new Cancel();
        Request request = new Request();
        Update update = new Update();
        View view = new View();

        /**
         * Leveraging Javalin framework to create an API
         */
        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins);
        app.start(7000);

        //GET INFORMATION BASED ON AN ID
        //GET BRAND NAME FROM ID
        app.get("/brand/{brandid}", ctx -> {
            ctx.json(view.getBrandNameFromID(Integer.parseInt(ctx.pathParam("brandid"))));
        });

        //GET GENDER FROM ID
        app.get("gender/{genderID}", ctx -> {
            ctx.json(view.getGenderFromID(Integer.parseInt(ctx.pathParam("genderID"))));
        });

        //GET PRODUCT TYPE FROM ID
        app.get("product_type/{productTypeID}", ctx -> {
            ctx.json((view.getProductTypeFromID((Integer.parseInt(ctx.pathParam("productTypeID"))))));
        });

        //GET CUSTOMER NAME FROM ID
        app.get("/customers/search/id/{customerid}", ctx -> {
            ctx.json(view.getCustomerNameFromID(Integer.parseInt(ctx.pathParam("customerid"))));
        });

        //GET WARRANTY
        app.get("/warranties/", ctx -> {
            ctx.json(view.getAllWarranty());
        });

        //REQUEST Warranty - CUSTOMER
        app.post("/customers/", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            CustomerInformation customer = mapper.readValue(ctx.body(), CustomerInformation.class);
            request.addCustomerInformation(customer.getId(), customer.getName(), customer.getEmail(), customer.getPhone());
        });

        //GET CUSTOMER ID FOR WARRANTY - FOR WARRANTY FORM
        app.get("/customers/search/email/{email}", ctx -> {
            ctx.json(request.getCustomerByEmail(ctx.pathParam("email")));
        });

        //REQUEST - PRODUCT INFO
        app.post("/warranty/new/", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            WarrantyRequest newWarranty = mapper.readValue(ctx.body(), WarrantyRequest.class);
//          ctx.result(String.valueOf(r.addWarrantyInformation(newWarranty).warrantyID));
            ctx.json(request.addWarrantyInformation(newWarranty));
        });

        //DELETE Warranty - Customer
        app.delete("/warranties/remove/{warrantyno}", ctx -> {
            ctx.json(cancel.deleteWarrantyInformation(Integer.parseInt(ctx.pathParam("warrantyno"))));
        });

        //NEW LOOK UP
        app.get("/warranties/search/{id}",ctx -> {
            String intake = ctx.pathParam("id");
            System.out.println(intake);
            ctx.json(view.getWarrantyFromWarrantyNo(Integer.parseInt(ctx.pathParam("id"))));
        });

        //LOGIN
        app.post("/users/", ctx ->{
//          System.out.println("Post request for login got hit");
            ObjectMapper mapper = new ObjectMapper();
            LoginRequest loginRequest = mapper.readValue(ctx.body(), LoginRequest.class);
            AdminService adminService = new Admin();
            ctx.status(adminService.validateLogin(loginRequest));
        });

        //Update via Warranty ID - ADMIN
        app.patch("warranties/update/{warrantyno}", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            WarrantyInformation updateWarranty = mapper.readValue(ctx.body(), WarrantyInformation.class);
            update.updateWarrantyInformation(updateWarranty.getStatus(), updateWarranty.getWarrantyID());
        });

    }
}
