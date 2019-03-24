package myLessson;

public class Storage {

    private static Storage instance;

    private String toSave;

    public static synchronized Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    private Storage() {
    }

    public void save() {
        // ...
    }

    public void  load() {
        // ...
    }

}
