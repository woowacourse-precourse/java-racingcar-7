package racingcar.view.output;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.car.Name;
import racingcar.model.game.position.Positions;
import racingcar.support.repeater.StringRepeater;

public class ConsoleOutputView implements OutputView {

    public static final String COLON = " : ";

    @Override
    public void showCommentForCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void showCommentForRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    @Override
    public void showCommentForResult() {
        System.out.println("\n실행 결과");
    }

    @Override
    public void showCarPosition(final List<Name> names, final List<Long> positions,
                                final StringRepeater stringRepeater) {
        formatPositions(names, positions, stringRepeater).forEach(System.out::println);
        System.out.println();
    }

    private List<String> formatPositions(final List<Name> names, final List<Long> positions,
                                         final StringRepeater stringRepeater) {
        return IntStream.range(0, names.size())
                .mapToObj(index -> formatPosition(names.get(index), stringRepeater, positions.get(index)))
                .toList();
    }

    private String formatPosition(final Name name, final StringRepeater stringRepeater, final long position) {
        return name.name() + COLON + stringRepeater.repeat(position);
    }

    @Override
    public void showWinners(final String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
