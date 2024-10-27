package racingcar.mock.model.dependency.validator;

import racingcar.model.dependency.validator.RacingCarValidator;

/**
 * RacingCarValidator 의 Mock 클래스
 * <p>
 * validate() 와 validateName() 을 호출 여부를 확인할 수 있다.
 * validateName() 의 결과를 설정할 수 있다.
 */
public class MockedRacingCarValidator implements RacingCarValidator {

    private boolean isValidateNameWillPass;

    private boolean isValidateCalled;
    private boolean isValidateNameCalled;

    public MockedRacingCarValidator() {
        clear();
    }

    public void setIsValidateNameWillPass(boolean validateNameWillPass) {
        this.isValidateNameWillPass = validateNameWillPass;
    }

    public boolean isValidateCalled() {
        return isValidateCalled;
    }

    public boolean isValidateNameCalled() {
        return isValidateNameCalled;
    }

    public void clear() {
        isValidateNameWillPass = false;

        isValidateCalled = false;
        isValidateNameCalled = false;
    }

    @Override
    public void validate(String name) {
        isValidateCalled = true;
        validateName(name);
    }

    @Override
    public void validateName(String name) {
        isValidateNameCalled = true;
        if (!isValidateNameWillPass) {
            throw new RuntimeException();
        }
    }
}
