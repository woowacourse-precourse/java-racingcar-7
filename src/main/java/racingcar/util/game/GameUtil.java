package racingcar.util.game;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.vo.CarVO;

import java.util.List;

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

    public static List<CarVO> oneTurnPrintAndUpdate(List<CarVO> carNameAndGoCountList) {
        for (var carAndCount : carNameAndGoCountList) {
            int randomNumber = Randoms.pickNumberInRange(0,9);
            if (randomNumber >= 4) {
                carAndCount.goOneStep();
            }
            System.out.println(carAndCount.getCarName() + " : " + "-".repeat(carAndCount.getGoCount()));
        }

        return carNameAndGoCountList;
    }

    // TODO : 우승한 자동차를 추출하고 출력하는 함수

    // TODO : 게임 진행 함수

    private GameUtil() {
    }
}
