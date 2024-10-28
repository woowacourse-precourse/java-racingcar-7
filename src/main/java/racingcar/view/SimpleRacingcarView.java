package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.RacingcarResults;
import racingcar.dto.UserInput;
import racingcar.global.validator.InputValidator;

import java.util.List;

public class SimpleRacingcarView implements RacingcarView {

    @Override
    public UserInput getInput() {
        this.printInputCarNameMessage();
        List<String> carNames = InputValidator.validCarNames(Console.readLine());

        this.printInputRepeatNumber();
        int repeatNum = InputValidator.validRepeatNum(Console.readLine());

        return new UserInput(carNames, repeatNum);
    }

    private void printInputCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private void printInputRepeatNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    @Override
    public void printOutput(RacingcarResults result) {
        result.getResults().forEach(this::printOneCarOutput);
        System.out.println();
    }

    private void printOneCarOutput(RacingcarResults.RacingcarResult result) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(result.name());
        stringBuilder.append(" : ");
        stringBuilder.append("-".repeat(Math.max(0, result.position())));

        System.out.println(stringBuilder);
    }

    @Override
    public void printResult(List<String> winner) {
        System.out.println("최종 우승자 : " + String.join(",", winner));
    }
}
