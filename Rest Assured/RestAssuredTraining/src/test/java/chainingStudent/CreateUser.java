package chainingStudent;

import static io.restassured.RestAssured.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CreateUser 
{
	@Test
	void test_createUser(ITestContext context)
	{
		Faker faker=new Faker();
		JSONObject data=new JSONObject();
		
		data.put("name",faker.name().fullName());
		data.put("location","india");
		data.put("phone",faker.phoneNumber().cellPhone());
		String coursesarr[]= {"testing","selenium"};
		data.put("courses",coursesarr);
		
		int id=given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/students")
		.jsonPath().get("id");
		System.out.println(id);
	    context.getSuite().setAttribute("user_id",id);
		
	}

}
