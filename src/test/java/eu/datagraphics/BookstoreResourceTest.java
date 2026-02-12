package eu.datagraphics;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;


@QuarkusTest
class BookstoreResourceTest {
    @Test
    void testBookstoreEndpoint() {
        given()
                .when().get("/bookstore")
                .then()
                .statusCode(200)
                .body("$.size()", is(4)) // check number of books returned
                .body("[0].bookname", equalTo("Effective Java"))
                .body("[0].author", equalTo("Joshua Bloch"))
                .body("[0].year", equalTo(2018))
                .body("[1].bookname", equalTo("Clean Code"))
                .body("[1].author", equalTo("Robert C. Martin"))
                .body("[1].year", equalTo(2008));
    }

}
