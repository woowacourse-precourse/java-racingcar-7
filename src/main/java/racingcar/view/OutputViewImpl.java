package racingcar.view;

public class OutputViewImpl implements OutputView {
    @Override
    public void printCarRaceGameResults(String carName, String progress) {
        System.out.println(carName + " : " + progress);
    }

    @Override
    public void printWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
