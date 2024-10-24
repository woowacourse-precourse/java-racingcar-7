package racingcar.validationTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.util.Validation;

public class ValidationTest {

	@Test
	@DisplayName("차 이름 입력 유효성 검사")
	public void validCarNameTest(){

		//given
		Validation validation = new Validation();

		//when & then
		// - right input case
		assertDoesNotThrow(() -> validation.validateCarNameInput("name1,name2,nm3,n4,5,CarNM"));
		assertDoesNotThrow(() -> validation.validateCarNameInput("name1"));

		// - wrong input case
		assertThrows(IllegalArgumentException.class, () -> validation.validateCarNameInput(",name,name2"));
		assertThrows(IllegalArgumentException.class, () -> validation.validateCarNameInput("name,,name2"));
		assertThrows(IllegalArgumentException.class, () -> validation.validateCarNameInput("name,name2,"));
		assertThrows(IllegalArgumentException.class, () -> validation.validateCarNameInput("name_over_than_five,name"));
		assertThrows(IllegalArgumentException.class, () -> validation.validateCarNameInput("sixcar"));
	}
}
