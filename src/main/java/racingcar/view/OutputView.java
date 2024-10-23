package racingcar.view;

import racingcar.model.CarRacingProgress;
import racingcar.model.Winner;

/**
 * 출력을 담당하는 인터페이스
 */
public interface OutputView {

    void printProgress(CarRacingProgress car);

    void printRaceResult(Winner winner);

    void printStartRace();

    void printLineBreaking();
}
