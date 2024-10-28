# java-racingcar-precourse

- - -

## 학습 목표
### 공통 목표
- 함수의 분리 : 큰 함수를 단일 역할을 수행하는 작은 함수로의 분리하자.
- 테스트 도구의 사용으로 작동 테스트를 진행하자.
- 1주차 공통 피드백 반영하자.

### 개인 목표
- 기능 구현을 모듈 단위에서 점차 확대하자.
- 변수명, 함수명을 직관적이고 상세하게 만들어 코드 의도를 드러내자.
- 단위 테스트를 진행하자.
- 출력 문구, 조건 등을 상수로 관리하자.
- 내부 필드의 변수의 필요성에 대해 한 번 더 생각하자.

- - -

## 과제 진행 방식 및 요구사항
1. 저장소를 포크/클론 한다.
2. 기능 구현 전 기능 목록을 `README.md` 정리해 추가한다.
3. 커밋 시, 커밋 단위와 커밋 메시지 컨벤션을 참고한다.
4. 기능 구현
   - 기본적인 기능을 우선적으로 구현한다.
   - 다음으로 추가 기능과 예외처리를 다룬다.
   - 단위 테스트를 진행한다.
5. 테스트 실행
   - 터미널에서 `java -version` 실행하여 21이 나오는지 확인한다.
   - 터미널에서 `./gradelw clean test` 실행하여 `BUILD SUCCESSFUL in Os`가 나오는지 확인한다.

- - -

## 패키지
```
📦racingcar
┣ 📂constant
┃ ┣ 📜Constant.java
┃ ┣ 📜ErrorMessage.java
┃ ┗ 📜OutputMessage.java
┣ 📂controller
┃ ┗ 📜RacingController.java
┣ 📂exception
┃ ┣ 📜EmptyNameException.java
┃ ┗ 📜OverLimitedNameException.java
┣ 📂model
┃ ┗ 📜Racing.java
┣ 📂service
┃ ┣ 📜InputService.java
┃ ┣ 📜RacingRoundService.java
┃ ┗ 📜WinnerService.java
┣ 📂validator
┃ ┗ 📜Validator.java
┣ 📂view
┃ ┣ 📜InputView.java
┃ ┗ 📜OutputView.java
┗ 📜Application.java
```

- - -

## 기능 요구사항 확인

- [x] 입력
  - [x] `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용
  - [x] 경주할 자동차 이름: 개수 제한 없음, 5자 이내, `,`으로 구분
    - [x] 예외 : 아래 예외 항목에 기재
    - [x] 이름에 숫자, 공백(문자 사이)는 가능
  - [x] 시도할 횟수
    - [x] 0 입력 시 종료
    - [ x] 예외: 아래 예외 항목에 기재

- [x] 출력
  - [x] 차수별 실행 결과
  - [x] 우승자 안내 문구

- [ ] 자동차
  - [x] 자동차 이름 정보와 여태까지의 이동을 같이 저장할 수 있는 것 선택 -> Map
  - [x] 이때 이동정보를 숫자로 저장 ~~혹은 "-" 으로 저장?~~

- [x] Random 시행 결과
  - [x] Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
  - [x] 0-9 사이의 정수
  - [x] N대의 자동차마다 시행하고 값을 가져야 한다.

- [x] 이동 결정
  - [x] Random 결과가 4 이상인지 판단
  - [x] 4 - 9이면 전진
  - [x] 0 ~ 3이면 정지

- [x] 우승자
  - [x] 자동차에서 이동정보 중 가장 큰 값 판단
  - [x] 이때 가장 큰 이동정보를 가진 자동차 이름을 얻어야 한다.
  - [x] 중복 허용

- [ ] 예외
  - [ ] 이름 입력: `IllegalArgumentException`
    - [x] 5자 초과 입력
    - [x] 공백 포함
    - [x] `""` 입력
    - [x] `\n` 입력
    - [x] `,` 을 포함하는 이름 -> 공백으로 처리
    - [x] 쉼표 개수 오타 -> 공백으로 처리
  - [x] 시도 횟수 입력: `NumberFormatException`
    - [x] 문자 입력, 소수/실수 입력, 음수 입력
    


- - -

## 기능 요구 사항
> 초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

- - -

## 입출력 요구 사항
**입력**
- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
```pobi,woni,jun```
- 시도할 횟수
```5```

**출력**
- 차수별 실행 결과
```
pobi : --
woni : ----
jun : ---
```
- 단독 우승자 안내 문구
```
최종 우승자 : pobi
공동 우승자 안내 문구
최종 우승자 : pobi, jun
```
- 실행 결과 예시
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
woni :
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```
