package lab;

import java.util.ArrayList;
import static java.lang.Math.*;

/**
 * This class for working with polynomials array
 */
public class Polynomial {

    private ArrayList<Fraction> fractions;

    /**
     * This is the constructor of polynomial (coefficients arrays)
     */
    public Polynomial() // массив полиномов
    {
        fractions = new ArrayList<Fraction>();

    }

    /**
     * This function add coefficients ro array
     * 
     * @param n fraction (coefficients)
     */
    public void AddCoff(Fraction n) // массив коэфф (дробей)
    {
        fractions.add(n);
    }

    /**
     * This function return double sum of our polynomial
     * 
     * @param X      passed parameter x
     * @param degree degree of our polynomial
     * @return sum of the polynomial
     */
    public double sum(double X, int degree) {

        double x = X;
        int degr = degree;
        double Summ = 0;

        for (int i = 0; i <= degr; i++) {
            Summ = fractions.get(i).GetValue() * pow(x, i) + Summ;

        }

        return Summ;
    }

    /**
     * Return our polynomial which includes all polynomial (sum)
     * 
     * @param size max degree of our polynomial
     * @param Pops our polynomial
     * @return
     */
    public String output(int size, Polynomial Pops) // строим строку вывода полинома
    {

        StringBuilder sb = new StringBuilder();
        for (int i = size; i >= 0; i--) {
            double value = Pops.fractions.get(i).GetValue();
            if (value != 0) {
                if (value > 0) {
                    sb.append(value);
                } else {
                    sb.append("(").append(value).append(")");
                }

                sb.append(" * ").append("x^").append(i).append(" + ");
            }

        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    /**
     * This function return polynomial which includes the sum of 2 polynomials
     * 
     * @param Polynomial_1 next polynomial, the previous polynomial already in class
     * @return polynomial of the sum
     */
    public Polynomial Summ_Coff(Polynomial Polynomial_1) {
        Polynomial Polynomial_3 = new Polynomial();

        if (Polynomial_1.fractions.size() > this.fractions.size()) {
            Polynomial_3.fractions.addAll(Polynomial_1.fractions);
        } else {
            Polynomial_3.fractions.addAll(this.fractions);
        }

        for (int i = 0; i < min(Polynomial_1.fractions.size(), this.fractions.size()); i++) {

            Fraction fraction1 = new Fraction(Polynomial_1.fractions.get(i).GetN(),
                    Polynomial_1.fractions.get(i).GetD());
            Fraction fraction2 = new Fraction(this.fractions.get(i).GetN(), this.fractions.get(i).GetD());
            Polynomial_3.fractions.set(i, fraction1.Summ_of_2_fraction(fraction1, fraction2));

        }

        return Polynomial_3;

    }

}