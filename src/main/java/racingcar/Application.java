package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.car.CarUtil;
import racingcar.util.game.GameUtil;
import racingcar.vo.CarVO;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String carNames = Console.readLine();
        Integer turnNumber = Integer.valueOf(Console.readLine());

        List<CarVO> carObjectList = CarUtil.getCarNameAndGoCountList(carNames);
        List<CarVO> afterGameCarVOList = GameUtil.oneGamePrintAndUpdate(carObjectList, turnNumber);
        System.out.println(GameUtil.getWinnerName(afterGameCarVOList));
    }
}
