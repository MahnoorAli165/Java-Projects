package apartmentcomplexmanagementsystem_final;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class tempResident extends Resident
{
    int roomNo;
    
    public tempResident()
    {
        super();
    }
    
    public tempResident(int ID, String name, String gender, long phoneNo, String email, int roomNo)
    {
        super(ID, name, gender, phoneNo, email);
        this.roomNo = roomNo;
    }
    
    public void setroomNo(int rn)
    {
        this.roomNo = rn;
    }
    public int getroomNo()
    {
        return this.roomNo;
    }
    
    public String toString()
    {
        return(super.toString() + ";" + roomNo);
    }
    
    public boolean addRecord() 
    {
        boolean result = false;
        if((searchID() == null) && (searchroomNo() == false) && ((searchroomMon() == true) || (searchroomY() == true)))
        {
            FileWriter f;
            try
            {
                f = new FileWriter("tempRes.txt", true);
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
        else if(searchID() != null)
        {
            JOptionPane.showMessageDialog(null, "ID already taken.", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else if((searchID() == null) && (searchroomNo() == true))
        {
            JOptionPane.showMessageDialog(null, "Room already taken.", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else if((searchID() == null) && (searchroomMon() == false) || (searchroomY() == false))
        {
            JOptionPane.showMessageDialog(null, "Apartment doesn't exist.", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return result;
    }
    
    public static ArrayList viewRecords()
    {
        ArrayList<String> a = new ArrayList<String>();
        try
        {
            File f = new File("tempRes.txt");
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
    
    public Object searchRecordID()
    {
        tempResident r = null;
        if(searchID() != null)
        {
            r = searchID();
            JOptionPane.showMessageDialog(null, "Record exists:\n" + " ID: " + r.getID() + ", Name: " + r.getName() + ", Gender: " + r.getGender() + ", Phone Number: " + r.getphoneNumber() + ", Email: " + r.getEmail() + ", Room Number: " +roomNo, "Record Found", JOptionPane.PLAIN_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Record does not exist.", "Record Not Found", JOptionPane.PLAIN_MESSAGE);
        }
        
        return r;
    }
    
    public Object searchRecordName() 
    {
        tempResident r = null;
        if(searchName() != null)
        {
            r = searchName();
            JOptionPane.showMessageDialog(null, "Record exists:\n" + " ID: " + r.getID() + ", Name: " + r.getName() + ", Gender: " + r.getGender() + ", Phone Number: " + r.getphoneNumber() + ", Email: " + r.getEmail() + ", Room Number: " +roomNo, "Record Found", JOptionPane.PLAIN_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Record does not exist.", "Record Not Found", JOptionPane.WARNING_MESSAGE);
        }
        
        return r;
    }
    
    public boolean updateRecord() 
    {
        try
        {
            boolean updated = false;
            File f = new File("tempRes.txt");
            File f1 = new File("tempRes_temp.txt");
            Scanner input = new Scanner(f);
            FileWriter fx = new FileWriter(f1);
            while(input.hasNext())
            {
                String s = input.nextLine();
                String[] s_ = s.split(";");
                if(Integer.parseInt(s_[0]) == getID() && (searchroomNo() == false) && ((searchroomMon() == true) || (searchroomY() == true)))
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
            File f = new File("tempRes.txt");
            File f1 = new File("tempRes_temp.txt");
            Scanner input = new Scanner(f);
            FileWriter fx = new FileWriter(f1);
            while(input.hasNext())
            {
                String s = input.nextLine();
                String[] s_ = s.split(";");
                if(Integer.parseInt(s_[0]) == getID())
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
    
    public tempResident searchID()
    {
        tempResident r = null;
        try
        {
            File f = new File("tempRes.txt");
            Scanner input = new Scanner(f);
            while(input.hasNext())
            {
                String[] s = input.nextLine().split(";");
                if(Integer.parseInt(s[0]) == getID())
                {
                    r = new tempResident(Integer.parseInt(s[0]), s[1], s[2], Long.parseLong(s[3]), s[4], Integer.parseInt(s[5]));
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
    
    public tempResident searchName()
    {
        tempResident r = null;
        try
        {
            File f = new File("tempRes.txt");
            Scanner input = new Scanner(f);
            while(input.hasNext())
            {
                String[] s = input.nextLine().split(";");
                if((s[1]).equalsIgnoreCase(getName()))
                {
                    r = new tempResident(Integer.parseInt(s[0]), s[1], s[2], Long.parseLong(s[3]), s[4], Integer.parseInt(s[5]));
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
    
    public boolean searchroomNo()
    {
        boolean result = false;
        try
        {
            File f = new File("tempRes.txt");
            Scanner input = new Scanner(f);
            while(input.hasNext())
            {
                String[] s = input.nextLine().split(";");
                if(Integer.parseInt(s[5]) == this.roomNo)
                {
                    result = true;
                    break;
                }
                else
                {
                    result = false;
                }
            }
            input.close();
        }
        catch(FileNotFoundException e)
        {
            result = false;
        }
        
        return result;
    }
    
    public boolean searchroomMon()
    {
        boolean result = false;
        try
        {
            File f = new File("monApart.txt");
            Scanner input = new Scanner(f);
            while(input.hasNext())
            {
                String[] s = input.nextLine().split(";");
                if(Integer.parseInt(s[0]) == this.roomNo)
                {
                    result = true;
                    break;
                }
                else
                {
                    result = false;
                }
            }
            input.close();
        }
        catch(FileNotFoundException e)
        {
            result = false;
        }
        
        return result;
    }
    
    public boolean searchroomY()
    {
        boolean result = false;
        try
        {
            File f = new File("yApart.txt");
            Scanner input = new Scanner(f);
            while(input.hasNext())
            {
                String[] s = input.nextLine().split(";");
                if(Integer.parseInt(s[0]) == this.roomNo)
                {
                    result = true;
                    break;
                }
                else
                {
                    result = false;
                }
            }
            input.close();
        }
        catch(FileNotFoundException e)
        {
            result = false;
        }
        
        return result;
    }
}
