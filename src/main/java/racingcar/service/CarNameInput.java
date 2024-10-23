package racingcar.service;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class CarNameInput implements CarManager{

    public List<String> carNameInput(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 "+SEPARATOR_NAME+"("+SEPARATOR+") 기준으로 구분)");
        String carNames = Console.readLine();
        List<String> carNameList = carNamesSplit(carNames);

        return carNameList;
    }
}
