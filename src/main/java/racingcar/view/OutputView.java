package racingcar.view;

public class OutputView {

    public void printInputCarNameGuideMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printInputRacingTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printCarNameAndMoveDistance(final String carName, final String moveDistance) {
        System.out.println(carName + " : " + moveDistance);
    }

    public void printRacingResultGuideMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printFinalWinners(final String delimitedWinners){
        System.out.println("최종 우승자 : " + delimitedWinners);
    }
}
