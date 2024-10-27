package racingcar.validator;

import java.util.List;
import racingcar.dto.request.RacingRequestDTO;

public class RacingRequestValidator {
    public static void validate(RacingRequestDTO racingRequestDTO) {
        validateCarNames(racingRequestDTO.carNames());
        validateMoveCount(racingRequestDTO.moveCount());
    }

    private static void validateCarNames(List<String> carNames) {
        if (carNames.stream().anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException("차 이름은 비어 있을 수 없습니다.");
        }
        if (carNames.stream().anyMatch(carName -> carName.length() > 5)) {
            throw new IllegalArgumentException("차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    private static void validateMoveCount(Integer moveCount) {
        if(moveCount<1) {
            throw new IllegalArgumentException();
        }
    }
}
