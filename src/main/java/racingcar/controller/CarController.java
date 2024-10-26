package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;

public class CarController {

    public static List<String> makeCarNameList(String carString) {
        List<String> carNameList = new ArrayList<>();

        String[] splitCars = carString.split(",");

        for (String splitCar : splitCars) {
            if (splitCar.strip().length() >= 1 && splitCar.strip().length() <= 5) {
                carNameList.add(splitCar.strip());
            } else {
                throw new IllegalArgumentException("자동차 이름은 1~5글자만 가능합니다.");
            }
        }

        return carNameList;
    }

    public static List<Car> makeCarList(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();

        for (String carName : carNameList) {
            Car car = new Car();

            car.setCarName(carName);

            carList.add(car);
        }

        return carList;
    }

    public static void putRandomNumber(Car car) {
        car.setRandomNumber(Randoms.pickNumberInRange(0, 9));
    }

    public static void addMoveCount(Car car) {
        if (car.getRandomNumber() > 3) {
            car.getMoveCount().add('-');
        }
    }

    public static void roundResult(List<Car> carList, int roundNumber) {
        for (int i = 0; i < roundNumber; i++) {
            for (Car car : carList) {
                putRandomNumber(car);
                addMoveCount(car);
                System.out.println(car.getCarName() + " : " + convertListToString(car.getMoveCount()));
            }
            System.out.println();
        }
    }

    public static String convertListToString(List<Character> moveCount) {
        String moveCountString = "";
        for (Character character : moveCount) {
            moveCountString += character;
        }
        return moveCountString;
    }
}
