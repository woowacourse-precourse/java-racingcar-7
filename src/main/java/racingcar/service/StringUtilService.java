package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtilService {
	// start: Singleton Holder
	private StringUtilService() {
	}

	private static class InnerValidatorService {
		private static final StringUtilService instance = new StringUtilService();
	}

	public static StringUtilService getInstance() {
		return InnerValidatorService.instance;
	}
	// end: Singleton Holder

	public List<String> splitByComma(String strInput) {
		if (strInput.indexOf(",") == -1) return new ArrayList<>(Arrays.asList(strInput.trim()));
		List<String> stringList = new ArrayList<>();
		for (String strEach : strInput.split(",")) {
			stringList.add(strEach.trim());
		}

		return stringList;
	}
}
