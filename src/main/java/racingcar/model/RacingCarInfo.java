package racingcar.model;

public record RacingCarInfo(
    String[] carName,
    int trialNum
) {
    public static RacingCarInfo map(
        String carNameInput,
        String trialNumInput
    ) {
        return new RacingCarInfo(
            carNameInput.split(","),
            Integer.parseInt(trialNumInput)
        );
    }
}
