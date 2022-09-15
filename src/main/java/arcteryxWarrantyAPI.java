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

        // lets this running down the service classes - make sure your CRUD transfers and shows

        //ALL COMPONENTS
        //View All Warranties - ADMIN
        app.get("/warranty/viewall", ctx -> {
            ctx.json(v.getAllWarrantyInformation());});
        //STATUS CHECK - Search via Warranty ID - ADMIN + CUSTOMER
        app.get("/warranty/search/{warrantyno}", ctx -> {
            ctx.json(v.getAllWarrantyInfoByWarrantyNo(Integer.parseInt(ctx.pathParam("warrantyno"))));
        });

        //Update via Warranty ID - ADMIN
        app.patch("/warranty/update/", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            warrantyInformation updateWarranty = mapper.readValue(ctx.body(), warrantyInformation.class);
            u.updateWarrantyInformation(updateWarranty.getStatus(),updateWarranty.getWarrantyID());
        });

        //REQUEST Warranty - CUSTOMER
        app.post("/warranty/request/customer", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            customerInformation customer = mapper.readValue(ctx.body(),customerInformation.class);
            r.addCustomerInformation(customer.getName(),customer.getEmail(),customer.getPhone());
        });

        //GET CUSTOMER ID FOR WARRANTY
        app.get("/customer/{email}",ctx -> {
            ctx.json(r.getCustomerIdByEmail(ctx.pathParam("email")));
        });

        //REQUEST - PRODUCT INFO
        app.post("/warranty/request/newWarranty", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            warrantyInformation newWarranty = mapper.readValue(ctx.body(),warrantyInformation.class);
            r.addWarrantyInformation(newWarranty.getCustomerID(),newWarranty.getWarrantyID(),newWarranty.getBrandID()
                    ,newWarranty.getGenderID(),newWarranty.getProductTypeID(),newWarranty.getProductName(),
                    newWarranty.getProductIssue(), newWarranty.getStatus());
        });

        //DELETE Warranty - Customer
        app.delete("/warranty/delete/{warrantyno}", ctx -> {
            ctx.json(c.deleteWarrantyInformation(Integer.parseInt(ctx.pathParam("warrantyno"))));
        });
    }
}
