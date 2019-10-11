package lab;

import java.io.*;
import java.util.Scanner;

/**
 * Laboratory work number 1
 * 
 * @author Maxim
 * @version %I% , %G%
 */
public class Main {
    /**
     * This is main function, where we start our code. In this code, we opening data
     * files and scan some information from the user console.
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        File fractions = new File("C:\\Users\\maxim\\Desktop\\project1\\pr\\src\\main\\java\\lab\\fractions.txt");
        Scanner scanner = new Scanner(fractions);
        Scanner in = new Scanner(System.in);

        File fraction_res = new File(
                "C:\\Users\\maxim\\Desktop\\project1\\pr\\src\\main\\java\\lab\\fractions_res.txt");
        FileWriter writer = new FileWriter(fraction_res, false);

        FractionOptions scc = new FractionOptions();
        System.out.println("it's alive");
        int cal = scanner.nextInt();

        for (int i = 0; i < cal; i++) // считываем
        {
            int a = scanner.nextInt();
            char ch = scanner.next().charAt(0);// считываем разделитель
            int b = scanner.nextInt();
            Fraction sc = new Fraction(a, b);
            scc.AddFraction(sc); // кидаем дробь в массив дробей
        }

        System.out.println("Набор дробей");
        scc.PrintSet(); // выводим набор дробей в консоль
        writer.write("Сумма дробей в дробной форме");
        writer.write("\n");
        writer.write(scc.SummaDrob().GetN() + "");
        writer.write("/");
        writer.write(scc.SummaDrob().GetD() + ""); // с интом всё работает нормально без преобразование к стрингу
        writer.write("\n");
        writer.write("Максимум из набора");
        writer.write("\n");
        writer.write(String.format("%.3f", scc.getMax().GetValue())); // выводим максимум из набора (3 цифры после
                                                                      // запятой)
        writer.write("\n");
        writer.write("Минимум из набора");
        writer.write("\n");
        writer.write(String.format("%.3f", scc.getMin().GetValue()));// выводим минимум из набора

        // Нахождение колличества дробей больше и меньше заданной в консольке
        System.out.println("Введите дробь для нахождения колличества дробей больше задней и меньше задней");
        int numerator = in.nextInt();
        int denominator = in.nextInt();
        Fraction fraction = new Fraction(numerator, denominator);
        System.out.println("Колличество дробей больше заданой");
        System.out.println(scc.Bigger_than(fraction));
        System.out.println("Колличество дробей меньше заданой");
        System.out.println(scc.Less_than(fraction));

        scanner.close();
        writer.close();
        in.close();

        // Работа с Полиномом

        Polynomial Polynomial_1 = new Polynomial();
        Polynomial sum = new Polynomial();

        File polynomial = new File("C:\\Users\\maxim\\Desktop\\project1\\pr\\src\\main\\java\\lab\\polynomial.txt");
        Scanner scan = new Scanner(polynomial);

        File polynomial_res = new File(
                "C:\\Users\\maxim\\Desktop\\project1\\pr\\src\\main\\java\\lab\\polynomial_res.txt");
        FileWriter wri = new FileWriter(polynomial_res, false);
        System.out.println("тебе всё равно никто не поверит");
        int number = scan.nextInt(); // считываем колличество полиномов
        double FULLSUM = 0;
        int maxsize = 0;

        for (int j = 0; j < number; j++) {

            int size = scan.nextInt(); // степень многочлена

            if (j == 0) {
                maxsize = size;
            }

            if (maxsize < size) {
                maxsize = size;
            }

            double Xx = scan.nextDouble(); // считывем X

            Polynomial Polynomail_2 = new Polynomial();

            for (int k = 0; k <= size; k++) // вводим коэф многочлена
            {

                int a = scan.nextInt(); // числитель
                char ch = scan.next().charAt(0); // считываем разделитель
                int b = scan.nextInt(); // знаменатель

                Fraction scq = new Fraction(a, b);

                Polynomail_2.AddCoff(scq);

                if (j == 0) {
                    Polynomial_1.AddCoff(scq);
                }
            }

            if (j == 1) {
                sum = Polynomial_1.Summ_Coff(Polynomail_2);
            }

            if (j != 1 && j != 0) {
                sum = sum.Summ_Coff(Polynomail_2);

            }

            System.out.println("Сумма Полинома при X = " + Xx);
            System.out.println(Polynomail_2.sum(Xx, size));

            FULLSUM = (Polynomail_2.sum(Xx, size)) + FULLSUM;

            if (j == number - 1) {
                wri.write("Наш вид общего Полинома");
                wri.write("\n");
                wri.write(Polynomial_1.output(maxsize, sum));
                wri.write("\n");
                wri.write("Полная сумма Полиномов = " + FULLSUM);

            }

        }
        scan.close();
        wri.close();

    }

}

// work in progress
// powered by Live share
// done