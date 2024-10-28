package racingcar.view;

import static racingcar.view.ViewMessages.PRINT_EXECUTION_RESULT;
import static racingcar.view.ViewMessages.PRINT_FINAL_WINNER;
import static racingcar.view.ViewMessages.REQUIRE_CARS_NAME;
import static racingcar.view.ViewMessages.REQUIRE_NUMBER_OF_ATTEMPTS;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingGames;
import racingcar.dto.ResultDTO;

public class OutputView {
    public static void requireCarsName(){
        System.out.println(REQUIRE_CARS_NAME);
    }

    public static void requireNumberOfAttempts(){
        System.out.println(REQUIRE_NUMBER_OF_ATTEMPTS);
    }

    public static void printResult(ResultDTO resultDTO){
        System.out.println(PRINT_EXECUTION_RESULT);
        System.out.println(resultDTO.getGameResult());
        System.out.println(PRINT_FINAL_WINNER);
        System.out.println(resultDTO.getFinalWinner());
    }
}