package racingcar.request;

import java.util.List;

public record RaceCreateRequest(List<String> names, int tryCount) {

    public RaceCreateRequest {
        validateName(names);
        validateTryCount(tryCount);
    }

    private void validateTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateName(List<String> names) {
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