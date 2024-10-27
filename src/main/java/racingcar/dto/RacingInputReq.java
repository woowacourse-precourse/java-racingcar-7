package racingcar.dto;

public class RacingInputReq {
    private String carNames;
    private String raceRounds;

    public RacingInputReq(String carNames, String raceRounds) {
        this.carNames = carNames;
        this.raceRounds = raceRounds;
    }

    public String getCarNames() {
        return carNames;
    }

    public String getRaceRounds() {
        return raceRounds;
    }
}
