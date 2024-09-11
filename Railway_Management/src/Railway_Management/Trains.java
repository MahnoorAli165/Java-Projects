package Railway_Management;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public abstract class Trains implements trainInterface {
    Scanner in = new Scanner(System.in);

    private int trainId;
    private String trainName;
    private int ESeats;
    private int EFair;
    private int BSeats;
    private int BFair;
    
    /**
    * Default constructor
    */
    public Trains() {
        trainId = 0;
        trainName = null;
    }
    /**
    * Overloaded constructor
    */
    public Trains(int trainId, String trainName, int BFair,int BSeats, int EFair, int ESeats) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.BFair = BFair;
        this.BSeats = BSeats;
        this.EFair = EFair;
        this.ESeats = ESeats;
    }

    public int getESeats() {
        return ESeats;
    }

    public void setESeats(int ESeats) {
        this.ESeats = ESeats;
    }

    public int getEFair() {
        return EFair;
    }

    public void setEFair(int EFair) {
        this.EFair = EFair;
    }

    public int getBSeats() {
        return BSeats;
    }

    public void setBSeats(int BSeats) {
        this.BSeats = BSeats;
    }

    public int getBFair() {
        return BFair;
    }

    public void setBFair(int BFair) {
        this.BFair = BFair;
    }
    /**
     * Mutator method for trainId
     */
    public void setTrainId(int id) {
        this.trainId=id;
    }
    
    /**
     * Mutator method for train name
     */
    public void setTrainName(String name) {
        this.trainName=name;
    }
    
    /**
     * Getter method for trainId
     */
    public int getTrainId() {
        return trainId;
    }

    /**
     * Getter method for trainName
     */
    public String getTrainName() {
        return trainName;
    }

    /**
     * toString method
     * Returns trainId and trainName of object as string
     */    
    public String toString() {
        return trainId+" "+trainName+" ";
    }
    
    /**
     * equals method
     * Takes id and File in its parameter
     * returns true if id matches id of train already present in file else returns false
     */    
    public static boolean equals(int id,File f){
        boolean check=false;
        try {
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String s1 = s.nextLine();
                String[] s2 = s1.split(" ");
                if (Integer.parseInt(s2[0]) == id) {
                    check=true;
                    s.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return check;
    }
    
    /**
     * Mutator
     * Sets number of seats of train
     */    
    public abstract void setNumberOfBisSeats();
    
    /**
     * Mutator
     * Sets fair for one seat of train
     */  
    public abstract void setBisFair();
    
    /**
     * Getter
     * Returns number of seats of train
     */  
    public abstract int getNumberOfBisSeats();
    
     public abstract int getBisFair();
    
    /**
     * Getter
     * Returns fair for one seat of train
     */  
    public abstract int getEcFair();
    
    
    public abstract void setNumberOfESeats();
    
    /**
     * Mutator
     * Sets fair for one seat of economic train
     */  
    public abstract void setEcFair();
    
    /**
     * Getter
     * Returns number of seats of train
     */  
    public abstract int getNumberOfESeats();
    
    /**
     * Getter
     * Returns fair for one seat of train
     */  
   
    
}

