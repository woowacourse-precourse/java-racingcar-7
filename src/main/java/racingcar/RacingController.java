package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingController {
    private Car[] cars;

    public RacingController(String[] carNames) {
        this.cars = createCars(carNames);
    }

    public void progressRace(int raceCount) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < raceCount; i++) {
            startRace();
            printRaceResult();
            System.out.println();
        }
    }

    private Car[] createCars(String[] carNames) {
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }

    private void startRace() {
        for (Car car : cars) {
            car.incrementFowardCount(Randoms.pickNumberInRange(0, 9));
        }
    }

    private void printRaceResult() {
        for (Car car : cars) {
            String raceResult = car.getName() + ":" + "-".repeat(car.getForwardCount());
            System.out.println(raceResult);
        }
    }

    public Car[] getCars() {
        return cars;
    }
}
