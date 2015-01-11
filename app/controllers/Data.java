package controllers;

import play.*;
import play.mvc.*;
import static play.mvc.Results.*;
import play.data.*; //Este tiene para el Form  
import play.libs.*;
import models.*;
import play.data.validation.*;
import static play.data.validation.Constraints.*;
import javax.validation.*;
import views.html.*;
import java.util.*;

//v1: how to create a structure from the dictionary
//v2: structure obtained from the form that will mimic the dictionary
public class Data extends Controller {

    //static Form<User> userForm = form(User.class);
    static Form<User> userForm = Form.form(User.class);
    //The underlying binding is done using Spring data binder
    public static Result show(){
        
        //v1
        //Map<String,String> toBind = new HashMap<String,String>();
        //Map<String,String> toBind = new HashMap(); //warn uses unchecked or unsafe operations.
        //toBind.put("name","Arturo"); //la primera key tiene que coincidir con la variable de la Clase

        //User user = userForm.bind(toBind).get();
        //https://www.playframework.com/documentation/2.2.x/JavaForms
        //return ok(data.render(user));
        //v2
        //return ok(data.render(Scala.Option(((User) null ))));
        //v3
        return ok(data.render(userForm));
    }


    public static Result post() {
        //v2
        //User user = userForm.bindFromRequest().get();
        //bindFromRequest: retrieve the data needed by the form somewhere in the request
        //The query string: This is our case, because we have sent a GET request.
        //The body: For POST/PUT methods. There are several options here because the 
        //content could be a map of URL parameters, a multipart, or JSON encoded.
        //it returns a Form instance filled with these values on
        //which we may call get in order to retrieve the related domain object. But, we could
        //also call the data method that would give us back the dictionary of values.
        
        //return ok(data.render(Scala.Option(user)));
        //v3
        return ok(data.render(userForm.bindFromRequest()));
    }
}