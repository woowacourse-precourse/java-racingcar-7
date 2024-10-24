package racingcar;

public class RacingController {
    private final RacingInputView inputView;

    public RacingController(RacingInputView inputView) {
        this.inputView = inputView;
    }
    public String[] splitCarNames(String RacingCarNames) {
        return RacingCarNames.split(",");
    }
    private String[] trimCarNames(String[] carNames) {
        String[] trimNames = new String[carNames.length];
        for(int i = 0 ; i < carNames.length ;i++) {
            trimNames[i] = carNames[i].trim();
        }
        return trimNames;
    }

    public String[] finalGetCarsNames() {
        String inputCarNames = inputView.RacingCarNames();
        String[] carNames = splitCarNames(inputCarNames);
        return trimCarNames(carNames);
    }

    private int getRoundRacing() {
        return inputView.RacingRoundCount();
    }
    private void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름의 길이는 5글자 이하여야 합니다.");
            }
        }
    }
    public void RacingRun() {
        try {
            String[] carNames = finalGetCarsNames();
            int RacingRounds = getRoundRacing();
            validateCarNames(carNames);

        }catch (IllegalArgumentException e) {
            System.out.println("오류" + e.getMessage());
        }
    }
}
