package chainingProcess;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateUser 
{
	@Test
	void test_creatUser(ITestContext context)
	{
		Faker faker=new Faker();
		JSONObject data=new JSONObject();
		
		data.put("name",faker.name().fullName());
		data.put("gender","male");
		data.put("email",faker.internet().emailAddress());
		data.put("status","active");

        String bearertoken="c109ce127731d2ba4b161ee20913e28efebd5fd05ffd10eb2265e4860f1d5ad6";
		
        int id=given()
		.headers("Authorization","Bearer "+bearertoken)
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		  .post("https://gorest.co.in/public/v2/users")
          .jsonPath().getInt("id");
		 context.getSuite().setAttribute("user_id",id);
		 System.out.println("generated id is :"+id);
		
	}

}
