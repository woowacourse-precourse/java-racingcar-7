package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameStart {
    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String PRINT_WINNER = "최종 우승자 : ";

    public static void run(List<RacingCar> racingCarList, int tryCount) {
        System.out.println(RESULT_MESSAGE);
        for (int i = 0; i < tryCount; i++) {
            for (RacingCar racingCar : racingCarList) {
                racingCar.move();
            }
            System.out.println("");
        }

        System.out.print(PRINT_WINNER);
        IOHandler.printWinner(getWinner(racingCarList));
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
            if (maxMove < racingCar.getCount()) {
                maxMove = racingCar.getCount();
            }
        }

        if (maxMove == 0) {
            throw new IllegalArgumentException();
        }
        return maxMove;
    }
}
