package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private Input(){

    }
    public static String getCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }
    public static int getRaceTime(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return validateNumberFormat();
    }

    private static int validateNumberFormat() {
        int raceTime;
        try{
            raceTime = Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("경주 횟수가 숫자 형식이 아닙니다");
        }
        return raceTime;
    }
}
