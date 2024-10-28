package racingcar.application;

import racingcar.domain.Result;

public interface Printer {

    void print(String message);

    void printResultAfterGame(Result result);
}
