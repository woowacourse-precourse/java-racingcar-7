package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserInputStringConverterTest {
    @Test
    void toList_InputString_OutputList(){
        //Given : 사용자 입력 문자열
        String userInputString = "Mike,John,Jane";

        //When : toList 메서드 호출
        List<String> result = UserInputStringConverter.toList(userInputString);

        // Then: ","로 구분한 리스트
        assertEquals(3, result.size()); // 리스트 크기 확인
        assertEquals("Mike", result.get(0)); // 첫 번째 요소 확인
        assertEquals("John", result.get(1)); // 두 번째 요소 확인
        assertEquals("Jane", result.get(2)); // 세 번째 요소 확인
    }

    @Test
    void toList_InputStringWithEmpty_OutputListWithEmpty(){
        //Given : 공백이 포함된 사용자 입력 문자열
        String userInputStringWithEmpty = "Mike,John,,Jane";

        //When : toList 메서드 호출
        List<String> result = UserInputStringConverter.toList(userInputStringWithEmpty);

        // Then: ","로 구분한 리스트
        assertEquals(4, result.size()); // 리스트 크기 확인
        assertEquals("Mike", result.get(0)); // 첫 번째 요소 확인
        assertEquals("John", result.get(1)); // 두 번째 요소 확인
        assertEquals("", result.get(2)); // 세 번째 요소(공백) 확인
        assertEquals("Jane", result.get(3)); // 세 번째 요소 확인
    }
}