package chainingProcess;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser 
{
	@Test
	void test_getUser(ITestContext context)
	{
        String bearertoken="c109ce127731d2ba4b161ee20913e28efebd5fd05ffd10eb2265e4860f1d5ad6";
        int id=(Integer) context.getSuite().getAttribute("user_id");
		given()
		.headers("Authorization","Bearer "+bearertoken)
		.pathParam("id",id)
		.when()
		.get("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}

}
