package api.test;

import api.model.CompanyResponse;
import io.restassured.response.Response;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CompaniesQuantityTest extends BaseTest {

    // Test number 2
    @ParameterizedTest
    @ValueSource(ints = {20, 5, 1})
    void testCompaniesQuantityEndpoint(int quantity) {
        Response response = getCompaniesWithQuantity(quantity);

        // Verify status code
        assertThat("Status code should be 200",
                response.getStatusCode(), is(equalTo(200)));

        // Parse response
        CompanyResponse companyResponse = response.as(CompanyResponse.class);

        // Verify status and code
        assertThat("Response status should be OK",
                companyResponse.getStatus(), is(equalTo("OK")));
        assertThat("Response code should be 200",
                companyResponse.getCode(), is(equalTo(200)));

        // Verify the amount of data returned
        assertThat("Total should match requested quantity",
                companyResponse.getTotal(), is(equalTo(quantity)));
        assertThat("Data array size should match requested quantity",
                companyResponse.getData().size(), is(equalTo(quantity)));

        System.out.printf("✅ Test passed for quantity: %d, received: %d companies%n",
                quantity, companyResponse.getData().size());
    }
}
