package racingcar.view;

import static racingcar.constant.SymbolType.RESULT_DELIMITER;
import static racingcar.constant.SymbolType.RESULT_POSITION;
import static racingcar.constant.SymbolType.RESULT_TOKEN;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.utils.Parser;
import racingcar.validator.Validator;

public final class View {
    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_RESULT_MESSAGE = "최종 우승자 : ";

    public static List<String> getCarNames() {
        System.out.println(NAME_INPUT_MESSAGE);
        return Parser.parse(Console.readLine());
    }

    public static int getCount() {
        System.out.println(COUNT_INPUT_MESSAGE);
        String count = Console.readLine().trim();
        Validator.countValidate(count);
        System.out.println();
        return Integer.parseInt(count);
    }

    public static void showResult(List<Car> cars) {
        System.out.println(RESULT_MESSAGE);
        cars.forEach(car -> {
            System.out.println(
                    car.getName() + RESULT_TOKEN.getSymbol() + RESULT_POSITION.getSymbol().repeat(car.getLocation()));
        });
        System.out.println();
    }

    public static void showFinalResult(List<Car> cars) {
        System.out.print(FINAL_RESULT_MESSAGE);
        String winners = cars.stream().map(Car::getName).collect(Collectors.joining(RESULT_DELIMITER.getSymbol()));
        System.out.println(winners);
    }
}
