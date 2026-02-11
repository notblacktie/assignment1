package assignment2.interfaces;


public class task15 {
    public static void main(String[] args) throws Exception {
    }

    interface Selectable {
        void onSelect();
    }

    interface Updatable extends Selectable {
        void refresh();
    }

    class Screen implements Updatable {
        public void onSelect() {}
        public void refresh() {}
    }
}
