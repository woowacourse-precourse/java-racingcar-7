package racingcar.io.request;

public record TryCountRequest(
    int tryCount
) {

    public TryCountRequest(final String request) {
        this(parseToInt(request));
    }

    private static int parseToInt(final String request) {
        try {
            int count = Integer.parseInt(request);
            checkNumberOver(count);
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private static void checkNumberOver(final int count) {
        if (count < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}