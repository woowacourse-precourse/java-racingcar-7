package racingcar.notice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;

class NoticeTest {

    @Test
    void inputName_성공테스트() {
        class inputData {
            final String input;
            final List<String> answer;
            inputData(String input, List<String> answer) {
                this.input = input;
                this.answer = answer;
            }
        }

        List<inputData> dataList = List.of(
                new inputData("abcde", List.of("abcde")),
                new inputData("abcde,안녕하세요", List.of("abcde", "안녕하세요"))
        );

        List<Predicate<String>> policies = List.of(
                (name) -> name.length() <= 5
        );

        for(inputData inputData : dataList) {
            List<String> names = Notice.inputName(() -> inputData.input, policies);
            assertThat(names).isEqualTo(inputData.answer);
        }
    }
    @Test
    void inputName_실패테스트() {
        class inputData {
            final String input;
            inputData(String input) {
                this.input = input;
            }
        }

        List<inputData> dataList = List.of(
                new inputData(",,"),
                new inputData("abcdefsada")
        );

        List<Predicate<String>> policies = List.of(
                (name) -> name.length() <= 5
        );

        for(inputData inputData : dataList) {
            assertThrows(IllegalArgumentException.class, () -> {
                Notice.inputName(() -> inputData.input, policies);
            });
        }
    }


    @Test
    void inputGameTime_성공테스트() {
        class inputData {
            final String input;
            final Integer answer;

            inputData(String input, Integer answer) {
                this.input = input;
                this.answer = answer;
            }
        }

        List<inputData> dataList = List.of(
                new inputData("12345", 12345),
                new inputData("0", 0)
        );

        for(inputData inputData : dataList) {
            Integer result = Notice.inputGameTime(() -> inputData.input);
            assertThat(result).isEqualTo(inputData.answer);
        }
    }
    @Test
    void inputGameTime_실패테스트() {
        class inputData {
            final String input;

            inputData(String input) {
                this.input = input;
            }
        }

        List<inputData> dataList = List.of(
                new inputData("-10"),
                new inputData("abs")
        );

        for(inputData inputData : dataList) {
            assertThrows(IllegalArgumentException.class, () -> Notice.inputGameTime(() -> inputData.input));
        }
    }
}