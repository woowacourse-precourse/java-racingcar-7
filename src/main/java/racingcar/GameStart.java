package racingcar;

import java.util.List;

public class GameStart {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String PRINT_WINNER = "최종 우승자 : ";

    public static void run(List<RacingCar> racingCarList, int tryCount) {
        System.out.println('\n' + RESULT_MESSAGE);
        for (int i = 0; i < tryCount; i++) {
            for (RacingCar racingCar : racingCarList) {
                racingCar.move();
            }
            System.out.println("");
        }

        System.out.print(PRINT_WINNER);
        int maxmove = 0;
        String winner = "";
        for (RacingCar racingCar : racingCarList) {
            if (maxmove < racingCar.getCount()) {
                maxmove = racingCar.getCount();
                winner = racingCar.getName();
            } else if (maxmove == racingCar.getCount()) {
                winner += ", " + racingCar.getName();
            }
        }
        if (maxmove == 0) {
            throw new IllegalArgumentException();
        }
        IOHandler.printWinner(winner);
    }
}
