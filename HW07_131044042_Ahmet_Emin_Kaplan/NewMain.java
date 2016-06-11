/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw07_131044042_ahmeteminkaplan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author aek
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
         AEKPriorityQueue<Customer> liste=new AEKPriorityQueue<Customer>(new CompareCustomers());
        String tempStr="";
        File input;
        input = new File("data1.txt");
        FileReader myFileReader = new FileReader(input);
        BufferedReader myBufferedReader = new BufferedReader(myFileReader);
        int i,k,minutes=0,transaction=0,customerT=0;
        while ((tempStr = myBufferedReader.readLine()) != null) {
            
            i=0;
            StringTokenizer myTokenizer = new StringTokenizer(tempStr);

            while (myTokenizer.hasMoreTokens()) {

                String token = myTokenizer.nextToken();
                if(i==0)
                {
                    minutes=(token.charAt(0)-'0')*600;
                    minutes+=(token.charAt(1)-'0')*60;
                    minutes+=(token.charAt(3)-'0')*10;
                    minutes+=(token.charAt(4)-'0');
                }
                else if(i==1){
                    transaction=(token.charAt(0)-'0')*10;
                    transaction+=token.charAt(1)-'0';
                
                }
                
                else if(i==3){
                    if(token.equals("1"))
                        customerT=1;
                    else if(token.equals("2"))
                        customerT=2;
                    else if(token.equals("3"))
                        customerT=3;
                
                }
                ++i;
            }

           liste.enqueue(new Customer(minutes, transaction, customerT));
        }
        myFileReader.close();
        
        
        
        
        

        Simulator mySimulator=new Simulator(liste);
        
               
        System.out.print(liste.toString());
         
        System.out.println();  
        System.out.println();     
        System.out.println();
        
        mySimulator.Simulate();


        System.out.println();
    }
    
}
