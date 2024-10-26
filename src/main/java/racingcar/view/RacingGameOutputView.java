package racingcar.view;

import racingcar.model.Car;
import racingcar.model.RacingGameRoundResult;

import java.util.List;

public class RacingGameOutputView {
    public void printRacingGameStartingMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public void printRacingGameRoundInputMessage(){
        System.out.println("시도할 횟수는 몇 회인가요?");
    }
    public void printRacingRoundResultStartingMessage(){
        System.out.println("실행 결과");
    }
    public void printRoundResults(List<RacingGameRoundResult> roundResults){
        for (RacingGameRoundResult roundResult : roundResults){
            printRoundResult(roundResult);
        }
    }
    private void printRoundResult(RacingGameRoundResult roundResult){
        StringBuilder resultBuilder = new StringBuilder();

        for (Car car : roundResult.getCars()) {
            resultBuilder.append(car.getName()).append(" : ");
            resultBuilder.append("-".repeat(Math.max(0, car.getLocation())));
            resultBuilder.append(System.lineSeparator());
        }

        System.out.println(resultBuilder);
    }
}
