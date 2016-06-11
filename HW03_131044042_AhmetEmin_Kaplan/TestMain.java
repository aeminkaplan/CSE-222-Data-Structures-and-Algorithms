/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw03_131044042_ahmetemin_kaplan;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author aek
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            SpecList<Integer> mylist = new SpecList<Integer>();

            SpecList<Integer> mylist2 = new SpecList<Integer>();

           
            mylist2.add(11);
            mylist2.add(12);
            mylist2.add(13);
            mylist2.add(14);
            mylist2.add(15);
            mylist2.add(16);
            
            
            mylist.add(1);
            mylist.add(2);
            mylist.add(3);
            mylist.add(4);
            mylist.add(5);
            mylist.add(6);
            mylist.add(7);
            mylist.add(8);
            mylist.add(9);            

            Iterator myListIt=mylist.iterator();
           System.out.printf("myList contains this items before adding :\n");
            while(myListIt.hasNext())
           {
                System.out.printf("%d ", myListIt.next());
           }
           System.out.printf("\n");
                      System.out.printf("\n");
           
             Iterator myListIt2=mylist2.iterator();
           System.out.printf("myList2 contains this items before adding :\n");
            while(myListIt2.hasNext())
           {
                System.out.printf("%d ",myListIt2.next());
           }
           System.out.printf("\n");
                      System.out.printf("\n");
           
           mylist.addAllAtHead(mylist2);
           
           
            myListIt=mylist.iterator();
           System.out.printf("myList contains this items after adding :\n");
           while(myListIt.hasNext())
           {
                System.out.printf("%d ", myListIt.next());
           }
           System.out.printf("\n");
                      System.out.printf("\n");
           

           
           
           
           
           
           
            SpecList<Character> mylist3 = new SpecList<Character>();

           SpecList<Character> mylist4 = new SpecList<Character>();
           
           mylist3.add('a');
           mylist3.add('a');
           mylist3.add('b');
           mylist3.add('c');
           mylist3.add('u');
           mylist3.add('t');
           mylist3.add('c');
           
             Iterator myListIt3=mylist3.iterator();
           System.out.printf("myList3 contains this items before adding :\n");
            while(myListIt3.hasNext())
           {
                System.out.printf("%c ",myListIt3.next());
           }
           System.out.printf("\n");
                      System.out.printf("\n");
           
           
           mylist4.add('b');
           mylist4.add('c');
           mylist4.add('c');
           mylist4.add('a');
           mylist4.add('a');
           mylist4.add('t');
           mylist4.add('a');
           
             Iterator myListIt4=mylist4.iterator();
           System.out.printf("myList4 contains this items  :\n");
            while(myListIt4.hasNext())
           {
                System.out.printf("%c ",myListIt4.next());
           }
           System.out.printf("\n");
                      System.out.printf("\n");
           
           
           List<Character> mylist5=mylist3.getIntersectList(mylist4);
           
           
             Iterator myListIt5=mylist5.iterator();
           System.out.printf("myList5(Intersection of myList3 and myList4) contains this items  :\n");
            while(myListIt5.hasNext())
           {
                System.out.printf("%c ",myListIt5.next());
           }
           System.out.printf("\n");
                      System.out.printf("\n");
           
           SpecList<Double> mylist6 = new SpecList<Double>();
           
           mylist6.add(3.5);
           mylist6.add(6.4);
           mylist6.add(1.5);
           mylist6.add(9.42);
           mylist6.add(7.2);
           mylist6.add(11.66);
           mylist6.add(77.4);
           mylist6.add(6.4);
           mylist6.add(8.1);
           
            Iterator myListIt6=mylist6.iterator();
           System.out.printf("myList6 contains this items before Sorting :\n");
            while(myListIt6.hasNext())
           {
                System.out.printf("%.2f ",myListIt6.next());
           }
           System.out.printf("\n");
                      System.out.printf("\n");
           
           
           mylist6.sortList(true);
           
           
           myListIt6=mylist6.iterator();
           System.out.printf("myList6 contains this items after Sorting :\n");
           
           while(myListIt6.hasNext())
           {
                System.out.printf("%.2f   ",myListIt6.next());
           }
           System.out.printf("\n");
                      System.out.printf("\n");
           
            mylist6.sortList(false);
           
            
           myListIt6=mylist6.iterator();
           System.out.printf("myList6 contains this items after Sorting :\n");
           
           while(myListIt6.hasNext())
           {
                System.out.printf("%.2f   ",myListIt6.next());
           }
           System.out.printf("\n");
                      System.out.printf("\n");
            
            
            
            
        } catch (Exception e) {
            System.out.printf("%s\n", e.getMessage());
            System.exit(0);

        }

    }
}
