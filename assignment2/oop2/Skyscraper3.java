package assignment2.oop2;

public class Skyscraper3 {
    private int floorsCount;
    private String developer;

    public Skyscraper3() {
        this.floorsCount = 5;
        this.developer = "JavaRushDevelopment";
    }

    public Skyscraper3(int floorsCount, String developer) {
        this.floorsCount = floorsCount;
        this.developer = developer;
    }

    public static void main(String[] args) {
        Skyscraper3 skyscraper = new Skyscraper3();
        Skyscraper3 skyscraperUnknown = new Skyscraper3(50, "Unknown");
    }
}

