package api.test;


import api.model.Address;
import api.model.Company;
import api.model.CompanyResponse;
import api.model.Contact;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CompaniesValidationTest extends BaseTest {

    // Test number 3.a
    @Test
    void testCompaniesEndpointResponseValidation() {
        Response response = getCompanies();

        // Verify status code
        assertThat("Status code should be 200",
                response.getStatusCode(), is(equalTo(200)));

        // Parse response
        CompanyResponse companyResponse = response.as(CompanyResponse.class);

        // Verify basic response structure
        assertAll("Basic response validation",
                () -> assertThat("Response status should be OK",
                        companyResponse.getStatus(), is(equalTo("OK"))),
                () -> assertThat("Response code should be 200",
                        companyResponse.getCode(), is(equalTo(200))),
                () -> assertNotNull(companyResponse.getData(), "Data should not be null"),
                () -> assertThat("Data should not be empty",
                        companyResponse.getData().size(), greaterThan(0))
        );

        // Verify all IDs are not null using comprehensive loop validation
        verifyAllIdsNotNull(companyResponse);

        System.out.printf("✅ Response validation passed. Total companies: %d%n",
                companyResponse.getData().size());
    }

    private void verifyAllIdsNotNull(CompanyResponse companyResponse) {
        System.out.println("🔍 Verifying ALL IDs are not null using loop functions...");

        List<Company> companies = companyResponse.getData();

        // Loop through all companies
        for (int i = 0; i < companies.size(); i++) {
            Company company = companies.get(i);

            // Verify Company ID
            assertNotNull(company.getId(),
                    String.format("Company at index %d has null ID", i));
            System.out.printf("   ✓ Company %d: ID = %d%n", i + 1, company.getId());

            // Verify Company Addresses IDs using loop
            if (company.getAddresses() != null) {
                verifyAddressIds(company.getAddresses(), i);
            }

            // Verify Contact ID and Contact Address ID using loop
            if (company.getContact() != null) {
                verifyContactIds(company.getContact(), i);
            }
        }

        System.out.println("✅ All ID validations completed successfully!");
    }

    private void verifyAddressIds(List<Address> addresses, int companyIndex) {
        for (int j = 0; j < addresses.size(); j++) {
            Address address = addresses.get(j);
            assertNotNull(address.getId(),
                    String.format("%s %d, Address at index %d has null ID", "Company", companyIndex, j));
            System.out.printf("     ✓ %s %d, Address %d: ID = %d%n",
                    "Company", companyIndex + 1, j + 1, address.getId());
        }
    }

    private void verifyContactIds(Contact contact, int companyIndex) {
        // Verify Contact ID
        assertNotNull(contact.getId(),
                String.format("Company %d, Contact has null ID", companyIndex));
        System.out.printf("     ✓ Company %d, Contact: ID = %d%n",
                companyIndex + 1, contact.getId());

        // Verify Contact Address ID (if contact has address)
        if (contact.getAddress() != null) {
            Address contactAddress = contact.getAddress();
            assertNotNull(contactAddress.getId(),
                    String.format("Company %d, Contact Address has null ID", companyIndex));
            System.out.printf("       ✓ Company %d, Contact Address: ID = %d%n",
                    companyIndex + 1, contactAddress.getId());
        }
    }

    // Test number 3.b
    @Test
    void testJsonSchemaValidation() {
        Response response = getCompanies();

        // Verify status code
        assertThat("Status code should be 200",
                response.getStatusCode(), is(equalTo(200)));

        // Validate JSON schema structure
        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("json_schema/companies_schema.json"));

        System.out.println("✅ JSON Schema validation passed");
    }
}
