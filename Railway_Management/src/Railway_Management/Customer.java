package Railway_Management;

import java.util.Scanner;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Customer {

    static private ArrayList<Object> record = new ArrayList();
    private int c_id;
    private String name;
    private long cnic;
    private long phoneNo;

    //Default constructor
    public Customer() {
        c_id = 0;
        name = null;
        cnic = 0;
        phoneNo = 0;
    }

    //Overloaded Constructor
    public Customer(int c_id, String name, long cnic, long phoneNo) {
        this.c_id = c_id;
        this.name = name;
        this.cnic = cnic;
        this.phoneNo = phoneNo;
    }

    //Assigns id to customer
    public void setC_id(int c_id) {
        c_id = c_id;
    }

    //Assigns name to customer
    public void setName(String name) {
        this.name = name;
    }

    //Assigns CNIC to customer
    public void setCnic(long cnic) {
        this.cnic = cnic;

    }

    //Assigns phone number to customer
    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    //Sets values of the instance variables
    //Calls all mutator methods
    public int getC_id() {
        return c_id;
    }

    public String getName() {
        return name;
    }

    public long getCnic() {
        return cnic;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    @Override
    public String toString() {
        return (getC_id() + " " + getName() + " " + getCnic() + " " + getPhoneNo());
    }

    //Checks id,CNIC and phone number of customer
    //Two or more customers cannot have same id,CNIC or phone number
    public static boolean equals(File f, Customer c) {
        Scanner s = null;
        String s1;
        String[] s2;
        boolean check = true;
        try {
            s = new Scanner(f);
            while (s.hasNext()) {
                s1 = s.nextLine();
                s2 = s1.split(" ");
                if (((Integer.parseInt(s2[0])) == c.getC_id()) || ((Long.parseLong(s2[2])) == c.getCnic()) || ((Long.parseLong(s2[2])) == c.getPhoneNo())) {
                    JOptionPane.showMessageDialog(null, "Record already exists");
                    check = false;
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (s != null) {
                s.close();
            }
        }
        return check;
    }

    //Adds new customer's data to file
    //uses toString method
    public static void addCustomer(File f, Customer c) {
        if (Customer.equals(f, c)) {
            PrintWriter pw;
            FileWriter fw;
            try {
                fw = new FileWriter(f.getAbsolutePath(), true);
                pw = new PrintWriter(fw);
                pw.println(c.toString());
                fw.close();
                pw.close();
            } catch (IOException e) {
                System.out.println(e);
            }
            JOptionPane.showMessageDialog(null, "Record added successfully");
        }
    }

    //Reads and display Customer's data from file
    public static ArrayList viewCustomer(File f) {
        try {
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String s1 = s.nextLine();
                String[] s2 = s1.split(" ");
                record.add(new Customer(Integer.parseInt(s2[0]), s2[1], Long.parseLong(s2[2]), Long.parseLong(s2[3])));
            }
            s.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return record;
    }

    //Search for a customer from data in the file(ID based search)
    public static void searchCustomer_id(File f, int id) {
        boolean found = false;
        Scanner s;
        String s1;
        try {
            s = new Scanner(f);
            while (s.hasNext()) {
                s1 = s.nextLine();
                String[] s2 = s1.split(" ");
                if (id == Integer.parseInt(s2[0])) {
                    JOptionPane.showMessageDialog(null, "ID: " + s2[0] + "\tName: " + s2[1] + "\tCNIC: " + s2[2] + "\tPhone no: " + s2[3]);
                    found = true;
                    break;
                }
            }
            s.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "No such record found");
        }
    }

    //Search for a customer from data in the file(Name based search)
    public static void searchCustomer_name(File f, String name) {
        boolean found = false;
        Scanner s = null;
        String s1;

        try {
            s = new Scanner(f);
            while (s.hasNext()) {
                s1 = s.nextLine();
                String[] s2 = s1.split(" ");
                if (name.equalsIgnoreCase(s2[1])) {
                    JOptionPane.showMessageDialog(null, "ID: " + s2[0] + "\tName: " + s2[1] + "\tCNIC: " + s2[2] + "\tPhone no: " + s2[3]);
                    found = true;
                    break;
                }
            }
            s.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "No such record found");
        }
    }

    //Updates data of customer in file other than its id
    public static void updateCustomer(File f, int id, int action) {
        Scanner in = new Scanner(System.in);
        FileWriter fw;
        File temp_file = new File("temp_file.txt");
        Scanner s;
        Customer c;
        boolean check = false;
        boolean updated = false;
        try {
            s = new Scanner(f);
            while (s.hasNext()) {
                String s1 = s.nextLine();
                String[] s2 = s1.split(" ");
                switch (action) {
                    case 1:
                        c = new Customer(Integer.parseInt(s2[0]), s2[1], Long.parseLong(s2[2]), Long.parseLong(s2[3]));
                        if (id == c.getC_id()) {
                            check = true;
                            String name = JOptionPane.showInputDialog("Enter name");
                            c.setName(name);
                        }
                        fw = new FileWriter(temp_file.getAbsolutePath(), true);
                        try (PrintWriter pw = new PrintWriter(fw)) {
                            pw.println(c.toString());
                            fw.close();
                            pw.close();
                        }
                        updated = true;
                        break;
                    case 2:
                        c = new Customer(Integer.parseInt(s2[0]), s2[1], Long.parseLong(s2[2]), Long.parseLong(s2[3]));
                        if (id == c.getC_id()) {
                            check = true;
                            do {
                                try {
                                    long CNIC = Long.parseLong(JOptionPane.showInputDialog("Enter CNIC"));
                                    c.setCnic(CNIC);
                                    check = false;
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Integer value required");
                                }
                            } while (check);

                        }
                        fw = new FileWriter(temp_file.getAbsolutePath(), true);
                        try (PrintWriter pw = new PrintWriter(fw)) {
                            pw.println(c.toString());
                            fw.close();
                            pw.close();
                        }
                        updated = true;
                        break;
                    case 3:
                        c = new Customer(Integer.parseInt(s2[0]), s2[1], Long.parseLong(s2[2]), Long.parseLong(s2[3]));
                        if (id == c.getC_id()) {
                            c = new Customer(Integer.parseInt(s2[0]), s2[1], Long.parseLong(s2[2]), Long.parseLong(s2[3]));
                            check = true;
                            do {
                                try {
                                    long phoneNo = Long.parseLong(JOptionPane.showInputDialog("Enter Phone no"));
                                    c.setCnic(phoneNo);
                                    check = false;
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Integer value required");
                                }
                            } while (check);
                            fw = new FileWriter(temp_file.getAbsolutePath(), true);
                            try (PrintWriter pw = new PrintWriter(fw)) {
                                pw.println(c.toString());
                                fw.close();
                                pw.close();
                            }
                        }
                        updated = true;
                        break;
                }
            }
            s.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        f.delete();
        temp_file.renameTo(f.getAbsoluteFile());
        if (updated) {
            JOptionPane.showMessageDialog(null, "Record updated successfully");
        }
    }

    //Deletes record of a customer from file
    public static void deleteCustomer(File f, int id) {
        boolean deleted = false;
        PrintWriter pw;
        FileWriter fw;
        File temp_file = new File("temp_file.txt");;
        Scanner s;
        try {
            s = new Scanner(f);
            fw = new FileWriter(temp_file, true);
            pw = new PrintWriter(fw);
            while (s.hasNext()) {
                String s1 = s.nextLine();
                String[] s2 = s1.split(" ");
                if (!(id == Integer.parseInt(s2[0]))) {
                    pw.println(s1);
                }
            }
            s.close();
            fw.close();
            pw.close();
            deleted = true;
        } catch (IOException e) {
            System.out.println(e);
        }
        f.delete();
        temp_file.renameTo(f.getAbsoluteFile());
        if (deleted) {
            JOptionPane.showMessageDialog(null, "Record deleted successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Error deleting record");
        }
    }
}
