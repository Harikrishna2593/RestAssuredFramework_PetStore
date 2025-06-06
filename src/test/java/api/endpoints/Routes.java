package api.endpoints;



/*
Swagger URI ------------> https://petstore.swagger.io/

Create User(Post) :https://petstore.swagger.io/v2/user
Get User(Get) : https://petstore.swagger.io/v2/user/{userName}
Update User(Put) : https://petstore.swagger.io/v2/user/{{userName}}
Delete User(Delete) : https://petstore.swagger.io/v2/user/{{userName}}

*/

public class Routes {

	public static String base_url = "https://petstore.swagger.io/v2"; 
	
	
	//User module
	
	public static String post_url = base_url+"/user"; 
	public static String get_url = base_url+"/user/{username}";
	public static String update_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	
	
	// store module
	
	  // Here you will create store module URL's
	
	//Pet module
	
	// Here you will create Pet module URL's
	
	
}
