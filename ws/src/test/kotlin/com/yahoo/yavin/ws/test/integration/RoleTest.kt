/**
 * Copyright 2021 Yahoo Holdings Inc.
 * Licensed under the terms of the MIT license. See accompanying LICENSE.md file for terms.
 */
package com.yahoo.yavin.ws.test.integration

import com.jayway.restassured.RestAssured.given
import com.yahoo.yavin.ws.test.framework.IntegrationTest
import com.yahoo.yavin.ws.test.framework.matchers.RegexMatcher
import org.apache.http.HttpStatus
import org.hamcrest.Matchers.empty
import org.hamcrest.Matchers.hasItems
import org.hamcrest.Matchers.nullValue
import org.junit.jupiter.api.Test

class RoleTest : IntegrationTest() {
    private val naviUser1 = "user1"
    private val adminRole = "admin"
    private val userRole = "user"

    @Test
    fun roleEndpointTest() {
        /*
         * Role endpoint is initially empty
         */
        given()
            .header("User", naviUser1)
            .When()
            .get("roles")
            .then()
            .assertThat()
            .statusCode(HttpStatus.SC_OK)
            .body("data", empty<Any>())

        /*
         * New role can be added
         */
        registerRole(adminRole)

        /*
         * Created role is visible in roles endpoint
         */
        given()
            .header("User", naviUser1)
            .When()
            .get("/roles")
            .then()
            .assertThat()
            .body("data.id", hasItems<String>(adminRole))
    }

    @Test
    fun createDateTest() {
        /*
         * Add test role
         */
        registerRole(userRole)

        /*
         * Check for created date
         */
        given()
            .header("User", naviUser1)
            .When()
            .get("/roles/$userRole")
            .then()
            .assertThat()
            .body("data.attributes.createDate", nullValue())
            .body(
                "data.attributes.createdOn",
                RegexMatcher.matchesRegex("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")
            ) // YYYY-MM-DD HH:MM:ss

        given()
            .header("User", naviUser1)
            .contentType("application/vnd.api+json")
            .body(
                """
                {
                    "data": {
                        "type": "roles",
                        "id": "$userRole",
                        "attributes": {
                            "createdOn": "2015-12-10 10:56:23"
                        }
                    }
                }
                """.trimIndent()
            )
            .When()
            .patch("/roles/$userRole")
            .then()
            .assertThat()
            .statusCode(HttpStatus.SC_FORBIDDEN)
    }
}
