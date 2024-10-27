package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.game.GameResult;
import racingcar.game.RacingCarGame;
import racingcar.integer_generator.IntegerGenerator;
import racingcar.integer_generator.TestIntegerGenerator;
import racingcar.validator.InputValidator;
import racingcar.view.input.InputValue;
import racingcar.view.output.OutputView;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GameTest {

    static final int MIN_VALUE_TO_MOVE = 4;

    static String attemptCount;
    InputValidator inputValidator = new InputValidator();
    IntegerGenerator testIntegerGenerator;
    OutputView outputView = new OutputView();
    RacingCarGame racingCarGame;

    public static Stream<Arguments> provideNumbers() {
        return IntStream.range(0, 9)
                .mapToObj(i -> Arguments.of(Integer.toString(i)));
    }

    /**
     * 자동차마다 딱 한 번 랜덤한 digit을 생성하고 그 후에는 해당 값으로 고정한다
     * 이를 바탕으로 게임을 실행하였을 때 우승자를 예측한다
     * (첫 랜덤 digit 생성 후 값이 고정되므로 그 값이 4 이상인 경우 우승자이다)
     */
//    @Test
    @ParameterizedTest
    @MethodSource("provideNumbers")
    void 전체_실행_테스트(String attemptCount) {
        racingcar.GameTest.attemptCount = attemptCount;

        String delimitedCarNames = "mini,woni,mom";

        List<String> carNames = inputValidator.validateDelimitedCarNames(delimitedCarNames);
        InputValue inputValue = new InputValue(carNames, Integer.parseInt(racingcar.GameTest.attemptCount));

        initRacingGame(inputValue, carNames);

        List<Integer> randomNumberList = createRandomNumberList();
        List<String> winners = expectWinners(carNames, randomNumberList);
        if (winners.isEmpty()) {
            winners = carNames;
        }

        racingCarGame.play();
        GameResult gameResult = racingCarGame.getGameResult();

        outputView.printResult(gameResult);
        String printResult = outputView.getPrintResult();

        String expectResult = createExpectResult(carNames, winners, randomNumberList);

        Assertions.assertThat(printResult).isEqualTo(expectResult);
    }

    private List<Integer> createRandomNumberList() {
        return ((TestIntegerGenerator) testIntegerGenerator).getRandomNumberList();
    }

    private List<String> expectWinners(List<String> carNames, List<Integer> randomNumberList) {
        if (attemptCount.equals("0")) {
            return carNames;
        }
        return IntStream.range(0, randomNumberList.size())
                .filter(i -> randomNumberList.get(i) >= MIN_VALUE_TO_MOVE)
                .mapToObj(carNames::get)
                .toList();
    }

    private static String createExpectResult(List<String> carNames,
                                             List<String> winners,
                                             List<Integer> randomNumberList) {
        StringBuilder expect = new StringBuilder("\n실행 결과\n");
        for (int step = 1; step <= Integer.parseInt(attemptCount); step++) {
            createStepResult(carNames, winners, expect, step, randomNumberList);
        }
        expect.append("최종 우승자 : ").append(String.join(", ", winners));

        return expect.toString();
    }

    private static void createStepResult(List<String> carNames,
                                         List<String> winners,
                                         StringBuilder expect,
                                         int step,
                                         List<Integer> randomNumberList) {
        for (int i = 0; i < carNames.size(); i++) {
            String carName = carNames.get(i);
            expect.append(carName).append(" : ");
            if (winners.contains(carName) && randomNumberList.get(i) >= MIN_VALUE_TO_MOVE) {
                expect.append("-".repeat(step));
            }
            expect.append("\n");
        }
        expect.append("\n");
    }

    private void initRacingGame(InputValue inputValue, List<String> carNames) {
        testIntegerGenerator = new TestIntegerGenerator(carNames.size());
        racingCarGame = new RacingCarGame(inputValue, testIntegerGenerator);
    }
}
