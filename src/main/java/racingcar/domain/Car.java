package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.Utils;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveRandomly(boolean if60PercentChance) {
        if (if60PercentChance) {
            this.position++;
        }
    }

    public static List<Car> createByStrings(String inputString) {
        List<Car> cars = Utils.splitInputStringsByComma(inputString).stream()
                .map(String::trim)
                .peek(Car::validateNameFormat)
                .peek(Car::validateNameLength)
                .peek(Car::validateEmptyName)
                .map(Car::new)
                .collect(Collectors.toList());

        return cars;
    }
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public static void validateNameLength(String inputname) {
        if (inputname.length() > 5) {
            throw new IllegalArgumentException("5글자 이하의 이름만 입력할 수 있습니다.");
        }
    }

    public static void validateEmptyName(String inputname) {
        if (inputname == null || inputname.isBlank()) {
            throw new IllegalArgumentException("빈 이름이 있습니다.");
        }
    }

    public static void validateNameFormat(String inputname) {
        String rex = "^[\\w]+$";
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(inputname);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("이름은 알파벳,숫자와 언더바(_)만 사용할 수 있습니다.");
        }
    }
}
