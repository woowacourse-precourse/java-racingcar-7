package racingcar.simulator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.car.Car;

public class Simulator {

    private static final int STD_NUMBER_OF_FORWARD = 4; // 전진하기 위해 나와야 하는 기준 수
    private final int numberOfAttempts;
    private final int numberOfCars;
    private final int[] racingBoard;    // 자동차들의 전진 상황을 저장하는 배열
    private final Map<Integer, Car> carMap = new HashMap<>();   // 자동차들의 정보를 저장하는 배열
    private final ResultPrinter resultPrinter = new ResultPrinter();    // 결과를 출력하는 서브 모듈

    public Simulator(int numberOfAttempts, String[] namesOfCars) {
        this.numberOfAttempts = numberOfAttempts;
        this.numberOfCars = namesOfCars.length;
        this.racingBoard = new int[namesOfCars.length];

        for (int carId = 0; carId < namesOfCars.length; carId++) {
            Car car = new Car(carId, namesOfCars[carId]);
            this.carMap.put(carId, car);
        }
    }

    protected int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private void moveForwardByCondition(Car car) {
        int randomNumber = this.getRandomNumber();

        if (randomNumber >= STD_NUMBER_OF_FORWARD) {
            ++this.racingBoard[car.getId()];
        }

    }

    private int findMaxForwardCount() {
        return Arrays.stream(racingBoard).max().orElseThrow();
    }

    private List<Car> findWinners() {
        int maxForwardCount = this.findMaxForwardCount();
        List<Car> winners = new ArrayList<>();

        for (int carId = 0; carId < this.numberOfCars; carId++) {
            if (maxForwardCount == racingBoard[carId]) {
                winners.add(carMap.get(carId));
            }
        }

        return winners;
    }

    public List<Car> simulate() {
        for (int tryCount = 1; tryCount <= this.numberOfAttempts; tryCount++) {
            for (int carId = 0; carId < this.numberOfCars; carId++) {
                Car currentOrderOfCar = carMap.get(carId);
                this.moveForwardByCondition(currentOrderOfCar);
            }
            resultPrinter.printResultOfForward(this.carMap, this.racingBoard);
        }
        List<Car> winners = this.findWinners();
        resultPrinter.printResultOfWinners(winners);

        return winners;
    }

    public int[] getRacingBoard() {
        return racingBoard;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public Map<Integer, Car> getCarMap() {
        return carMap;
    }
}
