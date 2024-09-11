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
public class LinkedList {

    private Node head;

    public LinkedList() {
        head = null;
    }

    public Node getHead(){
        return head;
    }
    
    public void addAtEnd(Node a) {
        if (head == null) {
            head = a;
        } else {
            Node b = head;
            while (b.next != null) {
                b = b.next;
            }
            b.next = a;
        }
    }

    public void remove(String r) {
        Node p, d;
        p = d = head;
        //Step 1: Finding node
        while (d != null) {
            if (d.regNo.equals(r)) {
                break;
            }
            p = d;
            d = d.next;
        }
        //Step 2: Deleting node
        if (d == null) {
            return;
        } else if (d == head) {
            head = head.next;
        } else {
            p.next = d.next;
        }
    }

    public void display() {
        Node a = head;
        if (head == null) {
            System.out.println("");
            return;
        } else {
            while (a != null) {
                System.out.print(a.regNo+" - ");
                a = a.next;
            }
        }
        System.out.println("");
    }
    
    public Node search(String r){
        Node a = head;
        while(a != null){
            if(a.regNo.equals(r)){
                System.out.println(a.regNo);
                System.out.println(a.name);
                System.out.println(a.number);
                return a;
            }
            a = a.next;
        }
        System.out.println("Not found!");
        return null;
    }
    
}
