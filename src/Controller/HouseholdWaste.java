package Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Model.Pay;
import Model.TransferStation;
import Model.Truck;
import View.Menu;

public class HouseholdWaste extends Menu<String> {

    static String[] options = {"Cost garbage collection", "Exit"};
    ArrayList<TransferStation> dataTS = new ArrayList<>();
    Truck truck = new Truck();
    Pay pay = new Pay();
    double total;
    Library library = new Library();

    public HouseholdWaste() {
        super("  Collecting household waste  ", options);
    }

    @Override
    public void execute(int n) throws FileNotFoundException, IOException {
        switch (n) {
            case 1:
                ArrayList<String> dataTS = library.readStringList();
                library.processInputData(dataTS, truck, pay);
                break;

            case 2:
                System.exit(0);
                break;
        }
    }
}
