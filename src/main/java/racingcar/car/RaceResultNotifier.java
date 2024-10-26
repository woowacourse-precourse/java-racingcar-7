package racingcar.car;

import java.util.List;

import static racingcar.constant.Condition.FIRST_CARS_POSITION;
import static racingcar.constant.Condition.SIZE_DECREMENT_FOR_LAST_INDEX;
import static racingcar.constant.Delimiter.COMMA_WITH_SPACE;

public class RaceResultNotifier {

    private final ForwardMovementDecider forwardMovementDecider = new ForwardMovementDecider();
    private final RaceResultJudge raceResultJudge = new RaceResultJudge();

    private void announceMultipleWinners(List<Car> winningCars) {
        for (int i = 0; i < winningCars.size(); i++) {
            if (i == winningCars.size() - SIZE_DECREMENT_FOR_LAST_INDEX.value()) {
                System.out.println(winningCars.get(i).name);
                return;
            }
            System.out.print(winningCars.get(i).name + COMMA_WITH_SPACE.value());
        }
    }

    public void announceUpcomingRaceResults() {
        System.out.println("실행 결과");
    }

    private void announceUpcomingWinnerResult() {
        System.out.print("최종 우승자 : ");
    }

    public void announceRoundResult(List<Car> cars) {
        cars.forEach(System.out::println);
        System.out.println();
    }

    public void announceRaceResult(List<Car> cars, long raceCount) {
        for (int i = 0; i < raceCount; i++) {
            cars.forEach(car -> {
                if (forwardMovementDecider.validateCondition()) {
                    car.move();
                }
            });
            announceRoundResult(cars);
        }
    }

    public void announceWinner(List<Car> winningCars) {
        announceUpcomingWinnerResult();

        if (raceResultJudge.isSingleWinner(winningCars)) {
            announceSingleWinner(winningCars, FIRST_CARS_POSITION.value());
            return;
        }

        announceMultipleWinners(winningCars);
    }

    private void announceSingleWinner(List<Car> winningCars, int FIRST_CARS_POSITION) {
        System.out.println(winningCars.get(FIRST_CARS_POSITION).name);
    }

    public long provideWinningScore(List<Car> cars) {
        return cars
                .stream()
                .mapToLong(car -> car.status)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }

}
