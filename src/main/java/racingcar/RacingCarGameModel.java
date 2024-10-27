package racingcar;

import racingcar.dto.RacingGameInitializationRequest;

import java.util.ArrayList;

public class RacingCarGameModel {
    ArrayList<ParticipantEntity> participantEntities = new ArrayList<>();
    private int time = 0;

    public void initializationGame(RacingGameInitializationRequest request) {
        String[] participants = request.participants().split(",");

        for (String participant : participants) {
            participantEntities.add(new ParticipantEntity(nameValidation(participant)));
        }

        time = timeValidation(request.time());
    }

    private String nameValidation(String name) {
        name = name.trim();

        if (name.length() > 5 || name.isEmpty()) {
            throw new IllegalArgumentException("참가자의 이름은 1글자 이상, 5자 이하만 가능합니다.");
        }

        return name;
    }

    private int timeValidation(String time) {
        int validationTime = 0;

        try {
            validationTime = Integer.parseInt(time.trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("시행횟수는 숫자만 가능합니다. 숫자만 입력해주세요.");
        }

        return validationTime;
    }
}
