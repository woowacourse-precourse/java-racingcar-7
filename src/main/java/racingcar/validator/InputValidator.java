package racingcar.validator;

public class InputValidator {

    public static void validatePlayer(String strPlayer) {
        if (strPlayer == null || strPlayer.isEmpty()) {
            throw new IllegalArgumentException("입력이 비어있습니다.");
        }

        String[] players = strPlayer.split(",");

        validatePlayerCount(players);
        validatePlayerName(players);
    }

    public static void validatePlayerCount(String[] players) {
        final int MIN_PLAYER_COUNT = 2;

        if (players.length < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException("플레이어 수는 최소 두명 이상이어야 합니다.");
        }
    }

    public static void validatePlayerName(String[] players) {
        final int MAX_PLAYER_NAME_LENGTH = 5;
        final int MIN_PLAYER_NAME_LENGTH = 1;

        for (String player : players) {
            int playerNameLength = player.trim().length();

            if (playerNameLength > MAX_PLAYER_NAME_LENGTH) {
                throw new IllegalArgumentException("플레이어 이름은 5자 이하만 가능합니다.");
            } else if (playerNameLength < MIN_PLAYER_NAME_LENGTH) {
                throw new IllegalArgumentException("플레이어 이름은 공백일 수 없습니다.");
            }
        }
    }

    public static void validateRound(String strRound) {
        final int MIN_ROUND = 0;

        try {
            int round = Integer.parseInt(strRound);

            if (round < MIN_ROUND) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("라운드는 자연수를 입력해주세요.");
        }
    }
}
