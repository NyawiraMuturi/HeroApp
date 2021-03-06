import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/home.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/squadform", (request, response) -> {

            Map<String, Object> model = new HashMap<String, Object>();

            model.put("template", "templates/squadform.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/squad", (request, response) -> {

            Map<String, Object> model = new HashMap<String, Object>();

            String squadName = request.queryParams("squadName");
            String squadSize = request.queryParams("squadSize");
            String squadCause = request.queryParams("squadCause");

            model.put("squadName", squadName);
            model.put("squadSize", squadSize);
            model.put("squadCause", squadCause);
            model.put("template", "templates/squadlist.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/heroform", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            model.put("template", "templates/heroform.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


        get("/hero", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            String heroName = request.queryParams("heroName");
            String heroAge = request.queryParams("heroAge");
            String specialPower = request.queryParams("specialPower");
            String weakness = request.queryParams("weakness");

            model.put("heroName", heroName);
            model.put("heroAge", heroAge);
            model.put("heroPower", specialPower);
            model.put("weakness", weakness);
            model.put("template", "templates/hero.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/herolist", (request, response) -> {

            Map<String, Object> model = new HashMap<String, Object>();

            model.put("template", "templates/herolist.vtl" );
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    }
}