package racingcar.game;

import racingcar.car.Car;
import racingcar.event.manager.EventPubSubManager;
import racingcar.game.handler.round.GameRoundHandler;

import java.util.List;

public class Game {
    private final List<Car> cars;
    private final int rounds;
    private final GameRoundHandler roundHandler;
    public enum GameEvent {
        GAME_START,
        ROUND_END,
        GAME_END
    }

    public Game(List<Car> cars, GameRoundHandler roundHandler, int rounds) {
        this.cars = cars;
        this.roundHandler = roundHandler;
        this.rounds = rounds;
    }

    public void run() {
        EventPubSubManager.publish(GameEvent.GAME_START);
        for (int i = 0; i < rounds; i++) {
            roundHandler.handle();
        }
        EventPubSubManager.publish(GameEvent.GAME_END);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public int getRounds() {
        return rounds;
    }
}