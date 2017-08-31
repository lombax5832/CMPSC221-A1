/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

/**
 *
 * @author Alexei Snytkine
 */
public class Assignment1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Initialize 2 new SavingsAccount with initial values of 2000 and 3000
        SavingsAccount account1 = new SavingsAccount(2000.00);
        SavingsAccount account2 = new SavingsAccount(3000.00);
        
        //Initial interest rate is 4%
        SavingsAccount.setAnnualInterestRate(0.04);
        
        //Format table header
        System.out.printf("%-7s%15s%15s\n",
                "Month", 
                "Account1", 
                "Account2");
        
        int i = 1;
        
        //Calculate Interest rate for 12 months
        for(i = 1; i < 13; i++){
            account1.calculateMonthlyInterest();
            account2.calculateMonthlyInterest();
            
            System.out.printf("%-7d%15s%15s\n", i, 
                    account1.getBalanceString(), 
                    account2.getBalanceString());
            
        }
        
        //Set new interest rate to 5%
        SavingsAccount.setAnnualInterestRate(0.05);
        
        //Interest Rate changes for 1 last month
        account1.calculateMonthlyInterest();
        account2.calculateMonthlyInterest();
        
        System.out.printf("%-7d%15s%15s\n", i, 
                    account1.getBalanceString(), 
                    account2.getBalanceString());
        
    }   
    
}
