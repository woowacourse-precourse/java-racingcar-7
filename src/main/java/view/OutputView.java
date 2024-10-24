package view;

public class OutputView {
    public static void printSetCarNameMessage() {
        System.out.println(SystemMessage.SET_CAR_NAME_MESSAGE.print());
    }

    public static void printCarPosition(int carPosition) {
        for (int i = 0; i < carPosition; i++) {
            System.out.println("-");
        }
    }
}
