package dataValidation;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ExtractingData {
	@Test
	void ParsingData()
	{
		Response res=given()
				.contentType(ContentType.JSON)
				.when()
				.get("http://localhost:3000/students");
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
         JSONArray jarr=new JSONArray(res.asString());
       String name=  jarr.getJSONObject(2).get("name").toString();
       System.out.println(name);
	}

}
