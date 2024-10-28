package racingcar.domain;

import java.util.ArrayList;

public class RacingGames {
    private final ArrayList<RacingGame> racingGames;

    public RacingGames() {
        racingGames = new ArrayList<RacingGame>();
    }

    public ArrayList<RacingGame> getRacingGames() {
        return racingGames;
    }

    public void addRacingGame(RacingGame racingGame){
        racingGames.add(racingGame);
    }
}
