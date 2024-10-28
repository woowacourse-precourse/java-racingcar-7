package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();
    private int tryCount;
    private String AllRoundsResult;

    public final void registerCars(List<Car> cars) {
        this.cars = cars;
    }

    public final void setTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException();
        }
        this.tryCount = tryCount;
    }

    public final void doGame() {
        StringBuilder resultSheet = new StringBuilder();
        while (this.tryCount > 0) {
            for (Car car : cars) {
                car.moveOrStay();
                resultSheet.append(car.printMoveCount());
            }
            resultSheet.append('\n');
            --this.tryCount;
        }
        AllRoundsResult = resultSheet.toString();
    }

    public final void printResult() {
        System.out.println("\n실행 결과");
        System.out.print(AllRoundsResult);
        System.out.print("최종 우승자 : ");
        List<Car> winners = getFinalWinner();
        int winnerNum = winners.size();

        for (int i = 0; i < winnerNum - 1; ++i) {
            System.out.print(winners.get(i).getCarName() + ", ");
        }
        System.out.print(winners.getLast().getCarName());
    }

    private void sortCarsByMoveCount() {
        cars.sort((c1, c2) -> Integer.compare(c2.getMoveCount(), c1.getMoveCount()));
    }

    private List<Car> getFinalWinner() {
        sortCarsByMoveCount();
        Car winner = cars.get(0);
        List<Car> Winners = new ArrayList<>();
        Winners.add(winner);

        for (int i = 1; i < cars.size(); ++i) {
            Car car = cars.get(i);
            if (car.getMoveCount() == winner.getMoveCount()) {
                Winners.add(car);
            } else {
                break;
            }
        }
        return Winners;
    }
}
