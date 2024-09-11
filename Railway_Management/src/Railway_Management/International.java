package Railway_Management;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class International extends Trains {
    private String Destination;
    static private ArrayList<Object> record = new ArrayList();
    
    /**
     * Default constructor 
     */
    public International() {
        super();
        Destination= null;
    }

    /**
     * Overloaded constructor
     */    
    public International(int trainId,String trainName,int BSeats, int BFair,int ESeats, int EFair, String Destination) {
        super(trainId,trainName,BFair, BSeats, EFair, ESeats);
        this.Destination = Destination;
        
    }

    /**
     * Abstract method of parent class(Trains) 
     */    
   @Override
    public void setNumberOfESeats() {
        boolean check = true;
        do {
            try {
                setESeats(in.nextInt());
                check = false;
            } catch (InputMismatchException e1) {
                System.out.println("Integer value required");
            }
            in.nextLine();
        } while (check);
    }

    /**
     * Abstract method of parent class(Trains) 
     */ 
    @Override
    public void setEcFair() {
        boolean check = true;
        do {
            try {
                setEFair(in.nextInt());
                check = false;
            } catch (InputMismatchException e1) {
                System.out.println("Integer value required");
            }
            in.nextLine();
        } while (check);
    }
    
    @Override
    public void setNumberOfBisSeats() {
        boolean check = true;
        do {
            try {
                setBSeats(in.nextInt());
                check = false;
            } catch (InputMismatchException e1) {
                System.out.println("Integer value required");
            }
            in.nextLine();
        } while (check);
    }

    /**
     * Abstract method of parent class(Trains) 
     */ 
    @Override
    public void setBisFair() {
        boolean check = true;
        do {
            try {
                setBFair(in.nextInt());
                check = false;
            } catch (InputMismatchException e1) {
                System.out.println("Integer value required");
            }
            in.nextLine();
        } while (check);
    }

    /**
     * Abstract method of parent class(Trains) 
     */ 
    @Override
    public int getNumberOfBisSeats() {
        return getBSeats();
    }

    /**
     * Abstract method of parent class(Trains) 
     */ 
    @Override
    public int getBisFair() {
        return getBFair();
    }
    
      @Override
    public int getNumberOfESeats() {
        return getESeats();
    }

    /**
     * Abstract method of parent class(Trains) 
     */ 
    @Override
    public int getEcFair() {
        return getEFair();
    }

    /**
    * Returns trainId,trainName,ESeats and EFair as string 
    */
    @Override
    public String toString() {
        return super.toString()+ getBSeats() + " " + getBFair()+ " "+getESeats() + " " + getEFair()+" "+Destination ;
    }
    
    
    /**
    * Takes id in its parameter
 passes business file object to equals method of Trains class
    */
    public boolean equals(int id){
        File f = new File("International.txt");
        return Trains.equals(id, f);
    }
    
    /**
    * Abstract method of trainInterface
    */    
    public static ArrayList viewTrains(File f) {
        try {
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String s1 = s.nextLine();
                String[] s2 = s1.split(" ");
                record.add(new Local(Integer.parseInt(s2[0]), s2[1], Integer.parseInt(s2[2]), Integer.parseInt(s2[3]), Integer.parseInt(s2[4]), Integer.parseInt(s2[5]), s2[6]));
            }
            s.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return record;
    }
    
    /**
    * Abstract method of trainInterface
    */ 
    @Override
    public boolean updateTrain(int id,int edit){
        File f = new File("International.txt");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        boolean check=true;
        Scanner s;
        FileWriter fw;
        PrintWriter pw;
        if(edit==1){
            
            int seats=Integer.parseInt(JOptionPane.showInputDialog("Enter Number of seats: "));
        
            try {
                    File f2 = new File("tempFile.txt");
                    s = new Scanner(f);
                    while (s.hasNext()) {
                        String s1 = s.nextLine();
                        String[] s2 = s1.split(" ");
                        if (Integer.parseInt(s2[0]) == id) {
                            s2[2] = String.valueOf(seats);
                        }
                       International e = new International(Integer.parseInt(s2[0]),s2[1],Integer.parseInt(s2[2]),Integer.parseInt(s2[3]),Integer.parseInt(s2[4]),Integer.parseInt(s2[5]),s2[6]);
                        fw = new FileWriter(f2.getAbsolutePath(), true);
                        pw = new PrintWriter(fw);
                        pw.println(e.toString());

                        fw.close();
                        pw.close();
                    }
                    s.close();
                    f.delete();
                    f2.renameTo(f);
                    check=true;
                } catch (IOException e) {
                    System.out.println(e);
                    check=false;
                }
            return check;
        }
        else{
            int fair=Integer.parseInt(JOptionPane.showInputDialog("Enter Fair for one seat: "));
        
            try {
                    File f2 = new File("tempFile.txt");
                    s = new Scanner(f);
                    while (s.hasNext()) {
                        String s1 = s.nextLine();
                        String[] s2 = s1.split(" ");
                        if (Integer.parseInt(s2[0]) == id) {
                            s2[3] = String.valueOf(fair);
                        }
                       International e = new International(Integer.parseInt(s2[0]),s2[1],Integer.parseInt(s2[2]),Integer.parseInt(s2[3]),Integer.parseInt(s2[4]),Integer.parseInt(s2[5]),s2[6]);
                        fw = new FileWriter(f2.getAbsolutePath(), true);
                        pw = new PrintWriter(fw);
                        pw.println(e.toString());

                        fw.close();
                        pw.close();
                    }
                    s.close();
                    f.delete();
                    f2.renameTo(f);
                    check=true;
                } catch (IOException e) {
                    System.out.println(e);
                    check=false;
                }
            return check;
        }
    }
    
    /**
    * Abstract method of trainInterface
    */ 
    @Override
    public Object searchTrain_id(int id){
        International c=null;
        File f = new File("International.txt");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        try {
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String s1 = s.nextLine();
                String[] s2 = s1.split(" ");
                if (Integer.parseInt(s2[0]) == id) {
                    c = new International(Integer.parseInt(s2[0]),s2[1],Integer.parseInt(s2[2]),Integer.parseInt(s2[3]),Integer.parseInt(s2[4]),Integer.parseInt(s2[5]),s2[6]);
                    s.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return c;
    }
    
    /**
    * Abstract method of trainInterface
    */ 
    @Override
    public Object searchTrain_name(String name){
        International c=null;
        File f = new File("International.txt");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        try {
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String s1 = s.nextLine();
                String[] s2 = s1.split(" ");
                if (s2[1].equalsIgnoreCase(name)) {
                   c = new International(Integer.parseInt(s2[0]),s2[1],Integer.parseInt(s2[2]),Integer.parseInt(s2[3]),Integer.parseInt(s2[4]),Integer.parseInt(s2[5]),s2[6]);
                    s.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return c;
    }
    
    /**
    * Abstract method of trainInterface
    */ 
    @Override
    public void addTrain(){
        File f= new File("International.txt");
        try{
            if(!(f.exists()))
            f.createNewFile();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "File does not exist");
        }
        FileWriter fw;
        PrintWriter pw;
        try {
            fw = new FileWriter(f.getAbsolutePath(), true);
            pw = new PrintWriter(fw);
            pw.println(this.toString());
            fw.close();
            pw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    /**
    * Abstract method of trainInterface
    */ 
    @Override
    public boolean deleteTrain(int id){
        File f= new File("International.txt");
        File f2=new File("tempFile.txt");
        Scanner s=null;
        FileWriter fw;
        PrintWriter pw;
        
        boolean check = false;
        try {
            s = new Scanner(f);
            fw = new FileWriter(f2, true);
            pw = new PrintWriter(fw);
            while (s.hasNext()) {
                String s1 = s.nextLine();
                String[] s2 = s1.split(" ");
                if (!(Integer.parseInt(s2[0]) == id)) {
                    pw.println(s1);
                    check=true;
                }
            }
            s.close();
            fw.close();
            pw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        f.delete();
        f2.renameTo(f);
        return check;
    }
}
