package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("자동차의 수를 입력해주세요");

        int countCars = Integer.parseInt(Console.readLine());

        System.out.println("자동차의 이름을 쉼표(.)로 구분해 입력해주세요 (5자 이하)");
        String[] carName = (Console.readLine()).split(",");



        }










    }
}
