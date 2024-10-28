package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RacingCarGame {
    private List<Car> cars;


    private RacingCarGame(List<Car> cars) {this.cars = cars;}

    public static RacingCarGame getInstance(List<Car> cars) {
        return new RacingCarGame(cars);
    }

    public void game(int turn) {
        for (int i=0; i<turn; i++) {
            gameTurn();
            System.out.println(turnResult());
        }

        System.out.println(finalResult());
    }
    private void gameTurn() {
        for (Car car: cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.move();
            }
        }
    }

    private String turnResult() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName())
                    .append(" : ")
                    .append("-".repeat(car.getLocation()))
                    .append("\n");
        }
        return sb.toString();
    }

    private String finalResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        int maxDistance = 0;
        for (Car car:cars) maxDistance = Math.max(maxDistance, car.getLocation());
        for (Car car:cars) {
            if (car.getLocation() == maxDistance) {
                sb.append(car.getName());
            }
        }
        return sb.toString();
    }
}
