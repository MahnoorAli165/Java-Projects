package Railway_Management;

import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class Reservation {

    int c_id;
    String c_name;
    int t_id;
    String status;
    String Class;
    String destination;
    Date d;
    int price;

    File f = new File("Reservation");

    public Reservation() {
        c_id = 0;
        c_name = null;
        t_id = 0;
        status = null;
        Class = null;
        destination = null;
        d = null;
        price = 0;
    }

    public Reservation(int c_id, String c_name, int t_id, String status, String Class, String destination, Date d, int price) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.t_id = t_id;
        this.status = status;
        this.Class = Class;
        this.destination = destination;
        this.d = d;
        this.price = price;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getStatus() {
        return status;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String get_Class() {
        return Class;
    }

    public void setClass(String Class) {
        this.Class = Class;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getD() {
        return d;
    }

    public void setD(Date d) {
        this.d = d;
    }

    public int getT_id() {
        return t_id;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return c_id + " " + c_name + " " + t_id + " " + status + " " + Class + " " + destination + " " + d + " " + price;
    }

    public void print() {
        if (!(f.exists())) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        if (Customer.equals(f, new Customer())) {

            try {
                FileWriter fw = new FileWriter(f, true);
                PrintWriter pw = new PrintWriter(fw);

                pw.println(toString());
                fw.close();
                pw.close();
                JOptionPane.showMessageDialog(null, "Customer id: " + c_id + "\nCustomer Name: " + c_name + "\nTrain ID: " + t_id + "\nStatus: " + status + "\nClass: " + Class + "\nDestination: " + destination + "\nDate: " + d + "\nPrice: " + price);
            } catch (IOException e) {
                System.out.println(e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Customer does not exist in record");
        }
    }
}
