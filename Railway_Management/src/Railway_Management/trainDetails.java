package Railway_Management;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class trainDetails {
    
    private int ID;
    int hours;
    int minutes;
    
    public trainDetails() {
        
    }

    public trainDetails(int ID, int hours,int minutes) {
        this.ID = ID;
        this.hours=hours;
        this.minutes=minutes;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return (ID + " "+ hours+":"+minutes);
    }

    public static boolean equals(int id) {
        File f= new File("TrainDetatils.txt");
        boolean check = false;
        try {
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String s1 = s.nextLine();
                String[] s2 = s1.split(" ");
                if (Integer.parseInt(s2[0]) == id) {
                    JOptionPane.showMessageDialog(null, "Record already exists");
                    check = true;
                    s.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return check;
    }

    //Add TrainDetails
    public static void addtrainDetails(trainDetails t) {
        File f= new File("TrainDetails.txt");
        Trains train = new Local();
        if (train.equals(t.getID())) {
            if (!trainDetails.equals(t.getID())) {
                PrintWriter pw;
                FileWriter fw;
                try {
                    fw = new FileWriter(f, true);
                    pw = new PrintWriter(fw);
                    pw.println(t.toString());
                    fw.close();
                    pw.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
                JOptionPane.showMessageDialog(null, "Record added successfully");
            }
            JOptionPane.showMessageDialog(null, "Record already exists in train details\nError adding record");
        }
        JOptionPane.showMessageDialog(null, "No train found\nError adding record");
    }

    //View Train Details 
    public static String viewCustomer(File f) {
        String record = "";
        try {
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String s1 = s.nextLine();
                String[] s2 = s1.split(" ");
                s1 = "ID: " + s2[0] + "     " + "Destination: " + s2[1] + "     " + " Arrival: " + s2[2] + "     " + " Departure " + s2[3];
                record = record + s1 + "\n";
            }
            s.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return record;
    }

    //Search for a customer from data in the file(ID based search)
    public static void searchTrainDetails(File f, int id) {
        boolean found = false;
        Scanner s;
        String s1;
        try {
            s = new Scanner(f);
            while (s.hasNext()) {
                s1 = s.nextLine();
                String[] s2 = s1.split(" ");
                if (id == Integer.parseInt(s2[0])) {
                    JOptionPane.showMessageDialog(null, "ID: " + s2[0] + "\tDestination: " + s2[1] + "\tArrival: " + s2[2] + "\tDeparture: " + s2[3]);
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

    ///Delete Train Details
    public static void deleteDetails(File f, int id) {
        boolean delete = false;
        PrintWriter pw;
        FileWriter fw;
        File temp_file = new File("temp_file.txt");;
        Scanner s;
        try {
            s = new Scanner(f);
            while (s.hasNext()) {
                String s1 = s.nextLine();
                String[] s2 = s1.split(" ");
                if (!(id == Integer.parseInt(s2[0]))) {
                    fw = new FileWriter(temp_file.getAbsolutePath(), true);
                    pw = new PrintWriter(fw);
                    pw.println(s1);
                    fw.close();
                    pw.close();
                } else {
                    delete = false;
                }
            }
            s.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        f.delete();
        temp_file.renameTo(f.getAbsoluteFile());
        if (delete) {
            JOptionPane.showMessageDialog(null, "Record deleted successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Error deleting record");
        }
    }

}
