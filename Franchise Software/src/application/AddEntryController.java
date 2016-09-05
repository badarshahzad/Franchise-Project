package application;

import java.io.File;

import javax.swing.JOptionPane;

import DataBase.DataBase;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AddEntryController {	

	@FXML
	private ImageView imageView;

	@FXML
	private TableView<StockTable> stockTable;

	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn itemsTableCol;

	@SuppressWarnings("rawtypes")
	@FXML 
	private TableColumn existTableCol;

	private final ObservableList<StockTable> stockData = FXCollections.observableArrayList();

	private DataBase dataBase = new DataBase();

	@SuppressWarnings("unchecked")
	@FXML
	private void initialize(){

		itemsTableCol.setCellValueFactory(new PropertyValueFactory<>("items"));
		existTableCol.setCellValueFactory(new PropertyValueFactory<>("exist"));
		setStock();
		stockTable.setItems(stockData);
	}

	//When Image is clicked call goes to this method to allow user to add image.
	@FXML
	public void addImageClicked(){

		Stage primaryStage = new Stage();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select Image");
		File selectedFile = 
				fileChooser.showOpenDialog(primaryStage);

		String imagePath = selectedFile.getPath();
		if(selectedFile == null || (!(imagePath.endsWith(".jpeg")) && !(imagePath.endsWith(".jpg")) && !(imagePath.endsWith(".exif")) && !(imagePath.endsWith(".tiff")) &&
				!(imagePath.endsWith(".gif")) && !(imagePath.endsWith(".bmp")) && !(imagePath.endsWith(".png"))
				&& !(imagePath.endsWith(".webpg")) && !(imagePath.endsWith(".bpg")))){

			JOptionPane.showMessageDialog(null, "Sorry\nPlease Select an Image");
		}

		else{

			try{
				File file = new File(imagePath);
				Image image = new Image(file.toURI().toString());
				imageView.setImage(image);
//				imageView.getImage().isError();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	//This method will set the stock data in order to populate table.
	public void setStock(){

		String[] stockDataStringArray = dataBase.getStock("select * from Stock;");

		stockData.add(new StockTable("HLR", stockDataStringArray[0]));
		stockData.add(new StockTable("Sim", stockDataStringArray[1]));
		stockData.add(new StockTable("Card", stockDataStringArray[2]));
		stockData.add(new StockTable("Mobiles", stockDataStringArray[3]));
		stockData.add(new StockTable("Easy Load", stockDataStringArray[4]));
		stockData.add(new StockTable("Easy Paisa", stockDataStringArray[5]));
		stockData.add(new StockTable("Cash", stockDataStringArray[6]));
	}

	public class StockTable {

		private final SimpleStringProperty items;
		private final SimpleStringProperty exist;

		private StockTable(String items, String exist) {

			this.items = new SimpleStringProperty(items);
			this.exist = new SimpleStringProperty(exist);
		}

		public String getItems() {
			return items.get();
		}

		public void setItems(String items) {
			this.items.set(items);
		}

		public String getExist() {
			return exist.get();
		}

		public void setExist(String exist) {
			this.exist.set(exist);
		}

	}
}
