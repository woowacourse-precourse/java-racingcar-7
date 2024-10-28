package racingcar;

public class ValidateCarNames {
    // 자동차 이름의 길이가 5 초과인지 검사
    public static String[] validateCarNames(String cars_name){
        String[] cars_list = cars_name.split(",");
        for(String car : cars_list) {
            if (car.length() > 5){
                throw new IllegalArgumentException("이름이 5자 초과입니다.");
            }
            else if (car.isEmpty()){
                throw new IllegalArgumentException("빈 값입니다.");
            }
        }
        return cars_list;
    }
}
