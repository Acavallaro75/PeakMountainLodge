package resort;

/* Needs to be done:
1. Initialize all table views, combo boxes, etc.
2. Logic for error messages and confirmation messages for certain things
3. Make it possible to create new managers/employee log-ins.
 */

import java.io.IOException;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/** The ManagerOverviewController corresponds to all items on the manager_overview.fxml file */
public class ManagerOverviewController {

  /** Table view financialReportsTableView is used to see all of the financial reports. */
  @FXML private TableView<ManagerDriver> financialReportsTableView;

  /** ChoiceBox sortBy allows the user to sort by a particular field in the financial reports. */
  @FXML private ChoiceBox<String> sortBy;

  /** DatePicker startDate is used to select a start date for the financial reports table view. */
  @FXML private DatePicker startDate;

  /** DatePicker endDate is used to select an end date for the financial reports table view. */
  @FXML private DatePicker endDate;

  /** ChoiceBox previousReports allows the user to select a year to view those reports. */
  @FXML private ChoiceBox<?> previousReports;

  /** Table view blackOutDatesTableView is used to view all of the rooms and to select a room. */
  @FXML private TableView<ManagerDriver> blackOutDatesTableView;

  /** CheckBox confirmation is used to confirm black out date selection. */
  @FXML private CheckBox confirmation;

  /** DatePicker datePicker is used to select the date for blacking out dates. */
  @FXML private DatePicker datePicker;

  /** Table view promotionsTableView is used to view all of the rooms and to select a room. */
  @FXML private TableView<?> promotionsTableView;

  /**
   * Table view customerInformationTableView is used to view all of the customers and their related
   * information from the database.
   */
  @FXML private TableView<ManagerDriver> customerInformationTableView;

  /** Text field to look up the customer by their name from the database. */
  @FXML private TextField customerName;

  /** Text field to look up the customer by their phone number from the database. */
  @FXML private TextField customerPhone;

  /** Text field to look up the customer by their credit card number from the database. */
  @FXML private TextField creditCardNumber;

  @FXML private TableColumn<Integer, ManagerDriver> ratesColumn;

  @FXML private TableColumn<Integer, ManagerDriver> diningColumn;

  @FXML private TableColumn<Integer, ManagerDriver> activitiesColumn;

  @FXML private TableColumn<Integer, ManagerDriver> expensesColumn;

  @FXML private TableColumn<Integer, ManagerDriver> revenueColumn;

  @FXML private TableColumn<?, ?> dateColumn;

  @FXML private TableColumn<?, ?> costColumn;

  @FXML private TableColumn<?, ?> roomNumberColumn;

  @FXML private TableColumn<?, ?> blackOutDateColumn;

  @FXML private TableColumn<?, ?> blackOutCostColumn;

  @FXML private TableColumn<?, ?> blackOutRoomTypeColumn;

  @FXML private TableColumn<?, ?> nameColumn;

  @FXML private TableColumn<?, ?> phoneNumberColumn;

  @FXML private TableColumn<?, ?> roomTypeColumn;

  @FXML private TableColumn<?, ?> last4CCNColumn;

  @FXML private TableColumn<?, ?> checkInColumn;

  @FXML private TableColumn<?, ?> checkOutColumn;


  private ObservableList<ManagerDriver> blackOut;
  private ObservableList<ManagerDriver> customerInfo;

