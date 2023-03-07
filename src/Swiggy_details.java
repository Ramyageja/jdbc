package project;

/*
 * In this program we acting has a swiggy management to add restaurant details.
 * we do some functions like add details,display,search the restaurant,delete restaurant details and update hotel  details using mysql (db)
 * we use some attributes -->shopName,location,owner,rating,veg_nonVeg
 */

import java.sql.SQLException;

/*To hide implementation details from user 
 * we use private attributes
 * attributes-->shopName,ownerName,location,rating,foodType,hoteId
 */
public class Swiggy_details {
	private String shopName;
	private String ownerName;
	private String location;
	private float rating;
	private String foodType;
	private int hotelId;
	private static String NAME= "Ramya";
	private static String SECRET= "Ramya30";
	
	/*To access the private attributes we use encapsulation
	 * getter and setter methods
	 * to set input-->setter
	 * to get the input values-->getter
	 */
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	
	/*In toCheckLogin(userName,password) method-->if the password and userName is correct
	 * it will login successfully--->toAccessData() is execute
	 * if the condition fails --->print-->"UserName or Password is incorrect"
	 */
	public static void toCheckLogin(String username, String password) throws SQLException,Exception {
		if(NAME.equals(username) && SECRET.equals(password)){
			System.out.println("Login successfully");
			Driver_Class.toAccessData();
		}
		else {
			System.out.println("UserName or Password is incorrect");
		}
	}
	
	/*In toCallLogout() -->process is completed it log out successfully*/
	public static void toCallLogout() {
		System.out.println("Logged Out Successfully");
	}
	

}
