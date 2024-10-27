package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.util.PlayerNameValidator;
import racingcar.util.WinnerSelector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarService {
    private final PlayerNameValidator playerNameValidator;
    private final WinnerSelector winnerSelector;

    public CarService(PlayerNameValidator playerNameValidator,
                      WinnerSelector winnerSelector) {
        this.playerNameValidator = playerNameValidator;
        this.winnerSelector = winnerSelector;
    }

    public List<Car> playRounds(String playersName, int moveCount) {
        List<String> names = splitByComma(playersName);
        playerNameValidator.validateName(names);

        List<Car> cars = carGenerator(names);
        raceStart(cars,moveCount);

        return winnerSelector.getWinners(cars);
    }

    public List<String> splitByComma(String input) {
        return Arrays.asList(input.split(","));
    }


    private List<Car> carGenerator(List<String> names){
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name)); // 이름으로 Car 객체 생성
        }
        return cars;
    }

    private void raceStart(List<Car> cars, int moveCount) {
        for(int i = 0 ; i<moveCount; i++) {
            race(cars);
            printCarsPositionStatus(cars);
        }
    }

    private void race(List<Car> cars) {
        for(Car car : cars){
            tryMoveForward(car);
        }
    }

    private void printCarsPositionStatus(List<Car> cars) {
        for(Car car : cars){
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private void tryMoveForward(Car car){
        if(canMove())
            car.moveForward();
    }

    private boolean canMove(){
        return Randoms.pickNumberInRange(0,9) >=4;
    }
}
