package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.observer.Observer;

public class Race implements Subject {

    private static final String OUTPUT_DELIMITER = ", ";
    private static final String INPUT_DELIMITER = ",";
    private final List<Car> carList;
    private final List<Observer> observers = new ArrayList<>();

    public Race(String carNames) {
        this.carList = parse(carNames);
    }

    public String runRace(int attemptCount) {
        playRound(carList, attemptCount);
        return determineWinnerList(carList);
    }


    private List<Car> parse(String carNames) {
        String[] carNameStrings = carNames.split(INPUT_DELIMITER);
        return createCarList(carNameStrings);
    }

    private List<Car> createCarList(String[] carNameStrings) {
        return Arrays.stream(carNameStrings)
                .map(Car::new)
                .collect(Collectors.toList());
    }


    public void playRound(List<Car> carList, int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            advanceCar(carList);
            notifyObservers();
        }
    }

    private void advanceCar(List<Car> carList) {
        for (Car car : carList) {
            car.attemptAdvance();
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(carList);
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }


    public String determineWinnerList(List<Car> carList) {
        int maxAdvances = getMaxAdvances(carList);
        List<Car> winnerList = getWinnerList(carList, maxAdvances);
        return formatWinnerList(winnerList);
    }

    private int getMaxAdvances(List<Car> carList) {
        return carList.stream().mapToInt(Car::getAdvanceCount).max().orElse(0);
    }

    private List<Car> getWinnerList(List<Car> carList, int maxAdvances) {
        return carList.stream().filter(car -> car.getAdvanceCount() == maxAdvances).collect(Collectors.toList());
    }

    private String formatWinnerList(List<Car> winnerList) {
        return winnerList.stream().map(Car::getName).collect(Collectors.joining(OUTPUT_DELIMITER));
    }
}
