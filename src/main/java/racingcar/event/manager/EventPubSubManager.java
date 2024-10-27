package racingcar.event.manager;

import racingcar.context.GameContext;
import racingcar.game.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class EventPubSubManager {
    private static final Map<Game.GameEvent, List<Consumer<Game>>> subscribers = new HashMap<>();

    public static <T> void publish(Game.GameEvent event) {
        List<Consumer<Game>> eventSubscribers = subscribers.get(event);
        if (eventSubscribers != null) {
            eventSubscribers.forEach(s -> s.accept((Game) GameContext.getAttribute(Game.class)));
        }
    }

    public static void subscribe(Game.GameEvent event, Consumer<Game> subscriber) {
        subscribers.computeIfAbsent(event, k -> new ArrayList<>()).add(subscriber);
    }
}
