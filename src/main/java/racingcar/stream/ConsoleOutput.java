package racingcar.stream;

import racingcar.domain.RacingCar;

import java.util.List;

public class ConsoleOutput implements Output {

    @Override
    public void writeCarNameGuide() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void writeRoundCountGuide() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    @Override
    public void writeWhiteLine() {
        System.out.println();
    }

    @Override
    public void writeResultTitle() {
        System.out.println("실행 결과");
    }

    @Override
    public void writeWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    @Override
    public void outputRoundResult(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            writeRacingCarPosition(racingCar);
        }
        writeWhiteLine();
    }

    private void writeRacingCarPosition(RacingCar racingCar) {
        String positionMark = "-";
        String repeatedMark = positionMark.repeat(racingCar.getPosition());
        System.out.println(racingCar.getName() + " : " + repeatedMark);
    }

}
