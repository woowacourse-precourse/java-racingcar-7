package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int attempts;

    public Race(List<Car> cars, int attempts){
        this.cars = cars;
        this.attempts = attempts;
    }

    public void start() {
        for(int i = 0; i < attempts; i++){
            moveAndPrintRound();
            System.out.println();
        }
    }

    private void moveAndPrintRound() {
        for(Car car : cars){
            int moveDistance = Randoms.pickNumberInRange(0, 9);
            car.move(moveDistance);
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));  // 수정된 부분: ": " -> " : "
        }
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}