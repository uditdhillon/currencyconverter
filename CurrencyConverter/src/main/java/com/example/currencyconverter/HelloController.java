package com.example.currencyconverter;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField amountTextField;

    @FXML
    private TextField convertedAmountTextField;

    @FXML
    private ComboBox<String> sourceCurrencyComboBox;

    @FXML
    private ComboBox<String> targetCurrencyComboBox;

    @FXML
    private Button convertButton;

    // Add your hardcoded conversion rates
    private static final double USD_TO_EUR_RATE = 0.85;
    private static final double USD_TO_GBP_RATE = 0.74;

    @FXML
    private void initialize() {
        // Set up ComboBox items
        sourceCurrencyComboBox.getItems().addAll("USD", "EUR", "GBP");
        targetCurrencyComboBox.getItems().addAll("USD", "EUR", "GBP");
    }

    @FXML
    private void handleConvertButtonAction() {
        try {
            // Retrieve input values
            double amount = Double.parseDouble(amountTextField.getText());
            String sourceCurrency = sourceCurrencyComboBox.getValue();
            String targetCurrency = targetCurrencyComboBox.getValue();

            // Perform conversion
            double convertedAmount = convertCurrency(amount, sourceCurrency, targetCurrency);

            // Display the converted amount
            convertedAmountTextField.setText(String.format("%.2f", convertedAmount));
        } catch (NumberFormatException e) {
            // Handle invalid input (non-numeric)
            // You may want to show an alert or handle it according to your application's requirements
            e.printStackTrace();
        }
    }

    private double convertCurrency(double amount, String sourceCurrency, String targetCurrency) {
        // Perform conversion based on hardcoded rates
        if ("USD".equals(sourceCurrency) && "EUR".equals(targetCurrency)) {
            return amount * USD_TO_EUR_RATE;
        } else if ("USD".equals(sourceCurrency) && "GBP".equals(targetCurrency)) {
            return amount * USD_TO_GBP_RATE;
        } else {
            // Add more conversion cases as needed
            return amount;
        }
    }
}