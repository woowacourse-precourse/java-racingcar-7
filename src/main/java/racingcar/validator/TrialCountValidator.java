package racingcar.validator;

// 시도 횟수 유효성 검증 클래스
public class TrialCountValidator {
    public static void validateTrialCount(int trialCount) {
        if (trialCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }
    }
}
