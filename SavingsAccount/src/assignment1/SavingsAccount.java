/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 *
 * @author Alexei Snytkine
 */
public class SavingsAccount {

    private static BigDecimal annualInterestRate;
    private BigDecimal savingsBalance;

    SavingsAccount(BigDecimal balance){
        //Avoiding overridable methods in constructors
        
        savingsBalance = balance;
    }
        
    SavingsAccount(double balance) {
        //Avoiding overridable methods in constructors
        savingsBalance = BigDecimal.valueOf(balance);
    }

    SavingsAccount() {
        this(0.0);
    }

    /**
     * Sets the balance to what it will be in a month
     */
    public void calculateMonthlyInterest() {
        addSavingsBalance(getSavingsBalance().
                multiply(annualInterestRate.divide(
                        BigDecimal.valueOf(12.0), 10, RoundingMode.HALF_UP)));
    }

    /**
     * Converts toAdd to BigDecimal then use:<br>
     * {@link addSavingsBalance(BigDecimal)}
     *
     * @param toAdd balance to add to savingsBalance
     */
    public void addSavingsBalance(double toAdd) {
        addSavingsBalance(BigDecimal.valueOf(toAdd));
    }

    /**
     * Add a BigDecimal value to savingsBalance
     *
     * @param toAdd balance to add to savingsBalance
     */
    public void addSavingsBalance(BigDecimal toAdd) {
        setSavingsBalance(savingsBalance.add(toAdd));
    }

    /**
     * Converts newRate to BigDecimal then use:<br>
     * {@link setAnnualInterestRate(BigDecimal)}
     *
     * @param newRate new annual interest rate
     */
    public static void setAnnualInterestRate(double newRate) {
        setAnnualInterestRate(BigDecimal.valueOf(newRate));
    }

    /**
     * @param newRate new annual interest rate
     */
    public static void setAnnualInterestRate(BigDecimal newRate) {
        annualInterestRate = newRate;
    }

    /**
     * @return the savingsBalance
     */
    public BigDecimal getSavingsBalance() {
        return savingsBalance;
    }

    /**
     * @param savingsBalance the savingsBalance to set
     */
    public void setSavingsBalance(double savingsBalance) {
        setSavingsBalance(BigDecimal.valueOf(savingsBalance));
    }

    /**
     *
     * @param savingsBalance the savingsBalance to set
     */
    public void setSavingsBalance(BigDecimal savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    /**
     *
     * @return Balance as a string
     */
    public String getBalanceString() {
        return NumberFormat.getCurrencyInstance().format(savingsBalance);
    }
    
    public static String getAnnualInterestRateString() {
        return NumberFormat.getNumberInstance().format(annualInterestRate);
    }
    
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
        System.out.printf("%-7s%15s%15s%n",
                "Month", 
                "Account1", 
                "Account2");
        
        int i;
        
        //Calculate Interest rate for 12 months
        for(i = 1; i < 13; i++){
            account1.calculateMonthlyInterest();
            account2.calculateMonthlyInterest();
            
            System.out.printf("%-7d%15s%15s%n", i, 
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
