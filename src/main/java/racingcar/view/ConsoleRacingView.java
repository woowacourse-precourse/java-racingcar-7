package racingcar.view;

public class ConsoleRacingView implements RacingView {
    @Override
    public void showRequestMessage(String string) {
        System.out.println(string);
    }
}
