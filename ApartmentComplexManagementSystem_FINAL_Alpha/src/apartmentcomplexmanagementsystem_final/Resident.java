package apartmentcomplexmanagementsystem_final;

public abstract class Resident implements commonInterface 
{
    private int ID;
    private String name;
    private String gender;
    private long phoneNo;
    private String email;
    
    public Resident()
    {
        
    }
    public Resident(int id, String name, String gender, long phNo, String email)
    {
        this.ID = id;
        this.name = name;
        this.gender = gender;
        this.phoneNo = phNo;
        this.email = email;
    }
    
    public String toString()
    {
        return this.ID + ";" + this.name + ";" + this.gender + ";" + this.phoneNo + ";" + this.email;
    }
    
    public void setID(int id)
    {
        this.ID = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    public void setphoneNumber(long phNo)
    {
        this.phoneNo = phNo;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public int getID()
    {
        return this.ID;
    }
    public String getName()
    {
        return this.name;
    }
    public String getGender()
    {
        return this.gender;
    }
    public long getphoneNumber()
    {
        return this.phoneNo;
    }
    public String getEmail()
    {
        return this.email;
    }
}
