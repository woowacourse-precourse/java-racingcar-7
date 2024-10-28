# java-racingcar-precourse
# 기능 요구사항
- 쉼표(`,`)를 기준으로 구분된 자동차 목록에 대하여 경주를 진행한다.
  - 각 자동차 이름은 5글자 이하
- 총 이동 횟수는 사용자의 입력을 기반으로 한다. 이동은 랜덤한 자동차에 대해 진행한다.
  - 이동 대상은 `0~9` 사이에서 추출된 랜덤한 값이 4 이상인 경우 선별된다.
- 종료 시 우승자를 선발한다. 동점자 발생 가능
- 잘못된 값을 입력 시, IllegalArgumentException 발생 후 종료한다.

# 개발 시스템 요구사항
- 들여쓰기 depth 2이하로 진행
- 3항 연산자 금지
- 최소 기능 메서드 구현 (클린코드)
- 테스트 코드 작성

# 구현 순서
1. 사용자 입력 받기 및 변환 작업 (자동차 목록 및 이동 횟수)
2. 랜덤 기능 구현 (자동차 선별 및 이동 여부)
3. 출력 기능 구현 (단계별 이동 결과 및 우승자 결과)
4. 게임 메인 로직 구현 (1~3에서 구현한 기능별 메서드 기반)

테스트코드는 각 단계에서 구현하며, 기타 예외사항도 동시에 처리한다.
