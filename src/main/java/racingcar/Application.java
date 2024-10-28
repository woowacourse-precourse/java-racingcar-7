package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();

        // 입력 받기
        inputHandler.inputNames();
        inputHandler.inputCount();

        // 입력을 기반으로 Car 인스턴스 생성
        List<Car> cars = new ArrayList<>();
        for(String name : inputHandler.getNames()){
            Car car = new Car(name);
            cars.add(car);
        }

        // Race 인스턴스 생성
        Race race = new Race(cars, inputHandler.getRunCount());

        // 경주 진행
        race.runRace();
        race.showWinners();
    }
}
