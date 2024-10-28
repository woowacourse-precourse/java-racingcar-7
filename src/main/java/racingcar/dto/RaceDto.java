package racingcar.dto;

import java.util.List;
import racingcar.domain.RaceRound;

public class RaceDto {

    private List<RaceRound> raceRounds;
    private String winnerCarName;

    private RaceDto(List<RaceRound> raceRounds, String winnerCarName) {
        this.raceRounds = raceRounds;
        this.winnerCarName = winnerCarName;
    }

    public List<RaceRound> getRaceRounds() {
        return raceRounds;
    }

    public String getWinnerCarName() {
        return winnerCarName;
    }

    public static RaceDto of(List<RaceRound> raceRounds, String winnerCarName){
        return new RaceDto(raceRounds,winnerCarName);
    }
}
