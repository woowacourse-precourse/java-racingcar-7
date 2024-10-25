package racingcar;

import java.util.List;
import racingcar.component.Car;
import racingcar.component.Game;
import racingcar.util.CustomConsole;

public class Application {
    public static void main(String[] args) {
        System.out.print("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)\n자동차 이름: ");
        List<Car> cars = Car.makeListFrom(CustomConsole.readLine());

        System.out.println("시도할 회수는 몇 회인가요?");
        int round = Integer.parseInt(CustomConsole.readLine());

        Game game = Game.create(round, cars);
        game.start();
    }
}
