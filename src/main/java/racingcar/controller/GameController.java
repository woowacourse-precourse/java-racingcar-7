package racingcar.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.modle.movableStrategy.BasicMoveStrategy;
import racingcar.modle.movableStrategy.MovableStrategy;
import racingcar.modle.vehicle.Vehicles;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final MovableStrategy movableStrategy = new BasicMoveStrategy();
    private Vehicles vehicles;
    private  int playCount;

    public void gameSetting(){
        vehicles = new Vehicles(movableStrategy);
        vehicles.nameSettings(InputView.playerNames());
        OutputView.requestPlayCount();
        playCount = InputView.playCount();
    }

    public void gamePlay(){
        OutputView.printResultMessage();
        playEachRound(playCount);
    }

    private void playEachRound(int playCount) {
        for(int i = 0; i < playCount; i++){
            vehicles = vehicles.move();
            roundResult();
        }
    }

    private void roundResult() {
        OutputView.printRoundMovementGraph(vehicles.names(), vehicles.positions());
    }

    public void gameResult(){
        OutputView.printWinner(findWinner());
    }

    private List<String> findWinner() {
        Map<String, Integer> namePositionMap = lsitToMap(vehicles.names(), vehicles.positions());
        int maxPosition = namePositionMap.values().stream().max(Integer::compareTo).get();

        return namePositionMap.entrySet().stream()
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
