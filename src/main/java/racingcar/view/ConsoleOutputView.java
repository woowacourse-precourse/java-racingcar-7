package racingcar.view;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.position.Positions;
import racingcar.util.StringRepeater;

public class ConsoleOutputView implements OutputView {

    public static final String COLON = " : ";

    @Override
    public void showCommentForCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void showCommentForAttempt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    @Override
    public void showCommentForResult() {
        System.out.println("\n실행 결과");
    }

    @Override
    public void showCarPosition(final List<String> names, final Positions positions,
                                final StringRepeater stringRepeater) {
        IntStream.range(0, names.size())
                .mapToObj(number -> names.get(number) + COLON + stringRepeater.repeat(positions.longValue(number)))
                .forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void showWinners(final String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
