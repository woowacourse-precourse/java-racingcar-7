package racingcar.view;

public interface RacingCarView {
    String getCarNamesFromView();

    Integer getNumberOfAttemptsFromView();

    void printRaceResults(String carName, String progress);

    void printWinners(String winners);
}
