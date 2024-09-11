package Railway_Management;

public interface trainInterface {
    /**
    * Adds a new train in the selected class
    */
    public void addTrain();
    
    /**
    * To update number of seats
    * And
    * To update fair of one seat
    * Returns true if train record is updated successfully
    */
    public boolean updateTrain(int id,int edit);
    
    /**
    * To delete a train
    * Takes id as input from user
    * Deletes record of the train
    * Returns true if train record is deleted successfully
    */
    public boolean deleteTrain(int id);
    
    /**
    * To search a train
    * Takes id as input from user
    * returns the required train as object
    */
    public Object searchTrain_id(int id);
    
    /**
    * To search a train
    * Takes name as input from user
    * returns the required train as object
    */
    public Object searchTrain_name(String name);
}
