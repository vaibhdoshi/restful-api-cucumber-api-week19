package com.restful.booker.bookininfo;

import com.restful.booker.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class TagsTest extends TestBase {
    @WithTags({
            @WithTag("bookingfeature:NEGATIVE"),
            @WithTag("bookingfeature:SMOKE")
    })
    @Title("Provide a 404 status code when incorrect HTTP method is used to access resource")
    @Test
    public void invalidMethod() {
        SerenityRest.rest()
                .given()
                .when()
                .post("/booking")
                .then()
                .statusCode(404)
                .log().all();
    }

    @WithTags({
            @WithTag("bookingfeature:POSITIVE"),
            @WithTag("bookingfeature:SMOKE")
    })
    @Title("This test will verify if a status code of 200 is returned for GET request")
    @Test
    public void verifyIfTheStatusCodeIs200() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/booking/{bookingId}")
                .then()
                .statusCode(200)
                .log().all();

    }


}
