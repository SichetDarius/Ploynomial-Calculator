package com.example.aaaa.controller;

import com.example.aaaa.models.Monomial;
import com.example.aaaa.models.Polynomial;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TheController implements Initializable {


    @FXML
    private Label wrongIputMessage;
    @FXML
    private TextField secondPolynomialField;
    @FXML
    private TextField resultField;
    @FXML
    private TextField firstPolynomialField;

    // public void

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        wrongIputMessage.setVisible(false);

        //wrong input message set to false ;
    }

    public void onAdditionButtonClick(ActionEvent actionEvent) {
        String s1 = firstPolynomialField.getText();
        String s2 = secondPolynomialField.getText();
        Polynomial poli1 = new Polynomial();
        poli1.splitString(s1);
        Polynomial poli3;
        poli3 = poli1;
        Polynomial poli2 = new Polynomial();
        poli2.splitString(s2);
        poli3.add(poli2);
        resultField.setText(poli3.displayPolynomResult());

        //wrongIputMessage.setVisible(true);
    }

    public void onSubtractionButtonClick(ActionEvent actionEvent) {
        String s1 = firstPolynomialField.getText();
        String s2 = secondPolynomialField.getText();
        Polynomial poli1 = new Polynomial();
        poli1.splitString(s1);
        Polynomial poli3;
        poli3 = poli1;
        Polynomial poli2 = new Polynomial();
        poli2.splitString(s2);
        poli3.subtract(poli2);
        resultField.setText(poli3.displayPolynomResult());
    }

    public void onMultiplicationButtonClick(ActionEvent actionEvent) {
        String s1 = firstPolynomialField.getText();
        String s2 = secondPolynomialField.getText();
        Polynomial poli1 = new Polynomial();
        poli1.splitString(s1);
        Polynomial poli3;
        poli3 = poli1;
        Polynomial poli2 = new Polynomial();
        poli2.splitString(s2);
        poli3 = poli3.multiply(poli2);
        resultField.setText(poli3.displayPolynomResult());
    }

    public void onDivisionButtonClick(ActionEvent actionEvent) {
        String s1 = firstPolynomialField.getText();
        String s2 = secondPolynomialField.getText();
        Polynomial poli1 = new Polynomial();
        poli1.splitString(s1);
        Polynomial poli3;
        poli3 = poli1;
        Polynomial poli2 = new Polynomial();
        poli2.splitString(s2);
        poli3 = poli3.divide(poli2);
        resultField.setText(poli3.displayPolynomResult());
    }

    public void onDerivativeButtonClick(ActionEvent actionEvent) {
        String s1 = firstPolynomialField.getText();
        Polynomial poli1 = new Polynomial();
        poli1.splitString(s1);
        Polynomial poli3;
        poli3 = poli1;
        poli3.derivateMeth();
        resultField.setText(poli3.displayPolynomResult());
    }

    public void onIntegrateButtonClick(ActionEvent actionEvent) {
        String s1 = firstPolynomialField.getText();
        Polynomial poli1 = new Polynomial();
        poli1.splitString(s1);
        Polynomial poli3;
        poli3 = poli1;
        //Polynomial poli2=new Polynomial();
        //poli2.splitString(s2);
        poli3.integrate();
        resultField.setText(poli3.displayPolynomResult());
        // wrongIputMessage.setVisible(true);
    }
}
