package apartmentcomplexmanagementsystem_final;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class condo
{
    int condoNo;
    int floor;
    int price;
    int size;
    
    public condo()
    {
        
    }
    
    public condo(int condoNo, int floor, int price, int size)
    {
        this.condoNo = condoNo;
        this.floor = floor;
        this.price = price;
        this.size = size;
    }
    
    public void setcondoNo(int condoNo)
    {
        this.condoNo = condoNo;
    }
    public void setFloor(int floor)
    {
        this.floor = floor;
    }
    public void setPrice(int price)
    {
        this.price = price;
    }
    public void setSize(int size)
    {
        this.size = size;
    }
    public int getcondoNo()
    {
        return this.condoNo;
    }
    public int getFloor()
    {
        return this.floor;
    }
    public int getPrice()
    {
        return this.price;
    }
    public int getSize()
    {
        return this.size;
    }
    
    public String toString()
    {
        return(this.condoNo + ";" + this.floor + ";" + this.price + ";" + this.size);
    }
    
    public boolean addRecord() 
    {
        boolean result = false;
        if((searchcondoNo() == null))
        {
            FileWriter f;
            try
            {
                f = new FileWriter("condo.txt", true);
                f.write(toString() + "\n");
                f.close();
                result = true;
                JOptionPane.showMessageDialog(null, "Record Added Successfully.", "Record Added", JOptionPane.PLAIN_MESSAGE);
            }
            catch(Exception e)
            {
                result = false;
            }
        }
        else if(searchcondoNo() != null)
        {
            JOptionPane.showMessageDialog(null, "ID already taken.", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return result;
    }
    
    public Object searchRecordID()
    {
        condo r = null;
        if(searchcondoNo() != null)
        {
            r = searchcondoNo();
            JOptionPane.showMessageDialog(null, "Record exists:\n" + " Condo Number: " + r.getcondoNo() + ", Floor: " + r.getFloor() + ", Size: " + r.getSize() + ", Price: " + r.getPrice(), "Record Found", JOptionPane.PLAIN_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Record does not exist.", "Record Not Found", JOptionPane.PLAIN_MESSAGE);
        }
        
        return r;
    }
    
    public boolean updateRecord()
    {
        try
        {
            boolean updated = false;
            File f = new File("condo.txt");
            File f1 = new File("condo_temp.txt");
            Scanner input = new Scanner(f);
            FileWriter fx = new FileWriter(f1);
            while(input.hasNext())
            {
                String s = input.nextLine();
                String[] s_ = s.split(";");
                if(Integer.parseInt(s_[0]) == getcondoNo())
                {
                    fx.write(toString() + "\n");
                    updated = true;
                }
                else
                {
                    fx.write(s + "\n");
                }
            }
            fx.close();
            input.close();
            f.delete();
            f1.renameTo(f);
            if(updated)
            {
                JOptionPane.showMessageDialog(null, "Record updated successfully.", "Record Updated", JOptionPane.PLAIN_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Record update failed.", "Record Not Updated", JOptionPane.PLAIN_MESSAGE);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "An unexpected error occurred.", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
    public boolean deleteRecord() 
    {
        try
        {
            boolean deleted = false;
            File f = new File("condo.txt");
            File f1 = new File("condo_temp.txt");
            Scanner input = new Scanner(f);
            FileWriter fx = new FileWriter(f1);
            while(input.hasNext())
            {
                String s = input.nextLine();
                String[] s_ = s.split(";");
                if(Integer.parseInt(s_[0]) == getcondoNo())
                {
                    deleted = true;
                }
                else
                {
                    fx.write(s + "\n");
                }
            }
            fx.close();
            input.close();
            f.delete();
            f1.renameTo(f);
            if(deleted)
            {
                JOptionPane.showMessageDialog(null, "Record deleted successfully.", "Record Deleted", JOptionPane.PLAIN_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Record deletion failed.", "Record Not Deleted", JOptionPane.PLAIN_MESSAGE);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Unexpected error occurred.", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
    public condo searchcondoNo()
    {
        condo r = null;
        try
        {
            File f = new File("condo.txt");
            Scanner input = new Scanner(f);
            while(input.hasNext())
            {
                String[] s = input.nextLine().split(";");
                if(Integer.parseInt(s[0]) == getcondoNo())
                {
                    r = new condo(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]));
                    break;
                }
                else
                {
                    r = null;
                }
            }
            input.close();
        }
        catch(Exception e)        
        {
            r = null;
        }
        
        return r;
    }
    
    public static ArrayList viewRecords()
    {
        ArrayList<String> a = new ArrayList<String>();
        try
        {
            File f = new File("condo.txt");
            Scanner input = new Scanner(f);
            while(input.hasNext())
            {
                a.add(input.nextLine());
            }
            input.close();
        }
        catch(Exception e)
        {
            
        }
        return a;
    }
}
