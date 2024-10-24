package racingcar.domain;

public record GameNumber(
        int value
) {

    public static int findGameNumber(String gameNumber) {
        if (gameNumber.isEmpty()) {
            throw new IllegalArgumentException("게임 횟수를 입력해야 합니다.");
        }
        try {
            Integer.parseInt(gameNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("게임 횟수는 숫자가 입력되어야 합니다.");
        }
        return Integer.parseInt(gameNumber);
    }
}
