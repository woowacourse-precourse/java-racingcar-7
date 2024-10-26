package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.racing.Racing;
import racingcar.domain.racing.RacingConstant;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Racing racing = new Racing();

        System.out.println(RacingConstant.INPUT_CAR_NAMES_MESSAGE);
        String inputTextForRacingCars = Console.readLine();
        racing.setRacingCars(inputTextForRacingCars);

        System.out.println(RacingConstant.INPUT_TRY_COUNT_MESSAGE);
        String inputTextForTryCount = Console.readLine();
        racing.setTryCount(inputTextForTryCount);

        racing.iterateRace();
        racing.calculateWinner();
        racing.printWinners();
    }
}
