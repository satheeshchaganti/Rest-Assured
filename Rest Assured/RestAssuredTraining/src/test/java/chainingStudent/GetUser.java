package chainingStudent;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class GetUser 
{
@Test
void test_getUser(ITestContext context)
{
	int id=(Integer)context.getSuite().getAttribute("user_id");
	
	given()
	.pathParam("id",id)
	.when()
	.get("http://localhost:3000/students/{id}")
	.then()
	.statusCode(200)
	.log().all();
	
	
	
}

}
