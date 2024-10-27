package racingcar.service;


import racingcar.exception.UserErrorMessage;

public class LacingCarService {

    private int count = 0;

    // 시도 횟수 입력값 알맞은지 확인
    public boolean validateCount(String inputCount) {
        if (inputCount == null || inputCount.isEmpty()) {
            throw new IllegalArgumentException(UserErrorMessage.NOT_ALLOWED_BLANK);
        }

        try{
            count = Integer.parseInt(inputCount);
            if(count <= 0) {
                throw new IllegalArgumentException(UserErrorMessage.NOT_ALLOWED_ZERO_NEGATIVE_NUMBER);
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(UserErrorMessage.NOT_ALLOWED_CHARACTER);
        }
    }

}
