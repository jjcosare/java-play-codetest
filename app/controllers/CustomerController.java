package controllers;

import com.google.inject.Inject;
import play.libs.F.Promise;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import services.ICustomerService;

/**
 * Created by jjcosare on 6/7/15.
 */
public class CustomerController extends Controller {

    @Inject
    ICustomerService customerService;

    @BodyParser.Of(BodyParser.Json.class)
    public Promise<Result> sortByDueDate(){
        String jsonRequest = request().body().asJson().toString();
        return Promise.promise(() -> customerService.sortByDueDate(jsonRequest)
        ).map((String jsonResponse) -> ok(jsonResponse));
    }

}
