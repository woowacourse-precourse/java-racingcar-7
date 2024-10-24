package racingcar.view;

import java.util.List;
import racingcar.domain.CarDomain;

public interface OutputView {
    String displayCarNameRequest();

    String displayRoundRequest();

    String displayRoundResultString();

    String displayEachRoundStatus(List<CarDomain> cars);

    String displayCarRaceWinner(List<CarDomain> winners);
}
