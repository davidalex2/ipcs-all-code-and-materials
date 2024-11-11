package org.example.do_examples;

import java.util.Scanner;

public class NestedFor {
    int num[][];
   public void displayFunction(){
       Scanner scanner=new Scanner(System.in);

       for(int i=1;i<=3;i++){
           //loop of j
           for(int j=1;j<=3;j++){
               num[i][j]=scanner.nextInt();
               System.out.println(num[i][j]);
           }//end of i
       }//end of j

   }



        }


