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
public class HashTable {

    private LinkedList[] list;
    private int count;

    public HashTable() {
        list = new LinkedList[100];
        for (int i = 0; i < list.length; i++) {
            list[i] = new LinkedList();
        }
        count = 0;
    }

    public int generateHash(String r) {
        int hashcode = 0;
        for (int i = 0; i < r.length(); i++) {
            if (r.charAt(i) != '-') {
                hashcode += r.charAt(i);
            }
        }
        hashcode = hashcode % 763;
        hashcode = hashcode % 100;
        return hashcode;
    }

    public void add(String r, String n, long num) {
        r = r.toUpperCase();
        if (search(r) == null) {
            if ((count < 100) && (r.matches("[A-Z][A-Z][0-1][0-9][-][A-Z][A-Z][A-Z][-][0-1][0-9][0-9]"))) {
                Node a = new Node(r, n, num);
                list[generateHash(r)].addAtEnd(a);
            }
            else {
                System.out.println("Hash table full, or Reg no format dosen't match.");
            }
        }
    }

    public Node search(String r) {
        Node a = list[generateHash(r)].search(r);
        return a;
    }

    public void delete(String r) {
        list[generateHash(r)].remove(r);
    }

    public LinkedList[] traverse() {
        for (int i = 0; i < list.length; i++) {
            System.out.print("----" + i + " :: ");
            list[i].display();
        }
        return list;
    }

}
