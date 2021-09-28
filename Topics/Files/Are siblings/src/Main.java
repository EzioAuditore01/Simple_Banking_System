import java.io.File;

class Siblings {

    public static boolean areSiblings(File f1, File f2) {
        // implement me
        String first = f1.getParent();
        String second = f2.getParent();

        if (first.equals(second)) {
            return true;
        }

        return false;
    }
}