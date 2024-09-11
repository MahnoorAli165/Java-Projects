/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_information;

/**
 *
 * @author Sharjeel Ahmad
 */
public class Node {
    
    public Node next;
    public String regNo;
    public String name;
    public long number;
    
    public Node(String r, String n, long num){
        next = null;
        regNo = r;
        name = n;
        number = num;
    }
    
}
