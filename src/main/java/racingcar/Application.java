package racingcar;

import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        Car car = new Car();
        HashMap<String, Integer> carInfo = car.getCar();
        int tryNumber = car.getTryNumber();

        Race race = new Race();
        race.startRace(carInfo, tryNumber);
        race.resultRace(carInfo);
    }
}
