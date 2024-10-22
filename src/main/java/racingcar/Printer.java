package racingcar;

import java.util.List;

public interface Printer {

    void printEachGameResult(String message);

    void printFinalWinner(List<String> winner);
}
