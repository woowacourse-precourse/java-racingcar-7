package racingcar.controller;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.movableStrategy.MoveStrategy;
import racingcar.modle.vehicle.Vehicles;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final Vehicles vehicles;
    private final List<Vehicles> eachRoundResults;
    private int playCount;

    public GameController(MoveStrategy moveStrategy) {
        this.vehicles = new Vehicles(moveStrategy);
        this.eachRoundResults = new ArrayList<>();
    }

    public void gameSetting() {
        vehicles.nameSettings(InputView.playerNames());
        OutputView.requestPlayCount();
        playCount = InputView.playCount();
    }

    public void gamePlay() {
        OutputView.printResultMessage();
        playEachRound(playCount);
    }

    private void playEachRound(int playCount) { //흠...이거너무 찝찝한데
        eachRoundResults.add(vehicles);
        for (int i = 1; i < playCount + 1; i++) {
            Vehicles thisRoundVehicles = eachRoundResults.get(i - 1).moveAll();
            eachRoundResults.add(thisRoundVehicles);
            printRoundResult(thisRoundVehicles);
        }
    }

    private void printRoundResult(Vehicles RoundVehicles) {
        OutputView.printRoundMovementGraph(RoundVehicles.names(), RoundVehicles.positions());
    }

    public void gameResult() {
        OutputView.printWinner(findWinner(eachRoundResults.getLast()));
    }

    private List<String> findWinner(Vehicles vehicles) {
        Map<String, Integer> nameAndPositionMap = lsitToMap(vehicles.names(), vehicles.positions());
        int maxPosition = nameAndPositionMap.values().stream().max(Integer::compareTo).get();

        return nameAndPositionMap.entrySet().stream()
                .filter(name -> name.getValue() == maxPosition)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static Map<String, Integer> lsitToMap(List<String> names, List<Integer> positions) {
        return IntStream.range(0, names.size())
                .boxed()
                .collect(Collectors.toMap(names::get, positions::get));
    }
}
