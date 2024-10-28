package racingcar.controller;

import racingcar.model.enums.ExceptionMessage;
import racingcar.service.CarService;
import racingcar.view.RaceView;
import racingcar.model.RacingCar;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class CarController {
    private final CarService carService;
    private final RaceView view;

    public CarController(RaceView view) {
        this.carService = new CarService();
        this.view = view;
    }

    public CarController() {
        this(new RaceView());
    }

    public void start() {
        RacingCar[] cars = getCars();
        if (cars == null) return; // 오류 발생 시 종료
        int attemptNumber = getAttemptNumber();
        runRace(cars, attemptNumber);
    }

    private RacingCar[] getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = readLine();

        try {
            List<RacingCar> carList = carService.createCars(carNamesInput);
            return carList.toArray(new RacingCar[0]);
        } catch (IllegalArgumentException e) {
            System.out.println("입력 오류: " + e.getMessage());
            throw e; // 예외를 다시 던짐 catch하면 테스트가 예외 발생을 인지하지 못할 수 있음
        }
    }

    private int getAttemptNumber() {
        view.printInputPrompt("시도할 횟수는 몇 회인가요?");
        return readPositiveInteger();
    }

    private int readPositiveInteger() {
        while (true) {
            try {
                int input = Integer.parseInt(readLine());
                if (input <= 0) {
                    throw new IllegalArgumentException(ExceptionMessage.INPUT_RANGE_EXCEPTION.getMessage());
                } else {
                    return input;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(ExceptionMessage.INPUT_NUMERIC_EXCEPTION.getMessage());
            }
        }
    }

    private void runRace(RacingCar[] cars, int attemptNumber) {
        for (int i = 0; i < attemptNumber; i++) {
            simulateRace(cars);
            view.printResults(cars);
        }
        view.printWinner(determineWinners(cars));
    }

    private void simulateRace(RacingCar[] cars) {
        for (RacingCar car : cars) {
            car.simulate();
        }
    }

    private String determineWinners(RacingCar[] cars) {
        int maxDashes = 0;
        StringBuilder winners = new StringBuilder();

        for (RacingCar car : cars) {
            int dashCount = car.countDashes();
            if (dashCount > maxDashes) {
                maxDashes = dashCount;
                winners.setLength(0);
                winners.append(car.getName());
            } else if (dashCount == maxDashes) {
                if (winners.length() > 0) {
                    winners.append(", ");
                }
                winners.append(car.getName());
            }
        }
        return winners.toString();
    }
}
