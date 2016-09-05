package DataBase;

import java.sql.*;
import java.util.ArrayList;

public class DataBase {
	
	private String database = "FranchiseProject"; 

	private String connectionString = "jdbc:mysql://localhost/"+database;
	private Connection con = null;
	private Statement st = null;
	private ResultSet result = null;
	private int rows=0;
	private ResultSetMetaData resultSet = null;
	
	public DataBase() {

		try {
			con = DriverManager.getConnection(connectionString, "root",
					"Muhammad");
			st = con.createStatement();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void executeQuery(String query) {
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getResult(String query){

		try {

			result = st.executeQuery(query);
			resultSet = result.getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getRow(String query){
		getResult(query);
		try {
			result.last();
			rows = result.getRow()+1;
			result.first();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.valueOf(rows);
	}

	public String[][] getPrices(String query){

		getResult(query);
		String[][] prices = new String[3][4];
		int row=0;
		try {
			while(result.next()){

				for(int col=0; col<4; col++){
					try {
						prices[row][col] = result.getString(col+1);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				row++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prices;
	}

	@SuppressWarnings("rawtypes")
	public ArrayList getEmployeeName(){

		ArrayList<String> names = new ArrayList<>();
		try {
			while(result.next()){

				names.add(result.getString(1));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return names;
	}

	@SuppressWarnings("rawtypes")
	public ArrayList getRecord(){
		ArrayList<String> record = new ArrayList<>();
		try {
			while(result.next()){

				String rowData="";
				for(int col=1; col<=resultSet.getColumnCount(); col++){

					if(rowData.equals("")){
						rowData+=result.getString(col);
					}
					else
						rowData+=", "+result.getString(col);
				}
				record.add(rowData);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return record;
	}

	@SuppressWarnings("unchecked")
	public String getARow(){

		String row = null;
		ArrayList<String> data = getRecord();
		try{
			row = data.get(0);

		}catch(IndexOutOfBoundsException e){

		}
		return row;		
	}

	@SuppressWarnings("rawtypes")
	public ArrayList getAdminData(){

		ArrayList<String> adminData = new ArrayList<>();
		try {
			while(result.next()){

				adminData.add(result.getString(1)+","+result.getString(2));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminData;
	}

	@SuppressWarnings("rawtypes")
	public ArrayList getMobilesData(){

		ArrayList<String> mobilesData = new ArrayList<>();
		try {
			while(result.next()){
				String row="";
				for(int i=1; i<=resultSet.getColumnCount(); i++){

					if(row.equals(""))
						row=result.getString(i);
					else
						row+="," + result.getString(i);
				}
				mobilesData.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mobilesData;
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList getEmployeesReocord(String query){
		
		getResult(query);
		ArrayList<String> record  = new ArrayList<String>();
		
		try {
			while(result.next()){
				
				String row="";
				for(int i=1; i<=resultSet.getColumnCount(); i++){

					if(row.equals(""))
						row=result.getString(i);
					else
						row+="," + result.getString(i);
				}
				record.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return record;
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList getMobilesRecord(String query){

		getResult(query);
		ArrayList<String> record  = new ArrayList<String>();
		
		try {
			while(result.next()){
				
				String row="";
				for(int i=1; i<=resultSet.getColumnCount(); i++){

					if(row.equals(""))
						row=result.getString(i);
					else
						row+="," + result.getString(i);
				}
				record.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return record;
	}
	
	public String[] getStock(String query){
		
		getResult(query);
		String[] stock = new String[7];
		try {
			while(result.next()){

				for(int col=0; col<7; col++){
					try {
						stock[col] = result.getString(col+1);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return stock;
	}

}
