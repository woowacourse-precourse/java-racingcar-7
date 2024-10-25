package racingcar.display;

import java.util.List;
import racingcar.ICar;

public interface IOutputDisplay {

    void print(String str);

    void printRoundResult(List<ICar> carList);

    void printWinners(List<ICar> carList);
}
