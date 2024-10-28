package racingcar.game.winner;

import racingcar.game.car.Car;

import java.util.List;

public class RacingWinnerFinder {
    public Winner find(List<Car> players) {
        int winnerLocation = findWinnerLocation(players);
        return new Winner(findWinnersNames(players, winnerLocation));
    }

    private List<String> findWinnersNames(List<Car> players, int winnerLocation) {
        return players.stream()
                .filter(player -> player.getLocation() == winnerLocation)
                .map(Car::getName)
                .toList();
    }

    private int findWinnerLocation(List<Car> players) {
        return players.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }
}
