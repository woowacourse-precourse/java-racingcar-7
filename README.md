# 🏎️ 미션 - 자동차 경주

## 💡 핵심 기능

### What

- 자동차 이름과 이동 조건을 설정해 주어진 횟수 동안 경주를 진행하고, 가장 멀리 이동한 자동차(들)를 우승자로 선정하는 기능을 제공하는 것

### How

- 각 턴에서 자동차는 0~9 사이의 무작위 값을 기준으로, 값이 4 이상일 경우 전진하고, 그렇지 않으면 멈추도록 구현
- 현재는 한 칸씩 전진하지만, 전진 칸 수의 확장성을 고려하여 설계
- 현재는 전진 기준이 무작위 값이 4일 때이지만, 무작위 값 조건의 확장성도 고려하여 설계 

### Why

- 전진 칸 수와 조건의 확장성을 고려하여, 다양한 게임 규칙으로 난이도와 재미를 높이기 위해
- 전진 칸 수와 조건이 바뀌어도 코드를 쉽게 수정하고 확장할 수 있도록 하기 위해

## ⛳️ 2주차 목표
- [ ] VO 사용해보기
- [ ] 1주차 피드백 모두 반영하기

## ✏️ 구현할 기능 목록

### 자동차 이름 입력 안내 멘트

- [x] "`경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`" 를 출력한다.

### 자동차 이름 입력값 확인

- [x] **사용자에게 경주할 자동차 이름을 입력받는다.**
    - [x] 입력된 문자열의 앞뒤 공백을 제거한다.
    - [x] 입력된 문자열이 `null`인지 확인한다.
        - [x] `null`인 경우`IllegalArgumentException`을 발생시키고 **"`null은 입력할 수 없습니다.`"** 라는 오류 메시지를 출력한 후 프로그램을 종료한다.
    - [x] 입력된 문자열이 빈 문자열(`""`)인지 확인한다.
        - [x] `빈 문자열`인 경우 `IllegalArgumentException`을 발생시키고 **"`빈 문자열은 입력할 수 없습니다.`"** 라는 오류 메시지를 출력한 후 프로그램을 종료한다.
    - [x] 입력된 각 자동차 이름의 앞뒤 공백을 제거하고 이름이 빈 문자열(`""`)인 자동차가 있는지 확인한다.
        - [x] `이름이 빈 문자인 자동차가 있는` 경우 `IllegalArgumentException`을 발생시키고 **"`자동차 이름은 빈 문자열일 수 없습니다.`"** 라는 오류 메시지를 출력한 후 프로그램을 종료한다.
    - [x] 입력된 자동차 이름이 `5자 초과`인지 확인한다
        - [x] `5자 초과`인 경우 `IllegalArgumentException`을 발생시키고 **"`자동차 이름은 5자 이하이어야 합니다.`"** 라는 오류 메시지를 출력한 후 프로그램을 종료한다.
    - [ ] 입력된 자동차 이름이 `중복`인지 확인한다
        - [ ] `자동차 이름이 중복`인 경우 `IllegalArgumentException`을 발생시키고 **"`자동차 이름은 중복이 되지 않아야 합니다.`"** 라는 오류 메시지를 출력한 후 프로그램을 종료한다.
    - [ ] 입력된 자동차 개수가 `1개 이하`인지 확인한다.
        - [ ] `자동차 개수가 1개 이하`인 경우 `IllegalArgumentException`을 발생시키고 **"`경주에 참가하는 자동차는 2개 이상이어야 합니다.`"** 라는 오류 메시지를 출력한 후 프로그램을 종료한다.
    - [ ] **그외 경우 다음 단계를 진행한다.**

### 시도할 횟수 이름 입력 안내 멘트

- [x] "`시도할 횟수를 입력하세요.`" 를 출력한다.

