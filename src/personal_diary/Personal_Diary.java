/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personal_diary;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Personal_Diary {
/******************Global variables*******************/
    static String num=null;
    static String name=null;
    static String mail=null;
    static String phone_num=null;
    
    /***********Clears Screen**********/
    public static void clearScreen() throws AWTException, InterruptedException
         {
        Robot rob = new Robot();
        rob.keyPress(17); //hold ctrl
        rob.keyPress(76); //hold 'L'
        rob.keyRelease(17); //releases ctrl
        rob.keyRelease(76); //releases 'L'
        Thread.sleep(15); //gives cpu the time to complete this process
    }
  
  /******************Insert User ************************/
     public static void insertUser() throws IOException 
     {  
        Scanner input = new Scanner(System.in); 
        System.out.println("Enter CNIC");
        num = input.nextLine();
        System.out.println("Enter name"); //Reads user information
        name = input.nextLine();
        System.out.println("Enter E-mail Address");
        mail = input.nextLine();
        System.out.println("Enter Phone Number");
        phone_num = input.nextLine();
        java.io.File file = new java.io.File("diary.txt"); //Creating new file checking for exisitng file 
        if (file.exists()) //checking whether file already exists or not  
        {
        System.out.println("File already exists");
        }
        else
            System.out.println("New File has been created");
        FileWriter fileWriter = new FileWriter(file, true); //Appending User's Information with file
        fileWriter.append("CNIC: "+num+" |"+" name: "+name+" |"+" E-mail: "+mail+" |"+" Phone Number: "+phone_num+"\n");
        fileWriter.close();
        
}
     
/**********************************View User***********************************/    
   public static void searchUser()
   {
    Scanner input = new Scanner(System.in);
    System.out.println("Please Enter CNIC for Searching User's Information");
       String cnic = input.next();  //user input
    try {
          java.io.File file = new java.io.File("diary.txt"); // real file 
         Scanner scanner = new Scanner(file);
         while (scanner.hasNextLine()) {
             String line = scanner.nextLine();//reading information from file line by line
             String[] tokens = line.split(" ");//A String array in which the read lines are stored 
             if (tokens[1].equals(cnic))//Checking whether array index matches with the User's entered data
            {
        
 System.out.println(tokens[0]+tokens[1]+tokens[2]+tokens[3]+tokens[4]+tokens[5]+tokens[6]+tokens[7]+tokens[8]+tokens[9]+tokens[10]);
            
            }
         }
          scanner.close();
       } catch (FileNotFoundException e) {
                         e.printStackTrace();
       }
   } 
   
    /*************************Delete User*********************************/
     
     public static void removeUser() throws FileNotFoundException, IOException
   {
   Scanner input = new Scanner(System.in);
       System.out.println("Please Enter CNIC for Deletion");
       String cnic = input.next();  //user input
        java.io.File file = new java.io.File("diary.txt"); // real file 
       java.io.File file1 = new java.io.File("diary1.txt"); //temp file
       Scanner reader  = new Scanner(file);//opening real file in Reader mode
       FileWriter writer = new FileWriter(file1);//Opening temporary file in Writing mode
       while(reader.hasNext()){
           String line = reader.nextLine(); //
           String cnicx = line.substring(line.indexOf(":")+1, line.indexOf("|")).trim(); //Searching User's CNIC from file 
           System.out.println("Found: "+cnicx+"");
           if(!cnicx.equals(cnic)){//if not found then append remaining data with tmporary file
               writer.append(line+"\n");
           }else{
               System.out.println("Found: "+line);
           }
       }
       writer.close();
       reader.close();
       file.delete();
       System.out.println("File name updated: "+file1.renameTo(file));//Rename temporary file to original/real file
   }
     
   /************************************View Users*************************************/
   public static void viewUser() throws FileNotFoundException{
       java.io.File file = new java.io.File("diary.txt"); 
       System.out.println("\t\t/***********************User's with their Information*************************/\t\t");
        Scanner scanner = new Scanner(file);//open file in reading mode
         while (scanner.hasNextLine()) {
             String line = scanner.nextLine();//read the content and display
             System.out.println(line);
         }
   }
   
   /*************************Update Users Information**********************************************/
   public static void updateUser() throws FileNotFoundException, IOException{
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter CNIC ");
        String cnic = input.next();  //user input
        java.io.File file = new java.io.File("diary.txt");
        String s="";
        Scanner read = new Scanner(file);
        while(read.hasNextLine())
        {
            s+=read.nextLine();
        }
        
        String[] array = s.split("/"); //Storing all the lines of file in an array
        
     
                int val=0;
                System.out.println("Which Feature you want to Change/Update"); 
                System.out.println("1-Name");
                System.out.println("2-E-amil");
                System.out.println("3-Phone Number");
                val=input.nextInt();//Asking from user which feature to be updated/changed
                switch(val){
                    case 1://When choosed value is 1
                    {
                        System.out.print("Enter new name: ");
                        String newname=input.next(); //taking data from user
                        int spacecount =0; //Setting Spaces to 0(zero)
                        int i=0;
                        int j=0;
                        int k=0;
                        for(;i<array.length;i++)//Picking up whole array
                        {
                            String temp=array[i];
                            if(temp.contains(cnic))//Checking whether the line contains CNIC
                            {
                                for(j=0;j<temp.length();j++)//picking up string
                                {
                                    if(temp.charAt(j)==' ')//Checking whether character is equal to space' '
                                    {
                                        spacecount++; //adding 1 in space
                                        if(spacecount==4)//checking whether the spaces are equal to 4
                                            break;
                                    }
                                }
                                for(k=j+1;k<temp.length();k++)//the position at which the content is stored(starting)
                                {
                                    if(temp.charAt(k)==' ')
                                    {
                                        spacecount++;
                                        if(spacecount==5)//the space at the end of stored content
                                        {
                                            break;
                                        }
                                    }
                                }
                            }
                            else
                                continue;//if line doesnot match the CNIC then continue
                            break;
                        }
                        
                        array[i]=array[i].replaceFirst(array[i].substring(j+1, k), newname);//Setting the location New name
                        
                        PrintWriter writer =  new PrintWriter("diary.txt");//Opening file in write mode
                        String temp ="";//initializing a temp string
                        for(i=0;i<array.length;i++)
                        {
                            temp=(array[i]); //Setting the string to the newly entered content
                            temp+="/";
                            writer.println(temp);//Appending/printing the changes in the file
                        }
                        writer.close();
                        break;
                }
                  case 2:
                    {
                        System.out.println("Enter New E-mail:");
                        String m = input.next();
                        int spacecount =0;
                        int i=0;
                        int j=0;
                        int k=0;
                        for(;i<array.length;i++){
                            String temp=array[i];
                            if(temp.contains(cnic)){
                                for(j=0;j<temp.length();j++){
                                    if(temp.charAt(j)==' '){
                                        spacecount++;
                                        if(spacecount==7)
                                            break;
                                    }
                                }
                                for(k=j+1;k<temp.length();k++){
                                    if(temp.charAt(k)==' '){
                                        spacecount++;
                                        if(spacecount==8){
                                            break;
                                        }
                                    }
                                }
                            }
                            else
                                continue;
                            break;
                        }
                        
                        array[i]=array[i].replaceFirst(array[i].substring(j+1, k), m);
                        
                        PrintWriter writer =  new PrintWriter("diary.txt");
                        String temp ="";
                        for(i=0;i<array.length;i++){
                            temp=(array[i]);
                            temp+="/";
                            writer.println(temp);
                        }
                        writer.close();
                        break;
                        
                    }
                    case 3:
                    {
                    
                        System.out.println("Enter New Phone Number:");
                        String p = input.next();
                        int spacecount =0;
                        int i=0;
                        int j=0;
                        for(;i<array.length;i++){
                            String temp=array[i];
                            if(temp.contains(cnic)){
                                for(j=0;j<temp.length();j++){
                                    if(temp.charAt(j)==' '){
//                                        space1++;
                                        spacecount++;
                                        if(spacecount==10)
                                            break;
                                    }
                                }
                            }
                            else
                                continue;
                            break;
                        }
                        
                        array[i]=array[i].replaceFirst(array[i].substring(j+1, array[i].length()), p);
                        
                        PrintWriter writer =  new PrintWriter("diary.txt");
                        String temp ="";
                        for(i=0;i<array.length;i++){
                            temp=(array[i]);
                            temp+="/";
                            writer.println(temp);
                        }
                        writer.close();
                        break;
                        
                    }
                    default:
                        System.out.println("Invalid Input");
                        
                    }
   }
   /**********************************Main function********************************************/
 public static void main(String[] args) throws IOException, AWTException, InterruptedException 
    {
        System.out.println("\t\t******************* Welcome to Personal Diary *********************\t\t");
        String choice=null;
        int val=0;
        Scanner input = new Scanner(System.in);
     
  do
      
     {
         clearScreen();
       
       System.out.println("Enter Choice 1-5"); 
       System.out.println("1-Add");
       System.out.println("2-Search");
       System.out.println("3-Delete");
       System.out.println("4-View");
       System.out.println("5-Update");
       val=input.nextInt();
       
       if(val==1)
       {
           clearScreen();
           insertUser();
       }
       
       else if (val==2)
       {
           clearScreen();
           searchUser();
       }
       else if(val==3)
       {
           clearScreen();
           removeUser();
       }
       else if(val==4)
       {
           clearScreen();
           viewUser();
       }
       else if(val==5)
        {
           clearScreen();
           updateUser();
        }
           
       
           System.out.println("Do you want to continue y for yes and n for no");
           choice=input.next();
        }
     while("y".equals(choice)||choice=="Y");
    
     System.out.println("\t\t ********Diary closed******* \t\t");
    }
}

