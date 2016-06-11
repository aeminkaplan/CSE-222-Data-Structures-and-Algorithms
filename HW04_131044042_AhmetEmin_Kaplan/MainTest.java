/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw04_131044042_ahmetemin_kaplan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author aek
 */
public class MainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        String myOperators = "+-*=/";
        String myDigits = "0123456789-";
        String tempStr = null;
        ExpressionConverter ec = new ExpressionConverter();
        ArrayList<Expression> temp = new ArrayList<Expression>();

        File input;
        input = new File("input.txt");
        FileReader myFileReader = new FileReader(input);
        BufferedReader myBufferedReader = new BufferedReader(myFileReader);

        while ((tempStr = myBufferedReader.readLine()) != null) {

            StringTokenizer myTokenizer = new StringTokenizer(tempStr);

            while (myTokenizer.hasMoreTokens()) {

                String token = myTokenizer.nextToken();
                if (token.compareTo("print") == 0) {
                    temp.add(new Operator('p'));
                } else if (token.length() == 1 && myOperators.indexOf(token.charAt(0)) != -1) {
                    temp.add(new Operator(token.charAt(0)));
                } else if (token.length() > 1 && myDigits.indexOf(token.charAt(0)) != -1) {
                    temp.add(new Operand(Integer.parseInt(token)));
                } else if (myOperators.indexOf(token.charAt(0)) == -1 && myDigits.indexOf(token.charAt(0)) != -1) {
                    temp.add(new Operand(Integer.parseInt(token)));
                } else if (myOperators.indexOf(token.charAt(0)) == -1 && myDigits.indexOf(token.charAt(0)) == -1) {
                    temp.add(new Operand(token.charAt(0)));
                }
            }
            try {
                ec.InfixToPostfix(temp);
                if(temp.size()!=0)
                ec.convertPostfixToAssembly();
                temp = new ArrayList<Expression>();
            } catch (Exception e) {
                System.out.printf("%s", e.getMessage());
                System.exit(0);
            }
            

        }
        myFileReader.close();

         ec.print();
    }

}
