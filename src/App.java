import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.print("Length of Fence Needed? > ");
        int length = input.nextInt();
        int inchesLength = length * 12;

        Quantities quantities = CalculateQuantities(inchesLength);
        Prices prices = new Prices(length, quantities.Posts, quantities.Rails, quantities.ConcreteBags, quantities.Panels, quantities.NailBoxes);

        PrintRecepit(quantities, prices);
        
        input.close();
    }
    private static Quantities CalculateQuantities(int length) {
        double sections = length / 92;

        int postQuantity = (int) Math.floor(sections) + 1;
        int rails = postQuantity * 3;
        int concreteBags = postQuantity * 2; 
        int panelQuantity = (int) Math.ceil(length / 5.621);
        int nailBoxes = (int) Math.ceil(((rails * 4) + (panelQuantity * 6)) / 100.);

        return new Quantities(length, postQuantity, rails, concreteBags, panelQuantity, nailBoxes);
    }
    private static void PrintRecepit(Quantities quantities, Prices prices) {
        System.out.println("\n                    TAMU FENCE COMPANY                    \n");
        System.out.printf("%.2f Feet of fence\n", quantities.Length / 12.);
        System.out.println("----------------------------------------------------------");
        System.out.println("Description                 Quantity    Cost        ");
        System.out.printf("%-27s %-11d $%.2f\n", "Bags of Concrete:", quantities.ConcreteBags, prices.ConcreteBags);
        System.out.printf("%-27s %-11d $%.2f\n", "Posts:", quantities.Posts, prices.Posts);
        System.out.printf("%-27s %-11d $%.2f\n", "Rails:", quantities.Rails, prices.Rails);
        System.out.printf("%-27s %-11d $%.2f\n", "Boxes of Nails:", quantities.NailBoxes, prices.NailBoxes);
        System.out.printf("%-27s %-11d $%.2f\n", "Panels:", quantities.Panels, prices.Panels);
        System.out.println("----------------------------------------------------------");
        System.out.printf("%-40s$%.2f\n", "Total Cost of Materials:", prices.TotalMaterialCost);
        System.out.printf("%-40s$%.2f\n\n", "Total Cost of Labor:", prices.Labor);
        System.out.printf("%-40s$%.2f\n", "Quote:", prices.Total);
    }
}
