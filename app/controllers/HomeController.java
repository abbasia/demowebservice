package controllers;

import play.mvc.*;
import play.libs.Json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;





/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(views.html.index.render());
    }


    @BodyParser.Of(BodyParser.Json.class)
    public Result hash256() {
        JsonNode json = request().body().asJson();
        if(json == null) {
            return badRequest("Expecting Json data");
        } else {
            String text = json.findPath("text").textValue();
            if(text == null) {
                return badRequest("Missing parameter [text]");
            } else {
                ObjectNode result = Json.newObject();
                result.put("hash", org.apache.commons.codec.digest.DigestUtils.sha256Hex(text));
                return ok(result);
            }
        }

    }

}
