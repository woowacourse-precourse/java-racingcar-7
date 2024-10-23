package racingcar.application;

import java.util.List;
import racingcar.domain.Result;

public interface Printer {

    void print(String message);

    void printAfterGameResult(Result result);

    void printFinalWinner(List<String> winner);
}
