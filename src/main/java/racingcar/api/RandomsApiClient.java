package racingcar.api;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomsApiClient {

    private RandomsApiClient() {}

    public static int getRandomNumber(final int startInclusive, final int endInclusive) {
        try {
            return Randoms.pickNumberInRange(startInclusive, endInclusive);
        } catch (IllegalArgumentException e) {
            throw new InvalidRangeException(e.getMessage(), e.getCause());
        } catch (Exception e) {
            throw new RandomsApiSystemException("Randoms API 호출 중 예외가 발생했습니다.", e.getCause());
        }
    }

}
