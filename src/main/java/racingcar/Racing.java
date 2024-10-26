package racingcar;

public class Racing {
    private static Car[] cars;

    public Racing(String[] carNames) {
        cars = new Car[carNames.length];
        int i = 0;
        for (String carName : carNames) {
            if (carName.isEmpty()) {
                cars[i] = new Car("NoName");
            } else {
                cars[i] = new Car(carName);
            }
            i++;
        }
    }

    public void runRound() {
        for (Car car : cars) {
            car.addDist();
        }
        Output.printRoundResult(cars);
        System.out.println();
    }
}
