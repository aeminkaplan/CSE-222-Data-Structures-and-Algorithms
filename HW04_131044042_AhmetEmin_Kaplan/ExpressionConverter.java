/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw04_131044042_ahmetemin_kaplan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 *
 * @author aek
 */
public class ExpressionConverter {
    
    private String FILEOUTPUT="";
    private ArrayList<Expression> postFix;
    private ArrayList<Expression> Infix;
    private Stack<Operator> OperatorStack;
    private ArrayList<Register> Registers;
    
    public void print() throws IOException{
    
         FileWriter output;
        output = new FileWriter("output.asm");
        BufferedWriter myBufferedWriter = new BufferedWriter(output);
        myBufferedWriter.write(FILEOUTPUT);
        myBufferedWriter.close();
    }
    public ExpressionConverter() {
        
        postFix=new ArrayList<Expression>();
        OperatorStack=new Stack<Operator>();
        Infix=new ArrayList<Expression>();
        Registers=new ArrayList<Register>();
        Registers.add(new Register("t0"));
        Registers.add(new Register("t1"));
        Registers.add(new Register("t2"));
        Registers.add(new Register("t3"));
        Registers.add(new Register("t4"));
        Registers.add(new Register("t5"));
        Registers.add(new Register("t6"));
        Registers.add(new Register("t7"));
        Registers.add(new Register("t8"));
        
    }
    /**
     * 
     * @return Arraylist - postfix formdaki 
     */
    public ArrayList<Expression> getPostfix(){
    
        return postFix;
    }
    /**
     * 
     * @param _Expression-ArrayList
     * Parametre olarak aldigi Expression ArrayList indeki islemi Postfix formuna cevirir
     * print fonksiyonu cagrildigi zaman postfixe cevirmek yerine bu metodun icinde handle edilmektedir
     * @throws Exception Eger syntax kurallarina uygun bir expression ile cagrilirsa exception firlatir
     */
    public void InfixToPostfix(ArrayList<Expression> _Expression) throws Exception{
        
        
       Infix=_Expression;
       Expression temp5;
       Expression temp;
       Operator tempOperator;
       Operand tempOperand=null;
       Operand tempOperand2 = null;
       Operator tempOperator2;
       Register tempRegister=null;
       
       /*Eger print fonksiyonu cagirilirsa  handle edilme kismi burasidir*/
       
       if(Infix.size()==2)
       {    
           if(((Operator)Infix.get(0)).getOperator()=='p')
           {    
               tempOperand2=(Operand)Infix.get(1);
                for(int i=0;i<Registers.size();++i)
                {
                    if(!Registers.get(i).IsFree() && Registers.get(i).getData().equals(tempOperand2))
                    {
                        tempRegister=Registers.get(i);
                        break;
                    }   
                }
           }
       
           if(tempRegister!=null)
           {
               FILEOUTPUT+=String.format("move $a0 %s\n", tempRegister);
               System.out.printf("move $a0 %s\n", tempRegister);
               
           }
           else{
           
               tempRegister=getAvailableRegister();
               tempRegister.setData(tempOperand2);
               
               FILEOUTPUT+=String.format("li %s,%s\n",tempRegister,tempOperand2);               
               System.out.printf("li %s,%s\n",tempRegister,tempOperand2);
               tempRegister.makeFree();
               FILEOUTPUT+=String.format("move $a0 %s\n", tempRegister);
               System.out.printf("move $a0 %s\n", tempRegister);
               
           }
            FILEOUTPUT+=String.format("li $v0,1\n");
            FILEOUTPUT+=String.format("syscall\n");
           System.out.printf("li $v0,1\n");
           System.out.printf("syscall\n");
           Infix.remove(0);
           Infix.remove(0);
           return;  
       }
           
      
       
       
       /*Operator ve operand uyumsuzlugu oldugu durumda syntax hatasi oldugunu belirten exception firlatir*/
       
       for(int j=0;j<Infix.size();++j)
       {
           if(j%2==0 && Infix.get(j) instanceof Operator)
               throw new Exception("Syntax Error!\n");
           else if(j%2==1 && Infix.get(j) instanceof Operand)
               throw new  Exception("Syntax Error!\n");
       }
       
       
       /*Postfix formuna cevirme kismi burasidir*/
       
       /*
       Genel algoritma :Eger gelen deger operand ise postfixe direk eklenir 
       eger operator ise operator stackinin durumu goz onunde bulundurularak postfixe eklenir */
       
       for(int i=0;i<Infix.size();++i)
       {
           
           temp=Infix.get(i);
           
           if(temp instanceof Operand)
           {    
               tempOperand=(Operand)temp;
               postFix.add(temp);
           }
       
           else if(temp instanceof Operator)
           {    
               tempOperator=(Operator)temp;
               if(OperatorStack.empty() || tempOperator.getPriority()> OperatorStack.peek().getPriority())
               {
                   OperatorStack.push(tempOperator);
               }
                   
               else if(!OperatorStack.empty() && tempOperator.getPriority()<=OperatorStack.peek().getPriority())
               {
                   
                        while(!OperatorStack.empty() && OperatorStack.peek().getPriority()>= tempOperator.getPriority())
                        {
                               postFix.add(OperatorStack.pop());
                       
                         }
                        OperatorStack.push(tempOperator);
             
               }
            }    
        
       }
        while(!OperatorStack.empty()){
             postFix.add(OperatorStack.pop());
        }  
    }
    
    
    /**
     * Postfixe cevrilmis olan ifadeyi ekrana yazdiran metoddur debug islemi yaparken kullandigim icin Unit testini yazmayacagim
     */
    public void showPostFix(){
    
        Operator temp1;
        Operand temp2;
        for(int i=0;i<postFix.size();++i)
        {
            if(postFix.get(i) instanceof Operand){
                temp2=(Operand) postFix.get(i);
            System.out.printf(" %s", temp2);
            }
            else if(postFix.get(i) instanceof Operator){
                temp1=(Operator) postFix.get(i);
                System.out.printf(" %c",temp1.getOperator());
            
            }
        }
        System.out.printf("\n");
    
    }
    /**
     * 
     * @param op1 operand
     * @param op2 operand
     * @throws Exception -Initilize edilmemis bir variable operand olarak kullanilirsa exception firlatir
     *      Constant bir degere atama yapilirsa exception firlatir
     *      Atama islemini 4 farklı durum icin handle eder 
     */
    
