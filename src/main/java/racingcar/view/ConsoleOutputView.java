package racingcar.view;

import racingcar.model.dto.CarRacingProgress;
import racingcar.model.io.Winner;
import racingcar.utils.IOMessage;

/**
 * 콘솔을 통해 출력을 담당하는 클래스
 */
public class ConsoleOutputView implements OutputView {

    @Override
    public void printProgress(CarRacingProgress carDto) {
        System.out.println(carDto);
    }

    @Override
    public void printStartRace() {
        System.out.println(IOMessage.RACING_START);
    }

    @Override
    public void printLineBreaking() {
        System.out.println();
    }

    @Override
    public void printRaceResult(Winner winner) {
        System.out.println(IOMessage.WINNER_ANNOUNCEMENT.toString() + winner);
    }


}
