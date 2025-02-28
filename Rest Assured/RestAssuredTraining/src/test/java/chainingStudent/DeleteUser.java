package chainingStudent;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser 
{
@Test
void test_deleteUser(ITestContext context)
{
	int id=(Integer)context.getSuite().getAttribute("user_id");
	 
	given()
	.pathParam("id",id)
	.when()
	.delete("http://localhost:3000/students/{id}")
	.then()
	.statusCode(200);
	
}
}
