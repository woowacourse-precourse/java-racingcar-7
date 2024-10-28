package racingcar.io;

import java.util.List;

public class Output {
    public void printResult() {
        System.out.println("실행 결과");
    }

    public void printCar(String car) {
        // 자동차 이름 출력
        System.out.print(car + " : ");
    }

    public void printMoveByOrder() {
        // 차수별 실행 결과 출력
        System.out.print("-");
    }

    public void printChampion(List<String> champions) {
        // 우승자 출력
        System.out.println("최종 우승자 : " + String.join(", ", champions));
    }
}
