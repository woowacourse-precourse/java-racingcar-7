package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RaceCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class RacingCarController {
    public void run() {
        Cars cars = getCars();
        RaceCount raceCount = getRaceCount();

        playRace(raceCount, cars);

//        Map<String, Integer> lastPositions = getLastPositions(cars);
//        List<String> carNames = new ArrayList<>(cars.keySet());
//        sortPositions(carNames, lastPositions);
//
//        String winnerNames = judgeWinner(carNames, lastPositions);
//
//        System.out.println("최종 우승자 : " + winnerNames);
    } // run

    public Cars getCars() {
        OutputView.requestForCarNames();
        String[] inputCarNames = InputView.responseForCarNames();
        return createCars(inputCarNames);
    } // getCars

    public Cars createCars(String[] inputCarNames) {
        List<Car> cars = new ArrayList<>();
        Arrays.stream(inputCarNames).forEach(name -> {
            Car car = new Car(name);
            cars.add(car);
        });
        return new Cars(cars);
    } // getCars

    public RaceCount getRaceCount() {
        OutputView.requestForRaceCount();
        int raceCount = InputView.responseForRaceCount();
        return new RaceCount(raceCount);
    } // getRaceCount

    public void playRace(RaceCount raceCount, Cars cars) {
        OutputView.displayRaceResult();
        for (int i = 0; i < raceCount.getRaceCount(); i++) {
            cars.move();
            OutputView.displayRoundResult(cars);
        } // end for
    } // playRace

    public Map<String, Integer> getLastPositions(Map<String, List<String>> cars) {
        Map<String, Integer> lastPositions = new HashMap<>();
        for (String name : cars.keySet()) {
            lastPositions.put(name, cars.get(name).size());
        } // end for
        return  lastPositions;
    } // getLastPositions

    public void sortPositions(List<String> carNames, Map<String, Integer> lastPositions) {
        carNames.sort(((o1, o2) -> lastPositions.get(o2) - lastPositions.get(o1)));
    } // sortPositions

    public String judgeWinner(List<String> carNames, Map<String, Integer> lastPositions) {
        int sortedMaxPosition = lastPositions.get(carNames.getFirst());
        StringBuilder winner = new StringBuilder();

        for (String carName : lastPositions.keySet()) {
            if (lastPositions.get(carName) == sortedMaxPosition) {
                winner.append(carName).append(", ");
            } // end if
        } // end for

        return removeLastComma(winner.toString());
    } // judgeWinner

    public String removeLastComma(String winnerNames) {
        if (winnerNames.endsWith(", ")) {
            winnerNames = winnerNames.substring(0, winnerNames.length() - 2);
        } // end if

        return winnerNames;
    } // removeLastComma
} // class