package racingcar;

import java.util.List;

public class Race {
    private List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void startRace(int attempts) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < attempts; ++i) {
            for (Car car : cars) {
                car.move();
                System.out.println(car.getName() + " : " + car.getPositionRepresentation());
            }
            System.out.println();
        }

        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        StringBuilder winners = new StringBuilder();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                if (!winners.isEmpty()) {
                    winners.append(", ");
                }
                winners.append(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + winners);
    }
}