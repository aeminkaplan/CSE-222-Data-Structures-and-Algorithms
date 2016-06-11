/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw05_131044042_ahmetemin_kaplan;

import java.util.Stack;

/**
 *
 * @author aek
 */
public class IterativeTowerOfHanoi {
    
    /*Kuleler*/
    private Stack<Integer> FirstPole;
    private Stack<Integer> SecondPole;
    private Stack<Integer> ThirdPole;
    
    /*Kulelerin isimlerini tutan karakterler*/
    private char charPole1;
    private char charPole2;
    private char charPole3;
    
    /*Disk sayisi*/
    private int diskSize;
    
    /**
     * TowerOfHanoi sinifinda herhangi bir ozel bir fonksiyon olmayacagi icin hemen hemen butun isi constructor yapiyor
     * @param _diskSize Disk sayisi
     * @param src -char 1.Kule ismi
     * @param dst -char 2.Kule ismi
     * @param _aux -char 3.Kule ismi
     */
    public IterativeTowerOfHanoi(int _diskSize,char src,char dst,char _aux) {
    
        /*Kuleler icin gerekli stackleri olusturuyorum*/
        
        diskSize=_diskSize;
        FirstPole=new Stack<>();
        SecondPole=new Stack<>();
        ThirdPole=new Stack<>();
        
        /*Birinci kuleye disklerin hepsini dolduruyorum*/
        System.out.printf("\n");
        
        for(int i=diskSize;i>0;--i)
        {
            FirstPole.push(i);
        }
        /*Kuleleri adlandiriyorum*/
        charPole1=src;
        charPole2=dst;
        charPole3=_aux;
    
        /*Yapilacak toplam hamle sayisi n tane disk icin  2^n - 1 olmali*/
        int totalMovements=(int) Math.pow(2,diskSize);
        
        --totalMovements;
        /*Yapilan hamlenin kacinci hamle olduguna gore hangi 2kule arasinda yapilacagini belirliyorum*/
        for(int k=1;k<=totalMovements;++k)
        {
            if(k%3==1)
                MakeMove(src,_aux);
            else if(k%3==2)
                MakeMove(src,dst);
            else if(k%3==0)
                MakeMove(_aux,dst);
        
        }
    
        
    }
    
    
    /**
     * iki kule arasinda islem yapan metoddur
     * @param src - char  - Kule ismi
     * @param dest - char - Kule ismi
     */
    private void MakeMove(char src,char dest)
    {
        /*Parametre olarak alinan karakterlere gore o karakterlerin temsil ettigi kuleler belirlenir
        ve en tepedeki elemanlarina erisilir*/
        
        int topelement1=-1,topelement2=-1;
        Stack<Integer> pole1 = null,pole2 = null;
        
        if(src==charPole1){
            if(FirstPole.size()==0)
                topelement1=-1;
            else
            topelement1=FirstPole.pop();
            
            pole1=FirstPole;
        }
        
        else if(src==charPole2){
            if(SecondPole.size()==0)
                topelement1=-1;
            else
            topelement1=SecondPole.pop();
            pole1=SecondPole;
        
        }
        else if(src==charPole3){
            if(ThirdPole.size()==0)
                topelement1=-1;
            else
            topelement1=ThirdPole.pop();
            pole1=ThirdPole;
        }
        
        
        if(dest==charPole1){
        
            if(FirstPole.size()==0)
                topelement2=-1;
            else
            topelement2=FirstPole.pop();
            pole2=FirstPole;
        }
        
        else if(dest==charPole2){
        
            if(SecondPole.size()==0)
                topelement2=-1;
            else
            topelement2=SecondPole.pop();
            pole2=SecondPole;
        }
        
        else if(dest==charPole3){
            if(ThirdPole.size()==0)
                topelement2=-1;
            else
            topelement2=ThirdPole.pop();
            pole2=ThirdPole;
        }
        
        /*Eger topelement1 -1 ise topelement1 in cekildigi kule bostur bundan dolayi bos kuleye topelement2 eklenir*/
        if(topelement1==-1){
            
            pole1.push(topelement2);
            System.out.printf("Move %d from %c to %c\n",topelement2,dest,src);
        }
        
        /*Eger topelement2 -1 ise topelement1 in cekildigi kule bostur bundan dolayi bos kuleye topelement1 eklenir*/        
        else if(topelement2==-1){
            pole2.push(topelement1);
            System.out.printf("Move %d from %c to %c \n",topelement1,src,dest);
        }
        
        /*Eger topelement1 topelemen2 den buyukse oyunun kurali geregi topelement2 yukariya gelecek bicimde kuleye eklenir*/
        else if(topelement1>topelement2)
        {
            pole1.push(topelement1);
            pole1.push(topelement2);
            System.out.printf("Move %d from %c to %c\n",topelement2,dest,src);
        
        }
        /*Eger topelement2 topelemen1 den buyukse oyunun kurali geregi topelemen1 yukariya gelecek bicimde kuleye eklenir*/
        else{
        
            pole2.push(topelement2);
            pole2.push(topelement1);
            System.out.printf("Move %d from %c to %c\n",topelement1,src,dest);
     
        }
    }

}
