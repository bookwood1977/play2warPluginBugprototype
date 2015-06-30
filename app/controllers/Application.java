package controllers;

import java.io.InputStream;

import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result showCodingGuidelines() {
    	
    	String filePath = "public/pdf/CSharpCodingStandards.pdf";
    	
		InputStream is = Play.application().classloader()
				.getResourceAsStream(filePath);
		
    	response().setHeader("Content-Disposition", "inline");
    	return ok(is).as("application/pdf");
    	
    }

}
