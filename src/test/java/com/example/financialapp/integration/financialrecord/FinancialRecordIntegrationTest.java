package com.example.financialapp.integration.financialrecord;

import com.example.financialapp.db.AbstractContextMockDataBase;
import com.example.financialapp.domain.enums.FinancialRecordType;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static com.example.financialapp.FiancialRecordPool.buildSalaryRecord;
import static com.example.financialapp.UserPool.USER_ID;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FinancialRecordIntegrationTest extends AbstractContextMockDataBase {
    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void createPostWhenSuccessShouldReturnPost() {
        var financialRecord = buildSalaryRecord();
        RestAssured.given()
                .header("x-user-id", USER_ID)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(financialRecord)
                .post("/financial-records")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("id", notNullValue())
                .body("type", equalTo(FinancialRecordType.INCOME.toString()))
                .body("value", equalTo(10))
                .body("description", equalTo("Salary"))
                .body("date", equalTo("2023-10-12"))
                .body("category", equalTo("Salary"));
    }

}
