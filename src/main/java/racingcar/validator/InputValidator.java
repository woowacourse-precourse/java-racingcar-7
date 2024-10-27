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
        if (players.length < 2) {
            throw new IllegalArgumentException("플레이어 수는 최소 두명 이상이어야 합니다.");
        }
    }

    public static void validatePlayerName(String[] players) {
        for (String player : players) {
            if (player.trim().length() > 5) {
                throw new IllegalArgumentException("플레이어 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public static void validateRound(String strRound) {
        try {
            int round = Integer.parseInt(strRound);

            if (round < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("라운드는 자연수를 입력해주세요.");
        }
    }
}
