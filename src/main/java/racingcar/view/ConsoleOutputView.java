package racingcar.view;

import racingcar.model.dto.CarRacingProgress;
import racingcar.model.io.Winner;

/**
 * 콘솔을 통해 출력을 담당하는 클래스
 */
public class ConsoleOutputView implements OutputView {

    @Override
    public void printProgress(CarRacingProgress carDto) {
        System.out.println(carDto);
    }

    @Override
    public void printRaceResult(Winner winner) {
        System.out.println("최종 우승자 : " + winner);
    }

    @Override
    public void printLineBreaking() {
        System.out.println();
    }

    @Override
    public void printStartRace() {
        System.out.println("실행 결과");
    }


}
