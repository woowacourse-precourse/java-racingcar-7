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

    // TODO : 게임 진행 함수

    // TODO : 게임의 한턴을 진행하여 각 자동차의 값을 업데이트 해주는 함수

    // TODO : 우승한 자동차를 추출하는 함수


    private GameUtil() {}
}
