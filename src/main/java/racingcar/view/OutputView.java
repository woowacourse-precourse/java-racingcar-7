package racingcar.view;

public class OutputView {

    public void getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void getRacingChance() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void raceGuide() {
        separateLine();
        System.out.println("실행 결과");
    }

    public void raceResult(String name, int chance) {
        System.out.println(name + " : " + "-".repeat(chance));
    }

    public void separateLine() {
        System.out.println();
    }

    public void findWinner(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }
}
