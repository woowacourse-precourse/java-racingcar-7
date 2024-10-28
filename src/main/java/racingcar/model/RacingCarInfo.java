package racingcar.model;

public record RacingCarInfo(
    String[] carName,
    int trialNum
) {
    public static RacingCarInfo map(
        String carNameInput,
        String trialNumInput
    ) {
        String[] carNames = carNameInput.replaceAll("\\s+", "").split(",");

        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해야 합니다.");
            }
        }

        int trialNum;
        try {
            trialNum = Integer.parseInt(trialNumInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수 값이어야 합니다.");
        }

        return new RacingCarInfo(
            carNames,
            trialNum
        );
    }
}
