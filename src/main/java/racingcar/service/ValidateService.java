package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidateService {

    int MAX_LENGTH = 5;
    long validateRaceCount;
    List<String> rawNames, validatedNames;

    public ValidateService() {
        this.validatedNames = new ArrayList<>();
        this.rawNames = new ArrayList<>();
    }

    public List<String> validateName(String names) {
        rawNames = Arrays.stream(names.split(",")).toList();

        rawNames.forEach(rawName -> {
            String trimmedName = rawName.trim();
            // 공백처리
            if (trimmedName.isEmpty()) {
                throw new IllegalArgumentException("이름이 공백입니다.");
            }

            // 길이 제한
            if (trimmedName.length() > MAX_LENGTH) {
                throw new IllegalArgumentException("길이가 5이하를 만족하지 않습니다.");
            }

            // 유효한 이름
            validatedNames.add(trimmedName);
        });
        return validatedNames;
    }

    public long validateRaceCount(String raceCount) {
        String trimmedRaceCount = raceCount.trim();

        // 공백 입력
        if (trimmedRaceCount.isEmpty()) {
            throw new IllegalArgumentException("입력이 비어 있습니다.");
        }

        try {
            int rawRaceCount = Integer.parseInt(trimmedRaceCount);

            if (rawRaceCount <= 0) {
                throw new IllegalArgumentException();
            }
            validateRaceCount = rawRaceCount;
        } catch (Exception e) {
            // 음수 확인, 숫자로 변경 할 수 없을 경우
            throw new IllegalArgumentException("올바른 숫자를 입력해주세요.");
        }
        return validateRaceCount;
    }

    public long getValidateRaceCount() {
        return validateRaceCount;
    }

    public List<String> getValidatedNames() {
        return validatedNames;
    }
}
