package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Set;

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
    public static void checkName(List<String> names){
        // 예외처리 : 자동차 이름이 같을 경우
        Set<String> uniqueNames = Set.copyOf(names);
        if(uniqueNames.size() != names.size()){
            throw new IllegalArgumentException("자동차 이름은 중복되지 않아야 합니다.");
        }

        // 예외처리 : 자동차 이름의 길이가 5글자를 초과하는 경우
        for(String name:names){
            if(name.length()>5){
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
            }
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 1. 자동차 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = List.of(Console.readLine().split(","));
        checkName(carNames);  // 예외처리


        // 2. 시도할 횟수 입력
        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = Integer.parseInt(Console.readLine());


    }
}
