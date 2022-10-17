package com.example.aaaa.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {
    Monomial mon1 = new Monomial(5, 3);
    Monomial mon2 = new Monomial(5, 2);
    Monomial mon3 = new Monomial(5, 1);
    Monomial mon4 = new Monomial(2, 2);
    Monomial mon5 = new Monomial(2, 1);
    Polynomial p1 = new Polynomial();
    Polynomial p2 = new Polynomial();

    @Test
    void add() {
        p1.getPolynom().add(mon1);
        p1.getPolynom().add(mon2);
        p1.getPolynom().add(mon3);
        p2.getPolynom().add(mon4);
        p2.getPolynom().add(mon5);
        p1.add(p2);
        assertTrue(p1.displayPolynomResult().equals("+5x^3 +7x^2 +7x "));
    }

    @Test
    void subtract() {
        p1.getPolynom().add(mon1);
        p1.getPolynom().add(mon2);
        p1.getPolynom().add(mon3);
        p2.getPolynom().add(mon4);
        p2.getPolynom().add(mon5);
        p1.subtract(p2);
        assertTrue(p1.displayPolynomResult().equals("+5x^3 +3x^2 +3x "));
    }

    @Test
    void multiply() {
        p1.getPolynom().add(mon1);
        p1.getPolynom().add(mon2);
        p1.getPolynom().add(mon3);
        p2.getPolynom().add(mon4);
        p2.getPolynom().add(mon5);
        p1 = p1.multiply(p2);
        assertTrue(p1.displayPolynomResult().equals("+10x^5 +20x^4 +20x^3 +10x^2 "));
    }

    @Test
    void derivateMethod() {
        p1.getPolynom().add(mon1);
        p1.getPolynom().add(mon2);
        p1.getPolynom().add(mon3);
        p2.getPolynom().add(mon4);
        p2.getPolynom().add(mon5);
        p1.derivateMeth();
        assertTrue(p1.displayPolynomResult().equals("+15x^2 +10x +5 "));
    }

    @Test
    void integrate() {
        p1.getPolynom().add(mon1);
        p1.getPolynom().add(mon2);
        p1.getPolynom().add(mon3);
        p2.getPolynom().add(mon4);
        p2.getPolynom().add(mon5);
        p1.integrate();
        assertTrue(p1.displayPolynomResult().equals("+1.25x^4 +1.6666666666666667x^3 +2.5x^2 "));
    }

    @Test
    void divide() {
        p1.getPolynom().add(mon1);
        p1.getPolynom().add(mon2);
        p1.getPolynom().add(mon3);
        p2.getPolynom().add(mon4);
        p2.getPolynom().add(mon5);
        p1 = p1.divide(p2);
        assertTrue(p1.displayPolynomResult().equals("+2.5x "));
    }
}