  public void initialize() {
    ObservableList<ManagerDriver> manager = FXCollections.observableArrayList();
    ObservableList<String> sort =
        FXCollections.observableArrayList(
            "Room Rates", "Dining", "Activities", "Expenses", "Total Revenue");
    ratesColumn.setCellValueFactory(new PropertyValueFactory<>("roomRates"));
    diningColumn.setCellValueFactory(new PropertyValueFactory<>("dining"));
    activitiesColumn.setCellValueFactory(new PropertyValueFactory<>("activities"));
    expensesColumn.setCellValueFactory(new PropertyValueFactory<>("expenses"));
    revenueColumn.setCellValueFactory(new PropertyValueFactory<>("revenue"));
    Random random = new Random();
    financialReportsTableView.setItems(manager);
    for (int i = 0; i <= 20; i++) {
      manager.add(
          new ManagerDriver(
              random.nextInt(500000),
              random.nextInt(500000),
              random.nextInt(500000),
              random.nextInt(500000),
              random.nextInt(500000)));
    }
    sortBy.getItems().clear();
    sortBy.setItems(sort);
    sortBy.getSelectionModel().selectFirst();
    List<Integer> numbers = new ArrayList<>();
    for (int i = 2018; i >= 2005; i--) {
      numbers.add(i);
    }
    ObservableList numberList = FXCollections.observableList(numbers);
    previousReports.getItems().clear();
    previousReports.setItems(numberList);
    previousReports.getSelectionModel().selectFirst();

    /**
     * used to fill the date column in the blackout tab
     */

    /*Calendar blackoutTab = Calendar.getInstance();
    ArrayList<Calendar> blackout = new ArrayList<>();

    for (int i = 0; i < 15; i++){
      blackoutTab.add(Calendar.DATE, -10);
      blackout.add(blackoutTab);
    }

    //blackOutDateColumn.setCellValueFactory(new PropertyValueFactory<String, Calendar>("date"));
    */

    /*
    for the black out tab
     */

    blackOut = FXCollections.observableArrayList();

    blackOutDateColumn.setCellValueFactory(new PropertyValueFactory("blackOutDate"));
    blackOutCostColumn.setCellValueFactory(new PropertyValueFactory("blackOutCost"));
    blackOutRoomTypeColumn.setCellValueFactory(new PropertyValueFactory("blackOutRoomNum"));

    blackOutDatesTableView.setItems(blackOut);
    addBlackout();

    /*
    for the customer info tab
     */
    customerInfo = FXCollections.observableArrayList();

    nameColumn.setCellValueFactory(new PropertyValueFactory("customerName"));
    phoneNumberColumn.setCellValueFactory(new PropertyValueFactory("customerPhNum"));
    roomTypeColumn.setCellValueFactory(new PropertyValueFactory("customerRoomType"));
    last4CCNColumn.setCellValueFactory(new PropertyValueFactory("last4CNN"));
    checkInColumn.setCellValueFactory(new PropertyValueFactory("customerCheckIn"));
    checkOutColumn.setCellValueFactory(new PropertyValueFactory("customerCheckOut"));

    customerInformationTableView.setItems(customerInfo);
    addCustomer();
  }//end initialize

  public void addBlackout() {
    Date d1 = new Date(119,11,20);
    Date d2 = new Date(119,11,20);
    Date d3 = new Date(119,11,20);
    Date d4 = new Date(119,11,20);
    Date d5 = new Date(119,11,21);
    Date d6 = new Date(119,11,21);
    Date d7 = new Date(119,11,21);
    Date d8 = new Date(119,11,25);
    Date d9 = new Date(119,11,25);
    Date d10 = new Date(119,11,25);
    Date d11 = new Date(119,11,25);
    Date d12 = new Date(119,11,25);
    Date d13 = new Date(119,11,29);
    Date d14 = new Date(119,11,29);
    Date d15 = new Date(119,11,29);
    Date d16 = new Date(119,11,29);
    Date d17 = new Date(119,11,29);



    blackOut.add(new ManagerDriver(d1,499.00,110));
    blackOut.add(new ManagerDriver(d2,419.00,114));
    blackOut.add(new ManagerDriver(d3,419.00,116));
    blackOut.add(new ManagerDriver(d4,419.00,214));
    blackOut.add(new ManagerDriver(d5,499.00,210));
    blackOut.add(new ManagerDriver(d6,499.00,310));
    blackOut.add(new ManagerDriver(d7,419.00,314));
    blackOut.add(new ManagerDriver(d8,419.00,316));
    blackOut.add(new ManagerDriver(d10,419.00,318));
    blackOut.add(new ManagerDriver(d11,499.00,210));
    blackOut.add(new ManagerDriver(d12,499.00,310));
    blackOut.add(new ManagerDriver(d13,419.00,314));
    blackOut.add(new ManagerDriver(d14,419.00,316));
    blackOut.add(new ManagerDriver(d15,419.00,214));
    blackOut.add(new ManagerDriver(d16,419.00,218));
    blackOut.add(new ManagerDriver(d17,419.00,216));
  }

  public void addCustomer(){
    Date d0 = new Date(119,11,20);
    Date d1 = new Date(119,11,25);

    Date d2 = new Date(119,10,12);
    Date d3 = new Date(119,10,20);

    Date d4 = new Date(119,10,10);
    Date d5 = new Date(119,10,12);

    Date d6 = new Date(119,10,1);
    Date d7 = new Date(119,10,8);

    customerInfo.add(new ManagerDriver("John Smith",5687452,"Suite 2", 8564, d0,d1));
    customerInfo.add(new ManagerDriver("Mary Barry",8756642,"Suite 1", 1852, d2,d3));
    customerInfo.add(new ManagerDriver("Hannah Nueben",9026432,"Suite 2", 4569, d4,d5));
    customerInfo.add(new ManagerDriver("Loki Novak",1024485,"Suite 1", 1856, d6,d7));
  }



  /**
   * The goToHomePage() function is used to bring the user to the home page and logs the manager out
   * of the system.
   *
   * @param event MouseEvent upon clicking the back button
   * @throws IOException yes, it does
   */
  @FXML
  void goToHomePage(MouseEvent event) throws IOException {
    Parent homeParent = FXMLLoader.load(getClass().getResource("home.fxml"));
    Scene homeScene = new Scene(homeParent);
    Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    homeStage.setScene(homeScene);
    homeStage.show();
  }

}// end of class ManagerOverviewController