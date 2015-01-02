package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import java.io.File;

public class Application extends Controller {

    public static Result index() {
        String[] files = new File("fotos").getAbsoluteFile().list();
        return redirect(routes.Application.foto(files[0]));
    }

    public static Result foto(String file) {
        File foto = new File("fotos", file).getAbsoluteFile();
        return ok(foto, true).as("image/jpeg");
    }

}
