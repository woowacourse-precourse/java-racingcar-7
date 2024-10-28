package racingcar.view;

import java.util.List;

public interface ApplicationView {

    String requestInputCars();

    String requestGameCount();

    void printRacingProgressResult(List<String> results);

    void printWinners(String winnersName);
}
