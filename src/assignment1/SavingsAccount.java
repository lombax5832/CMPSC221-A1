/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.math.BigDecimal;

/**
 *
 * @author aps5601
 */
public class SavingsAccount {

    private static double annualInterestRate;
    private double savingsBalance;

    
    SavingsAccount(double balance){
        savingsBalance = balance;
    }
    
    SavingsAccount(){
        this(0.0);
    }
    
    public static void setAnnualInterestRate(double newRate) {
        annualInterestRate = newRate;
    }

}
