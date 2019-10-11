package lab;

/**
 * This is class for creating our fraction with include numerator and
 * denominator
 */

/*
 * Start Developing
 */

public class Fraction {

    private int numerator;
    private int denominator;

    /**
     * The function which returns the numerator
     * 
     * @return numerator
     */
    public int GetN() {
        return numerator;
    }

    /**
     * The function which returns the denominator
     * 
     * @return denominator
     */
    public int GetD() {
        return denominator;
    }

    /**
     * The function which returns the value
     * 
     * @return value
     */
    public double GetValue() {
        return ((double) this.numerator) / this.denominator;
    }

    /**
     * This is the constructor of our fraction in which the fraction is also reduced
     * 
     * @param num   numerator
     * @param denom denominator
     */
    public Fraction(int num, int denom) {
        this.numerator = num;
        this.denominator = denom;

        if (denom == 0) {
            throw new ArithmeticException("Denominator cannot be equal to zero");
        }

        int limit = Math.min(num, denom);

        for (int i = 2; i <= limit; i++) // сокращение дроби
        {
            while ((num % i == 0) && (denom % i == 0)) {
                num = num / i;
                denom = denom / i;
            }
        }

        this.numerator = num; // перезаписываем числитель
        this.denominator = denom; // перезаписываем знаменатель

    }

    /**
     * This function returns the sum of two fractions in fractional form, receives
     * two fractions at the input and returns the third
     * 
     * @param fraction1 first fraction
     * @param fraction2 second fraction
     * @return fraction3 result of sum
     */
    public Fraction Summ_of_2_fraction(Fraction fraction1, Fraction fraction2) // использую в полиноме
    {
        int numerator = 0;
        int denomerator = 0;

        if (fraction1.GetD() == fraction2.GetD()) // если числители равны 0;
        {
            numerator = fraction1.GetN() + fraction2.GetN();
            denomerator = fraction1.GetD();
        } else {
            numerator = fraction1.GetN() * fraction2.GetD() + fraction2.GetN() * fraction1.GetD();
            denomerator = fraction1.GetD() * fraction2.GetD();
        }

        Fraction fraction3 = new Fraction(numerator, denomerator);
        return fraction3;
    }

}