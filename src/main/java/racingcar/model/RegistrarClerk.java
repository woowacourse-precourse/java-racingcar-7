package racingcar.model;

import racingcar.dto.RacingRegisterForm;
import racingcar.model.move.MoveStrategy;

public class RegistrarClerk {

    public CarRace register(RacingRegisterForm registerForm, MoveStrategy moveStrategy) {
        validateRegisterForm(registerForm);
        validateMoveStrategy(moveStrategy);
        Cars cars = new Cars(registerForm.carNames());
        return new CarRace(cars, moveStrategy);
    }

    private void validateRegisterForm(RacingRegisterForm registerForm) {
        if (registerForm == null) {
            throw new IllegalArgumentException("신청서가 유효하지 않아요. 다시 작성해주세요.");
        }
    }

    private void validateMoveStrategy(MoveStrategy moveStrategy) {
        if (moveStrategy == null) {
            throw new IllegalStateException("움직임 전략이 지정되지 않았습니다.");
        }
    }
}
