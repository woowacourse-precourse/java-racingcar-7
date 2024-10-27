package racingcar.dto;

public class RacingReq {
    private String carNames;
    private String raceRounds;

    public RacingReq(String carNames, String raceRounds) {
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
