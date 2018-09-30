package ru.valiullin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class OrderPrinter {
    static String name;

    public static void orderPrinter() {
        try(FileReader fileReader = new FileReader("products.txt");
            Scanner scanner = new Scanner(fileReader))
        {
            scanner.useLocale(Locale.ENGLISH);
            System.out.println(String.format("%-18s%-8s%-10s%11s", "Наименование", "Цена", "Кол-во", "Стоимость"));
            System.out.println(String.format("%47s", " ").replace(" ","="));
            float totalPrice = 0;
            int indx = 1;
            while(scanner.hasNext()) {
                String name = scanner.nextLine();
                float amount = Float.parseFloat(scanner.nextLine());
                float price = Float.parseFloat(scanner.nextLine());
                float total = amount * price;
                totalPrice = totalPrice + total;
                System.out.println(String.format("%-2d%-16s%-8.2f%-10.2f%11.2f", indx,name, price, amount, total));
                indx++;
            }
            System.out.println(String.format("%47s", " ").replace(" ","="));
            System.out.println((String.format("%40.2f рублей",totalPrice)));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
