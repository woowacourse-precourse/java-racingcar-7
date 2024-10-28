package racingcar;

public class DelimiterName {
    String delimiter = ",";

    public void validateDelimiter() {
        if (delimiter == null || delimiter.isEmpty()) {
            throw new IllegalArgumentException("구분자가 유효하지 않습니다. 구분자를 다시 확인해 주세요.");
        }
    }
}
