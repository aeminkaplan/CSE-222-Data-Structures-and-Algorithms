/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw05_131044042_ahmetemin_kaplan;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author aek
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Integer [] liste1={1,2,3,7,4,5};
        Integer [] liste2={1,2,3} ;       

        AClassHaveTwoSortedArray<Integer> ikiliListe;
        ikiliListe = new AClassHaveTwoSortedArray<Integer>(liste1,liste2);

        ArrayList<Integer> tmp= (ArrayList<Integer>) ikiliListe.unionOfLists();
        ArrayList<Integer> tmp2=(ArrayList<Integer>) ikiliListe.intersectionOfLists();
        
        System.out.printf("Liste1 icerigi: ");
        
        for(int i=0;i<liste1.length;++i)
        {
            System.out.printf("%d ",liste1[i]);
        }
        
        System.out.printf("\nListe2 icerigi: ");
       
        for(int i=0;i<liste2.length;++i)
        {
            System.out.printf("%d ",liste2[i]);
        }        

        System.out.printf("\nBirlesim kumesi: %s\n",tmp);
        
        System.out.printf("Kesisim kumesi: %s\n",tmp2);
        
         LinkedListRec<Integer> deneme = new LinkedListRec<Integer>();
        deneme.add(1);
        deneme.add(1);
        deneme.add(2);
        deneme.add(2);
        deneme.add(3);
        deneme.add(1);
        
        System.out.printf("Remove oncesi LinkedList icerigi : %s\n",deneme);
        deneme.remove(1);
        System.out.printf("Remove sonrasi LinkedList icerigi : %s\n",deneme);
        

        
        
        if(ikiliListe.isSubset())
            System.out.printf("List2 List1 in altkumesidir");
        else
            System.out.printf("List2 List1 in alt kumesi degildir");
        
        
        
        new IterativeTowerOfHanoi(3,'a','b','c');
    }
    
}
