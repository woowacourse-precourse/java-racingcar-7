package racingcar.io.request;

public record TryCountRequest(
    int tryCount
) {

    public TryCountRequest(String request) {
        this(validateRequest(request));
    }

    private static int validateRequest(String request) {
        int count = parseToInt(request);
        validateCount(count);
        return count;
    }

    private static int parseToInt(String request) {
        try {
            return Integer.parseInt(request);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private static void validateCount(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}