package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {

    static String inputCar;
    static int playCount;

    static void Input()  {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputCar= Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        playCount=Integer.parseInt(Console.readLine());

    }

    static String[] ParseInput()  {

        /* 입력받은 자동차 데이터를 쉼표를 기준으로 분리한다
         * 자동차 이름이 5글자가 넘어가면 throw한다.
         * 올바르지 않은 입력 데이터가 들어오면 throw한다.
         */
        String[] RaceMember = inputCar.split(",");

        if(RaceMember.length==0) {
            throw new IllegalArgumentException("데이터를 입력해주세요");
        }

        for(String car : RaceMember) {
            if(car.length() >5) {
                throw new IllegalArgumentException("차 이름의 길이가 너무 깁니다 5글자 이하로 입력해주세요");
            }
        }

        return RaceMember;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }
}
