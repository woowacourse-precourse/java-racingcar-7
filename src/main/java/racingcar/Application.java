package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        RaceInput input = getInput();

        String carNames = input.getCarNames();
        int numberOfAttempts = input.getNumberOfAttempts();
    }

    public static RaceInput getInput() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNames = Console.readLine();

            System.out.println("시도할 횟수는 몇 회인가요?");
            String inputOfAttempts = Console.readLine();

            int numberOfAttempts = Integer.parseInt(inputOfAttempts.trim());

            if (numberOfAttempts < 0) {
                throw new IllegalArgumentException("시도 횟수는 0보다 작을 수 없습니다.");
            }

            return new RaceInput(carNames, numberOfAttempts);
        }
        catch (NoSuchElementException e){
            throw new IllegalArgumentException("자동차 이름과 시도 횟수는 비어있을 수 없습니다.");
        }
    }
}