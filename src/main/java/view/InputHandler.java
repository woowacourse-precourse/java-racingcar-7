package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public List<String> getCarNames() {
        String carNames = Console.readLine();
        return parseCarNames(carNames);
    }

    public int getAttemp() {
        return Integer.parseInt(Console.readLine());
    }

    public List<String> parseCarNames(String carNames) {
        String[] nameArray = carNames.split(",");  // 쉼표로 나누어 배열 생성
        List<String> carNameList = new ArrayList<>();

        for (String name : nameArray) {
            carNameList.add(name);
        }

        return carNameList;
    }
}



