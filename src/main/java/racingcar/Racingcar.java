package racingcar;

/*
* 자동차 이름은 쉼표(,)를 기준으로 구분
* 사용자는 몇 번의 이동을 할 것인지를 입력
* */

import camp.nextstep.edu.missionutils.Console;

public class Racingcar {

    public String[] readNamesInput(){
        String nameInput = Console.readLine();
        return nameInput.split(",");
    }

    public int readNumInput(){
        int numInput = Integer.parseInt(Console.readLine()); // 나중에 분리
        return numInput;
    }
}
