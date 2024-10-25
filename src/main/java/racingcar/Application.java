package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();

        List<String> carNames = inputHandler.getCarNames();
        int attempts = inputHandler.getNumberOfAttempts();

        List<Car> cars = CarFactory.createCars(carNames);
        Car car = new Car("pobi");

        // attemps만큼 car move
        for (int i = 0; i < attempts; i++) {
            for (Car c : cars) {
                c.move();
            }
            for (Car c : cars) {
                System.out.println(c.getName() + " : " + c.getProgress());
            }
        }

        // 결과 출력
        List<String> winners = CarUtils.getWinners(cars);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
