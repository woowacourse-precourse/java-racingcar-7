package racingcar;

import java.util.List;

// 시도 횟수 별 자동차 경주 상태 출력하는 클래스
public class RacingCarOutput {
    public void getRaceState(List<Car> cars) {
        for (Car c : cars) {
            System.out.println(c.getName() + " : " + convertToDash(c.getLength()));
        }
        System.out.println();
    }

    public String convertToDash(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<length; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public void printFinalWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
