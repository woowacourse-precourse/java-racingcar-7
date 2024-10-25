package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputViewImpl implements InputView {
    @Override
    public String getCarNamesFormView() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    @Override
    public Integer getCountOfAttemptsFormView() {
        // TODO: 숫자인지 검증기능 구현
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.valueOf(Console.readLine());
    }
}
