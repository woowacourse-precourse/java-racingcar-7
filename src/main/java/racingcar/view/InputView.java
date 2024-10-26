package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine().trim();

        if(input.isEmpty()){
            throw new IllegalArgumentException("자동차 이름은 공백이 될 수 없습니다.");
        }
        return input;
    }


    public String getAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine().trim();

        if (input.isEmpty()) {
            throw new IllegalArgumentException("게임 횟수는 공백이 될 수 없습니다.");
        }

        int attemptCount;
        try {
            attemptCount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("게임 횟수는 양수를 입력해 주세요.");
        }
        if (attemptCount <= 0) {
            throw new IllegalArgumentException("게임 횟수는 양수를 입력해 주세요.");
        }

        return input;
    }
 }
