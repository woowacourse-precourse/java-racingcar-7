package racingcar.printer;

import racingcar.car.Car;
import racingcar.event.manager.EventPubSubManager;
import racingcar.game.Game;

import java.util.List;
import java.util.stream.Collectors;

public class ResultPrinter {
    public ResultPrinter() {
        EventPubSubManager.subscribe(Game.GameEvent.GAME_START, this::onStarted);
        EventPubSubManager.subscribe(Game.GameEvent.ROUND_END, this::onRoundEnded);
        EventPubSubManager.subscribe(Game.GameEvent.GAME_END, this::onGameEnded);
    }

    private void onStarted(Game game) {
        System.out.println("\n실행 결과");
    }

    private void onRoundEnded(Game game) {
        for (Car car : game.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private void onGameEnded(Game game) {
        List<Car> cars = game.getCars();
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<Car> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());

        System.out.println("최종 우승자 : " + String.join(",", winners.stream().map(Car::getName).toList()));
    }
}