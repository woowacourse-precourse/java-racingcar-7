package racingcar;

import java.util.List;
import java.util.NoSuchElementException;

public class StringSeparator {

    private String baseString;
    private String delimiter;
    private List<String> separatedStrings;
    private int separatedSize;
    private int currentIndex;

    public StringSeparator(String baseString, String delimiter) {
        validateEmptyString(baseString);
        validateEmptyString(delimiter);
        this.baseString = baseString;
        this.delimiter = delimiter;
        this.separatedStrings = separate();
        this.separatedSize = separatedStrings.size();
        this.currentIndex = 0;
    }

    private void validateEmptyString(String string) {
        if (string == null || string.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 값을 사용할 수 없습니다.");
        }
    }

    private List<String> separate() {
        return List.of(baseString.split(delimiter));
    }

    public boolean hasNext() {
        return currentIndex < separatedSize;
    }

    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException("분할된 다음 문자열이 남아있지 않습니다.");
        }

        return separatedStrings.get(currentIndex++);
    }
}