    public void assignmentProcess(Operand op1,Operand op2) throws Exception{
        
     
        Register r1=null;
        Register r2=null;

        for(int i=0;i<Registers.size();++i)
        {   
               if(!Registers.get(i).IsFree() && Registers.get(i).getData().equals(op1))
               {
                    r1=Registers.get(i);
                    break;
               }
        }
        
        for(int t=0;t<Registers.size();++t)
        {
            
               if(!Registers.get(t).IsFree() && Registers.get(t).getData().equals(op2) )
               {
                    r2=Registers.get(t);
                    break;
               }
        }
        
        if(r1!=null && r2!=null)
        { 
            FILEOUTPUT+=String.format("move %s,%s\n",r1,r2);
            System.out.printf("move %s,%s\n",r1,r2);
            if(r2.getData().getVariable()=='1')
                r2.makeFree();
            r1.setData(op2);
        }
        
        else if(r1==null && r2==null)
        {   if(op1.getVariable()=='1')
                throw new Exception("Constant values can not be leftvalue!\n");
            Register tempR=getAvailableRegister();
            tempR.getData().setVariable(op1.getVariable());
            FILEOUTPUT+=String.format("li %s,%s\n",tempR,op2);
            System.out.printf("li %s,%s\n",tempR,op2);
            tempR.setData(op2);
        }
        
        else if(r1!=null && r2==null)
        {    FILEOUTPUT+=String.format("li %s,%s\n",r1,op2);
            System.out.printf("li %s,%s\n",r1,op2);
            r1.setData(op2);
        }
        
        else if(r1==null && r2!=null)
        {   
            if(op1.getVariable()=='1')
                throw new Exception("Constant values can not be leftvalue!\n");
            
            
            Register tempR2=getAvailableRegister();
            tempR2.getData().setVariable(op1.getVariable());
            if(r2.getData().getVariable()=='1')
                r2.makeFree();
            FILEOUTPUT+=String.format("move %s,%s\n",tempR2,r2);
            System.out.printf("move %s,%s\n",tempR2,r2);
            tempR2.setData(op2);
        }
        
    }
    /**
     * 
     * @param op1 Operand
     * @param op2 Operand
     * @return  Operand toplama isleminin sonucunu return eder
     * @throws  Exception -Initilize edilmemis bir variable operand olarak kullanilirsa exception firlatir
     */
    public Operand addProcess(Operand op1,Operand op2) throws Exception{
    
      
        Register r1=null;
        Register r2=null;
        Register r3=null;
        Operand result = null;
        for(int i=0;i<Registers.size();++i)
        {   
               if(!Registers.get(i).IsFree() && Registers.get(i).getData().equals(op1))
               {
                    r1=Registers.get(i);
                    break;
               }
        }
        
        for(int t=0;t<Registers.size();++t)
        {
            
               if(!Registers.get(t).IsFree() && Registers.get(t).getData().equals(op2) )
               {
                    r2=Registers.get(t);
                    break;
               }
        }
        
        if(r1==null && r2==null)
        {
            if(op2.getVariable()!='1' || op1.getVariable()!='1')
                throw new Exception("Undefined variables  can not be operand!\n");
            r1=getAvailableRegister();
                        r1.setData(op1);
            r2=getAvailableRegister();
            

            r2.setData(op2);

            
            result= new Operand(op1.getValue()+op2.getValue());
                    r3=getAvailableRegister();
            r3.setData(result);
            FILEOUTPUT+=String.format("li %s %s\n",r1,op1);
            System.out.printf("li %s %s\n",r1,op1);
              
             FILEOUTPUT+=String.format("li %s %s\n",r2,op2);
            System.out.printf("li %s %s\n",r2,op2);
            
             FILEOUTPUT+=String.format("add %s,%s,%s\n",r3,r1,r2);
            System.out.printf("add %s,%s,%s\n",r3,r1,r2);
            r1.makeFree();
            r2.makeFree();
        }
        
        else if(r1!=null && r2!=null)
        {

            result= new Operand(op1.getValue()+op2.getValue());

                                r3=getAvailableRegister();
            r3.setData(result);
             FILEOUTPUT+=String.format("add %s,%s,%s\n",r3,r1,r2);
                        System.out.printf("add %s,%s,%s\n",r3,r1,r2);
                                    if(r1.getData().getVariable()=='1')
                r1.makeFree();
            if(r2.getData().getVariable()=='1')
                r2.makeFree();
        }
        
                
        else if(r1==null && r2!=null)
        {   if(op1.getVariable()!='1')
                throw new Exception("Undefined variables  can not be operand!\n");
            r1=getAvailableRegister();
            r1.setData(op1);

            result= new Operand(op1.getValue()+op2.getValue());
                                r3=getAvailableRegister();
            r3.setData(result);
             FILEOUTPUT+=String.format("li %s %s\n",r1,op1);
                        System.out.printf("li %s %s\n",r1,op1);
                        
             FILEOUTPUT+=String.format("add %s,%s,%s\n",r3,r1,r2);           
            System.out.printf("add %s,%s,%s\n",r3,r1,r2);
            r1.makeFree();
            if(r2.getData().getVariable()=='1')
            r2.makeFree();
        }
        
                
        else if(r1!=null && r2==null)
        {
                        if(op2.getVariable()!='1')
                throw new Exception("Undefined variables  can not be operand!\n");
            r2=getAvailableRegister();
            r2.setData(op2);

            result= new Operand(op1.getValue()+op2.getValue());
                                r3=getAvailableRegister();
            r3.setData(result);
             FILEOUTPUT+=String.format("li %s %s\n",r2,op2);
                        System.out.printf("li %s %s\n",r2,op2);
                        
            FILEOUTPUT+=String.format("add %s,%s,%s\n",r3,r1,r2);            
            System.out.printf("add %s,%s,%s\n",r3,r1,r2);
            r2.makeFree();
            if(r1.getData().getVariable()=='1')
                r1.makeFree();
           
        }
        
        return result;
    }
    /**
     * 
     * @param op1 Operand
     * @param op2 Operand
     * @return  Operand cikarma isleminin sonucunu return eder
     * @throws  Exception -Initilize edilmemis bir variable operand olarak kullanilirsa exception firlatir 
     */
     public Operand subProcess(Operand op1,Operand op2) throws Exception{
    
      
        Register r1=null;
        Register r2=null;
        Register r3=null;
        Operand result = null;
        for(int i=0;i<Registers.size();++i)
        {   
               if(!Registers.get(i).IsFree() && Registers.get(i).getData().equals(op1))
               {
                    r1=Registers.get(i);
                    break;
               }
        }
        
        for(int t=0;t<Registers.size();++t)
        {
            
               if(!Registers.get(t).IsFree() && Registers.get(t).getData().equals(op2) )
               {
                    r2=Registers.get(t);
                    break;
               }
        }
        
        if(r1==null && r2==null)
        {   
            if(op2.getVariable()!='1' || op1.getVariable()!='1')
                throw new Exception("Undefined variables  can not be operand!\n");
            r1=getAvailableRegister();
            r1.setData(op1);
            r2=getAvailableRegister();
            

            r2.setData(op2);

            
            result= new Operand(op1.getValue()-op2.getValue());
                    r3=getAvailableRegister();
            r3.setData(result);
            FILEOUTPUT+=String.format("li %s %s\n",r1,op1);
                    FILEOUTPUT+=String.format("li %s %s\n",r2,op2);
                            FILEOUTPUT+=String.format("sub %s,%s,%s\n",r3,r1,r2);
                        System.out.printf("li %s %s\n",r1,op1);
            System.out.printf("li %s %s\n",r2,op2);
            System.out.printf("sub %s,%s,%s\n",r3,r1,r2);
            r1.makeFree();
            r2.makeFree();
        }
        
        else if(r1!=null && r2!=null)
        {

            result= new Operand(op1.getValue()-op2.getValue());

               r3=getAvailableRegister();
            r3.setData(result);
                        if(r1.getData().getVariable()=='1')
                r1.makeFree();
            if(r2.getData().getVariable()=='1')
                r2.makeFree();
             FILEOUTPUT+=String.format("sub %s,%s,%s\n",r3,r1,r2);
                        System.out.printf("sub %s,%s,%s\n",r3,r1,r2);
        }
        
                
        else if(r1==null && r2!=null)
        {             
            if(op1.getVariable()!='1')
                throw new Exception("Undefined variables  can not be operand!\n");
            r1=getAvailableRegister();
            r1.setData(op1);

            result= new Operand(op1.getValue()-op2.getValue());
                                r3=getAvailableRegister();
            r3.setData(result);
             FILEOUTPUT+=String.format("li %s %s\n",r1,op1);
             FILEOUTPUT+=String.format("sub %s,%s,%s\n",r3,r1,r2);
                        System.out.printf("li %s %s\n",r1,op1);
            System.out.printf("sub %s,%s,%s\n",r3,r1,r2);
            r1.makeFree();
            if(r2.getData().getVariable()=='1')
            r2.makeFree();
        }
        
                
        else if(r1!=null && r2==null)
        {
             if(op2.getVariable()!='1')
                throw new Exception("Undefined variables  can not be operand!\n");
            r2=getAvailableRegister();
            r2.setData(op2);

            result= new Operand(op1.getValue()-op2.getValue());
                                r3=getAvailableRegister();
            r3.setData(result);
                FILEOUTPUT+=String.format("li %s %s\n",r2,op2);
                        System.out.printf("li %s %s\n",r2,op2);
                   FILEOUTPUT+=String.format("sub %s,%s,%s\n",r3,r1,r2);     
            System.out.printf("sub %s,%s,%s\n",r3,r1,r2);
            r2.makeFree();
            if(r1.getData().getVariable()=='1')
                r1.makeFree();
           
        }
        
        return result;
    }
    
