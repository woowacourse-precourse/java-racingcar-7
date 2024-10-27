package racingcar.controller.IO;

import racingcar.model.RacingCar;
import racingcar.view.ResultViewer;
import racingcar.view.ResultViewerEmb;


import java.util.List;
import java.util.stream.Collectors;

public class OutputControllerEmb implements OutputController {
    private static final String CAR_INPUT = "경주에 참가할 자동차들을 쉼표(,)로 구분해 입력해주세요 : ";
    private static final String ROUND_INPUT = "모든 자동차가 각각 전진을 시도할 총 차수를 입력해주세요 : ";
    private ResultViewer resultViewer;
    public OutputControllerEmb() {
        this.resultViewer =  new ResultViewerEmb();
    }
    @Override
    public void requestUserCarsInput() {
        resultViewer.output(CAR_INPUT);
    }

    @Override
    public void requestUserRoundInput(){
        resultViewer.output(ROUND_INPUT);
    }

    @Override
    public void printWinner(List<RacingCar> winners) {
        resultViewer.output("최종 우승자 : ");
        String winnerNames = winners.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));

        resultViewer.output(winnerNames);
    }

}
