package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class RacingView {

    private RacingView() {
    }

    private static class SingletonHelper {
        private static final RacingView INSTANCE = new RacingView();
    }

    public static RacingView getInstance() {
        return SingletonHelper.INSTANCE;
    }


    public void showDescription() {
        System.out.println(description);
    }

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String inputRaceCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    public void outputProgress(int raceCount, String raceProgress) {
        System.out.println(raceCount + "번째 이동");
        System.out.println(raceProgress);
    }

    public void outputResult(String result) {
        System.out.println("최종 우승자 : " + result);
    }


    String description = """
            =============================================================
                              자동차 경주 시뮬레이션 설명서
            
            단순한 자동차 경주 시뮬레이션을 제공하는 초간단 자동차 경주 게임입니다.
            경주에 참가하는 자동차들은 각 이동 횟수마다 무작위로 전진합니다.
            경주가 끝났을 때 가장 많이 전진한 자동차가 우승하게 됩니다!
            
            사용 방법
            1. 우선 경주에 참가하는 자동차들의 이름을 입력합니다.
               입력할 수 있는 자동차의 이름은 1자 이상 5자 이하이고, 경주에 참가하는
               자동차들의 이름은 ','로 구분되어야 합니다.
               경주에 참가할 수 있는 자동차의 수는 최소 1대, 최대 10대이며, 자동차
               이름은 중복될 수 없습니다.
               또한, 자동차의 이름에는 공백과 ','가 포함될 수 없습니다.
               ex) pobi,woni,jun (o)   pobi, woni (x)   cinador (x)
            
            2. 다음으로 자동차에게 주어지는 이동 횟수를 입력합니다.
               이동 횟수만큼 자동차들에게 전진할 수 있는 기회가 주어집니다.
               이동 횟수는 1이상 20이하의 정수만 입력할 수 있습니다.
            
            3. 이동 횟수마다 경주 진행 상황이 출력됩니다.
               경주가 끝난 이후에는 가장 많이 전진한 우승 자동차가 출력됩니다.
               가장 많이 전진한 자동차가 복수인 경우는 공동 우승입니다.
            
            ============================================================
            """;
}

