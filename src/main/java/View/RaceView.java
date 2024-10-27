package View;

import VO.CarVO;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RaceView {

    public String[] userInputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return readLine().split(",");
    }

    public int userInputRaceRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(readLine());
    }

    public void raceState(List<CarVO> cars, int i) {
        if (i == 0) {
            System.out.println("");
            System.out.println("실행 결과");
        }
        for (CarVO car : cars) {
            System.out.println(car.toString());
        }
        System.out.println("");
    }

    public void raceWinner(List<String> carsName) {
        String result = "";
        for (int i = 0; i < carsName.size(); i++) {
            if (i == carsName.size() - 1) {
                result += carsName.get(i);
            } else {
                result += carsName.get(i) + ",";
            }
        }
        System.out.println("최종 우승자 : " + result);
    }


}