### 시도할 횟수 입력값 확인
- [x] **사용자에게 시도할 횟수를 입력받는다.**
    - [x] 입력된 문자열이 `null`인지 확인한다.
        - [x] `null`인 경우`IllegalArgumentException`을 발생시키고 **"`null은 입력할 수 없습니다.`"** 라는 오류 메시지를 출력한 후 프로그램을 종료한다.
    - [x] 입력된 문자열이 빈 문자열(`""`)인지 확인한다.
        - [x] `빈 문자열`인 경우 `IllegalArgumentException`을 발생시키고 **"`빈 문자열은 입력할 수 없습니다.`"** 라는 오류 메시지를 출력한 후 프로그램을 종료한다.
    - [x] 입력된 시도할 횟수가 `1 이상의 양의 정수가 아닌지` 확인한다.
        - [x] `정수가 아니거나 1 미만`일 경우 `IllegalArgumentException`을 발생시키고 **"`시도할 횟수는 최소 1 이상의 양의 정수이어야 합니다.`"** 라는 오류 메시지를 출력한 후 프로그램을 종료한다.
    - [ ] **그외 경우 다음 단계를 진행한다.**
  
### 자동차 경주 진행
- [ ] 입력 받은 시도 횟수만큼 아래 로직을 수행한다.
  - [ ] 0 ~ 9 사이의 랜덤한 정수를 생성한다.
  - [ ] 랜덤 값이 4 이상일 경우 자동차를 전진시킨다.
  - [ ] 매 라운드 마다 자동차 이름과 이동한 거리를 출력한다.

### 자동차 경주 종료
- [ ] 게임이 끝난 후 가장 많이 전진한 위치를 구한다.
- [ ] 최대 위치 값에 해당하는 우승한 자동차 목록을 구한다.
- [ ] 우승자(들)를 출력한다.

## 📦 역할 별 패키지 분리



## ✅ 1주차 피드백 반영 여부
- [ ]  요구 사항을 정확하게 준수한다
- [ ]  커밋 메시지를 의미 있게 작성한다
- [ ]  커밋 메시지에 이슈 또는 풀 리퀘스트 번호를 포함하지 않는다
- [ ]  풀 리퀘스트를 만든 후에는 닫지 말고 추가 커밋을 한다
- [ ]  오류를 찾을 때 출력 함수 대신 디버거를 사용한다
- [ ]  이름을 통해 의도를 드러낸다
- [ ]  축약하지 않는다
- [ ]  if, for, while문 사이의 공백도 코딩 컨벤션이다.
- [ ]  공백 라인을 의미 있게 사용한다
- [ ]  스페이스와 탭을 혼용하지 않는다
- [ ]  의미 없는 주석을 달지 않는다
- [ ]  코드 포매팅을 사용한다
- [ ]  Java에서 제공하는 API를 적극 활용한다
- [ ]  배열 대신 컬렉션을 사용한다

## ✅ 과제 진행 요구 사항

- [x]  **[java-racingcar-7](https://github.com/woowacourse-precourse/java-racingcar-7)** 저장소를 Fork & Clone
- [x]  README.md에 구현할 기능 목록을 정리해 추가
- [ ]  완료 후 Pull Request
- [ ]  중간 회고를 진행하고 소감에 구체적인 결과를 작성해서 제출
- [ ]  제출한 후 결과 확인, 통과하지 못했다면 수정해 다시 제출

## ✅ 프로그래밍 요구 사항

### 제출 전 확인 리스트

- [ ]  JDK-21 사용
- [ ]  프로그램 실행의 시작점은 `Application`의 `main()`
- [ ]  `build.gradle` 변경 불가, 제공된 라이브러리만 사용
- [ ]  [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 준수하며 프로그래밍
- [ ]  프로그램 종료 시`System.exit()`를 호출 X
- [ ]  프로그램 구현 완료 시 `ApplicationTest`의 모든 테스트가 성공
- [ ]  프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동 X
- [ ]  자바 코드 컨벤션을 지키면서 프로그래밍한다.
- [ ]  indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [ ]  3항 연산자를 쓰지 않는다.
- [ ]  함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ]  JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.


### 라이브러리 요구 사항

- [ ]  camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현
    - [ ]  Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
    - [ ] 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
- [ ]  사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용 
