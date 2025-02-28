package fakerData;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class GeneratingFakeData 
{
	@Test
	void data()
	{
		Faker faker=new Faker();
		String firstname=faker.name().firstName();
		String lastname=faker.name().lastName();
		String username=faker.name().username();
		String password=faker.internet().password();
		String emailAddress=faker.internet().emailAddress();
		String phone=faker.phoneNumber().cellPhone();
		
		System.out.println("First Name :"+firstname);
		System.out.println("Last Name :"+lastname);
		System.out.println("User Name :"+username);
		System.out.println("Password :"+password);
		System.out.println("Email Address :"+emailAddress);
		System.out.println("Phone Number :"+phone);


	}

}
