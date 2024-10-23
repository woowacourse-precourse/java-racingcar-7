package racingcar.util;

public class PlayerValidation {

    public static void validation(String players) {
        if (!players.contains(",")) {
            throw new IllegalArgumentException("player는 ,(쉼표)로 구분됩니다.");
        }
        String[] playerArray = players.split(",");
        if (playerArray.length == 1) {
            throw new IllegalArgumentException("player는 2명 이상이여야 합니다..");
        }
        for (String player : playerArray) {
            if (isNumber(player)) {
                throw new IllegalArgumentException("player는 문자로 되어야 합니다.");
            }
            if (player.length() > 5) {
                throw new IllegalArgumentException("player의 이름은 최대 5글자입니다.");
            }
        }
    }

    private static boolean isNumber(String player) {
        return player.matches("[0-9]*");
    }
}
