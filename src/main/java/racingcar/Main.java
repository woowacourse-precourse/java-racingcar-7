package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public void run(){
        finishGame(playGame(prepareGame()));
    }

    public List<Car> prepareGame() {
        String carNameInput = receiveCarNames();
        List<String> carNames = splitCarNames(carNameInput);
        List<Car> cars = createAllCars(carNames);

        return cars;
    }

    public List<Car> playGame(List<Car> cars) {
        int playCounts = receivePlayCount();

        for (int i = 0; i < playCounts; i++) {
            for (Car car : cars) {
                int randomNumber = createRandomNumber();
                boolean isMove = isMove(randomNumber);
                if(isMove) {
                    setMoveInformation(car);
                }
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

    public List<String> splitCarNames(String input) {
        List<String> carNames = Arrays.stream(input.split(",")).toList();
        return carNames;
    }

    public Car createSingleCar(String carName) {
        Car car = new Car(carName, 0);
        return car;
    }

    public List<Car> createAllCars(List<String> carNames) {
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

    public void setMoveInformation(Car car) {
        car.setPosition(1);
    }

    public void printSingleResult(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
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
