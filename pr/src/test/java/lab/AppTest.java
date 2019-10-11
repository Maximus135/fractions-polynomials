package lab;

import org.junit.Assert;
import org.junit.Test;
import java.io.*;
import java.util.Scanner;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void fractions_sum() // проверка сложения
    {

        FractionOptions op = new FractionOptions();
        Fraction fraction_1 = new Fraction(1, 2);
        op.AddFraction(fraction_1);
        Fraction fraction_2 = new Fraction(4, 2);
        op.AddFraction(fraction_2);
        Fraction fraction_3 = new Fraction(1, 4);
        op.AddFraction(fraction_3);
        // 22/8=11/4
        Assert.assertTrue(11 == op.SummaDrob().GetN());
        Assert.assertTrue(4 == op.SummaDrob().GetD());

    }

    @Test
    public void insert_data() throws FileNotFoundException {
        File fractions = new File("C:\\Users\\maxim\\Desktop\\project1\\pr\\src\\main\\java\\lab\\fractions.txt");
        Scanner scan = new Scanner(fractions);
        int size = scan.nextInt();
        for (int i = 0; i < size * 2; i++) {
            Assert.assertNotNull(scan.nextInt()); // проверка вводимых данных
        }

        scan.close();
    }

}