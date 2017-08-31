/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 *
 * @author Alexei Snytkine
 */
public class SavingsAccount {

    private static BigDecimal annualInterestRate;
    private BigDecimal savingsBalance;

    SavingsAccount(double balance) {
        setSavingsBalance(balance);
    }

    SavingsAccount() {
        this(0.0);
    }

    /**
     * Sets the balance to what it will be in a month
     */
    public void calculateMonthlyInterest() {
        addSavingsBalance(getSavingsBalance().
                multiply(annualInterestRate.divide(BigDecimal.valueOf(12.0))));
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
    public static void setAnnualInterestRate(BigDecimal newRate){
        annualInterestRate = newRate;
    }

    /**
     * @return the savingsBalance
     */
    public BigDecimal getSavingsBalance() {
        return annualInterestRate;
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
    public void setSavingsBalance(BigDecimal savingsBalance){
        this.savingsBalance = savingsBalance;
    }
    
    /**
     * 
     * @return Balance as a string
     */
    public String getBalanceString(){
        return NumberFormat.getCurrencyInstance().format(savingsBalance);
    }
}
