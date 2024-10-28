package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

class Car{
    private String name;
    private int now = 0;
    public Car(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public String getNow(){
        return this.name;
    }
}
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 1. 자동차 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = List.of(Console.readLine().split(","));
        // System.out.println(carNames);
    }
}
