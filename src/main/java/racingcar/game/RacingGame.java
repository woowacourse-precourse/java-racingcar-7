package racingcar.game;

import static racingcar.error.GameErrorMessage.NO_STARTED;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.parser.RacingCarParser;
import racingcar.validator.NamesValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String PRINT_WINNER = "최종 우승자 : ";

    private List<RacingCar> racingCarList;
    private final int tryCount;

    RacingGame(List<RacingCar> racingCarList, int tryCount) {
        this.racingCarList = racingCarList;
        this.tryCount = tryCount;
    }

    public static void run() {
        RacingGame racingGame = inputData();
        playGame(racingGame);
        resultWinner(racingGame);
    }

    private static RacingGame inputData() {
        String inputName = InputView.inputName();
        NamesValidator.validateName(inputName);

        List<RacingCar> racingCarList = RacingCarParser.createRacingCarList(inputName);
        int tryCount = InputView.inputTryCount();

        return new RacingGame(racingCarList, tryCount);
    }

    private static void playGame(RacingGame racingGame) {
        System.out.println(RESULT_MESSAGE);
        for (int i = 0; i < racingGame.tryCount; i++) {
            for (RacingCar racingCar : racingGame.racingCarList) {
                racingCar.move();
            }
            System.out.println();
        }
    }

    private static void resultWinner(RacingGame racingGame) {
        System.out.print(PRINT_WINNER);
        OutputView.printWinner(getWinner(racingGame.racingCarList));
    }

    private static String getWinner(List<RacingCar> racingCarList) {
        List<String> winnerList = new ArrayList<>();
        int maxMove = getMaxMove(racingCarList);

        for (RacingCar racingCar : racingCarList) {
            if (maxMove == racingCar.getCount()) {
                winnerList.add(racingCar.getName());
            }
        }
        return String.join(", ", winnerList);
    }

    private static int getMaxMove(List<RacingCar> racingCarList) {
        int maxMove = 0;
        for (RacingCar racingCar : racingCarList) {
            maxMove = Math.max(maxMove, racingCar.getCount());
        }

        if (maxMove == 0) {
            throw new IllegalArgumentException(NO_STARTED.getMessage());
        }
        return maxMove;
    }
}
