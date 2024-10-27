package racingcar.DTO;

import java.util.List;

public class RaceFinalWinnerDTO {
    List<String> finalWinner;

    public RaceFinalWinnerDTO(List<String> finalWinner) {
        this.finalWinner = finalWinner;
    }

    public List<String> getFinalWinner() {
        return finalWinner;
    }
}
