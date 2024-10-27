package racingcar;




public class Application {

    public static void main(String[] args) {
        String inputCarNames = RacingCar.inputCarNames();
        int inputTrial = RacingCar.inputTrial();
        String[] carNames = RacingCar.splitInputCarNames(inputCarNames);
        RacingCar.checkInputCarNames(carNames);
        Car cars[] = new Car[carNames.length];
        RacingCar.saveCars(carNames, cars);
        RacingCar.OutputEachTrial(inputTrial, cars);


    }
}
