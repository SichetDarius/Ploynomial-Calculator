package com.example.aaaa.models;

import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private ArrayList<Monomial> polynom = new ArrayList<>();

    public Polynomial() {
    }

    public ArrayList<Monomial> getPolynom() {
        return polynom;
    }

    public void sortDegree() {
        Collections.sort(polynom, new Comparator<Monomial>() {
            @Override
            public int compare(Monomial o1, Monomial o2) {
                if (o1.getExponent() > o2.getExponent()) {
                    return -1;
                } else if (o1.getExponent() == o2.getExponent()) {
                    return 0;
                } else return 1;
            }
        });
    }

    public void simplifyMethod() {
        Iterator<Monomial> myIterator = this.getPolynom().iterator();
        Monomial m1 = myIterator.next();
        while (myIterator.hasNext()) {
            Monomial m2 = myIterator.next();
            if (m1.getExponent() == m2.getExponent()) {
                m1.setCoefficient(m1.getCoefficient().doubleValue() + m2.getCoefficient().doubleValue());
                myIterator.remove();
            } else {
                m1 = m2;
            }

        }
    }

    public void displayPolynom() {
        polynom.forEach(new Consumer<Monomial>() {
            @Override
            public void accept(Monomial monomial) {
                monomial.printMonomial();
            }
        });
    }

    public String displayPolynomResult() {
        final String[] result = {new String()};
        polynom.forEach(new Consumer<Monomial>() {
            @Override
            public void accept(Monomial monomial) {
                result[0] = result[0] + monomial.printMonomialResult();
            }
        });
        return result[0];
    }


    public void addMonomial(Monomial monomial) {
        this.sortDegree();
        final boolean[] k = {false};
        this.getPolynom().forEach(new Consumer<Monomial>() {
            @Override
            public void accept(Monomial monomial1) {
                if (monomial.getExponent() == monomial1.getExponent()) {
                    monomial1.setCoefficient(monomial.getCoefficient().doubleValue() + monomial1.getCoefficient().doubleValue());
                    k[0] = true;
                }
            }
        });
        if (!k[0]) {
            this.getPolynom().add(monomial);
        }
        this.sortDegree();
    }

    public void add(Polynomial p2) {
        this.simplifyMethod();
        Polynomial finalSum = this;

        p2.getPolynom().forEach(new Consumer<Monomial>() {
            @Override
            public void accept(Monomial monomial) {
                finalSum.addMonomial(monomial);
            }
        });
        finalSum.sortDegree();
        finalSum.simplifyMethod();
        finalSum.displayPolynom();
    }

    public void subtractMonomial(Monomial monomial) {
        this.sortDegree();
        final boolean[] k = {false};
        this.getPolynom().forEach(new Consumer<Monomial>() {
            @Override
            public void accept(Monomial monomial1) {
                if (monomial.getExponent() == monomial1.getExponent()) {
                    monomial1.setCoefficient(monomial1.getCoefficient().doubleValue() - monomial.getCoefficient().doubleValue());
                    k[0] = true;
                }
            }
        });
        if (!k[0]) {
            Monomial m3 = new Monomial(monomial.getCoefficient().doubleValue() * (-1), monomial.getExponent());
            this.getPolynom().add(m3);
        }
        this.sortDegree();
    }

    public void removeTerm() {
        Iterator<Monomial> myIterator = this.getPolynom().iterator();
        while (myIterator.hasNext()) {
            Monomial monomial = myIterator.next();
            if (monomial.getCoefficient().doubleValue() == 0.0) {
                myIterator.remove();
            }
        }
    }

    public void subtract(Polynomial p2) {
        this.simplifyMethod();
        Polynomial finalDiff = this;
        p2.getPolynom().forEach(new Consumer<Monomial>() {
            @Override
            public void accept(Monomial monomial) {
                finalDiff.subtractMonomial(monomial);
            }
        });
        finalDiff.sortDegree();
        finalDiff.simplifyMethod();
        finalDiff.displayPolynom();
    }

    public Polynomial subtract1(Polynomial p1, Polynomial p2) {
        Polynomial finalDiff = p1;
        p2.getPolynom().forEach(new Consumer<Monomial>() {
            @Override
            public void accept(Monomial monomial) {
                finalDiff.subtractMonomial(monomial);
            }
        });
        finalDiff.sortDegree();
        finalDiff.simplifyMethod();
        return finalDiff;
    }

    public Polynomial multiply(Polynomial p2) {
        this.sortDegree();
        this.simplifyMethod();
        Polynomial p3 = new Polynomial();
        Monomial monomial = new Monomial(0, 0);
        this.getPolynom().forEach(new Consumer<Monomial>() {
            @Override
            public void accept(Monomial monomial1) {
                p2.getPolynom().forEach(new Consumer<Monomial>() {
                    @Override
                    public void accept(Monomial monomial2) {
                        monomial.setCoefficient(monomial1.getCoefficient().doubleValue() * monomial2.getCoefficient().doubleValue());
                        monomial.setExponent(monomial1.getExponent() + monomial2.getExponent());
                        p3.getPolynom().add(new Monomial(monomial));
                    }
                });
            }
        });
        p3.sortDegree();
        p3.simplifyMethod();
        p3.displayPolynom();
        return p3;
    }

    public void derivateMeth() {
        this.sortDegree();
        this.simplifyMethod();
        this.getPolynom().forEach(new Consumer<Monomial>() {
            @Override
            public void accept(Monomial monomial1) {
                monomial1.setCoefficient(monomial1.getCoefficient().doubleValue() * monomial1.getExponent());
                monomial1.setExponent(monomial1.getExponent() - 1);
            }
        });
    }


    public void integrate() {
        this.sortDegree();
        this.simplifyMethod();
        this.getPolynom().forEach(new Consumer<Monomial>() {
            @Override
            public void accept(Monomial monomial1) {
                monomial1.setCoefficient(monomial1.getCoefficient().doubleValue() / (monomial1.getExponent() + 1));
                monomial1.setExponent(monomial1.getExponent() + 1);
            }
        });
    }

    public int comparePolynomials(Polynomial p2) {
        Iterator<Monomial> iterator1 = this.getPolynom().iterator();
        Iterator<Monomial> iterator2 = p2.getPolynom().iterator();
        Monomial m1 = iterator1.next();
        Monomial m2 = iterator2.next();
        if (m1.getExponent() > m2.getExponent()) {
            return 1;
        } else if (m1.getExponent() < m2.getExponent()) {
            return -1;
        } else if (m1.getExponent() == m2.getExponent()) {
            return 0;
        }
        return 0;
    }

    public Polynomial divide(Polynomial p2) {
        this.sortDegree();
        p2.sortDegree();
        this.simplifyMethod();
        p2.simplifyMethod();
        Polynomial p3 = this;
        Polynomial p4 = p2;
        Polynomial result = new Polynomial();
        Monomial monomialR = new Monomial(0, 0);
        Monomial monomialResult = new Monomial(0, 0);
        result.getPolynom().add(monomialR);
        while (p3.comparePolynomials(p4) != -1) {
            monomialResult.setCoefficient(p3.getPolynom().get(0).getCoefficient().doubleValue() / p4.getPolynom().get(0).getCoefficient().doubleValue());
            monomialResult.setExponent(p3.getPolynom().get(0).getExponent() - p4.getPolynom().get(0).getExponent());
            result.getPolynom().add(new Monomial(monomialResult));
            Polynomial intermediate = new Polynomial();
            p4.getPolynom().forEach(new Consumer<Monomial>() {
                @Override
                public void accept(Monomial monomial) {
                    intermediate.getPolynom().add(new Monomial(monomial.getCoefficient().doubleValue() * monomialResult.getCoefficient().doubleValue(), monomial.getExponent() + monomialResult.getExponent()));
                }
            });
            intermediate.simplifyMethod();
            p3.subtract1(p3, intermediate);
            p3.removeTerm();
            if (p3.getPolynom().size() == 0) break;
        }
        result.sortDegree();
        result.simplifyMethod();
        System.out.println("Quotient:");
        result.displayPolynom();

        if (p3.getPolynom().size() != 0) {
            p3.sortDegree();
            p3.simplifyMethod();
            System.out.println("\nRest:");
            p3.displayPolynom();
        } else {
            System.out.println("\nRest:0");
        }
        return result;
    }

    public void splitString(String string) {
        String delimiters1 = "-?\\d*x\\^?\\d*|-?\\d+\\.\\d+x\\^?\\d*|x\\^?\\d*|-?\\d+\\.\\d+|-?\\d+";
        Pattern pattern = Pattern.compile(delimiters1);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            String s = matcher.group();
            if ("x".equals(s)) {
                this.getPolynom().add(new Monomial(1, 1));
            } else if ("-x".equals(s)) {
                this.getPolynom().add(new Monomial(-1, 1));
            } else {
                List<String> vals = List.of(s.split("x\\^?|x?\\^"));
                if (vals.get(0).equals(s)) {
                    this.getPolynom().add(new Monomial(Double.parseDouble(vals.get(0)), 0));
                } else if ("x".equals(s.substring(s.length() - 1))) {
                    this.getPolynom().add(new Monomial(Double.parseDouble(vals.get(0)), 1));
                } else if (vals.get(0).equals("")) {
                    this.getPolynom().add(new Monomial(1, Integer.parseInt(vals.get(1))));
                } else {
                    if ("-".equals(vals.get(0))) {
                        this.getPolynom().add(new Monomial(-1, Integer.parseInt(vals.get(1))));
                    } else {
                        this.getPolynom().add(new Monomial(Double.parseDouble(vals.get(0)), Integer.parseInt(vals.get(1))));
                    }
                }
            }
        }
    }
}
