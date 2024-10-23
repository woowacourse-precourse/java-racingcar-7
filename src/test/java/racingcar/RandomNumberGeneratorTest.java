package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomNumberGeneratorTest {
    @DisplayName("0과 9 사이의 랜덤 수를 생성한다.")
    @Test
    void generateRandomNumber() {
        //Arrange
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        //Act
        int randomNumber = randomNumberGenerator.makeRandomNumber();

        //Assert
        assertThat(randomNumber).isBetween(0, 9);
    }
}
