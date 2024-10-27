package racingcar.views;

import java.util.Scanner;

public class InputView {
    private static Scanner sc = new Scanner(System.in);

    public static String readStringInput() {
        return sc.nextLine();
    }

    public static int readNumberInput() {
        return sc.nextInt();
    }
}
