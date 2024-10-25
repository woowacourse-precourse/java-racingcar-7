package racingcar;

import java.util.List;

public interface IOutputDisplay {

    void print(String str);

    void printRoundResult(List<ICar> carList);

    void printWinners(List<ICar> carList);
}
