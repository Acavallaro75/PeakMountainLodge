package resort;

import java.util.Date;

public class ManagerDriver {
  private int roomRates;
  private int dining;
  private int activities;
  private int expenses;
  private int revenue;

  private Date blackOutDate;
  private double blackOutCost;
  private int blackOutRoomNum;

  private String customerName;
  private int customerPhNum;
  private String customerRoomType;
  private int last4CNN;
  private Date customerCheckIn;
  private Date customerCheckOut;

  public ManagerDriver(String customerName, int customerPhNum, String customerRoomType, int last4CNN, Date customerCheckIn, Date customerCheckOut) {
    this.customerName = customerName;
    this.customerPhNum = customerPhNum;
    this.customerRoomType = customerRoomType;
    this.last4CNN = last4CNN;
    this.customerCheckIn = customerCheckIn;
    this.customerCheckOut = customerCheckOut;
  }

  public ManagerDriver(Date blackOutDate, double blackOutCost, int blackOutRoomNum) {
    this.blackOutDate = blackOutDate;
    this.blackOutCost = blackOutCost;
    this.blackOutRoomNum = blackOutRoomNum;
  }

  public ManagerDriver(int roomRates, int dining, int activities, int expenses, int revenue) {
    this.roomRates = roomRates;
    this.dining = dining;
    this.activities = activities;
    this.expenses = expenses;
    this.revenue = revenue;
  }

  public int getRoomRates() {
    return roomRates;
  }

  public void setRoomRates(int roomRates) {
    this.roomRates = roomRates;
  }

  public int getDining() {
    return dining;
  }

  public void setDining(int dining) {
    this.dining = dining;
  }

  public int getActivities() {
    return activities;
  }

  public void setActivities(int activities) {
    this.activities = activities;
  }

  public int getExpenses() {
    return expenses;
  }

  public void setExpenses(int expenses) {
    this.expenses = expenses;
  }

  public int getRevenue() {
    return revenue;
  }

  public void setRevenue(int revenue) {
    this.revenue = revenue;
  }

  public Date getBlackOutDate() {
    return blackOutDate;
  }

  public void setBlackOutDate(Date blackOutDate) {
    this.blackOutDate = blackOutDate;
  }

  public double getBlackOutCost() {
    return blackOutCost;
  }

  public void setBlackOutCost(double blackOutCost) {
    this.blackOutCost = blackOutCost;
  }

  public int getBlackOutRoomNum() {
    return blackOutRoomNum;
  }

  public void setBlackOutRoomNum(int blackOutRoomNum) {
    this.blackOutRoomNum = blackOutRoomNum;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public int getCustomerPhNum() {
    return customerPhNum;
  }

  public void setCustomerPhNum(int customerPhNum) {
    this.customerPhNum = customerPhNum;
  }

  public String getCustomerRoomType() {
    return customerRoomType;
  }

  public void setCustomerRoomType(String customerRoomType) {
    this.customerRoomType = customerRoomType;
  }

  public int getLast4CNN() {
    return last4CNN;
  }

  public void setLast4CNN(int last4CNN) {
    this.last4CNN = last4CNN;
  }

  public Date getCustomerCheckIn() {
    return customerCheckIn;
  }

  public void setCustomerCheckIn(Date customerCheckIn) {
    this.customerCheckIn = customerCheckIn;
  }

  public Date getCustomerCheckOut() {
    return customerCheckOut;
  }

  public void setCustomerCheckOut(Date customerCheckOut) {
    this.customerCheckOut = customerCheckOut;
  }
}