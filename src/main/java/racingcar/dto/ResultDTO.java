package racingcar.dto;

import racingcar.domain.Cars;
import racingcar.domain.RacingGames;

public class ResultDTO {
    private Cars cars;
    private RacingGames racingGames;
    private String finalWinner;

    public ResultDTO(Cars cars, RacingGames racingGames, String finalWinner) {
        this.cars = cars;
        this.racingGames = racingGames;
        this.finalWinner = finalWinner;
    }


}
