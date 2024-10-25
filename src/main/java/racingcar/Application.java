package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class Application {
    public static Map<String, List<String>> createCars(List<String> carNames) {
        Map<String, List<String>> cars = new HashMap<>();

        for (String carName : carNames) {
            List<String> positions = new ArrayList<>();
            cars.put(carName, positions);
        } // end for

        return cars;
    } // createCars

    public static void race(int raceCount, Map<String, List<String>> cars) {
        for (int i = 0; i < raceCount; i++) {
            moveForward(cars);
            System.out.println();
        } // end for
    } // race

    public static void moveForward(Map<String, List<String>> cars) {
        Set<String> carNames = cars.keySet();
        for (String name : carNames) {
            if (Randoms.pickNumberInRange(0, 9) > 4) {
                cars.get(name).add("-");
            } // end if
            System.out.println(name + " : "  + cars.get(name));
        } // end for
    } // moveForward

    public static Map<String, Integer> getLastPositions(Map<String, List<String>> cars) {
        Map<String, Integer> lastPositions = new HashMap<>();
        for (String name : cars.keySet()) {
            lastPositions.put(name, cars.get(name).size());
        } // end for
        return  lastPositions;
    } // getLastPositions

    public static void sortPositions(List<String> carNames, Map<String, Integer> lastPositions) {
        carNames.sort(((o1, o2) -> lastPositions.get(o2) - lastPositions.get(o1)));
    } // sortPositions

    public static String judgeWinner(List<String> carNames, Map<String, Integer> lastPositions) {
        int sortedMaxPosition = lastPositions.get(carNames.getFirst());
        StringBuilder winner = new StringBuilder();

        for (String carName : lastPositions.keySet()) {
            if (lastPositions.get(carName) == sortedMaxPosition) {
                winner.append(carName).append(", ");
            } // end if
        } // end for

        return removeLastComma(winner.toString());
    } // judgeWinner

    public static String removeLastComma(String winnerNames) {
        if (winnerNames.endsWith(", ")) {
            winnerNames = winnerNames.substring(0, winnerNames.length() - 2);
        } // end if

        return winnerNames;
    } // removeLastComma

    public static void main(String[] args) {
        OutputView.requestForCarNames();
        String[] inputCarNames = InputView.responseForCarNames();

        OutputView.requestForRaceCount();
        int raceCount = InputView.responseForRaceCount();

        System.out.println();
        System.out.println("실행 결과");

        Map<String, List<String>> cars = createCars(Arrays.stream(inputCarNames).toList());
        race(raceCount, cars);

        Map<String, Integer> lastPositions = getLastPositions(cars);
        List<String> carNames = new ArrayList<>(cars.keySet());
        sortPositions(carNames, lastPositions);

        String winnerNames = judgeWinner(carNames, lastPositions);

        System.out.println("최종 우승자 : " + winnerNames);
    } // main
} // class