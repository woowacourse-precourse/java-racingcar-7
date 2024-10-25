package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

public class GameController {
	private final List<Car> cars;
	private final int trialNum;
	
	public GameController(String[] carNames, int trialNum) {
		this.cars = createCars(carNames);
		this.trialNum = trialNum;
	}

	private List<Car> createCars(String[] carNames) {
		List<Car>  carList = new ArrayList<>();
		for (String name : carNames) {
			carList.add(new Car(name.trim()));
		}
		return carList;
	}
	
	public void play() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < trialNum; i++) {
            playRound();
        }
    }

    private void playRound() {
        moveAllCars();
        printRoundResult();
    }

    private void moveAllCars() {
        for (Car car : cars) {
            car.move(generateMoveCommand());
        }
    }

    private boolean generateMoveCommand() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    private void printRoundResult() {
        for (Car car : cars) {
            System.out.println(car.getCurrentPosition());
        }
        System.out.println();
    }

    public List<Car> getCars() {
        return cars;
    }
	
	

}
