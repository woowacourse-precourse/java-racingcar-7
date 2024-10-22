package racingcar;

import java.util.List;

public interface Printer {

    void printGameResult(String message);

    void printFinalWinner(List<String> winner);
}
