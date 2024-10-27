package racingcar.util.game;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.vo.CarVO;

import java.util.ArrayList;
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

    public static void oneTurnPrintAndUpdate(List<CarVO> carNameAndGoCountList) {
        for (var carAndCount : carNameAndGoCountList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                carAndCount.goOneStep();
            }
            System.out.println(carAndCount.getCarName() + " : " + "-".repeat(carAndCount.getGoCount()));
        }

        System.out.println();

    }

    public static List<CarVO> oneGamePrintAndUpdate(List<CarVO> carNames, int executeNumber) {
        System.out.println("실행 결과");

        for (int i = 0; i < executeNumber; i++) {
            GameUtil.oneTurnPrintAndUpdate(carNames);
        }

        return carNames;
    }

    public static int getMaxGoCount(List<CarVO> gameResultList) {
        var maxGoCount = 0;

        for (CarVO carNameAndCount : gameResultList) {
            if (carNameAndCount.getGoCount() > maxGoCount) {
                maxGoCount = carNameAndCount.getGoCount();
            }
        }

        return maxGoCount;
    }

    public static String getWinnerName(List<CarVO> carNameAndGoCountList) {
        List<String> winnerNameArray = new ArrayList<>();
        var maxCount = GameUtil.getMaxGoCount(carNameAndGoCountList);
        String winnerPrintValue = "최종 우승자 : ";

        for (CarVO carNameAndCount : carNameAndGoCountList) {
            if (carNameAndCount.getGoCount() == maxCount) {
                winnerNameArray.add(carNameAndCount.getCarName());
            }
        }

        if (winnerNameArray.size() == 1) {
            winnerPrintValue += winnerNameArray.getFirst();
        } else {
            winnerPrintValue += winnerNameArray.toString().replaceAll("[\\[\\]]", "");
        }

        return winnerPrintValue;
    }

    public static int getGameTurnNumber(String gameTurnInput) {
        String replaceNumber = gameTurnInput.replace(" ", "");
        Integer parseNumber;
        try {
            parseNumber = Integer.valueOf(replaceNumber);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("숫자만 입력해야합니다!");
        }

        return parseNumber;
    }






    private GameUtil() {
    }
}
