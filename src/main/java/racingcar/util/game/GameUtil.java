package racingcar.util.game;

/**
 * 게임 진행과 관련된 유틸리티 클래스
 */
public class GameUtil {
    // 차량의 정지, 혹은 전진 여부를 판단하여 문자열을 리턴한다.
    public static String goOrStop(int ranNum) {
        if (ranNum >= 4) {
            return "-";
        } else {
            return "";
        }
    }

    private GameUtil() {}
}
