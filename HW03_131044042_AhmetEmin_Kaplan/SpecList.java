/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw03_131044042_ahmetemin_kaplan;

import java.util.LinkedList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.List;

/**
 * 
 * @author aek
 * @param E 
 */
public class SpecList<E extends Comparable<E>> extends LinkedList<E> {

    /**
     * No-parameter constructor
     *
     */
    public SpecList() {

        super();
    }

    /**
     *
     * @param c Collection ? extends E tipinde alinan parametrenin elemanlarini
     * uzerinde islem yapilan speclist objesinin basina ekler 
     * @return boolean  
     * 
     */
    public boolean addAllAtHead(Collection<? extends E> c)  throws Exception{

        if(c.isEmpty())
            throw new Exception("Bos bir liste baska bir listenin basina eklenemez!\n ");
        
        E temp;

        Iterator<E> iteratorForParameter = (Iterator<E>) c.iterator();

        ListIterator<E> listIteratorForMyList = listIterator();

        while (iteratorForParameter.hasNext()) {

            temp = (E) iteratorForParameter.next();

            listIteratorForMyList.add(temp);

        }

        return true;
    }

    /**
     *
     * @param c Collection ? extends E tipinde alinan parametrenin elemanlari ile 
     * uzerinde islem yapilan speclist objesinin ortak elemanlarini bulur ve return eder
     * @return List E
     */
    public List<E> getIntersectList(Collection<? extends E> c) {

        E temp1;
        E temp2;
        E temp3;
        boolean isAlreadyIn = false;

        List<E> result = new LinkedList<E>();

        Iterator<E> iteratorForParameter = (Iterator<E>) c.iterator();

        ListIterator<E> listIteratorForMyList = listIterator();
        ListIterator<E> listIteratorForResult;

        while (iteratorForParameter.hasNext()) {

            isAlreadyIn = false;

            temp1 = iteratorForParameter.next();
            
            listIteratorForMyList = listIterator();

            while (listIteratorForMyList.hasNext()) {

                temp2 = listIteratorForMyList.next();
            
                if (temp2.compareTo(temp1) == 0) {
                    
                    listIteratorForResult = result.listIterator();
                    while (listIteratorForResult.hasNext()) 
                    {
                        temp3 = listIteratorForResult.next();
                        
                        if (temp1.compareTo(temp3) == 0){ 
                            isAlreadyIn = true;
                            break;
                        }
                    }
                        
                        if (!isAlreadyIn)
                            result.add(temp1);
                        
                }
            }
        }

        return result;
    }

  /**
   * 
   * @param mode boolean -  Alinan parametre true ise listeyi kucukten buyuge false ise
   * buyukten kucuge siralar.
   * @return List E - Listenin siralanmis halini return eder
   *  Bos bir listeyi siralamaya calistigimizda exception firlatir
   */

    
    public List<E> sortList (boolean mode) throws Exception {

        
        int listSize = size();

        if(listSize==0)
        {
            throw new Exception("Bos bir liste siralanamaz!\n");
        }
        
        ListIterator<E> listIter;

        ListIterator<E> listIter2;

        ListIterator<E> tempIterator;

        listIter = listIterator(1);
        listIter2 = listIterator(0);

        E temp, temp2, temp3;
        boolean swapped=false;

        for (int i = 0; i < listSize / 2; ++i) {
           
            
            tempIterator = listIter;
            listIter = listIter2;
            listIter2 = tempIterator;

            while (listSize - i - 2 > listIter.nextIndex() - 1) {
                temp = listIter.next();
                temp2 = listIter2.next();

                if (mode && temp.compareTo(temp2) > 0) {
                    temp3 = temp;
                    listIter.set(temp2);
                    listIter2.set(temp3);
                    swapped=true;
                }
                else if(mode==false &&  temp.compareTo(temp2) <0)
                {
                    temp3 = temp;
                    listIter.set(temp2);
                    listIter2.set(temp3);
                    swapped=true;
                
                
                }

            }

            
            tempIterator = listIter;
            listIter = listIter2;
            listIter2 = tempIterator;

            while (listIter2.previousIndex() + 1 > i) {
                temp = listIter.previous();
                temp2 = listIter2.previous();

                if (mode && temp.compareTo(temp2) < 0) {
                    temp3 = temp;
                    listIter.set(temp2);
                    listIter2.set(temp3);
                    swapped=true;
                }
                else if(mode==false && temp.compareTo(temp2) > 0){
              
                    temp3 = temp;
                    listIter.set(temp2);
                    listIter2.set(temp3);
                    swapped=true;
                
                
                }

            }
            
            if(!swapped)
                break;
        }

        return this;

    }

}
