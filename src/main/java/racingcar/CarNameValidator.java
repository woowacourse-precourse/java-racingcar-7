package racingcar;

public class CarNameValidator {
    public void separateByComma(String carNames) {
        if (!isCommaSeparated(carNames)) {
            throw new IllegalArgumentException("쉼표(,)로 구분하여 자동차 이름들을 입력해주세요");
        }
    }

    public void inputMoreThanTwo(String carNames) {
        if (!isMoreThanTwo(split(carNames))) {
            throw new IllegalArgumentException("자동차 이름을 두 개 이상으로 입력해주세요");
        }
    }

    public void inputMoreThenOneCharacter(String carNames) {
        String[] carNameArray = split(carNames);
        for (String carName : carNameArray) {
            if(carName == null || carName.trim().isEmpty()) {
                throw new IllegalArgumentException("이름을 1자 이상으로 입력해주세요");
            }
        }
    }

    private boolean isCommaSeparated(String carNames) {
        return carNames.matches("^[a-zA-Z0-9]+(,[a-zA-Z0-9]+)*$");
    }

    private boolean isMoreThanTwo(String[] carNameArray) {
        return carNameArray.length > 2;
    }

    private String[] split(String carNames) {
        return carNames.split(",");
    }
}
