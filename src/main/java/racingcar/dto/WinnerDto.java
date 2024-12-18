package racingcar.dto;

public class WinnerDto {
    private final String winnerName;

    public WinnerDto(String winnerName) {
        this.winnerName = winnerName;
    }

    public String getWinnerName() {
        return winnerName;
    }
}
