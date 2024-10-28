package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView
{
    public static String[] getCarNames()
    {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }

    public static int getRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try
        {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 숫자를 입력하세요.");
        }
    }
}
