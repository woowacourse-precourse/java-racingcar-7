package racingcar;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RaceView {

    public String[] userInputCarName(){
        System.out.println("자동차 경주에 참가할 자동차 이름을 입력하시오.각 자동차는 쉼표로 구분하여 입력하여주세요.");
        return readLine().split(",");
    }

    public int userInputRaceRound(){
        System.out.println("자동차 경주 횟수를 입력해주세요.");
        return Integer.parseInt(readLine());
    }

    public void raceState(List<CarVO> cars){
        for (CarVO car : cars) {
            System.out.println(car.toString());
        }
    }

    public void raceWinner(List<String> carsName){
        String result = "";
        for (String carName : carsName) {
            result += carName + ",";
        }
        System.out.println(result);
    }

}
