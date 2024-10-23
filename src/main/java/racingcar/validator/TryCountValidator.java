package racingcar.validator;

public class TryCountValidator implements Validator{
    @Override
    public void validTryCount(int tryCount){
        if(tryCount < 0){
            throw new IllegalArgumentException("입력하신 시도할 횟수가 음수입니다.");
        }
    }

    @Override
    public int convertTryCountToInt(String stringTryCount) {
        try {
            return Integer.parseInt(stringTryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력하신 시도할 횟수를 int로 변환할 수 없습니다.");
        }
    }
}
