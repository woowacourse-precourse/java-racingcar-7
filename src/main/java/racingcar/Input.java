package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {

    public List<Car> getCars(){
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        return Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .peek(this::checkValidation)
                .map(Car::new)
                .toList();
    }

    public int getRoundInput(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String round = Console.readLine();
        checkRoundInt(round);
        return Integer.parseInt(round);
    }

    public void checkValidation(String name) {
        checkIsEmpty(name);
        checkNameLength(name);
    }

    public void checkNameLength(String name) {
        if (name.length() > 5) throw new IllegalArgumentException("이름은 5글자를 넘을 수 없습니다.");
    }

    public void checkIsEmpty(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("이름은 한 글자 이상 입력해야 합니다.");
    }

    public void checkRoundInt(String round){
        try{
            Integer.parseInt(round);
        }catch (NumberFormatException  e){
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

}
