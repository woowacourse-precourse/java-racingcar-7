package racingcar.view.output;

import java.util.List;

public class RacingGameOutPutView implements OutputView {

    @Override
    public void printRoundResult(List<RoundView> results) {
        StringBuilder output = new StringBuilder();
        output.append("\n실행 결과\n");

        results.forEach(result ->
                output.append(result.getGameRoundOutputFormat())
                        .append("\n")
        );

        System.out.println(output);
    }

    @Override
    public void printGameResult(List<String> winners) {
        System.out.println("\n최종 우승자 : " + String.join(", ", winners));
    }
}
