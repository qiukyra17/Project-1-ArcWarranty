import DAO.ViewRepo;
import Model.customerInformation;
import Model.warrantyInformation;
import Service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;

public class arcteryxWarrantyAPI {
    public static void main(String[] args) {
        Admin a = new Admin();
        Cancel c = new Cancel();
        Request r = new Request();
        Update u = new Update();
        View v = new View();

        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins);
        app.start(7000);

        //NEW
        //GET WARRANTY
        app.get("/warranty/all", ctx -> {
            ctx.json(v.getAllWarranty());
        });

        //GET CUSTOMER NAME FROM ID
        app.get("/customer/{customerid}", ctx -> {
            ctx.json(v.getCustomerNameFromID(Integer.parseInt(ctx.pathParam("customerid"))));
        });

        //GET BRAND NAME FROM ID
        app.get("/brand/name/{brandid}", ctx -> {
            ctx.json(v.getBrandNameFromID(Integer.parseInt(ctx.pathParam("brandid"))));
        });

        //GET GENDER FROM ID
        app.get("gender/{genderID}", ctx -> {
            ctx.json(v.getGenderFromID(Integer.parseInt(ctx.pathParam("genderID"))));
        });

        //GET PRODUCT TYPE FROM ID
        app.get("product_type/{productTypeID}", ctx -> {
            ctx.json((v.getProductTypeFromID((Integer.parseInt(ctx.pathParam("productTypeID"))))));
        });


        //NEW LOOK UP
        app.get("/warranty/search/{id}",ctx -> {
            String intake = ctx.pathParam("id");
            System.out.println(intake);
            ctx.json(v.getWarrantyFromWarrantyNo(Integer.parseInt(ctx.pathParam("id"))));
        });

        //Update via Warranty ID - ADMIN
        app.patch("/warranty/update/", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            warrantyInformation updateWarranty = mapper.readValue(ctx.body(), warrantyInformation.class);
            u.updateWarrantyInformation(updateWarranty.getStatus(), updateWarranty.getWarrantyID());
        });

        //REQUEST Warranty - CUSTOMER
        app.post("/warranty/request/customer", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            customerInformation customer = mapper.readValue(ctx.body(), customerInformation.class);
            r.addCustomerInformation(customer.getId(), customer.getName(), customer.getEmail(), customer.getPhone());
        });

        //GET CUSTOMER ID FOR WARRANTY
        app.get("/customer/search/{email}", ctx -> {
            ctx.json(r.getCustomerIdByEmail(ctx.pathParam("email")));
        });

        //REQUEST - PRODUCT INFO
        app.post("/warranty/request/", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            warrantyInformation newWarranty = mapper.readValue(ctx.body(), warrantyInformation.class);
            r.addWarrantyInformation(newWarranty.getCustomerID(), newWarranty.getWarrantyID(), newWarranty.getBrandID()
                    , newWarranty.getGenderID(), newWarranty.getProductTypeID(), newWarranty.getProductName(),
                    newWarranty.getProductIssue(), newWarranty.getStatus());
        });

        //DELETE Warranty - Customer
        app.delete("/warranty/delete/{warrantyno}", ctx -> {
            ctx.json(c.deleteWarrantyInformation(Integer.parseInt(ctx.pathParam("warrantyno"))));
        });
    }
}
