package dataValidation;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class DataValidation 
{
	@Test
	void data()
	{
		Response res=
				given()
				.contentType(ContentType.JSON)
				.when()
				.get(" http://localhost:3000/students");		
		       JSONArray jarr=new JSONArray(res.asString());
		       
		   // String course=jarr.getJSONObject(2).getJSONArray("courses").get(1).toString();
			  Object course=jarr.getJSONObject(2).get("phone");

		       System.out.println(course);
	}

}
