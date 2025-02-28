package diffWaysToCreatingRequestBody;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class DataCreationWithExternalJsonFile {
	@Test(priority=1)
	void ExternalFile() throws FileNotFoundException
	{
		File f=new File(".//body.json");
		FileReader fr=new FileReader(f);
		JSONTokener jt=new JSONTokener(fr);
		JSONObject data=new JSONObject(jt);

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
