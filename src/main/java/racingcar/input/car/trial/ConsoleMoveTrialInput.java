package racingcar.input.car.trial;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleMoveTrialInput implements MoveTrialInputHandler{
    @Override
    public int readMoveTrialCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String trialCount = Console.readLine();
        if (trialCount.length() == 1 && Character.isDigit(trialCount.charAt(0)))
            return Integer.parseInt(trialCount);
        else
            throw new IllegalArgumentException("잘못된 시도 횟수 입력");
    }
}
