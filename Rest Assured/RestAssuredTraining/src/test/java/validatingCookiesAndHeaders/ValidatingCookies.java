package validatingCookiesAndHeaders;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class ValidatingCookies {
@Test
	void cookiesValidation()
{
	Response res=given()
	         .when()
	         .get("https://google.com");
	      Map<String, String> cookies=res.getCookies();
	      for(String k:cookies.keySet())
	      {
	    	  String cookie_value=res.getCookie(k);
	    	  System.out.println(k+"    "+cookie_value);
	      }
}
}
