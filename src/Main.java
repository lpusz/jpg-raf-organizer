public class Main {
    final static String path = "Your absolute path";
    final static String rafsDirectoryName = "Target RAFs directory";

    public static void main(String[] args) {
        System.out.println("Program started...");

        final String rafsTarget = path + "\\" + rafsDirectoryName;
        Organizer organizer = new Organizer(path);
        organizer.organize(rafsTarget);

        System.out.println("Success!");
    }
}