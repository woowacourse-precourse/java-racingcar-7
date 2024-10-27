# java-racingcar-precourse

## :skull: 구현할 기능 목록

### 자동차 이름들(carNamesRaw) 입력 처리

**자동차 이름들**은 *쉼표(,)로 구분된 자동차 경기에 참가하는
n개의 자동차 이름들* 을 의미합니다.

- [ ] 쉼표(`,`)로 구분되는 자동차 이름들을 입력 받음
  - `,` 외의 모든 문자는 이름의 일부로 간주
  - 쉼표 앞뒤로 붙은 공백은 구분자로 간주
    - 예: `abc, ave   , aef,gh,ij` → `abc`, `ave`, `aef`, `gh`, `ij`
    - 스페이스 누르는 기준이 다 다르기 때문
  - 리스트 첫 이름의 leading whitespace, 마지막 이름의 trailing whitespace는 무시
    - 타 조건 검사 전 `strip()` 사용
- [ ] 각 이름은 5자 이하만 허용
- [ ] 빈 이름은 입력하지 않은 것으로 간주하고 무시
- [ ] 중복된 이름 금지
- [ ] 참가자 0명 금지
  - 참가자 1명 허용 (단독 참가하여 우승 허용)

### 반복 횟수(iterationNumberRaw) 입력 처리

**반복 횟수**는 자동차 이름들 다음으로 입력받는
*10진수 양수 정수 문자열* 을 의미합니다.

- [ ] <kbd>⏎ Enter</kbd> 누를 때까지 입력 받음
- [ ] 양수 정수만 허용
- [ ] 10진수만 허용
- [ ] leading/trailing whitespaces는 `strip()`하여 너그럽게 허용

### 계산 및 계산 경과 출력 처리

- [ ] 0~9 사이의 랜덤한 정수를 뽑아(roll) 4 이상일 경우 전진
- [ ] cars의 모든 entry에 대해 roll 후 현재 상태를 visualize

### 메시지 처리

**메시지**는 프로그램 동작 시 사용자의 콘솔에 표시될 수 있는 문자열로,
<b><기능 요구 사항></b>의 <b><실행 결과 예시></b>에서 주어진 *일반 메시지*와,
예외 발생 시 표시되는 *예외 메시지*를 의미합니다.

- 일반 메시지
  - [ ] `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n`
  - [ ] `시도할 횟수는 몇 회인가요?\n`
  - [ ] `실행 결과\n`
  - [ ] `{carName} : {distanceBar}\n`
  - [ ] `\n최종 우승자 : {String.join(", ", winnerCars)}`
- 올바른 행동을 유도하는 예외 메시지
  - [ ] 모든 예외 메시지에 접두사 `[ERROR] ` 표시
  - [ ] 길이 초과 시 표시
  - [ ] 이름 중복 시 표시
  - [ ] 참가자 비어있을 시 표시
  - [ ] 숫자 파싱 실패 시 표시

### 추가 요구 사항 준수

**추가 요구 사항**은 <b><1주차 공통 피드백></b>, <b><프로그래밍 요구 사항></b>에 명시된,
*기능 외의 요구 사항* 을 의미합니다.

- **<프로그래밍 요구 사항>** 관련
  - [ ] JDK 21 사용
  - [ ] `System.exit()` 호출 금지
  - [ ] 요구 사항에서 명시하지 않은 파일 및 패키지 변경 금지
  - [ ] [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/blob/main/styleguide/java) 준수
  - [ ] indent depth는 2까지 허용
  - [ ] 3항 연산자 금지
  - [ ] 함수 또는 메서드는 한 가지 일만 하도록 작게 구현
  - [ ] JUnit 5와 AssertJ를 이용한 테스트 구현
  - `camp.nextstep.edu.missionutils`에서 제공하는 API로 입력 및 랜덤 처리
    - [ ] 입력은 `Console.readLine()` 사용
    - [ ] 랜덤은 `Randoms.pickNumberInRange()` 사용
- **<1주차 공통 피드백>** 관련
  - Git 관련
    - [ ] 기본적인 Git 명령어 숙지
    - [ ] Git으로 관리할 자원 고려
    - [ ] 의미 있는 커밋 메시지
    - [ ] 커밋 메시지에 이슈 또는 PR 번호 포함 금지
    - [ ] PR 생성 후 닫지 않는다(닫을 필요가 없다)
  - [ ] 디버깅 시 `sout` 말고 디버거 사용
  - 코드 작성 관련
    - [ ] 이름을 통해 의도 드러내기
    - [ ] 축약 금지
    - [ ] 코딩 컨벤션의 올바른 공백 준수
    - [ ] 의미 있는 공백 라인
    - [ ] 스페이스와 탭 중 하나만 사용
    - [ ] 의미 없는 주석 금지
    - [ ] 코드 포매팅 사용
    - [ ] Java 기본 API 적극 활용
    - [ ] 배열 대신 컬렉션(`List`, `Set`, `Map`) 사용
