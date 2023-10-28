package Controller;

import Model.Pay;
import Model.Truck;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    public static int getInt(String prompt, int m, int n) {
        int a = -1;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(prompt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a >= m && a <= n) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number between " + m + " and " + n);
            }
        }
        return a;
    }

    public ArrayList<String> readStringList() {
        ArrayList<String> stringList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the amount of garbage at each station in order by quantity (kg) as follows: ");
        String input = sc.nextLine();
        String[] elements = input.split(" ");
        for (String element : elements) {
            stringList.add(element);
        }

        return stringList;
    }

    public void processInputData(ArrayList<String> dataTS, Truck truck, Pay pay) {
        int totalWeight = 0;
        int totalTime = 0;
        double totalCost = 0;

        for (String tsString : dataTS) {
            int weight = Integer.parseInt(tsString);
            if (truck.getWeight() + weight <= truck.getMaxWeight()) {
                truck.setWeight(truck.getWeight() + weight);
                truck.setTime(truck.getTime() + 8);
            } else {
                truck.setWeight(weight);
                truck.setTime(truck.getTime() + 38);
                pay.setDump(pay.getDump() + 57000);
            }
            totalWeight += weight;
        }

        totalTime = truck.getTime() + 30;
        pay.setDump(pay.getDump() + 57000);
        totalCost = ((double) totalTime / 60) * 120000 + (double) pay.getDump();
        System.out.println("Total weight: " + totalWeight);
        System.out.println("Total time: " + totalTime + " minutes");
        System.out.println("The total cost is " + totalCost + " VND");
    }

}
