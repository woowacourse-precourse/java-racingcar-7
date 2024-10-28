package racingcar.validator.car.name.count;

public class CarNameCountValidatorImpl implements CarNameCountValidator {
    @Override
    public void validate(String[] carNameList) {
        if (carNameList.length < 2)
            throw new IllegalArgumentException("입력한 자동차의 개수가 2개 이상이여야 합니다.");
    }
}
