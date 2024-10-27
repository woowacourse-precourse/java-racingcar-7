package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.utils.Parser;
import racingcar.view.OutputView;

public class CarRace {
    private final List<Car> carList;
    private int remainNum;

    public CarRace(String cars, String num) {
        carList = Parser.parseCarList(cars);
        remainNum = Parser.parseNum(num);
    }

    public void startRace() {
        while (remainNum-- > 0) {
            moveCars();
            OutputView.printResult(createOutputMessage());
        }
        OutputView.printResult(createWinnerMessage());
    }

    private void moveCars() {
        carList.forEach(this::moveCarIfEligible);
    }

    private void moveCarIfEligible(Car car) {
        if (getRandomNumber() >= 4) {
            car.move();
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private String createOutputMessage() {
        return carList.stream()
                .map(this::formatCurrentStatus)
                .collect(Collectors.joining("\n"));
    }

    private String formatCurrentStatus(Car car) {
        return car.getName() + " : " + "-".repeat(car.getDistance());
    }

    private String createWinnerMessage() {
        List<Car> winners = getWinners();
        return "최종 우승자 : " + formatWinners(winners);
    }

    private String formatWinners(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private List<Car> getWinners() {
        int maxDistance = getMaxDistance();

        return carList.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }

    private int getMaxDistance() {
        return carList.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }
}
