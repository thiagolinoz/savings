package com.linoz.savings.api;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by linoz on 2/12/21
 */

public class UserResourceTest {

    @Test
    public void testGetOneRetornaStatusOk() {
        get("/users/user/1").then().statusCode(200).assertThat()
                .body("body.id", equalTo(1));
    }

}
