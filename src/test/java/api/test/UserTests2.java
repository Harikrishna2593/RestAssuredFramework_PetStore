package api.test;



import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;


public class UserTests2 {
	
	
	 
	Faker faker;
	User userPayload;
	public Logger logger; //for logs
	 
	
	@BeforeClass
	public void setup()
	{
		faker=new Faker();
		userPayload=new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		 logger = LogManager.getLogger(this.getClass());
		
	}
	
	@Test(priority = 0)
	public void testPostUser()
	{
		logger.info("***************************Creating User*************************");
		Response response = UserEndPoints2.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
 		logger.info("***************************User is created*************************");
	}
	
	
	@Test(priority = 1)
	public void testGetUserByName()
	{
		
		logger.info("***************************Reading User info*************************");
		Response response = UserEndPoints2.readUser(this.userPayload.getUsername());
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("***************************Reading info is displayed*************************");
	}
	
	@Test(priority = 2)
	public void testUpdateUserByName()
	{
		logger.info("***************************Updating user*************************");
		//Update user by payload
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = UserEndPoints2.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("***************************user updated*************************");
		//checking data for update
		
        Response afetrUpdateResponse = UserEndPoints.readUser(this.userPayload.getUsername());
		
        afetrUpdateResponse.then().log().all();
		Assert.assertEquals(afetrUpdateResponse.getStatusCode(), 200);
		
		
	}
	
	
	@Test(priority = 3)
	public void testDeleteUserByName()
	{
		
		
		logger.info("***************************Deleting  user*************************");
		Response response = UserEndPoints2.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("*************************** user deleted*************************");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
