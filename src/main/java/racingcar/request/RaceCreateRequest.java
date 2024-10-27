package racingcar.request;

import java.util.List;

public class RaceCreateRequest {
    private final List<String> names;
    private final int tryCount;

    public RaceCreateRequest(List<String> names, int tryCount) {
        validateName(names);
        validateTryCount(tryCount);
        this.names = names;
        this.tryCount = tryCount;
    }

    public List<String>  getNames() {
        return names;
    }

    public int getTryCount() {
        return tryCount;
    }

    private void validateTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateName(List<String>  names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException();
        }

        for (String name : names) {
            validateName(name);
        }
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}