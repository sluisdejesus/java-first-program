package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {
    private float [] credits;
    private float [] debits;

    public SavingsCalculator(float [] credits, float [] debits){

        this.credits = credits;
        this.debits = debits;
    }

    private float sumOfCredits(){
        float sum = 0.0f;
        for (float credit : credits){
            sum += credit;
        }
        return sum;
    }

    private float sumOfDebits(){
        float sum = 0.0f;
        for (float debit : debits){
            sum += debit;
        }
        return sum;
    }

    private static int remainingDaysInMonth(LocalDate date){
        YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
        int totalDaysInMonth = yearMonth.lengthOfMonth();
        int remainingDays = totalDaysInMonth - date.getDayOfMonth();

        return remainingDays;
    }

    public float calculate(){
        return sumOfCredits() - sumOfDebits();
    }

    public static void main(String[] args ){
        final String[] creditsAsStrings = args[0].split(",");
        final String[] debitsAsStrings = args[0].split(",");

        final float[] credits = new float[creditsAsStrings.length];
        final float[] debits = new float[debitsAsStrings.length];

        for (int index = 0; index < creditsAsStrings.length; index++){
            credits[index] = Float.parseFloat(creditsAsStrings[index]);
        };

        for (int index = 0; index < debitsAsStrings.length; index++){
            debits[index] = Float.parseFloat(debitsAsStrings[index]);
        }

        final SavingsCalculator calculator = new SavingsCalculator(credits, debits);
        float netSavings = calculator.calculate();
        System.out.println("Net Savings = " + netSavings + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now()));

    }
}
