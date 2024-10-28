package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RaceUtil {
    /***
     * 레이스할 자동차의 이름을 입력 받는 메소드
     *
     * @return 입력받은 이름을 담은 ArrayList
     */
    public ArrayList<String> inputRaceCar(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> carNameList = new ArrayList<>();
        String[] carName = scanner.nextLine().split(",");

        Collections.addAll(carNameList, carName);

        return carNameList;
    }

    /***
     * 시도 횟수 입력
     *
     * @return 입력받은 이름을 담은 ArrayList
     */
    public Integer inputRaceCount(){
        Scanner scanner = new Scanner(System.in);
        String cnt = scanner.nextLine();
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
}
