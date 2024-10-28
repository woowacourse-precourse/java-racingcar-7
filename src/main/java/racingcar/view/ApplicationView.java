package racingcar.view;

import java.util.List;

public interface ApplicationView {

    String requestInputCars();

    int requestGameCount();

    void printRacingProgressResult(List<String> results);

    void printWinners(String winnersName);
}
