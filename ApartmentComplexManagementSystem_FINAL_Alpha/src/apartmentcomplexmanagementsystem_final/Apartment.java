package apartmentcomplexmanagementsystem_final;

public abstract class Apartment implements commonInterface_Apartment
{
    private int apartNo;
    private int floor;
    private int size;
    
    public Apartment()
    {
        
    }
    public Apartment(int apartNo, int floor, int size)
    {
        this.apartNo = apartNo;
        this.floor = floor;
        this.size = size;
    }
    
    public String toString()
    {
        return this.apartNo + ";" + this.floor + ";" + this.size;
    }
    
    public void setapartNo(int apartNo)
    {
        this.apartNo = apartNo;
    }
    public void setFloor(int floor)
    {
        this.floor = floor;
    }
    public void setSize(int size)
    {
        this.size = size;
    }
    public int getapartNo()
    {
        return this.apartNo;
    }
    public int getFloor()
    {
        return this.floor;
    }
    public int getSize()
    {
        return this.size;
    }
}
