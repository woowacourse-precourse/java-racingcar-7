# java-racingcar-precourse

![image](https://github.com/user-attachments/assets/7e5f21c4-fd8f-421f-bf5a-a0e75116beb7)

> # 🏎️ 자동차 경주
입력한 문자열에서 기본 구분자 및 커스텀 구분자를 기준으로 숫자를 추출하여 더하는 계산기를 구현

<br>

> ## ⚽ 학습 목표
- 여러 역할을 수행하는 큰 함수를 단일 역할을 수행하는 작은 함수로 분리한다.
- 테스트 도구를 사용하는 방법을 배우고 프로그램이 제대로 작동하는지 테스트한다.
- 1주 차 공통 피드백을 최대한 반영한다.

<br>

> ## 🧬 프로젝트 구조
- 자동차 상태 관리 및 전진 기능 (`Car` 클래스)
  - 자동차의 이름과 위치를 저장하고, 전진 조건에 따라 이동
  - 현재 위치를 시각적으로 표시
- 입력 값 검증 기능 (`Validator` 클래스)
  - 자동차 이름의 길이, 특수 문자 포함 여부, 중복 여부 등을 검증
  - 시도 횟수가 유효한 숫자이자 양수인지 검증

<br>

> ## 📋 기능 목록
- 경주할 자동차 이름을 입력받는 기능 ☑️
  - 쉼표 기준으로 구분
  - 이름은 5자 이하
- 시도할 횟수를 입력받는 기능 ☑️
- `Randoms.pickNumberInRange(0, 9)`가 4 이상일 경우 전진하는 기능 ☑️
- 차수별 실행 결과를 출력하는 기능 ☑️
- 자동차 경주 게임을 완료한 후 우승자를 출력하는 기능
  - 여러 명일 경우 `,`를 이용하여 구분

<br>

> ## 📋 예외 처리 목록
사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 프로그램 종료

<br>

 - 자동차 이름이 유효하지 않은 경우 ☑️
   - 자동차 이름 내부에 공백 존재
   - 자동차 이름이 언더바(`_`)를 제외한 특수 문자를 포함한 경우
   - 언더바(`_`)가 이름의 시작이나 끝에 위치하는 경우
   - 자동차 이름이 5자가 초과하는 경우
   - 자동차 이름이 중복되는 경우
 - 시도할 횟수가 양수로 주어지지 않은 경우 ☑️
   - 시도할 횟수가 음수거나, 영(`0`)일 경우
   - 시도할 횟수가 문자가 포함되어 주어진 경우

<br>

> ## 📺 개발 환경
- <img src="https://img.shields.io/badge/Build-%23121011?style=for-the-badge"><img src="https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=Gradle&logoColor=white"><img src="https://img.shields.io/badge/8.7-515151?style=for-the-badge">
- <img src="https://img.shields.io/badge/Language-%23121011?style=for-the-badge"><img src="https://img.shields.io/badge/java-%23ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"><img src="https://img.shields.io/badge/21-515151?style=for-the-badge">
- <img src="https://img.shields.io/badge/Project Encoding-%23121011?style=for-the-badge"><img src="https://img.shields.io/badge/UTF 8-EA2328?style=for-the-badge">
