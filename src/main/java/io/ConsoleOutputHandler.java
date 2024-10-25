package io;

import java.util.List;
import java.util.stream.IntStream;

public class ConsoleOutputHandler implements OutputHandler {

    private static final String HYPHEN = "-";

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
    public void showCarPosition(final List<String> names, final List<Long> positions) {
        IntStream.range(0, names.size())
                .mapToObj(number -> names.get(number) + " : " + repeatHyphen(positions.get(number)))
                .forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void showWinners(final String winners) {
        System.out.println("최종 우승자 : " + winners);
    }

    private String repeatHyphen(long count) {
        if (count < 0) {
            throw new IllegalArgumentException("count is negative: " + count);
        }
        if (count == 1) {
            return HYPHEN;
        }
        StringBuilder repeatedValue = new StringBuilder();
        for (long i = 0; i < count; i++) {
            repeatedValue.append(HYPHEN);
        }
        return repeatedValue.toString();
    }
}
