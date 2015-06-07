package controllers;

import play.libs.F.*;
import play.mvc.*;
import views.html.*;

public class ApplicationController extends Controller {

    public Promise<Result> index() {
        return Promise.promise(() -> "Your new application is ready."
        ).map((String title) -> ok(index.render(title)));
    }

}
