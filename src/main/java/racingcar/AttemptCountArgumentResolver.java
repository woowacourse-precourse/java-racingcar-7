package racingcar;

public class AttemptCountArgumentResolver {

    public int parse(String parameter) {
        try {
            return Integer.parseInt(parameter);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 변환가능한 입력이어야 합니다.");
        }
    }

}
