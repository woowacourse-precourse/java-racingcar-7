package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분. 중복 불가)");
        String carNames = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String roundNumber = Console.readLine();

        Input input = new Input(carNames, roundNumber);
        Racing racing;

        if (Util.isValidCarNamesInput(input.getCarNames()) && Util.isValidRoundNumber(input.getRounds())) {
            if (Util.hasDuplicates(input.splitCarNameInput())) {
                throw new IllegalArgumentException("입력한 자동차 이름에 중복이 있습니다.");
            }
        } else {
            throw new IllegalArgumentException("입력이 유효하지 않습니다.");
        }
    }
}
