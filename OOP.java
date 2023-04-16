package com.objectorientedprogramming;

import java.util.*;
public class OOP {

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.println("This is Debit and Credit Calculator");
      System.out.println("Do you want to continue?");
      System.out.print("Answer: ");
      String strEnter = input.nextLine();
      boolean a = true;

      while (!a);
      try {
         if (strEnter.equalsIgnoreCase("Yes")) {
            Debit debit = new Debit(strEnter);
            System.out.println("DEBIT");
            System.out.print("Enter Debit: ");
            double dDebit = input.nextDouble();
            System.out.print("Enter Expenses: ");
            double dExpenses = input.nextDouble();
            System.out.print("Enter Asset: ");
            double dAsset = input.nextDouble();
            System.out.print("Enter Drawing: ");
            double dDrawing = input.nextDouble();
            debit.setDebit(dDebit, dExpenses, dAsset, dDrawing);
            System.out.println(debit);

            Credit credit = new Credit(strEnter);
            System.out.println("CREDIT");
            System.out.print("Enter Credit: ");
            double dCredit = input.nextDouble();
            System.out.print("Enter Liabilities: ");
            double dLiabilities = input.nextDouble();
            System.out.print("Enter Income: ");
            double dIncome = input.nextDouble();
            System.out.print("Enter Capital: ");
            double dCapital = input.nextDouble();
            credit.setCredit(dCredit, dLiabilities, dIncome, dCapital);
            System.out.println(credit);

            // ternary:
            // double for seperate the formula for tot and String for ternary output:
            double dResult = debit.getDebit() - credit.getCredit();
            String output = (dResult > 0) ? "Your Buissness is Good Condition!" : "Your Buissness is down be secure your money!";
            System.out.println("Total: " + dResult);
            System.out.println("The output is: " + output);
         } else {
            throw new InputMismatchException();
         }
      } catch (InputMismatchException ex) {
         System.out.println("Your Input is No The Excection is Shutting down!");
      } // end of try and catch

   }
   // superClass/ parent
   public static class Enter {
      private String strAnswer;

      //contractor 
      Enter(String strAnswer) {
         setEnter(strAnswer);
      }
      // override
      void setEnter(String strAnswer) {
         this.strAnswer = strAnswer;
      }
      public String getEnter() {
         return strAnswer;
      }
   }

   // subClass / babyClass
   public static class Debit extends Enter {
      //encapsulation
      private double dDebit, dExpenses, dAsset, dDrawing, dTotal;

      // contractor
      Debit(String strAnswer) {
         super(strAnswer);
      }
      // ovveride setter
      void setDebit(double dDebit, double dExpenses, double dAsset, double dDrawing) {
         this.dDebit = dDebit;
         this.dExpenses = dExpenses;
         this.dAsset = dAsset;
         this.dDrawing = dDrawing;

         dTotal = dDebit + dExpenses + dAsset + dDrawing;

      }

      // getter
      double getDebit() {
         return dTotal;
      }

      // toStrinf
      public String toString() {
         return "The total of Debit is: " + getDebit();
      }
   }

   // subclass or babyClass
   public static class Credit extends Enter {
      // encapsulation
      private double dCredit, dLiabilities, dIncome, dCapital, dCTotal;
      //contractor
      Credit(String strAnswer) {
         super(strAnswer);
      }
      // ovveride setter
      void setCredit(double dCredit, double dLiabilities, double dIncome, double dCapital) {
         this.dCredit = dCredit;
         this.dLiabilities = dLiabilities;
         this.dIncome = dIncome;
         this.dCapital = dCapital;

         dCTotal = dCredit + dLiabilities + dIncome + dCapital;
      }

      // getter
      double getCredit() {
         return dCTotal;
      }
      // to String
      public String toString() {
         return "Your Credit is: " + getCredit();
      }

   }

}