package apartmentcomplexmanagementsystem_final;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class monApart extends Apartment
{
    int monthlyRent;
    
    public monApart()
    {
        super();
    }
    
    public monApart(int apartNo, int floor, int size, int monthlyRent)
    {
        super(apartNo, floor, size);
        this.monthlyRent = monthlyRent;
    }
    
    public void setmonthlyRent(int mr)
    {
        this.monthlyRent = mr;
    }
    public int getmonthlyRent()
    {
        return this.monthlyRent;
    }
    
    public String toString()
    {
        return(super.toString() + ";" + this.monthlyRent);
    }
    
    public boolean addRecord() 
    {
        boolean result = false;
        if((searchapartNo() == null))
        {
            FileWriter f;
            try
            {
                f = new FileWriter("monApart.txt", true);
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
        else if(searchapartNo() != null)
        {
            JOptionPane.showMessageDialog(null, "ID already taken.", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return result;
    }
    
    public Object searchRecordID()
    {
        monApart r = null;
        if(searchapartNo() != null)
        {
            r = searchapartNo();
            JOptionPane.showMessageDialog(null, "Record exists:\n" + " Apartment Number: " + r.getapartNo() + ", Floor: " + r.getFloor() + ", Size: " + r.getSize() + ", Monthly Rent: " + r.getmonthlyRent(), "Record Found", JOptionPane.PLAIN_MESSAGE);
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
            File f = new File("monApart.txt");
            File f1 = new File("monApart_temp.txt");
            Scanner input = new Scanner(f);
            FileWriter fx = new FileWriter(f1);
            while(input.hasNext())
            {
                String s = input.nextLine();
                String[] s_ = s.split(";");
                if(Integer.parseInt(s_[0]) == getapartNo())
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
            File f = new File("monApart.txt");
            File f1 = new File("monApart_temp.txt");
            Scanner input = new Scanner(f);
            FileWriter fx = new FileWriter(f1);
            while(input.hasNext())
            {
                String s = input.nextLine();
                String[] s_ = s.split(";");
                if(Integer.parseInt(s_[0]) == getapartNo())
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
    
    public monApart searchapartNo()
    {
        monApart r = null;
        try
        {
            File f = new File("monApart.txt");
            Scanner input = new Scanner(f);
            while(input.hasNext())
            {
                String[] s = input.nextLine().split(";");
                if(Integer.parseInt(s[0]) == getapartNo())
                {
                    r = new monApart(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]));
                    break;
                }
                else
                {
                    r = null;
                }
            }
            input.close();
        }
        catch(FileNotFoundException e)        
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
            File f = new File("monApart.txt");
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
