package racingcar.view;

public interface RacingCarView {
    String getCarNames();

    Integer getNumberOfAttempts();

    void printRaceResults(String carName, String progress);

    void printWinners(String winners);
}
