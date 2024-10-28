package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();

        String[] names = input.split(",");

        if(names.length == 0){//구분자만 넣었을 경우
            throw new IllegalArgumentException("자동차의 이름을 1글자 이상 입력하세요.");
        }
        for(String name : names){
            if(name.length() > 5){
                throw new IllegalArgumentException("자동차의 이름은 5글자 이하만 가능합니다.");
            }
            else if(name.isEmpty()){
                throw new IllegalArgumentException("자동차의 이름을 1글자 이상 입력하세요.");
            }
            else if(name.isBlank()){
                throw new IllegalArgumentException("공백으로만 이루어진 자동차의 이름은 불가능합니다.");
            }
            System.out.println(name.length());
            
        }


    }
}
