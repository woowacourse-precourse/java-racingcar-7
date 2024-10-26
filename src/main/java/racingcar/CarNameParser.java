package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 자동차 이름을 기록한 문자열을 해석하여 이름들을 추출하는 기능을 담당하는 클래스입니다.
 */
public class CarNameParser {
    /**
     * 자동차 이름들을 기록한 문자열로부터 이름들을 추출해 반환합니다.
     * <br/>입력 구문이 잘못되었다면 IllegalArgumentException이 발생합니다.
     * @param carNames 자동차 이름들을 기록한 문자열입니다.
     * @param maxNameLen 단일 자동차 이름의 최대 길이입니다.
     * @return 자동차 이름들이 담긴 리스트
     * @exception IllegalArgumentException 입력 문자열이 잘못된 형식을 가지고 있거나, 이름 길이의 제한이 1보다 작을 경우 발생합니다.
     * <br/>발생 상황은 다음과 같습니다 :
     * <br/>- 이름 입력이 null일 때
     * <br/>- 이름 내에 공백이 포함될 때
     * <br/>- 이름이 최대 길이를 넘길 때
     * <br/>- 길이가 0인 이름이 하나 이상 존재할 때
     * <br/>- 이름 길이 제한이 1보다 작을 때
     */
    public static List<String> parse(String carNames, int maxNameLen) {
        if (carNames == null || maxNameLen < 1) {
            throw new IllegalArgumentException();
        }
        
        List<String> names = new ArrayList<String>();
        HashSet<String> nameCheckingSet = new HashSet<String>(); 
        
        String[] rawNames = carNames.split(",", -1);
        for (int i = 0; i < rawNames.length; i++) {
            String rawName = rawNames[i].trim();
            
            if (rawName.length() == 0
                    || rawName.length() > maxNameLen
                    || nameCheckingSet.contains(rawName)) {
                throw new IllegalArgumentException();
            }
            else {
                names.add(rawName);
                nameCheckingSet.add(rawName);
            }
        }
        
        return names;
    }
}
