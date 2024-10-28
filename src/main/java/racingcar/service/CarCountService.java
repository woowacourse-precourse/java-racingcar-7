package racingcar.service;

public class CarCountService {
    public int getTryCountFromString(String count) {
        if (count == null || count.isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 시도 횟수 입니다.");
        }
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자 형태의 입력만 가능합니다. ");
        }
    }
}
