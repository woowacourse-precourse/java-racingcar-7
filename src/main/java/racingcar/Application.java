package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.car.CarUtil;
import racingcar.util.game.GameUtil;
import racingcar.vo.CarVO;

import java.util.List;
import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("경주할 자동차의 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
            String carNames = Console.readLine();
            System.out.println(carNames);

            System.out.println("시도할 횟수는 몇번인가요?");
            Integer turnNumber = GameUtil.getGameTurnNumber(Console.readLine());
            System.out.println(turnNumber);

            List<CarVO> carObjectList = CarUtil.getCarNameAndGoCountList(carNames);
            List<CarVO> afterGameCarVOList = GameUtil.oneGamePrintAndUpdate(carObjectList, turnNumber);
            System.out.println(GameUtil.getWinnerName(afterGameCarVOList));
        } catch (NoSuchElementException noSuchElementException) {
            throw new IllegalArgumentException("시스템에 값이 입력되지 않았습니다!");
        }
    }
}
