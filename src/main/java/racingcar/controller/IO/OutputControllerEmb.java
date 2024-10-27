package racingcar.controller.IO;

import racingcar.model.RacingCar;
import racingcar.view.ResultViewer;
import racingcar.view.ResultViewerEmb;


import java.util.List;
import java.util.stream.Collectors;

public class OutputControllerEmb implements OutputController {
    private static final String CAR_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_INPUT = "시도할 횟수는 몇 회인가요?";
    private ResultViewer resultViewer;

    public OutputControllerEmb() {
        this.resultViewer =  new ResultViewerEmb();
    }

    @Override
    public void requestUserCarsInput() {
        resultViewer.output(CAR_INPUT);
        resultViewer.output("\n");
    }

    @Override
    public void requestUserRoundInput(){
        resultViewer.output(ROUND_INPUT);
        resultViewer.output("\n");
    }

    @Override
    public void printWinner(List<RacingCar> winners) {
        resultViewer.output("최종 우승자 : ");
        String winnerNames = winners.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));
        resultViewer.output(winnerNames);
    }

    @Override
    public void printCarsCurrentDistance(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            resultViewer.output(racingCar.getName() + " : ");
            resultViewer.output("-".repeat(racingCar.getDistance()));
            resultViewer.output("\n");
        }
    }
}
