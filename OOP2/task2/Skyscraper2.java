package assignment2.OOP2.task2;

public class Skyscraper2 {
    public static final String SKYSCRAPER_WAS_BUILD = "Skyscraper is built.";
    public static final String SKYSCRAPER_WAS_BUILD_FLOORS_COUNT =
            "Skyscraper is built. The number of floors - ";
    public static final String SKYSCRAPER_WAS_BUILD_DEVELOPER =
            "Skyscraper is built. Developer - ";

    public Skyscraper2() {
        System.out.println(SKYSCRAPER_WAS_BUILD);
    }

    public Skyscraper2(int floors) {
        System.out.println(SKYSCRAPER_WAS_BUILD_FLOORS_COUNT + floors);
    }

    public Skyscraper2(String developer) {
        System.out.println(SKYSCRAPER_WAS_BUILD_DEVELOPER + developer);
    }

    public static void main(String[] args) {
        Skyscraper2 skyscraper = new Skyscraper2();
        Skyscraper2 skyscraperTower = new Skyscraper2(50);
        Skyscraper2 skyscraperSkyline = new Skyscraper2("JavaRushDevelopment");
    }
}

