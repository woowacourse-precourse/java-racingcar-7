package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.CarFactory;
import racingcar.game.RacingGameController;
import racingcar.game.RacingGameControllerFactory;

public class Application {

    public static final int MOVE_CONDITION = 4;

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();

        System.out.println("시도할 회수는 몇회인가요?");
        String round = Console.readLine();
        Console.close();

        RacingGameController racingGameController = RacingGameControllerFactory.create();
        String result = racingGameController.run(CarFactory.createCars(cars, MOVE_CONDITION, 5), round);
        System.out.println("최종 우승자 : " + result);
    }
}
