package racingcar.request;

public class CarCreateRequest {
    private final String[] names;
    private final int tryCount;

    public CarCreateRequest(String[] names, int tryCount) {
        validateName(names);
        validateTryCount(tryCount);
        this.names = names;
        this.tryCount = tryCount;
    }

    public String[] getNames() {
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

    private void validateName(String[] names) {
        if (names == null || names.length == 0) {
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
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}