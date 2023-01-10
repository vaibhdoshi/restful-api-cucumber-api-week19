package com.restful.booker.bookininfo;

import com.restful.booker.constants.EndPoints;
import com.restful.booker.model.AuthPojo;
import com.restful.booker.params.Headers;
import com.restful.booker.utils.TestUtils;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
public class AuthSteps {

    @Step("Get auth token with username: {0} and password: {1}")
    public String getAuthToken(String username, String password) {
        AuthPojo authPojo = AuthPojo.getAuthBody(username, password);
        return SerenityRest.given().log().ifValidationFails()
                .header(Headers.CONTENT_TYPE, "application/json")
                .body(TestUtils.jsonToString(authPojo))
                .when()
                .post(EndPoints.AUTH)
                .then().log().ifValidationFails()
                .statusCode(200).extract().path("token");
    }
}
