package racingcar.dto;

public class UserInputDTO {
    String carNames;
    String roundCount;

    public UserInputDTO(String carNames, String roundCount) {
        this.carNames = carNames;
        this.roundCount = roundCount;
    }

    private UserInputDTO() {
    }

    public String carNames() {
        return carNames;
    }

    public String roundCount() {
        return roundCount;
    }

    public boolean isValid() {
        return carNames != null && roundCount != null && !carNames.isEmpty() && !roundCount.isEmpty();
    }
}
