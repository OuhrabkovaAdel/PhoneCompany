package com.phonecompany.billing;

import java.io.File;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        TelephoneBillCalculator Calculator = new TelephoneBillCalculatorImpl();
        System.out.println(Calculator.calculate("C:\\Users\\Adel\\Desktop\\PhoneCompany\\BillCalculator\\src\\main\\java\\com\\phonecompany\\billing\\import.csv"));
    }
}
