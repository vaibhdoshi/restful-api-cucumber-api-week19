package com.restful.booker.cucumber.steps;

import com.restful.booker.bookininfo.AuthSteps;
import com.restful.booker.bookininfo.BookingSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class CrudStepdef {
    static String username = "admin";
    static String password = "password123";
    static int bookingId;
    static String token;
    static ValidatableResponse response;

    @Steps
    BookingSteps bookingSteps;

    @Steps
    AuthSteps authSteps;
    @Given("^restful booker application is running$")
    public void restfulBookerApplicationIsRunning() {
    }

    @When("^When I create a new booking by providing the information firstName \"([^\"]*)\" lastName \"([^\"]*)\" totalPrice \"([^\"]*)\" depositPaid \"([^\"]*)\"checkIn\"([^\"]*)\"checkOut\"([^\"]*)\"additionalNeeds\"([^\"]*)\"$")
    public void whenICreateANewBookingByProvidingTheInformationFirstNameLastNameTotalPriceDepositPaidCheckInCheckOutAdditionalNeeds(String firstName, String lastName, int totalPrice, boolean depositPaid, String checkIn, String checkOut, String additionalNeeds)  {
        response=bookingSteps.createBooking(firstName,lastName,totalPrice,depositPaid,checkIn,checkOut,additionalNeeds);
        bookingId = response.extract().path("bookingid");
    }

    @Then("^I verify that the booking is created$")
    public void iVerifyThatTheBookingIsCreated() {
        response.statusCode(200);
    }

    @And("^I update the booking with information firstName \"([^\"]*)\" lastName \"([^\"]*)\" totalPrice \"([^\"]*)\" depositPaid \"([^\"]*)\"checkIn\"([^\"]*)\"checkOut\"([^\"]*)\"additionalNeeds\"([^\"]*)\"$")
    public void iUpdateTheBookingWithInformationFirstNameLastNameTotalPriceDepositPaidCheckInCheckOutAdditionalNeeds(String firstName, String lastName, int totalPrice, boolean depositPaid, String checkIn, String checkOut, String additionalNeeds)  {
        lastName = lastName + "_updated";
        token = authSteps.getAuthToken(username, password);
        response = bookingSteps.updateBooking(bookingId, firstName, lastName, totalPrice,
                depositPaid, checkIn, checkOut, additionalNeeds, token);
    }

    @And("^The user is updated successfully$")
    public void theUserIsUpdatedSuccessfully() {
        response.statusCode(200);
    }

    @And("^I delete the booking with userId$")
    public void iDeleteTheBookingWithUserId() {
        response = bookingSteps.deleteBookingWithBookingId(bookingId, token);
    }

    @Then("^The user deleted successfully from the application$")
    public void theUserDeletedSuccessfullyFromTheApplication() {
        bookingSteps.getBookingWithBookingId(bookingId).log().all().statusCode(404);
    }
}
