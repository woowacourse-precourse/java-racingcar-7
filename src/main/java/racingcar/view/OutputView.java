package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Game;

import java.util.List;

public class OutputView {

    public void showResult(Game game) {
        System.out.println("\n실행 결과");
        List<Car> cars = game.getCars();
        int roundRemain = Integer.parseInt(game.getRounds());

        while (roundRemain > 0) {
            for (Car car : cars) {
                car.move();
                System.out.println(car.getName() + " : " + car.markCarMove(car));
            }
            System.out.println();

            roundRemain--;
        }
    }

    public void showWinner(Game game) {
        List<String> names = game.getWinner();

        System.out.print("최종 우승자 : " + String.join(",", names));
    }
}
