package racingcar.race;

import racingcar.component.RacingCar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MatchResolver {

    public List<RacingCar> determineWinner(List<RacingCar> players) {
        List<RacingCar> sortedPlayers = sortDescending(players);

        RacingCar firstWinner = sortedPlayers.getFirst();
        return sortedPlayers.stream()
                .filter((racingCar) -> racingCar.isNotLoserWith(firstWinner))
                .toList();
    }

    private List<RacingCar> sortDescending(List<RacingCar> players) {
        ArrayList<RacingCar> clonedPlayers = new ArrayList<>(players);
        clonedPlayers.sort(Comparator.reverseOrder());
        return clonedPlayers;
    }

}
