package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.InputDto;

public class RacingView {

    public void printWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }

    public InputDto input() {
        String carNames = inputCarNames();
        int repeatCount = inputRepeatCount();

        inputValidate(carNames, repeatCount);

        return toInputDto(carNames, repeatCount);
    }

    private InputDto toInputDto(String carNames, int repeatCount) {
        return InputDto.Builder()
                .carNames(carNames)
                .repeatCount(repeatCount)
                .build();
    }

    private String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private int inputRepeatCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private void inputValidate(String carNames, int repeatCount) {
        if (carNames.endsWith(",") || carNames.isEmpty() || repeatCount <= 0 || repeatCount > 10000) {
            throw new IllegalArgumentException();
        }

        for (final String carName : carNames.split(",")) {
            if (carName.length() > 5 || carName.isBlank()) {
                throw new IllegalArgumentException();
            }
        }
    }
}
