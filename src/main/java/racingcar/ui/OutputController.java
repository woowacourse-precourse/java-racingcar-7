package racingcar.ui;

import java.util.List;
import racingcar.domain.ProgressedInformation;
import racingcar.domain.RoundInformation;

public class OutputController {

    private final OutputConsole outputConsole;

    public OutputController(final OutputConsole outputConsole) {
        this.outputConsole = outputConsole;
    }

    public void printNameInputInformation() {
        this.outputConsole.printWithLineBreak("경주할 자동차 이름을 입력하세요.(이름은 쉼포(,) 기준으로 구분)");
    }

    public void printRoundInputInformation() {
        this.outputConsole.printWithLineBreak("시도할 횟수는 몇 회인가요?");
    }

    public void printProgressedInfo(final List<RoundInformation> roundInformations) {
        this.outputConsole.printWithLineBreak("실행 결과");
        for (final RoundInformation roundInformation : roundInformations) {
            final List<ProgressedInformation> progressedInformations = roundInformation.getProgressedInformations();
            for (final ProgressedInformation information : progressedInformations) {
                this.outputConsole.printWithLineBreak(new ProgressedResult(information).getResult());
            }
            this.outputConsole.printWithLineBreak("");
        }
    }

    public void printWinners(final WinnerResults winnerResults) {
        this.outputConsole.print(winnerResults.getResult());
    }
}