package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.Car;

public class CarController {

    public static List<String> makeCarNameList(String carString) throws IllegalArgumentException {
        List<String> carNameList = new ArrayList<>();

        String[] splitCars = carString.split(",");

        for (String splitCar : splitCars) {
            if (splitCar.strip().length() >= 1 && splitCar.strip().length() <= 5) {
                carNameList.add(splitCar.strip());
            } else {
                throw new IllegalArgumentException("자동차 이름은 1~5글자만 가능합니다.");
            }
        }

        findDuplicated(carNameList);
        return carNameList;
    }

    public static void findDuplicated(List<String> carNameList) throws IllegalArgumentException {
        Set<String> carNameSet = new HashSet<>();

        for (String carName : carNameList) {
            if (!carNameSet.add(carName)) {
                throw new IllegalArgumentException("자동차 이름은 중복 될 수 없습니다. 다시 입력해주세요.");
            }
        }
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

    public static String convertListToString(List<Character> moveCount) {
        String moveCountString = "";
        for (Character character : moveCount) {
            moveCountString += character;
        }
        return moveCountString;
    }

    public static List<Car> findWinners(List<Car> carList) {
        int moveCount = 0;
        List<Car> winnerList = new ArrayList<>();

        for (Car car : carList) {
            if (car.getMoveCount().size() > moveCount) {
                moveCount = car.getMoveCount().size();
                winnerList.clear();
                winnerList.add(car);
            } else if (car.getMoveCount().size() == moveCount) {
                winnerList.add(car);
            }
        }

        return winnerList;
    }

    public static void printWinner(List<Car> winnerList) {
        String winner = "";

        for (Car car : winnerList) {
            winner += car.getCarName().toString() + ", ";
        }

        System.out.println("최종 우승자 : " + winner.substring(0, winner.length() - 2));
    }

    public static void gameResult(List<Car> carList, int roundNumber) {
        for (int i = 0; i < roundNumber; i++) {
            for (Car car : carList) {
                putRandomNumber(car);
                addMoveCount(car);
                System.out.println(car.getCarName() + " : " + convertListToString(car.getMoveCount()));
            }

            System.out.println();
        }

        printWinner(findWinners(carList));
    }
}
