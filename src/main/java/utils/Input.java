package utils;

import static camp.nextstep.edu.missionutils.Console.readLine;

import dto.RacingInput;

public class Input {

    public static RacingInput getInput() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String repeatCount = readLine();

        return new RacingInput(input, repeatCount);
    }
}