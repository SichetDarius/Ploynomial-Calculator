package com.example.aaaa.models;


public class Monomial {
    private Number coefficient;
    private int exponent;

    public Monomial(double coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public Monomial(Monomial other) {
        this((Double) other.coefficient, other.exponent);
    }

    public Number getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Number coefficient) {
        this.coefficient = coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public void printMonomial() {
        if (coefficient.doubleValue() > 0) {
            System.out.print("+" + coefficient + "x^" + exponent + " ");
        } else if (coefficient.doubleValue() < 0) {
            System.out.print(coefficient + "x^" + exponent + " ");
        }
    }

    public String printMonomialResult() {
        String s = new String();
        if (exponent == 0) {
            if (coefficient.doubleValue() > 0) {
                if (coefficient.doubleValue() == coefficient.intValue()) {
                    s = s + "+" + coefficient.intValue() + " ";
                } else {
                    s = s + "+" + coefficient + " ";
                }
                return s;
                //System.out.print("+"+coefficient+"x^"+exponent+" ");
            } else if (coefficient.doubleValue() < 0) {
                if (coefficient.doubleValue() == coefficient.intValue()) {
                    s = s + coefficient.intValue();
                } else {
                    s = s + coefficient;
                }
                return s;
            }
        } else if (exponent == 1) {
            if (coefficient.doubleValue() > 0) {
                if (coefficient.doubleValue() == coefficient.intValue()) {
                    s = s + "+" + coefficient.intValue() + "x ";
                } else {
                    s = s + "+" + coefficient + "x ";
                }
                return s;
                //System.out.print("+"+coefficient+"x^"+exponent+" ");
            } else if (coefficient.doubleValue() < 0) {
                if (coefficient.doubleValue() == coefficient.intValue()) {
                    s = s + coefficient.intValue() + "x ";
                } else {
                    s = s + coefficient + "x ";
                }
                return s;
                //System.out.print(coefficient+"x^"+exponent+" ");
            }
        } else if (coefficient.doubleValue() > 0) {
            if (coefficient.doubleValue() == coefficient.intValue()) {
                s = s + "+" + coefficient.intValue() + "x^" + exponent + " ";
            } else {
                s = s + "+" + coefficient + "x^" + exponent + " ";
            }
            return s;
            //System.out.print("+"+coefficient+"x^"+exponent+" ");
        } else if (coefficient.doubleValue() < 0) {
            if (coefficient.doubleValue() == coefficient.intValue()) {
                s = s + coefficient.intValue() + "x^" + exponent + " ";
            } else {
                s = s + coefficient + "x^" + exponent + " ";
            }
            return s;
        }
        return s;
    }
}
