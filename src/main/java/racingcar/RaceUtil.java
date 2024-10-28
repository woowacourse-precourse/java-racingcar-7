package racingcar;
import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.Collections;

public class RaceUtil {
    /***
     * 레이스할 자동차의 이름을 입력 받는 메소드
     *
     * @return 입력받은 이름을 담은 ArrayList
     */
    public ArrayList<String> inputRaceCar(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        ArrayList<String> carNameList = new ArrayList<>();
        String[] carName = Console.readLine().split(",");

        Collections.addAll(carNameList, carName);
        if(checkRaceCarName(carNameList)) return carNameList;
        else throw  new IllegalArgumentException("이름의 길이가 다섯자를 넘습니다.");
    }

    /***
     * 시도 횟수 입력
     *
     * @return 입력받은 이름을 담은 ArrayList
     */
    public Integer inputRaceCount(){
        String cnt = Console.readLine();
        if(checkRaceCountInput(cnt)) return Integer.parseInt(cnt);
        else throw new IllegalArgumentException("잘못된 시도 횟수를 입력했습니다. ->" + cnt);
    }

    /**
     * 입력받은 count 가 유효한지 확인하는 메소드
     *
     * @return 유효하면 true 유효하지 않으면 false
     */
    private boolean checkRaceCountInput(String cnt){
        try {
            int number = Integer.parseInt(cnt);
            return number > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 경주차의 이름이 유효한지 검사하는 메소드
     *
     * @param cars
     * @return 이름이 유효한지 여부
     */
    private boolean checkRaceCarName(ArrayList<String> cars){
        for(String name : cars) {
            if(name.length() > 5) return false;
        }

        return true;
    }
}
