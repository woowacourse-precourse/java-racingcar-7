package racingcar;

public class PlayCount {
    private int playCount;

    public PlayCount(String playCount) {
        validatePlayCount(playCount);

        this.playCount = Integer.parseInt(playCount);
    }

    public int getPlayCount() {
        return playCount;
    }

    private void validatePlayCount(final String playCount) {
        for (char c : playCount.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
            }
        }
        try {
            Integer.parseInt(playCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자의 범위를 벗어났습니다.");
        }
    }
}
