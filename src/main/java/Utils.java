public class Utils {
    /*
     * Right now the cls command is not working for windows.
     *
     * */
    public static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            System.out.print("\033[H\033[2J");
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
