package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<Car> prepareGame() {
        String carNameInput = receiveCarNames();
        String[] carNames = splitCarNames(carNameInput);
        List<Car> cars = createAllCars(carNames);

        return cars;
    }

    public List<Car> playGame(List<Car> cars) {
        int playCounts = receivePlayCount();

        for (int i = 0; i < playCounts; i++) {
            for (Car car : cars) {
                int randomNumber = createRandomNumber();
                boolean isMove = isMove(randomNumber);
                setMoveInformation(car, isMove);
                printSingleResult(car);
            }
        }

        return cars;
    }

    public void finishGame(List<Car> cars) {
        printWinners(cars);
    }

    public String receiveCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input;
    }

    public String[] splitCarNames(String input) {
        String[] carNames = input.split(",");
        return carNames;
    }

    public Car createSingleCar(String carName) {
        Car car = new Car(carName, false, 0);
        return car;
    }

    public List<Car> createAllCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(createSingleCar(carName));
        }

        return cars;
    }

    public int receivePlayCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = Integer.parseInt(Console.readLine());
        return count;
    }

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean isMove(int randomNumber) {
        return randomNumber >= 4;
    }

    public void setMoveInformation(Car car, boolean move) {
        car.setMove(move);
    }

    public int repeatCreation() {
        String userInput = receiveCarNames();
        String[] carNames = splitCarNames(userInput);

        List<Car> cars = createAllCars(carNames);

        int repeatCount = 0;

        for (Car car : cars) {
            setMoveInformation(car, isMove(createRandomNumber()));
            repeatCount++;
        }

        return repeatCount;
    }

    public void printSingleResult(Car car) {
        System.out.println(car.getName() + " : " + (car.getMove() ? "-" : ""));
    }

    public int repeatGame(int count) {
        int game = 0;
        repeatCreation();

        for (int i = 0; i < count; i++) {
            game++;
        }

        return game;
    }

    public void printWinners(List<Car> cars) {
        int maxPosition = -1;
        StringBuilder winner = new StringBuilder();

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                winner.setLength(0);
                winner.append(car.getName());
                maxPosition = car.getPosition();
            } else if (car.getPosition() == maxPosition) {
                winner.append(", ").append(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + winner);
    }
}
