package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*In this class we defined some of the methods like add,display,search,update*/
public class Hotel_details {
	private static Scanner scan =new Scanner(System.in);

	/*In toAdd(connection)-->method we inserted values using insert DML query
	 * preparedStatement-->we get values from user using this statement 
	 * then execute using executeUpdate
	 * int insertValues-->store the executed values in integer type 
	 */
	public void toAdd(Connection connection) throws SQLException {
		PreparedStatement addAll=connection.prepareStatement("INSERT INTO hotels values(?,?,?,?,?,?)");
		System.out.println("Enter the hotel no: ");
		addAll.setInt(1,scan.nextInt());
		System.out.println("Enter the hotel name: ");
		addAll.setString(2,scan.next());
		System.out.println("Enter the owner name: ");
		addAll.setString(3, scan.next());
		System.out.println("Enter the location: ");
		addAll.setString(4, scan.next());
		System.out.println("Enter the rating: ");
		addAll.setFloat(5, scan.nextFloat());
		System.out.println("Enter the foodType: ");
		addAll.setString(6, scan.next());
		int insertValues=addAll.executeUpdate();
		System.out.println(insertValues+" inserted values");	

	}

	/*In toDisplayAll(connection)-->method it display all the inserted details
	 * Statement-->create SQL basis statements in java it provides method to execute queries with the database
	 * then execute using executeQuery--->SELECT * FROM hotels
	 * It display the all details using while loop
	 */
	public void toDisplayAll(Connection connection) throws SQLException,Exception {
		Statement inputDisplay=connection.createStatement();
		ResultSet view=inputDisplay.executeQuery("SELECT * FROM hotels");
		while(view.next()) {
			System.out.println("Hotel ID= "+view.getInt(1)+", Hotel name= "+view.getString(2)+", Owner name= "+view.getString(3)+", Location= "+view.getString(4)+", Rating= "+view.getFloat(5)+", Food type= "+view.getString(6));	
		}

	}

	/*In toDisplayAll(connection)-->method it display the hotel details using Id
	 * --->SELECT * FROM hotels where hotelId=?
	 * preparedStatement-->we get Hotel Id from user using this statement
	 *set the values-->displayId.setInt(1,id);
	 *then execute using executeQuery
	 * It display the hotel details by hotelId given by the user
	 */
	public void toDisplayById(Connection connection) throws SQLException {
		PreparedStatement displayId = connection.prepareStatement("SELECT * FROM hotels WHERE hotelId = ?");
		System.out.println("Enter the restaurant id to Display");
		int id = scan.nextInt();
		displayId.setInt(1,id);
		ResultSet view = displayId.executeQuery();
		while(view.next()) {
			System.out.println("Hotel ID= "+view.getInt(1)+", Hotel name= "+view.getString(2)+", Owner name= "+view.getString(3)+", Location= "+view.getString(4)+", Rating= "+view.getFloat(5)+", Food type= "+view.getString(6));
		}
	}
	
	
	/*In toDeleteById(connection)-->method it delete the hotel details using Id
	 * --->DELETE  FROM hotels where hotelId=?
	 * preparedStatement-->we get Hotel Id from user using this statement 
	 *set the values-->deleteId.setInt(1,id);
	 *then execute using executeUpdate
	 *if deleted means-->gives 1 record deleted
	 *not deleted means--->gives 0 record deleted
	 * It delete the hotel details by hotelId given by the user
	 */

	public void toDeleteById(Connection connection) throws SQLException {
		PreparedStatement delete = connection.prepareStatement("DELETE FROM hotels WHERE hotelId= ?");
		System.out.println("Enter the restaurant id to Delete");
		int id = scan.nextInt();
		delete.setInt(1,id);
		int deleteValue = delete.executeUpdate();
		System.out.println(deleteValue + "record deleted");
	}

	/*In toUpdateById(connection)-->method it update the hotel details using Id
	 * --->Update hotels where hotelId=?
	 * preparedStatement-->we get Hotel Id from user using this statement 
	 *set the values-->UpdateId.setInt(1,id);
	 *update food type 
	 *then execute using executeUpdate-->store in integer type
	 *if update-->gives 1 record updated successfully
	 *not update means--->gives 0
	 * It display the update successfully 
	 */
	public void toUpdateById(Connection connection) throws SQLException,Exception {

		PreparedStatement update=connection.prepareStatement("Update hotels set foodType=? where hotelId= ?");
		System.out.println("Enter the hotel Id: ");
		update.setInt(2, scan.nextInt());
		System.out.println("Enter the food type: ");
		update.setString(1, scan.next());
		int updateValues=update.executeUpdate();
		System.out.println(updateValues+" record updated successfully");

	}

}
