package racingcar.domain;

import static racingcar.error.GameErrorMessage.NO_STARTED;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.OutputView;

public class RacingGame {
    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String PRINT_WINNER = "최종 우승자 : ";

    private List<RacingCar> racingCarList;
    private final int tryCount;

    public RacingGame(List<RacingCar> racingCarList, int tryCount) {
        this.racingCarList = racingCarList;
        this.tryCount = tryCount;
    }

    public void play() {
        System.out.println(RESULT_MESSAGE);
        for (int i = 0; i < this.tryCount; i++) {
            for (RacingCar racingCar : this.racingCarList) {
                racingCar.move();
            }
            System.out.println();
        }
    }

    public void resultWinner() {
        System.out.print(PRINT_WINNER);
        OutputView.printWinner(getWinner(this.racingCarList));
    }

    private String getWinner(List<RacingCar> racingCarList) {
        List<String> winnerList = new ArrayList<>();
        int maxMove = getMaxMove(racingCarList);

        for (RacingCar racingCar : racingCarList) {
            if (maxMove == racingCar.getCount()) {
                winnerList.add(racingCar.getName());
            }
        }
        return String.join(", ", winnerList);
    }

    private int getMaxMove(List<RacingCar> racingCarList) {
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
