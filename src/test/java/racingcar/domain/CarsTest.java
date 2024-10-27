package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("[Cars Test]")
public class CarsTest {


    @Nested
    @DisplayName("create - 일급 컬렉션 객체를 생성한다")
    class createTest{

        @Test
        @DisplayName("성공적으로 Cars 일급 컬렉션 객체를 생성한다.")
        void Given_ValidNames_When_Create_Then_Success(){
            //given
            List<String> validCarNames = Arrays.asList("뽀뚜","뚜보","우테코");

            //when & then
            assertDoesNotThrow(()-> Cars.createCars(validCarNames));


        }

    }
}