     /**
     * 
     * @param op1 Operand
     * @param op2 Operand
     * @return  Operand carpma isleminin sonucunu return eder
     * @throws  Exception -Initilize edilmemis bir variable operand olarak kullanilirsa exception firlatir
     * 
     */
    public Operand multProcess(Operand op1,Operand op2) throws Exception
    {
        Register r1=null;
        Register r2=null;
        Register r3=null;
        Operand result = null;
        for(int i=0;i<Registers.size();++i)
        {   
               if(!Registers.get(i).IsFree() && Registers.get(i).getData().equals(op1))
               {
                    r1=Registers.get(i);
                    break;
               }
        }
        
        for(int t=0;t<Registers.size();++t)
        {
            
               if(!Registers.get(t).IsFree() && Registers.get(t).getData().equals(op2) )
               {
                    r2=Registers.get(t);
                    break;
               }
        }
        
        if(r1==null && r2==null)
        {
             if(op2.getVariable()!='1' || op1.getVariable()!='1')
                throw new Exception("Undefined variables  can not be operand!\n");
            r1=getAvailableRegister();
                        r1.setData(op1);
            r2=getAvailableRegister();
            

            r2.setData(op2);

            
            result= new Operand(op1.getValue()*op2.getValue());
             r1.makeFree();
            r2.makeFree();
    
             r3=getAvailableRegister();
            r3.setData(result);
            FILEOUTPUT+=String.format("li %s %s\n",r1,op1);
                    FILEOUTPUT+=String.format("li %s %s\n",r2,op2);
                            FILEOUTPUT+=String.format("mult %s,%s\n",r1,r2);
                                    FILEOUTPUT+=String.format("mflo %s\n",r3);
            System.out.printf("li %s %s\n",r1,op1);
            System.out.printf("li %s %s\n",r2,op2);
            System.out.printf("mult %s,%s\n",r1,r2);
            System.out.printf("mflo %s\n",r3);
        }
        
        else if(r1!=null && r2!=null)
        {

            result= new Operand(op1.getValue()*op2.getValue());
            if(r1.getData().getVariable()=='1')
                r1.makeFree();
            if(r2.getData().getVariable()=='1')
                r2.makeFree();
                                r3=getAvailableRegister();
            r3.setData(result);
            FILEOUTPUT+=String.format("mult %s,%s\n",r1,r2);
             FILEOUTPUT+=String.format("mflo %s\n",r3);
                        System.out.printf("mult %s,%s\n",r1,r2);
                        System.out.printf("mflo %s\n",r3);
        }   
        
                
        else if(r1==null && r2!=null)
        {   
            if( op1.getVariable()!='1')
                throw new Exception("Undefined variables  can not be operand!\n");
            r1=getAvailableRegister();
            r1.setData(op1);

            r1.makeFree();
            if(r2.getData().getVariable()=='1')
            r2.makeFree();
            
            result= new Operand(op1.getValue()*op2.getValue());
            r3=getAvailableRegister();    
            r3.setData(result);
            FILEOUTPUT+=String.format("li %s %s\n",r1,op1);
                    FILEOUTPUT+=String.format("mult %s,%s\n",r1,r2);
                            FILEOUTPUT+=String.format("mflo %s\n",r3);
            System.out.printf("li %s %s\n",r1,op1);
            System.out.printf("mult %s,%s\n",r1,r2);
            System.out.printf("mflo %s\n",r3);
        }
        
                
        else if(r1!=null && r2==null)
        {
            if( op2.getVariable()!='1')
                throw new Exception("Undefined variables  can not be operand!\n");
            r2=getAvailableRegister();
            r2.setData(op2);
            r2.makeFree();
            
            if(r1.getData().getVariable()=='1')
                r1.makeFree();
            
            result= new Operand(op1.getValue()*op2.getValue());
            r3=getAvailableRegister();
            r3.setData(result);
             FILEOUTPUT+=String.format("li %s %s\n",r2,op2);
                      FILEOUTPUT+=String.format("mult %s,%s\n",r1,r2);
                               FILEOUTPUT+=String.format("mflo %s\n",r3);
                        System.out.printf("li %s %s\n",r2,op2);
            System.out.printf("mult %s,%s\n",r1,r2);
            System.out.printf("mflo %s\n",r3);
           
        }
        
        return result;
    
    
    
    }
    /**
     * 
     * @param op1 Operand
     * @param op2 Operand
     * @return  Operand bolme isleminin sonucunu return eder
     * @throws  Exception -Initilize edilmemis bir variable operand olarak kullanilirsa exception firlatir
     *      Divide by Zero durumunda exception firlatir
     *  
     */
    public Operand divideProcess(Operand op1,Operand op2) throws Exception{
       
        Register r1=null;
        Register r2=null;
        Register r3=null;
        Operand result = null;
        
        if(op2.getValue()==0)
            throw new Exception("Divide by Zero exception!\n");
        
        for(int i=0;i<Registers.size();++i)
        {   
               if(!Registers.get(i).IsFree() && Registers.get(i).getData().equals(op1))
               {
                    r1=Registers.get(i);
                    break;
               }
        }
        
        for(int t=0;t<Registers.size();++t)
        {
            
               if(!Registers.get(t).IsFree() && Registers.get(t).getData().equals(op2) )
               {
                    r2=Registers.get(t);
                    break;
               }
        }
        
        if(r1==null && r2==null)
        {
            
             if(op2.getVariable()!='1' || op1.getVariable()!='1')
                throw new Exception("Undefined variables  can not be operand!\n");
            r1=getAvailableRegister();
             r1.setData(op1);
            r2=getAvailableRegister();
            

            r2.setData(op2);

            
            result= new Operand(op1.getValue()*op2.getValue());
             r1.makeFree();
            r2.makeFree();
    
             r3=getAvailableRegister();
            r3.setData(result);
             FILEOUTPUT+=String.format("li %s %s\n",r1,op1);
                      FILEOUTPUT+=String.format("li %s %s\n",r2,op2);
                               FILEOUTPUT+=String.format("div %s,%s\n",r1,r2);
                                        FILEOUTPUT+=String.format("mfhi %s\n",r3);
            System.out.printf("li %s %s\n",r1,op1);
            System.out.printf("li %s %s\n",r2,op2);
            System.out.printf("div %s,%s\n",r1,r2);
            System.out.printf("mfhi %s\n",r3);
        }
        
        else if(r1!=null && r2!=null)
        {

            result= new Operand(op1.getValue()*op2.getValue());
            if(r1.getData().getVariable()=='1')
                r1.makeFree();
            if(r2.getData().getVariable()=='1')
                r2.makeFree();
                                r3=getAvailableRegister();
            r3.setData(result);
             FILEOUTPUT+=String.format("div %s,%s\n",r1,r2);
                      FILEOUTPUT+=String.format("mfhi %s\n",r3);
                        System.out.printf("div %s,%s\n",r1,r2);
                        System.out.printf("mfhi %s\n",r3);
        }   
        
                
        else if(r1==null && r2!=null)
        {   
            if(op1.getVariable()!='1')
                throw new Exception("Undefined variables  can not be operand!\n");
            r1=getAvailableRegister();
            r1.setData(op1);

            r1.makeFree();
            if(r2.getData().getVariable()=='1')
            r2.makeFree();
            
            result= new Operand(op1.getValue()*op2.getValue());
            r3=getAvailableRegister();    
            r3.setData(result);
            FILEOUTPUT+=String.format("li %s %s\n",r1,op1);
                    FILEOUTPUT+=String.format("div %s,%s\n",r1,r2);
                            FILEOUTPUT+=String.format("mfhi %s\n",r3);
            System.out.printf("li %s %s\n",r1,op1);
            System.out.printf("div %s,%s\n",r1,r2);
            System.out.printf("mfhi %s\n",r3);
        }
        
                
        else if(r1!=null && r2==null)
        {
             if(op2.getVariable()!='1')
                throw new Exception("Undefined variables  can not be operand!\n");
            r2=getAvailableRegister();
            r2.setData(op2);
            r2.makeFree();
            
            if(r1.getData().getVariable()=='1')
                r1.makeFree();
            
            result= new Operand(op1.getValue()*op2.getValue());
            r3=getAvailableRegister();
            r3.setData(result);
            FILEOUTPUT+=String.format("li %s %s\n",r2,op2);
            FILEOUTPUT+=String.format("div %s,%s\n",r1,r2);
                    FILEOUTPUT+=String.format("mfhi %s\n",r3);
                        System.out.printf("li %s %s\n",r2,op2);
            System.out.printf("div %s,%s\n",r1,r2);
            System.out.printf("mfhi %s\n",r3);
           
        }
        
        return result;
        
    }
    /**
     * 
     * @return Register - Herhangi musait bir registeri return eder
     * @throws Exception
     * - Yeterli register olmadigi durumda exception firlatir 
     */
    public Register getAvailableRegister() throws Exception{
        
        for(int i=0;i<Registers.size();++i)
        {
            if(Registers.get(i).IsFree())
                return Registers.get(i);
        }
    
        throw new Exception("There is no available register!\n");
    }
    /**
     *  Postfix ifadeyi assembly ifadelerine cevirir
     * @throws Exception Eger syntax hatasi varsa operand stack ten empty stack exception firlatilirsa 
     * O exception yakalanir ve Syntax error exception firlatilir.
     * 
     */
    public void convertPostfixToAssembly() throws Exception{
        
        Stack<Expression> temp=new Stack<Expression>();
       
        Expression temporary;
        Operand operand1;
        Operand operand2;
        Operator operatorx;
        try{
        while(!postFix.isEmpty()){
            
            temporary=postFix.remove(0);
            
            if(temporary instanceof Operand)
                temp.push(temporary);
            else{
                
                operatorx=(Operator)temporary;
                operand2=(Operand)temp.pop();
                operand1=(Operand)temp.pop();
                
                if(operatorx.getOperator()=='=')
                    assignmentProcess(operand1, operand2);
                else if(operatorx.getOperator()=='+')
                    temp.push(addProcess(operand1,operand2));
                else if(operatorx.getOperator()=='-')
                    temp.push(subProcess(operand1,operand2));
                else if(operatorx.getOperator()=='*')
                    temp.push(multProcess(operand1,operand2));
                else if(operatorx.getOperator()=='/')
                    temp.push(divideProcess(operand1, operand2));
            }
                
            }
            if(temp.size()>1)
                throw new Exception("Syntax Error!\n");
        }catch(EmptyStackException e)
        {
            throw new Exception("Syntax Error!\n");
        }
    }
}
