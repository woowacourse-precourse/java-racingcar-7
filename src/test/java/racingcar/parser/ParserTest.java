package racingcar.parser;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("[Parser Test]")
public class ParserTest {

    @Nested
    @DisplayName("parse - Delimiter로 inputString을 나누어 리스트 형태로 반환한다")
    class parseTest{
        @Test
        @DisplayName("입력값이 null인 경우 아무것도 담기지 않은 리스트를 반환한다")
        void Given_Null_When_Parse_Then_ReturnEmptyList(){
            //given
            final String delimiter = ",";
            final String inputString = null;

            //when
            List<String> result = Parser.parse(inputString, delimiter);

            //then
            assertThat(result).isEmpty();

        }

        @Test
        @DisplayName("입력값이 공백인 경우 아무것도 담기지 않은 리스트를 반환한다")
        void Given_EmptyInput_When_Parse_Then_ReturnEmptyList(){
            //given
            final String delimiter = ",";
            final String inputString = "";

            //when
            List<String> result = Parser.parse(inputString, delimiter);

            //then
            assertThat(result).isEmpty();

        }

        @Test
        @DisplayName("입력값이 화이트스페이스로만 이루어진 경우 아무것도 담기지 않은 리스트를 반환한다")
        void Given_OnlySpaceInput_When_Parse_Then_ReturnEmptyList(){
            //given
            final String delimiter = ",";
            final String inputString = "   ";

            //when
            List<String> result = Parser.parse(inputString, delimiter);

            //then
            assertThat(result).isEmpty();

        }

        @Test
        @DisplayName("옳바른 입력값이 들어온 경우 파싱에 성공한다")
        void Given_ValidInput_When_Parse_Then_ReturnList(){
            //when
            final String delimiter = ",";
            final String inputString = "뽀뚜,보뚜,우테코";

            //when
            List<String> result = Parser.parse(inputString, delimiter);

            //then
            assertThat(String.join(delimiter ,result)).isEqualTo(inputString);

        }
    }
}
