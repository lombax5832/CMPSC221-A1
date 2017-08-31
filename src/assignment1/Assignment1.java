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
        SavingsAccount account1 = new SavingsAccount(2000.00);
        SavingsAccount account2 = new SavingsAccount(3000.00);
        
        SavingsAccount.setAnnualInterestRate(0.04);
        
        
        
        for(int i = 1; i < 13; i++){
            
            account1.calculateMonthlyInterest();
            account2.calculateMonthlyInterest();
        
            System.out.printf("%-7d%10s%10s", i, 
                    account1.getBalanceString(), 
                    account2.getBalanceString());
            
        }
    }   
    
}
