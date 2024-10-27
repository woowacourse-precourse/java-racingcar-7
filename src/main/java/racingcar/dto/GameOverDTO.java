package racingcar.dto;

import racingcar.model.RoundResult;

import java.util.List;

public class GameOverDTO {
    private List<roundResultDTO> roundResults;
    private List<String> winners;

    public GameOverDTO(List<roundResultDTO> roundResults, List<String> winners){
        this.roundResults = roundResults;
        this.winners = winners;
    }

    public List<roundResultDTO> getRoundResults() {
        return roundResults;
    }

    public List<String> getWinners(){
        return winners;
    }
}