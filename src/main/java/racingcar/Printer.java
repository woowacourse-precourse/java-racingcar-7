package racingcar;

import java.util.List;
import racingcar.domain.Cars;

public interface Printer {

    void print(String message);

    void printAfterGameResult(List<Cars> afterGameCars);

    void printFinalWinner(List<String> winner);
}
