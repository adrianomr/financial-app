package com.example.financialapp.integration.financialrecord;

import com.example.financialapp.db.AbstractContextMockDataBase;
import com.example.financialapp.infra.database.FinancialRecordRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.util.UUID;

import static com.example.financialapp.FiancialRecordPool.*;
import static com.example.financialapp.UserPool.USER_ID;
import static org.hamcrest.CoreMatchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CategoriesIntegrationTest extends AbstractContextMockDataBase {
    @LocalServerPort
    private int port;
    @Autowired
    private FinancialRecordRepository financialRecordRepository;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
        var income = buildSalaryRecord();
        income.setId(UUID.randomUUID());
        financialRecordRepository.save(income);
        income.setId(UUID.randomUUID());
        financialRecordRepository.save(income);
        var cdb = buildCdbRecord();
        cdb.setId(UUID.randomUUID());
        financialRecordRepository.save(cdb);
        var iceCream = buildIceCreamRecord();
        iceCream.setId(UUID.randomUUID());
        financialRecordRepository.save(iceCream);
    }

    @Test
    void createPostWhenSuccessShouldReturnPost() {
        RestAssured.given()
                .header("x-user-id", USER_ID)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .queryParam("startDate", "2023-10-01")
                .queryParam("endDate", "2023-10-31")
                .get("/categories")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("categories[0].type", equalTo("INCOME"))
                .body("categories[0].description", equalTo("Investments"))
                .body("categories[0].total", equalTo(105.1F))
                .body("categories[1].type", equalTo("INCOME"))
                .body("categories[1].description", equalTo("Salary"))
                .body("categories[1].total", equalTo(20.0F))
                .body("categories[2].type", equalTo("EXPENSE"))
                .body("categories[2].description", equalTo("Food"))
                .body("categories[2].total", equalTo(15.1F))
                .log()
                .all();
    }

}
