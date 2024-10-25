package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class InputManager {
    public void processInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");

        System.out.println("시도할 횟수는 몇 회인가요?");
        String numberInput = Console.readLine();
        int number = Integer.parseInt(numberInput);

        GameInitializer gameInitializer = new GameInitializer();
        gameInitializer.gameInitialize(names);
        startGame(gameInitializer.getCars(), number);

        gameInitializer.longestCarName(gameInitializer.getCars());
    }


    public void startGame(ArrayList<Car> cars, Integer number) {
        for (int i = 0; i < number; i++) {
            for (Car car : cars) {
                car.move();
            }
            gamePrint(cars);
        }
    }

    public void gamePrint(ArrayList<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.displayStatus());
        }
        System.out.println();
    }
}
