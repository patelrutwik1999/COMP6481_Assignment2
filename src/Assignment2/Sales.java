package Assignment2;

//...............................................................
//Assignment 2
//© Rutwikkumar Sunilkumar Patel
//Written By: Rutwikkumar Sunilkumar Patel, Student Id: 40160646
//...............................................................

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * -------------Project Description--------------
 * All the attributes of the Sale class are being declared and initialized here. Also, there are getter and setter methods of these
 * attributes to get and set the values of attributes. It has also equals() and toString() method overridden to compare the objects
 * and to print the attributes value in string format respectively.
 */
public class Sales {
    private String country;
    private String item_type;
    private char order_priority;
    private Date order_date;
    private long order_ID;
    private Date ship_date;
    private int units_sold;
    private float unit_price;
    private float unit_cost;
    private double total_profit;

    /**
     * Default Constructor of Sales class.
     */
    public Sales() {
        this.country = "abc";
        this.item_type = "A";
        this.order_priority = 'a';
        this.order_date = new Date();
        this.order_ID = 23343434;
        this.ship_date = new Date();
        this.units_sold = 123;
        this.unit_price = 22;
        this.unit_cost = 150;
        this.total_profit = 33.4;
    }

    /**
     * Parametrized constructor of Sales class.
     *
     * @param country        country of the sale.
     * @param item_type      item_type of the sale.
     * @param order_priority order_priority of the sale.
     * @param order_date     order_date of the sale.
     * @param order_ID       order_id of the sale.
     * @param ship_date      ship_date of the sale.
     * @param units_sold     units_sold of the sale.
     * @param unit_price     unit_price of the sale.
     * @param unit_cost      unit_cost of the sale.
     * @param total_profit   total_profit of the sale.
     */
    public Sales(String country, String item_type, char order_priority, Date order_date, long order_ID, Date ship_date, int units_sold, float unit_price, float unit_cost, double total_profit) {
        this.country = country;
        this.item_type = item_type;
        this.order_priority = order_priority;
        this.order_date = order_date;
        this.order_ID = order_ID;
        this.ship_date = ship_date;
        this.units_sold = units_sold;
        this.unit_price = unit_price;
        this.unit_cost = unit_cost;
        this.total_profit = total_profit;
    }

    /**
     * Setter method for country attribute.
     *
     * @param country country of the sale.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Setter method for item_type attribute.
     *
     * @param item_type item_type of the sale.
     */
    public void setItemType(String item_type) {
        this.item_type = item_type;
    }

    /**
     * Setter method for order_priority attribute.
     *
     * @param order_priority order_priority of the sale.
     */
    public void setOrderPriority(char order_priority) {
        this.order_priority = order_priority;
    }

    /**
     * Setter method for order_date attribute.
     *
     * @param order_date order_date of the sale.
     */
    public void setOrderDate(Date order_date) {
        this.order_date = order_date;
    }

    /**
     * Setter method for units_sold attribute.
     *
     * @param units_sold units_sold of the sale.
     */
    public void setUnitsSold(int units_sold) {
        this.units_sold = units_sold;
    }

    /**
     * Setter method for ship_date attribute.
     *
     * @param ship_date ship_date of the sale.
     */
    public void setShipDate(Date ship_date) {
        this.ship_date = ship_date;
    }

    /**
     * Setter method for order_ID attribute.
     *
     * @param order_ID order_ID of the sale.
     */
    public void setOrderId(long order_ID) {
        this.order_ID = order_ID;
    }

    /**
     * Setter method for unit_price attribute.
     *
     * @param unit_price unit_price of the sale.
     */
    public void setUnitPrice(float unit_price) {
        this.unit_price = unit_price;
    }

    /**
     * Setter method for unit_cost attribute.
     *
     * @param unit_cost unit_cost of the sale.
     */
    public void setUnitCost(float unit_cost) {
        this.unit_cost = unit_cost;
    }

    /**
     * Setter method for total_profit attribute.
     *
     * @param total_profit total_profit of the sale.
     */
    public void setTotalProfit(double total_profit) {
        this.total_profit = total_profit;
    }

    /**
     * Getter method for country attribute.
     *
     * @return country of the sale.
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * Getter method for item_type attribute.
     *
     * @return item_type of the sale.
     */
    public String getItemType() {
        return this.item_type;
    }

    /**
     * Getter method for order_date attribute.
     *
     * @return order_date of the sale.
     */
    public Date getOrderDate() {
        return this.order_date;
    }

    /**
     * Getter method for ship_date attribute.
     *
     * @return ship_date of the sale.
     */
    public Date getShipDate() {
        return this.ship_date;
    }

    /**
     * Getter method for order_ID attribute.
     *
     * @return order_ID of the sale.
     */
    public long getOrderId() {
        return this.order_ID;
    }

    /**
     * Getter method for units_sold attribute.
     *
     * @return units_sold of the sale.
     */
    public int getUnitsSold() {
        return this.units_sold;
    }

    /**
     * Getter method for unit_price attribute.
     *
     * @return unit_price of the sale.
     */
    public float getUnitPrice() {
        return this.unit_price;
    }

    /**
     * Getter method for unit_cost attribute.
     *
     * @return unit_cost of the sale.
     */
    public float getUnitCost() {
        return this.unit_cost;
    }

    /**
     * Getter method for total_profit attribute.
     *
     * @return total_profit of the sale.
     */
    public double getTotalProfit() {
        return this.total_profit;
    }

    /**
     * Getter method for order_priority attribute.
     *
     * @return order_priority of the sale.
     */
    public char getOrderPriority() {
        return this.order_priority;
    }

    /**
     * Equals method check if the two objects are equal or not. Not only by comparing the object but also the attributes are compared.
     *
     * @param sales object of the sale class.
     * @return true if two objects are equal otherwise return false.
     */
    @Override
    public boolean equals(Object sales) {
        if (this == sales) {
            return true;
        }

        if (getClass() != sales.getClass()) {
            return false;
        }

        Sales sale = (Sales) sales;
        if (this.country.equals(sale.country) && this.item_type.equals(sale.item_type) && this.order_date.equals(sale.order_date) &&
                this.ship_date.equals(sale.ship_date) && this.order_priority == sale.order_priority && this.order_ID == sale.order_ID &&
                this.units_sold == sale.units_sold && this.unit_cost == sale.unit_cost && this.unit_price == sale.unit_price &&
                this.total_profit == sale.total_profit) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method converts the data type to string format to print in the output.txt file.
     * @param date is the order or shipping date depending on the function call.
     * @return date in dd/MM/YYYY format.
     */
    public String parseDate(Date date) {
        return (new SimpleDateFormat("dd/MM/yyyy")).format(date);
    }

    /**
     * toString method of the class Sale to represent attributes of the Sale class.
     *
     * @return attributes of the Sale class in string format.
     */
    @Override
    public String toString() {
        return this.country + "\t" + this.item_type + "\t" + this.order_priority + "\t" + parseDate(this.order_date) + "\t" + this.order_ID + "\t"
                + parseDate(this.ship_date) + "\t" + this.units_sold + "\t" + this.unit_price + "\t" + this.unit_cost + "\t" + this.total_profit;
    }
}
