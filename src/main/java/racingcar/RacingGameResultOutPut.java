package racingcar;

import java.util.List;

public class RacingGameResultOutPut implements GameResultOutput {

    @Override
    public void printRoundResult(List<GameRoundResultOutput> results) {
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
