package validators;

import java.util.List;
import java.util.Set;

public class EmptyValidator {

    private static final int Empty = 0;

    // 횟수 입력 값이 0이거나 0보다 작을 때 오류 메세지 터트리기
    public static void countValidate(List<Integer> counts) {
        for (Integer count : counts) {
            if (count == Empty || count <= Empty) {
                throw new IllegalArgumentException("횟수는 0 이상이어야 합니다.");
            }
        }
    }

    // 차 이름을 입력 안 했을 때 오류 메세지 터트리기
    public static void validateCarName(String name, Set<String> uniqueNames) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 넘을 수 없습니다.");
        }
        if (!uniqueNames.add(name)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다 : " + name);
        }
    }

    public static void otherWinners(String name){
        if(name == name){
            System.out.println("우승자가 한 명 입니다.");
        }
    }
}
