package chainingProcess;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UpdateUser
{
	@Test
	void test_updateUser(ITestContext context)
	{
		Faker faker=new Faker();
		JSONObject data=new JSONObject();
		
		data.put("name",faker.name().fullName());
		data.put("gender","male");
		data.put("email",faker.internet().emailAddress());
		data.put("status","active");

        String bearertoken="c109ce127731d2ba4b161ee20913e28efebd5fd05ffd10eb2265e4860f1d5ad6";
		int id=(Integer)context.getSuite().getAttribute("user_id");
		given()
		.headers("Authorization","Bearer "+bearertoken)
		.contentType("application/json")
		.body(data.toString())
		.pathParam("id",id)

		.when()
		  .put("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.log().all();
	
	}

}
