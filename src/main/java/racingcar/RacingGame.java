package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();
    private int tryCount;


    public final void registerCars(String input) {
        StringTokenizer strtok = new StringTokenizer(input, ",");

        while (strtok.hasMoreTokens()) {
            String carName = strtok.nextToken();
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
            cars.add(new Car(carName));
        }
    }

    public final void setTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException();
        }
        this.tryCount = tryCount;
    }

    public final void doGame() {
        System.out.println("실행 결과");
        while (this.tryCount > 0) {
            for (Car car : cars) {
                car.moveOrStay();
                car.printMoveCount();
            }
            System.out.println();
            --this.tryCount;
        }

        List<Car> winners = getFinalWinner();
        System.out.print("최종 우승자 : ");
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
