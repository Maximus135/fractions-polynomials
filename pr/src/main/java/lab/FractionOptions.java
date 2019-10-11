package lab;

import java.util.ArrayList;
/*
    Added fiture 4 amazing
    New cool feature not fiture!
*/

/**
 * This class for working with an array of the functions which includes get max
 * fraction, get min fraction, get bigger than, get less than, prints our
 * fractions set.
 */

public class FractionOptions {
    private ArrayList<Fraction> fractions; // масив дробей

    private Fraction MaxValue;
    private Fraction MinValue;

    private Fraction Bigger;
    private Fraction Less;

    /**
     * This is the constructor of creating array list of fractions
     */
    public FractionOptions() {
        fractions = new ArrayList<Fraction>();

    }

    /**
     * Add fraction at the array of the fraction Options
     * 
     * @param n fraction which we want to add
     */
    public void AddFraction(Fraction n) {
        fractions.add(n);
    }

    /**
     * Console output our fraction array
     */
    public void PrintSet() // вывод списка дробей
    {
        for (int i = 0; i < fractions.size(); i++) {
            System.out.println(i + 1);
            System.out.print(fractions.get(i).GetN());
            System.out.print("/");
            System.out.println(fractions.get(i).GetD());
        }
    }

    /**
     * Return the bigest fraction from our array
     * 
     * @return max value fraction
     */
    public Fraction getMax() // получение наибольшего значения дроби
    {
        MaxValue = fractions.get(0);
        for (int i = 0; i < fractions.size(); i++) {
            if (MaxValue.GetValue() < fractions.get(i).GetValue())
                MaxValue = fractions.get(i);
        }
        return MaxValue;
    }

    /**
     * Return the less fraction from our array
     * 
     * @return min value fraction
     */
    public Fraction getMin() // получение наименьшего значения дроби
    {
        MinValue = fractions.get(0);
        for (int i = 0; i < fractions.size(); i++) {
            if (MinValue.GetValue() > fractions.get(i).GetValue())
                MinValue = fractions.get(i);
        }
        return MinValue;

    }

    /**
     * Return counter which shows us how many fractions bigger than fraction which
     * we print at the console
     * 
     * @param n fraction to compare
     * @return counter
     */
    public int Bigger_than(Fraction n) // выводит колличество дробей больше заданной
    {
        Bigger = n;

        int counter = 0;

        for (int i = 0; i < fractions.size(); i++) {
            if (Bigger.GetValue() < fractions.get(i).GetValue())
                counter++;

        }

        return counter;
    }

    /**
     * Return counter which shows us how many fractions less than fraction which we
     * print at the console
     * 
     * @param n fraction to compare
     * @return counter
     */
    public int Less_than(Fraction n) // выводит колличество дробей меньше заданной
    {
        Less = n;

        int counter = 0;

        for (int i = 0; i < fractions.size(); i++) {
            if (Less.GetValue() > fractions.get(i).GetValue())
                counter++;

        }

        return counter;
    }

    /**
     * This function return sum of all fraction in the array in fraction form.
     * 
     * @return fraction of the sum
     */
    public Fraction SummaDrob() // функция суммы дробей для получения ответа в дробной форме()
    {
        int SumNumer = 0;
        int SumDenomer = 0;

        for (int i = 0; i < fractions.size(); i++) {
            if (i == 0) // берем первую дробь
            {
                SumNumer = fractions.get(i).GetN();

                SumDenomer = fractions.get(i).GetD();
            }

            if (i != 0 && fractions.get(i - 1).GetD() != fractions.get(i).GetD()) // если знаменатели не равны
            {

                if (i == 1) // если вторая дробь
                {
                    SumDenomer = fractions.get(i).GetD() * SumDenomer;
                    SumNumer = fractions.get(i - 1).GetN() * fractions.get(i).GetD()
                            + fractions.get(i - 1).GetD() * fractions.get(i).GetN();
                } else {
                    SumNumer = SumNumer * fractions.get(i).GetD() + SumDenomer * fractions.get(i).GetN();
                    SumDenomer = SumDenomer * fractions.get(i).GetD();
                }
            }

            if (i != 0 && fractions.get(i - 1).GetD() == fractions.get(i).GetD()) // если знаменатели ровны

            {

                SumNumer = SumNumer + fractions.get(i).GetN();

            }

        }

        Fraction result_fraction = new Fraction(SumNumer, SumDenomer); // возвращаем дробь суммы

        return result_fraction;
    }

    public Fraction divisionFraction() {
        int SumNumer = 0;
        int SumDenomer = 0;
        for (int i = 0; i < fractions.size(); i++) {
            if (i == 0) // берем первую дробь
            {
                SumNumer = fractions.get(i).GetN();
                SumDenomer = fractions.get(i).GetD();
            } else {
                SumNumer = SumNumer * fractions.get(i).GetD();
                SumDenomer = SumDenomer * fractions.get(i).GetN();
            }
        }
        Fraction result_fraction = new Fraction(SumNumer, SumDenomer); // возвращаем дробь частного
        return result_fraction;
    }

    public Fraction subtractionFraction() {
        int SumNumer = 0;
        int SumDenomer = 0;
        for (int i = 0; i < fractions.size(); i++) {
            if (i == 0) // берем первую дробь
            {
                SumNumer = fractions.get(i).GetN();
                SumDenomer = fractions.get(i).GetD();
            }
            if (i != 0 && fractions.get(i).GetD() == SumDenomer) {
                SumNumer = SumNumer - fractions.get(i).GetN();
            }
            if (i != 0 && fractions.get(i).GetD() != SumDenomer) {
                SumNumer = SumNumer * fractions.get(i).GetD() - SumDenomer * fractions.get(i).GetN();
                SumDenomer = SumDenomer * fractions.get(i).GetD();
            }

        }
        Fraction result_fraction = new Fraction(SumNumer, SumDenomer); // возвращаем дробь разности
        return result_fraction;

    }

}