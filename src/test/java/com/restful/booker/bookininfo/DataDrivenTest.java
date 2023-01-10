package com.restful.booker.bookininfo;

import com.restful.booker.testbase.TestBase;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;

//@UseTestDataFrom("src/test/java/resources/testdata/booking.csv")
//@RunWith(SerenityParameterizedRunner.class)
public class DataDrivenTest extends TestBase {

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private String checkIn;
    private String checkout;
    private String additionalneeds;
    private String username;
    private String password;

    @Steps
    BookingSteps bookingSteps;

    @Title("Data driven test for adding multiple users")
    @Test
    public void createMultipleUsers(){
        bookingSteps.createBooking(firstname,lastname,totalprice,depositpaid,checkIn,checkout,additionalneeds).statusCode(200);
    }
}
