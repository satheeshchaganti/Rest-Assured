package chainingStudent;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

import com.github.javafaker.Faker;

public class UpdateUser 
{
@Test
void test_updateUser(ITestContext context)
{
	
	Faker faker=new Faker();
	JSONObject data=new JSONObject();
	
	data.put("name",faker.name().fullName());
	data.put("location","usa");
	data.put("phone",faker.phoneNumber().cellPhone());
	String coursesarr[]= {"java","developer"};
	data.put("courses",coursesarr);
	int id=(Integer)context.getSuite().getAttribute("user_id");

	given()
	.contentType("application/json")
	.body(data.toString())
	.pathParam("id",id)
	.when()
	.put("http://localhost:3000/students/{id}")
	.then()
	.log().all();
}
}
