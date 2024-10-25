package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class InputView {

    private final static String regex = "^[a-zA-Z0-9가-힣]+$";

    public String getCarNameInput(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public int getCountInput(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public static List<String> getUniqueName(String userInput){
        List<String> splitedInput = Arrays.asList(userInput.split(","));

        Set<String> uniqueSet = Set.copyOf(splitedInput);
        return uniqueSet.stream().toList();
    }

    public boolean validateCarName(String userInput){
        List<String> splitedInput = getUniqueName(userInput);

        if (splitedInput.size() <= 1){
            throw new IllegalArgumentException("생성할 수 있는 자동차의 개수는 2개 이상 20이하 입니다.");
        }

        for (String name: splitedInput){
            if (!name.matches(regex)){
                throw new IllegalArgumentException("이름은 숫자, 알파벳, 한글 조합만 가능합니다.");
            }

            if (name.isEmpty() || name.length() > 5){
                throw new IllegalArgumentException("이름은 1글자 이상, 5글자 이하 입니다.");
            }
        }
        return true;
    }

//    public boolean validateCount(int userInput){
//        if (userInput <= 0 || userInput > 99999){
//            throw new IllegalArgumentException("시도할 횟수는 1이상 99999이하 입니다.");
//        }
//        return true;
//    }
}
