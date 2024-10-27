package view;

public class OutputView {
    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printCarPosition(int carPosition) {
        for (int i = 0; i < carPosition; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
