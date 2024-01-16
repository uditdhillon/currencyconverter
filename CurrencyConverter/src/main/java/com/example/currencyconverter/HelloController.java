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


    @FXML
    private void initialize() {
        // Set up ComboBox items
        sourceCurrencyComboBox.getItems().addAll("USD", "EUR", "GBP","RUB");
        targetCurrencyComboBox.getItems().addAll("USD", "EUR", "GBP","RUB");
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
            e.printStackTrace();
        }
    }

    private double convertCurrency(double amount, String sourceCurrency, String targetCurrency) {
        // Perform conversion based on hardcoded rates
        if ("USD".equals(sourceCurrency) && "EUR".equals(targetCurrency)) {
            return amount * 0.92;
        } else if ("USD".equals(sourceCurrency) && "GBP".equals(targetCurrency)) {
            return amount * 0.79;
        } else if("USD".equals(sourceCurrency) && "RUB".equals(targetCurrency)) {
            return amount * 88.10;
        }
        else if ("EUR".equals(sourceCurrency) && "USD".equals(targetCurrency)) {
            return amount * 1.09;
        } else if ("EUR".equals(sourceCurrency) && "GBP".equals(targetCurrency)) {
            return amount * 0.86;
        } else if("EUR".equals(sourceCurrency) && "RUB".equals(targetCurrency)) {
            return amount * 95.73;
        }
        else if ("GBP".equals(sourceCurrency) && "USD".equals(targetCurrency)) {
            return amount * 1.26;
        } else if ("GBP".equals(sourceCurrency) && "EUR".equals(targetCurrency)) {
            return amount * 1.16;
        } else if("GBP".equals(sourceCurrency) && "RUB".equals(targetCurrency)) {
            return amount * 111.22;
        } else if ("RUB".equals(sourceCurrency) && "USD".equals(targetCurrency)) {
            return amount * 0.011;
        } else if ("RUB".equals(sourceCurrency) && "GBP".equals(targetCurrency)) {
            return amount * 0.009;
        } else if("RUB".equals(sourceCurrency) && "EUR".equals(targetCurrency)) {
            return amount * 0.010;
        } else{

            return amount;
        }
    }
}