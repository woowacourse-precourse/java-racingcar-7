package racingcar;

public class Racing {
    private static final String ONE_STEP = "-";

    public static void start(Car[] cars, int attemptCount) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < attemptCount; i++) {
            Racing.racing(cars);
        }
        System.out.print("최종 우승자 : ");
        Winner.printFinalWinner(cars);
    }

    public static void racing(Car[] cars) {
        carMove(cars);
        for (Car car : cars) {
            printRacingResult(car, car.getMoveCount());
        }
        System.out.println();
    }

    private static void carMove(Car[] cars) {
        for (Car car : cars) {
            if (camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9) >= 4) {
                car.addMoveCount();
            }
        }
    }

    private static void printRacingResult(Car car, int moveCount) {
        System.out.print(car.getName() + " : ");
        System.out.println(ONE_STEP.repeat(moveCount));
    }
}
