package assignment2.OOP2.task12;

public class Market {
    private static boolean hasEggs = true; // cannot modify

    public static void makePurchases(boolean hasEggs) {
        if (hasEggs) {
            System.out.println("Bought 10 loaves");
        } else {
            System.out.println("Bought 1 loaf");
        }
    }
}
