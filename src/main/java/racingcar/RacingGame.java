package racingcar;

public class RacingGame {
    private final Car[] cars;
    private final int numberOfRounds;
    private final MoveStrategy moveStrategy;

    public RacingGame(Car[] cars, int numberOfRounds, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.numberOfRounds = numberOfRounds;
        this.moveStrategy = moveStrategy;
    }

    // 지정된 횟수만큼 라운드를 진행하며, 각 라운드가 끝날 때마다 결과를 출력하고 최종 우승자를 출력
    public void start() {
        for (int i = 0; i < numberOfRounds; i++) {
            playRound();
            printRoundResult();
        }
        printWinners();
    }

    // MoveStrategy에 따라 각 자동차의 이동 여부를 결정하고 이동 상태를 갱신
    private void playRound() {
        for (Car car : cars) {
            car.move(moveStrategy.isMovable());
        }
    }

    // 우승자를 계산하여 결과를 출력
    private void printRoundResult() {
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getProgress());
        }
        System.out.println();
    }

    private void printWinners() {
        Car[] winners = WinnerDeterminer.determineWinners(cars);
        StringBuilder result = new StringBuilder("최종 우승자 : ");
        for (int i = 0; i < winners.length; i++) {
            result.append(winners[i].getName());
            if (i < winners.length - 1) {
                result.append(", ");
            }
        }
        System.out.println(result);
    }
}
