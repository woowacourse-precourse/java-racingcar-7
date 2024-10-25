package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public String receiveCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input;
    }

    public String[] splitCarNames(String input) {
        String[] carNames = input.split(",");
        return carNames;
    }

    public int calculateCarCount(String[] carNames) {
        return carNames.length;
    }

    public Car createSingleCar(String carName) {
        Car car = new Car(carName);
        return car;
    }

    public List<Car> createAllCars(String[] carNames){
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public int receivePlayCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = Integer.parseInt(Console.readLine());
        return count;
    }

    public int createRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }
}
