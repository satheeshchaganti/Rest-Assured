package diffWaysToCreatingRequestBody;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

public class DataCreationWithJsonLibrary {
	@Test(priority=1)
	void JsonLibrary()
	{
		JSONObject data=new JSONObject();
		data.put("name","satish");
		data.put("phone","123456");
		data.put("location","india");

		String coursesarr[]= {"c","c++"};
		data.put("courses",coursesarr);

		
		given()
		.contentType("application/json")
		.body(data.toString())

		.when()
		.post("http://localhost:3000/students")

		.then()
		.statusCode(201)
		.body("name",equalTo("satish"))
		.body("phone",equalTo("123456"))
		.body("location",equalTo("india"))
		.body("courses[0]",equalTo("c"))
		.body("courses[1]",equalTo("c++"))
		.log().all();  
	}
	@Test(priority=2)
	void Delete()
	{
		when()
		.delete("http://localhost:3000/students/4")
		.then()
		.statusCode(200)
		.log().all();
	}

}
