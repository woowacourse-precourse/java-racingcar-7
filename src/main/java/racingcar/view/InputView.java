package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String CAR_GETTING_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_GETTING_MESSAGE = "시도할 횟수는 몇 회인가요?";
    public List<String> getNameList() {
        System.out.println(CAR_GETTING_MESSAGE);
        String readInput = Console.readLine();
        return parseCarNameList(readInput);
    }

    private List<String> parseCarNameList(String readInput){
        String[] splitInput = readInput.trim().split("\\s*,\\s*", -1);

        try {
            List<String> carNameList = new ArrayList<>();

            for (String carName : splitInput) {
                if (carName.isEmpty()) {
                    throw new IllegalArgumentException("비어 있는 항목이 발견되었습니다.");
                }
                if (carName.length() > 5) {
                    throw new IllegalArgumentException("길이가 5자 초과인 항목이 발견되었습니다: " + carName);
                }
                if (carNameList.contains(carName)){
                    throw new IllegalArgumentException("중복된 항목이 발견되었습니다: " + carName);
                }
                carNameList.add(carName);
            }

            return carNameList;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException();
        }
    }


    public int getRound() {
        System.out.println(ROUND_GETTING_MESSAGE);
        String readInput = Console.readLine();

        try{
            return Integer.parseInt(readInput);
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
    }
}
