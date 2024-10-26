package racingcar.model;

import racingcar.dto.RacingRegisterForm;

public class RegistrarClerk {

    public CarRace register(RacingRegisterForm registerForm) {
        validateRegisterForm(registerForm);
        Cars cars = new Cars(registerForm.carNames());
        int raceRoundCount = registerForm.raceRoundCount();
        return new CarRace(cars, raceRoundCount);
    }

    private void validateRegisterForm(RacingRegisterForm registerForm) {
        if (registerForm == null) {
            throw new IllegalArgumentException("신청서가 유효하지 않아요. 다시 작성해주세요.");
        }
    }
}
