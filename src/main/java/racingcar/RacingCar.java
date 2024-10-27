package racingcar;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


class Car {
    private String name;
    private int go;

    public Car(String name) {
        this.name = name;
        this.go = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getGo() {
        return this.go;
    }

    public int addTrial() {
        this.go += 1;
        return this.go;
    }


}

public class RacingCar {


    public static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static int inputTrial() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

    }

    public static String[] splitInputCarNames(String inputCarNames) {
        return inputCarNames.split(",");
    }

    public static void checkInputCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5 || carName.isEmpty()) {
                throw new IllegalArgumentException();
            }
        }
    }
    public static void saveCars(String[] carNames, Car[] cars) {
        int index = 0;

        for (String carName : carNames) {
            cars[index++] = new Car(carName);
        }

    }
    public static void OutputEachTrial(int trial, Car cars[]) {

        for (int i = 0; i < trial; i++) {
            saveCarsActions(cars);
            printCarsActions(cars);
        }

    }

    public static void saveCarsActions(Car cars[]) {

        for (int i = 0; i < cars.length; i++) {
            if (stopOrGo(cars[i])) {
                cars[i].addTrial();
            }
        }
    }
    public static boolean stopOrGo(Car car) {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (randomValue >= 4) {
            return true;
        }

        return false;
    }



}