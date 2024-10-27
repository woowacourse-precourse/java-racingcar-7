package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;

public class RacingCarOutput {

    public void printCurrentScore(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<RacingCar> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
