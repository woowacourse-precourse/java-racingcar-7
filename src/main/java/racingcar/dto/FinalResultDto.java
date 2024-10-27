package racingcar.dto;

import static racingcar.View.constant.OutputMessage.FINAL_WINNER;

import java.util.List;

public class FinalResultDto {
    private final String result;

    private FinalResultDto(String result) {
        this.result = result;
    }

    public static FinalResultDto from(List<String> winnerList) {
        String finalWinner = String.join(", ", winnerList);
        String result = FINAL_WINNER.getMessage() + finalWinner;
        return new FinalResultDto(result);
    }

    public String getResult() {
        return result;
    }
}
