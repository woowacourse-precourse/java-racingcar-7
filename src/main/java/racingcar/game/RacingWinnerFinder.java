package racingcar.game;

import racingcar.Car;

import java.util.List;

public class RacingWinnerFinder {
    public List<Car> find(List<Car> players) {
        int winnerLocation = findWinnerLocation(players);
        return players.stream()
                .filter(player -> player.getLocation() == winnerLocation)
                .toList();
    }

    private int findWinnerLocation(List<Car> players) {
        return players.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }
}
