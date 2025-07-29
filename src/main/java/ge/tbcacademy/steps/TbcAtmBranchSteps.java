package ge.tbcacademy.steps;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class TbcAtmBranchSteps {
    private final Response response;

    public TbcAtmBranchSteps(Response response) {
        this.response = response;
    }

    public TbcAtmBranchSteps validateStatusCode(int expectedCode) {
        response.then().statusCode(expectedCode);
        return this;
    }

    public TbcAtmBranchSteps validateContentType(String expectedContentType) {
        response.then().contentType(expectedContentType);
        return this;
    }

    public TbcAtmBranchSteps validateAtmsOrBranchesPresent() {
        response.then().body("$", anyOf(hasKey("atms"), hasKey("branches")));
        return this;
    }

    public TbcAtmBranchSteps printPretty() {
        System.out.println(response.prettyPrint());
        return this;
    }
}
