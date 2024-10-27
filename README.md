# 7기 백엔드 2주차 미션 - 자동차 경주

## 기능 목록

- 입력 기능
  - [x] 첫 번째 입력 - 자동차 이름은 **쉼표(,)를 기준으로 구분**하며 이름은 **5자 이하**만 가능하다.
    ```text
    경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
    pobi,woni,jun
    ```
    - 구분자 형식만 지키면 숫자든 첫 번째 입력은 쉼표를 기준으로 구분되는 다수의 길이 5이하의 `String`
  - [x] 두 번째 입력 - 사용자는 **몇 번의 이동**을 할 것인지를 입력할 수 있어야 한다.
    ```text
    시도할 횟수는 몇 회인가요?
    5
    ```
    - 이동 횟수는 소수점으로 표현할 수 없음 -> 두 번째 입력은 범위를 넘어가지 않는 0 이상의 `Integer`
  
- 입력 검증 기능
  - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
    - [x] Case 1. 입력이 주어지지 않았을 때(공백 문자가 들어오는 경우)
    - [x] Case 2. 입력된 자동차 중 이름 길이가 5를 넘어가는 자동차가 있는 경우
    - [x] Case 3. 이동 횟수를 입력할 때 0 ~ 2,147,483,647 외의 정수가 입력되는 경우
    - [x] Case 4. 이동 횟수를 입력할 때 숫자가 아닌 문자가 들어오는 경우
  
- 경주 수행 기능
    - [x] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
    - [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
    
- 우승자 산출 기능
    
    - [ ] 라운드가 모두 끝나면 우승자를 뽑아야 한다. 우승자는 한 명 이상일 수 있다.
    - [ ] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
    
- 출력 기능
  - [x] 차수별 실행 결과 - 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
    ```text
    pobi : --
    woni : ----
    jun : ---
    ```
    - 각 결과는 입력 2에서 주어진 횟수만큼 반복 출력되어야 한다.
    
  - [x] 우승자 안내 문구 - 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
    - [x] 단독 우승자 안내 문구
    
      ```
      최종 우승자 : pobi
      ```
      
    - [x] 공동 우승자 안내 문구 - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
    
    	```text
    	최종 우승자 : pobi, jun
    	```

## 제출 전 체크리스트

### 과제 진행 관련

- [ ] README.md에 정리한 기능 목록 단위로 커밋을 추가했는가?
- [ ] AngularJS Git Commit Message Conventions를 참고해 커밋 메시지를 작성했는가?
- [ ] JDK 21 버전에서 실행이 가능한가?
- [ ] 프로그램 실행의 시작점이 `Application`의 `main()`인가?
- [ ] `build.gradle` 파일의 무결성이 유지되었는가?
- [ ] 외부 라이브러리를 사용하지 않았는가?
- [ ] `System.exit()`를 이용하여 프로그램을 강제로 종료하지 않았는가?
- [ ] 구현 시 생성한 파일을 제외한 기존에 존재하던 파일들의 이름과 패키지를 변경하지 않았는가?
- [ ] 작성된 코드 중 indent depth가 3을 넘어가는 코드가 존재하는가?
- [ ] 3항 연산자를 사용하지 않았는가?
- [ ] 메서드가 한 가지 일만을 담당하고 있는가?
- [ ] 정리 및 구현한 기능 목록들을 테스트 코드를 통해 검증했는가?