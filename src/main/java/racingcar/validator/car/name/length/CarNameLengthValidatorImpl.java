package racingcar.validator.car.name.length;

public class CarNameLengthValidatorImpl implements CarNameLengthValidator{

    @Override
    public void validate(String[] carNameList) {
        for (String carName : carNameList) {
            if (carName.length() > 5)
                throw new IllegalArgumentException("차 이름("+carName+")이 너무 깁니다");
        }
    }
}
