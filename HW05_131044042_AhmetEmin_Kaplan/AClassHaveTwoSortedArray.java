/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw05_131044042_ahmetemin_kaplan;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aek
 */
public class AClassHaveTwoSortedArray<E> {

    private E[] list1;
    private E[] list2;

    public AClassHaveTwoSortedArray(E[] _list1, E[] _list2) {

        list1 = _list1;
        list2 = _list2;
    }

    /**
     * Wrapper Method
     * @return boolean - Eger list2 , list1 in alt kumesi ise true return eder degilse false return eder
     */
    public boolean isSubset() {

        return isSubset(0);
    }
    /**
     * 
     * @param firstindex Wrapper method tarafindan baslangic indexi 0 olarak cagrilir list2 nin herbir
     * elemaninin list1 de olup olmadigini kontrol eder
     * @return boolean- Eger list2 , list1 in alt kumesi ise true return eder degilse false return eder
     */
    private boolean isSubset(int firstindex) {

            boolean temp;
        
            /*Eger list2 bos kumeyse list1 in alt kumesidir*/
            if(list2.length==0)
                return true;
        
            /*Basecase*/
            if (list2.length == firstindex)
            {
                temp=false;
            }
            
            else 
            {
                temp = isSubset(firstindex + 1);
                /*Basecaseden false donduyse veya bir onceki cagridan true donmusse duruma gore result guncellenir
                aksi takdirde result false donmusse ve bu deger basecaseden gelmemisse guncellenmeden
                metodun disina false olarak dondurulur*/
                if ((temp == false && firstindex==list2.length-1) || temp==true) 
                {
                    /*isContain metodu helper metoddur ve recursive calismaktadir*/
                    if (isContain(list1, list2[firstindex])) 
                    {
                        temp= true;
                    }
                    else 
                        temp= false;

                }
            }


            return temp;
    }

    
    
    /**
     * Wrapper Method
     * @return List
     */
    public List unionOfLists() {

        return unionOfLists(0);
    }
    
    /**
     * 
     * @param firstindex  Wrapper method tarafindan baslangic indexi 0 olarak cagrilir.
     * Ve basecaseden donen bos ArrayList e elemanlar eklenir daha once eklenmemis olmak kosuluyla
     * @return ArrayList
     */
    private List unionOfLists(int firstindex) {

        ArrayList<E> temp;

        /*Basecase*/
        /*Metod cagrilinca basecase gelene kadar index guncellenerek kendini cagirir basecase e gelince bos bir ArrayList return edilir*/
        if (firstindex >= list1.length && firstindex>=list2.length) {
            return new ArrayList<E>();
        } 
        
        /*List1 ve list2 de bulunan elemanlar tek tek kontrol edilerek ortak Unionlist guncellenir*/
        else {
            temp = (ArrayList<E>) unionOfLists(firstindex+1);

            if (list1.length>firstindex && temp.indexOf(list1[firstindex])==-1)
            {
                temp.add(list1[firstindex]);
            }
            
            if (list2.length>firstindex && temp.indexOf(list2[firstindex])==-1)
            {
                temp.add(list2[firstindex]);
            }


            return temp;
        }

    }
    
    /**
     * Wrapper Method
     * @return ArrayList
     */
    public List intersectionOfLists() {

        return intersectionOfLists(0);

    }
    
    /**
     * 
     * @param firstindex  Wrapper method tarafindan baslangic indexi 0 olarak cagrilir 
     * Basecase den donen bos ArrayListe list1 in herbir elemani eklenir.
     * Ama list2 de de bulunmak ve Arraylist te bulunmamak kosulu ile
     * @return 
     */
    private List intersectionOfLists(int firstindex) {

        ArrayList<E> temp;
        
        /*Basecase*/
        
        if (firstindex == list1.length) {
            return new ArrayList<E>();
        }
        
        else {
            temp = (ArrayList<E>) intersectionOfLists(firstindex + 1);

            if (isContain(list2, list1[firstindex]) && temp.indexOf(list1[firstindex])==-1) {
                temp.add(list1[firstindex]);
            }

            return temp;
        }

    }
    /**
     * Wrapper Method
     * @param E[] _array
     * @param E target
     * @return boolean
     */
    private boolean isContain(E[] _array, E target) {

        return isContain(_array, 0, target);
    }

    /**
     * Recursive bir sekilde bir arrayin icinde arama yapan metoddur
     * Diger metodlar icin helper gorevi ustlenir
     * @param _array
     * @param firstindex
     * @param target
     * @return boolean
     */
    private boolean isContain(E[] _array, int firstindex, E target) {

        if (firstindex == _array.length) {
            return false;
        } else {
            if (_array[firstindex].equals(target)) {
                return true;
            } else {
                return isContain(_array, firstindex + 1, target);
            }
        }
    }

}
