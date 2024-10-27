package racingcar;

public class CarList {
    public static String[] carList (String input){
        final String[] nameList = input.trim().split("\\s*,\\s*");
        for (String i : nameList) {

            if (i == null || i.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름 중 공백이 존재합니다.");
            }

            if (i.length() > 5) {
                throw new IllegalArgumentException("자동차 이름의 길이는 5를 넘길 수 없습니다.");
            }
        }
        return nameList;
    }
}
