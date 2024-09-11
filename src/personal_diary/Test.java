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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hoorain
 */
public class Test {
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
        rob.keyRelease(17); //releases 'L'
        rob.keyRelease(76); //releases ctrl
        Thread.sleep(10); //gives cpu the time to complete this process
    }
  
  /******************Insert User ************************/
     public static void insertUser() throws IOException 
     {  
        Scanner input = new Scanner(System.in); 
        System.out.println("Enter CNIC");
        num = input.nextLine();
        System.out.println("Enter name"); //Reads user inoformation
        name = input.nextLine();
        System.out.println("Enter E-mail Address");
        mail = input.nextLine();
        System.out.println("Enter Phone Number");
        phone_num = input.nextLine();
        java.io.File file = new java.io.File("diary.txt"); //Creating or checking for exisitng file 
        if (file.exists()) {
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
    System.out.println("Please Enter CNIC for Viewing User's Information");
       String cnic = input.next();  //user input
    try {
          java.io.File file = new java.io.File("diary.txt"); // real file 
         Scanner scanner = new Scanner(file);
         while (scanner.hasNextLine()) {
             String line = scanner.nextLine();
             String[] tokens = line.split(" ");
             if (tokens[1].equals(cnic))
            {
              line=" ";
            System.out.println(tokens[0]+tokens[1]+tokens[2]+tokens[3]+tokens[4]+tokens[5]+tokens[6]+tokens[7]+tokens[8]+tokens[9]+tokens[10]+tokens[11]);
            
            }
            else
            {
                 System.out.println("No such record exists");
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
       Scanner reader  = new Scanner(file);
       FileWriter writer = new FileWriter(file1);
       while(reader.hasNext()){
           String line = reader.nextLine();
           String cnicx = line.substring(line.indexOf(":")+1, line.indexOf("|")).trim();
           System.out.println("Found: '"+cnicx+"'");
           if(!cnicx.equals(cnic)){
               writer.append(line+"\n");
           }else{
               System.out.println("Found: "+line);
           }
       }
       writer.close();
       reader.close();
       file.delete();
       System.out.println("File name updated: "+file1.renameTo(file));
   }
     
       /*********************View Users************************/
   public static void viewUser() throws FileNotFoundException{
       java.io.File file = new java.io.File("diary.txt"); 
        Scanner scanner = new Scanner(file);
         while (scanner.hasNextLine()) {
             String line = scanner.nextLine();
             System.out.println(line);
         }
   }
   
   /*************************Update Users Information**********************************************/
   public static void updateUser() throws FileNotFoundException, IOException{
       Scanner input = new Scanner(System.in);
        System.out.println("Please Enter CNIC ");
        String cnic = input.next();  //user input
        java.io.File file = new java.io.File("diary.txt");
//        java.io.File file1 = new java.io.File("diary1.txt");
        String s="";
        Scanner read = new Scanner(file);
        while(read.hasNextLine()){
            s+=read.nextLine();
        }
        
        String[] array = s.split("/");
        
     
                int val=0;
                System.out.println("Which Feature you want to Change/Update"); 
                System.out.println("1-Name");
                System.out.println("2-E-amil");
                System.out.println("3-Phone Number");
                val=input.nextInt();
                switch(val){
                    case 1:
                    {
                        System.out.print("Enter new name: ");
                        String newname=input.next();
                        int spacecount =0;
                        int i=0;
                        int j=0;
                        int k=0;
                        for(;i<array.length;i++){
                            String temp=array[i];
                            if(temp.contains(cnic)){
                                for(j=0;j<temp.length();j++){
                                    if(temp.charAt(j)==' '){
//                                        space1++;
                                        spacecount++;
                                        if(spacecount==4)
                                            break;
                                    }
                                }
                                for(k=j+1;k<temp.length();k++){
                                    if(temp.charAt(k)==' '){
//                                        space2=i;
                                        spacecount++;
                                        if(spacecount==5){
                                            break;
                                        }
                                    }
                                }
                            }
                            else
                                continue;
                            break;
                        }
                        
                        array[i]=array[i].replaceFirst(array[i].substring(j+1, k), newname);
                        
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
//                                        space1++;
                                        spacecount++;
                                        if(spacecount==7)
                                            break;
                                    }
                                }
                                for(k=j+1;k<temp.length();k++){
                                    if(temp.charAt(k)==' '){
//                                        space2=i;
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
                    
                        
                
                
         }

         
            
        
               
//               System.out.println("File name updated: "+file1.renameTo(file));
        
       
} 
   
    
    
    
/***********Main function*******************/
    public static void main(String[] args) throws IOException, AWTException, InterruptedException 
    {
        System.out.println("\t\t Welcome to Personal Diary");
        String choice=null;
        int val=0;
        Scanner input = new Scanner(System.in);
     
  do
      
     {
       
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
       
      // else
       
      // {
           System.out.println("Do you want to continue y for yes and n for no");
           //Scanner input=new Scanner(System.in);
           choice=input.next();
          
       //}
        
   }while("y".equals(choice)||choice=="Y");
    
  
  
       System.out.println("Diary closed");
    }
}
