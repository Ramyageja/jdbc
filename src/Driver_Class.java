package project;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


import java.util.Scanner;

public class Driver_Class {
	private static Scanner scan=new Scanner(System.in);

	/*In toConnectDb()-->involves 5 steps to connect with db
	 * register the driver class---->Class.forName("com.mysql.cj.jdbc.Driver")
	 * create connection--->connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swiggy",userName,password)
	 * create statement----->Statement line=connection.createStatement()
	 * Execute queries---->add,display,displayById,updateById
	 * close the connection ---->connection.close()
	 */
	public static Connection toConnectDb() throws SQLException {
		Connection connection= null;
		try {
			String userName = "root";
			String password = "Ramya@12345";
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swiggy",userName,password);
			Statement line=connection.createStatement();

		}
		catch(Exception expObj) {
			System.out.println(expObj);
		}
		return connection;
	}

	/*after login success it access this method
	 * Here we call some of the methods from Hotel_details class
	 * methods--->toAdd(),toDisplay(),toDisplayById(),toDeleteById(),toUpdateById()
	 * do while loop --->until the condition fails it execute do one time-->exit level 
	 */
	public static void toAccessData() throws SQLException,Exception {

		Connection connection =toConnectDb();
		Hotel_details mObj=new Hotel_details();
		Scanner scan=new Scanner(System.in);
		System.out.println("    **SWIGGY**  ");
		System.out.println("1.Add the restaurants");
		System.out.println("2.Display the restaurants detail");
		System.out.println("3.Search the restaurants");      
		System.out.println("4.Remove the hotel");
		System.out.println("5.Update the details");	
		int choice;
		do {
			choice=scan.nextInt();
			switch(choice) {

			case 1:
				System.out.println("    Insert Restaurant details  ");
				mObj.toAdd(connection);
				break;
			case 2:
				System.out.println("    Display restaurant details");
				mObj.toDisplayAll(connection);
				break;
			case 3:
				System.out.println("    Find Restaurant using HotelNum");
				mObj.toDisplayById(connection);
				break;
			case 4:
				System.out.println("    Delete the restaurant using HotelNum");
				mObj.toDeleteById(connection);
				break;
			case 5:
				System.out.println("    Update the restaurant using HotelNum");
				mObj.toUpdateById(connection);
				break;
			case 6:
				Swiggy_details.toCallLogout();
				break;
			case 7:
				break;
			}
		}while(choice!=7);
		connection.close();
	}

	/*In main method we get userName and password from user using scanner class obj
	 * call toCheckLogin(userName,password)-->method from Swiggy_details class
	 */
	public static void main(String[] args) throws Exception, SQLException {
		System.out.println("Enter the username:");
		String userName=scan.next();
		System.out.println("Enter the password: ");
		String password=scan.next();
		Swiggy_details.toCheckLogin(userName, password);


	}

}
