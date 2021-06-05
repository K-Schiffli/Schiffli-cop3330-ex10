/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Kevin Schiffli
 */
package Base;


import java.util.Scanner;
public class App {
    static Scanner in = new Scanner(System.in);

    public static void main( String[] args )
    {
        String[] priceArray = new String[3];
        String[] quantityArray = new String[3];
        double[] priceNumArray = new double[3];
        double[] quantityNumArray = new double[3];

        getPAndQ(priceArray, quantityArray);
        stringToInt(priceArray, quantityArray, priceNumArray, quantityNumArray);
        double subtotal = calcSubtotal(priceNumArray, quantityNumArray);
        double tax = calcTax(subtotal);
        double total = calcTotal(subtotal, tax);

        printOutput(subtotal, tax, total);
    }
    public static void getPAndQ(String[] priceArray, String[] quantityArray)
    {
        for (int i = 0; i < 3; i++)
        {
            System.out.printf( "Enter the price of item %d: ", i+1);
            priceArray[i] = in.nextLine();

            System.out.printf( "Enter the quantity of item %d: ", i+1);
            quantityArray[i] = in.nextLine();
        }
    }
    public static void stringToInt(String[] priceArray, String[] quantityArray,
                                   double[] priceNumArray, double[] quantityNumArray)
    {
        for (int i = 0; i < 3; i++)
        {
            priceNumArray[i] = Double.parseDouble(priceArray[i]);

            quantityNumArray[i] = Double.parseDouble(quantityArray[i]);
        }
    }

    public static double calcSubtotal(double[] priceNumArray, double[] quantityNumArray)
    {
        double subtotal = 0;
        for (int i = 0; i < 3; i++)
        {
            subtotal += priceNumArray[i] * quantityNumArray[i];
        }
        return subtotal;
    }

    public static double calcTax(double subtotal)
    {
        return subtotal *= 0.055;
    }

    public static double calcTotal(double subtotal, double tax)
    {
        return tax + subtotal;
    }

    public static void printOutput (double subtotal, double tax, double total)
    {
        System.out.printf( "Subtotal: $%.2f\nTax: $%.2f\nTotal: $%.2f", subtotal,tax,total);
    }
}