package diffWaysToCreatingRequestBody;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class DataCreationWithPOJOClass {
	@Test(priority=1)
	void POJOData()
	{
		POJOClass data=new POJOClass();
		data.setName("satish");
		data.setPhone("123456");
		data.setLocation("india");
		String coursesarr[]= {"c","c++"};
		data.setCourses(coursesarr);
	given()
	.contentType("application/json")
	.body(data)

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
