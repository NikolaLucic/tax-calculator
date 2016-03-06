package controllers;

import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;

public class Application extends Controller {

  public static Result index()  {
    return ok(views.html.main.render(0));
  }
  
  public static Result calculate()  {
	  DynamicForm requestData = Form.form().bindFromRequest();
	  int grossAmount = Integer.valueOf(requestData.get("grossAmount"));
	  //TODO change to spring injected
	  int neto = Calculator.calculate(grossAmount);
	    return ok(views.html.main.render(neto));
	  }

}
