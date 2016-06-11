/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw06_131044042_ahmetemin_kaplan;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 *
 * @author aek
 */
public class MainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        HuffmanTree Htree = new HuffmanTree();
        
        // Create symbol array
        HuffmanTree.HuffData[] symbols = {
                            new HuffmanTree.HuffData(186, '_'),
                            new HuffmanTree.HuffData(103, 'e'),
                            new HuffmanTree.HuffData(80, 't'),
                            new HuffmanTree.HuffData(64, 'a'),
                            new HuffmanTree.HuffData(63, 'o'),
                            new HuffmanTree.HuffData(57, 'i'),
                            new HuffmanTree.HuffData(57, 'n'),
                            new HuffmanTree.HuffData(51, 's'),
                            new HuffmanTree.HuffData(48, 'r'),
                            new HuffmanTree.HuffData(47, 'h'),
                            new HuffmanTree.HuffData(32, 'd'),
                            new HuffmanTree.HuffData(32, 'l'),
                            new HuffmanTree.HuffData(23, 'u'),
                            new HuffmanTree.HuffData(22, 'c'),
                            new HuffmanTree.HuffData(21, 'f'),
                            new HuffmanTree.HuffData(20, 'm'),
                            new HuffmanTree.HuffData(18, 'w'),
                            new HuffmanTree.HuffData(16, 'y'),
                            new HuffmanTree.HuffData(15, 'g'),
                            new HuffmanTree.HuffData(15, 'p'),
                            new HuffmanTree.HuffData(13, 'b'),
                            new HuffmanTree.HuffData(8, 'v'),
                            new HuffmanTree.HuffData(5, 'k'),
                            new HuffmanTree.HuffData(1, 'j'),
                            new HuffmanTree.HuffData(1, 'q'),
                            new HuffmanTree.HuffData(1, 'x'),
                            new HuffmanTree.HuffData(1, 'z')
        };
        
        // Build hufffman tree 
        Htree.buildTree(symbols);
        
        // Print huffman codes of the symbols
        String EncodedSymbolList = Htree.toString();
        
        // Decode huffman codes to symbıls
        String code = "10101000000000010111010110011100001";
        String decodedCode = Htree.decode(code);
        System.out.println("Code to Message : \n"+code+" : \t"+decodedCode);
        String encodedMessage=Htree.encode(decodedCode);
        System.out.println("Message to Code : \n"+encodedMessage+" :\t"+decodedCode);
    
        BinarySearchTree<Integer> Btree = new BinarySearchTree<Integer>();
        Btree.add(2);
        Btree.add(1);
        Btree.add(12);
        Btree.add(20);
        Btree.add(11);
        Btree.add(0);
        
        //System.out.println(Btree.find(21));
        System.out.println(Btree.toString());
       /* Btree.add(15);
        System.out.println(Btree.toString());
        Btree.delete(11);
        System.out.println(Btree.toString());*/
        System.out.printf("Iterator icin test \n");
        try{
            Iterator it=Btree.iterator();
            while(it.hasNext())
            {
             System.out.printf("%s ",it.next());
            }
            
        }
        catch(EmptyStackException e){
                System.out.printf("Uzerinde gezilen agac standartlara uymamaktadir!\n");
        }
        System.out.printf("\nIterator icin test sonu!\n");
    }
    
}
