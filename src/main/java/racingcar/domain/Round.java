package racingcar.domain;

public record Round(int value) {
    public Round {
        if (value <= 0 || value > 20) {
            throw new IllegalArgumentException("시도 횟수는 1에서 20 사이여야 합니다.");
        }
    }

    /**
     * 입력된 문자열을 파싱하여 Round 객체를 생성합니다. 이 메서드는 입력 문자열이 숫자 형태인지 확인하고, 유효한 숫자인 경우 Round 객체를 생성합니다.
     *
     * @param input 라운드 수를 나타내는 문자열
     * @return Round 객체
     * @throws IllegalArgumentException 유효하지 않은 숫자가 입력된 경우
     */
    public static Round of(String input) {
        try {
            int rounds = Integer.parseInt(input);
            return new Round(rounds);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해야 합니다.");
        }
    }
}
