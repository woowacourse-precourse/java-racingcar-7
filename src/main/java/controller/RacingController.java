package controller;

import common.BeanFactory;
import dto.OriginalInputDTO;
import dto.ValidatedInputDataDTO;
import service.RacingService;

public class RacingController {

    private final BeanFactory beanFactory;
    private final OriginalInputDTO originalInput;

    public RacingController(BeanFactory beanFactory, OriginalInputDTO originalInput) {
        this.beanFactory = beanFactory;
        this.originalInput = originalInput;
    }

    public String run() {
        ValidatedInputDataDTO validatedInputDataDTO = validateInput();
        RacingService racingService = beanFactory.provideRacingService(validatedInputDataDTO);
        return racingService.racingStart();
    }

    public ValidatedInputDataDTO validateInput(){
        OriginalInputDTO replaceBlankInput = replaceBlankInput(originalInput.name(), originalInput.name());
        isEmptyInput(replaceBlankInput.name(), replaceBlankInput.count());
        return new ValidatedInputDataDTO(replaceBlankInput.name(),convertTryCount(replaceBlankInput.count()));
    }


    public OriginalInputDTO replaceBlankInput(String name, String count){
        return new OriginalInputDTO(name.replace(" ", ""), count.replace(" ", ""));
    }

    public void isEmptyInput(String name,String count){
        //TODO : exceptionMessage Enum 만들어서 관리 하기.
        if (name.isBlank()||name.isEmpty()){
            throw new IllegalArgumentException("이름에는 공백만 입력할 수 없습니다.");
        }
        if (count.isBlank()||count.isEmpty()){
            throw new IllegalArgumentException("시도횟수는 1이상 입력해야합니다.");
        }
    }

    public Long convertTryCount(String tryCount){
        //TODO : Long 범위 벗어나면 예외처리
        return Long.parseLong(tryCount);
    }

}
