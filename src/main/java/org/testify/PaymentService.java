package org.testify;

import org.testify.entity.BankService;
import org.testify.entity.BaseRateProvider;

public class PaymentService {

    private BankService bankService;

    public PaymentService(BankService bankService) {
        this.bankService = bankService;
    }

    /**
     * Calculates an adjusted interest rate for a loan based on the loan amount, borrower's credit score,
     * loan duration, and an external base rate. This method accounts for multiple factors, introducing complexity in testing.
     *
     * @param loanAmount the amount of the loan. Must be greater than 0.
     * @param creditScore the credit score of the borrower. Range: 300 (poor) to 850 (excellent).
     * @param durationYears the duration of the loan in years. Must be greater than 0.
     * @param baseRateProvider an interface to fetch the base rate, simulating an external dependency. The base rate is expected to be a positive percentage.
     * @return the adjusted interest rate based on the input parameters.
     * @throws IllegalArgumentException if any input parameter is invalid, specifically:
     *         - loanAmount must be positive.
     *         - creditScore must be between 300 and 850.
     *         - durationYears must be positive.
     */
    public static double calculateInterestRateAdjustment(double loanAmount, int creditScore, int durationYears, BaseRateProvider baseRateProvider) {
        if (loanAmount <= 0 || durationYears <= 0 || creditScore < 300 || creditScore > 850) {
            throw new IllegalArgumentException("Invalid input parameters.");
        }

        double baseRate = baseRateProvider.getBaseRate();

        double rateAdjustment = 0.0;

        if (loanAmount < 100000) {
            rateAdjustment += 0.5;
        } else if (loanAmount >= 100000 && loanAmount <= 500000) {
            rateAdjustment += 0.25;
        }

        // Adjust based on credit score
        if (creditScore < 600) {
            rateAdjustment += 1.5;
        } else if (creditScore >= 600 && creditScore < 700) {
            rateAdjustment += 1.0;
        } else if (creditScore >= 700 && creditScore < 750) {
            rateAdjustment += 0.5;
        }

        // Adjust based on loan duration
        if (durationYears <= 5) {
            rateAdjustment += 0.25;
        } else if (durationYears > 15) {
            rateAdjustment -= 0.25; // Longer terms get a slight reduction
        }

        return baseRate + rateAdjustment;
    }

    /**
     * Attempts to process a payment transaction.
     *
     * @param fromAccountId the ID of the payer's account
     * @param toAccountId the ID of the payee's account
     * @param amount the amount to be transferred
     * @return true if the payment is processed successfully, false if there are insufficient funds
     * @throws IllegalArgumentException if the amount is negative
     */
    public boolean makePayment(String fromAccountId, String toAccountId, double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }

        boolean hasFunds = bankService.hasSufficientFunds(fromAccountId, amount);
        if (!hasFunds) {
            return false; // Insufficient funds
        }

        return bankService.processPayment(fromAccountId, toAccountId, amount);
    }
}

