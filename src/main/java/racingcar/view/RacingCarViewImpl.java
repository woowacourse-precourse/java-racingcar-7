package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarViewImpl implements RacingCarView {

    @Override
    public String getCarNamesFromView() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    @Override
    public Integer getNumberOfAttemptsFromView() {
        // TODO: 숫자인지 검증기능 구현
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.valueOf(Console.readLine());
    }

    @Override
    public void printRaceResults(String carName, String progress) {
        System.out.println(carName + " : " + progress);
    }

    @Override
    public void printWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
