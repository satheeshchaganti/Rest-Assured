package validatingCookiesAndHeaders;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
public class ValidatingHeaders {
@Test
void TestHeaders() {
	Response res=given()
	         .when()
	         .get("https://google.com");
	Headers hrs=res.getHeaders();
    for(Header k:hrs)
    {
  	  System.out.println(k.getName()+"    "+k.getValue());
    }

}
}

