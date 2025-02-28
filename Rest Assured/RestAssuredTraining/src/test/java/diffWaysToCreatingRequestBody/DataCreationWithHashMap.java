package diffWaysToCreatingRequestBody;
import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class DataCreationWithHashMap
{
	//@Test(priority=1)
//	void HashMap()
//	{
//		HashMap data=new HashMap();
//		data.put("name","harish");
//		data.put("phone","123456");
//		data.put("location","india");
//
//		String coursesarr[]= {"c","c++"};
//		data.put("courses",coursesarr);
//
//		given()
//		.contentType("application/json")
//		.body(data)
//
//		.when()
//		.post("http://localhost:3000/students")
//
//		.then()
//		.statusCode(201)
//		.body("name",equalTo("harish"))
//		.body("phone",equalTo("123456"))
//		.body("location",equalTo("india"))
//		.body("courses[0]",equalTo("c"))
//		.body("courses[1]",equalTo("c++"))
//		.log().all();  
//	}
	@Test(priority=1)
	void Delete()
	{
		when()
		.delete("http://localhost:3000/students/6")
		.then()
		//.statusCode(200)
		.log().all();
	}


}
