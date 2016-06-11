/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw05_131044042_ahmetemin_kaplan;

/**
 *
 * @author aek
 */
/** A recursive linked list class with recursive methods.
 *  @author Koffman and Wolfgang
 *  */

public class LinkedListRec < E > {

  /** The list head */
  private Node < E > head;

  /** A Node is the building block for a single-linked list. */
  private static class Node < E > {
    // Data Fields
    /** The reference to the data. */
    private E data;

    /** The reference to the next node. */
    private Node next;

  
    private Node(E dataItem) {
      data = dataItem;
      next = null;
    }

  } //end class Node

  
  /**
   * Kolayca elemanlari goruntuleyebilmek icin kitaptan kopyaladigim metod
   * @return String
   */
  private String toString(Node < E > head) {
    if (head == null)
      return "";
    else
      return head.data + "  " + toString(head.next);
  }

  /**
   * Kolayca elemanlari goruntuleyebilmek icin kitaptan kopyaladigim metod
   * @return String
   */
  public String toString() {
    return toString(head);
  }

  /**
   * Olusturdugum LinkedListRec sinifina kolay eleman ekleyebilmek icin kitaptan kopyaladigim metod
   * @param head
   * @param data 
   */
  private void add(Node < E > head, E data) {
    // If the list has just one element, add to it.
    if (head.next == null)
      head.next = new Node < E > (data);
    else
      add(head.next, data); // Add to rest of list.
  }

  /**
   * Olusturdugum LinkedListRec sinifina kolay eleman ekleyebilmek icin kitaptan kopyaladigim metod
   * @param data 
   */
  public void add(E data) {
    if (head == null)
      head = new Node < E > (data); // List has 1 node.
    else
      add(head, data);
  }

  /**
   * Wrapper metod tarafindan cagrilan recursive metoddur.Parametre olarak aldigi datanin butun occurencelarini linkedlistten siler
   * @param _head node E refrence
   * @param pred    node E refrence
   * @param outData E
   * @return boolean Eger eslesme varsa ve silme islemi basariliysa true return eder degilse false return eder
   */
  private boolean remove(Node < E > _head, Node < E > pred, E outData) {
    
      boolean result;
      
      /*Basecase*/
      if (_head == null) // Eger liste bos ise.
      
          result=false;
      
      else{
            result=remove(_head.next,_head,outData);
            /*Eger aranan eleman listenin ilk elemani ise listenin head bileseni guncellenerek eleman silinir*/
             if(pred==null && _head.data.equals(outData) )
             {
                 
                 head=_head.next;                
                 result=true;
             
             }
             /*Aranan eleman ortada veya sonda ise previous node bilindigi icin rahatca silinir*/
             else if(_head.data.equals(outData)){
                    pred.next=_head.next;
                    result=true;
             }

        }
  
      return result;
  }
  
  /**
   * Wrapper Method
   * @param outData
   * @return boolean
   */
  public boolean remove(E outData) {
    
      if (head == null)
        return false;
    
    else{
      
            return remove(head, null, outData);
        }
  
  }


}