package racingcar.view;

public class OutputView {
    public static void showRaceResult(String name, int position) {
        String dash = "-".repeat(position);
        System.out.println(name + " : " + dash);
    }
}
