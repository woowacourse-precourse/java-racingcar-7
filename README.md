# 자동차 경주

자동차 경주는 자동차의 이름과 이동 횟수를 입력받은 뒤
각각의 자동차들을 확률적으로 이동시켜 우승자를 출력하는 초간단 게임입니다.
자동차의 이름은 쉼표로 구분되며 공백으로 지을 수 없으며 5자 이하여야 합니다.
우승자는 한 명 이상일 수 있습니다.

## 📝요구 사항 분석 후 결정 사항

* 자동차 이름 입력 문자열이 없다면 잘못된 입력으로 처리한다.
* 입력받은 자동차 이름 각각은 strip 해서 지정한다.
* 입력받은 자동차 이름이 공백문자인 경우 잘못된 입력으로 처리한다.
* 입력받은 자동차 이름이 중복될 시 잘못된 입력으로 처리한다.
* 이동 횟수가 0회면 잘못된 입력으로 처리한다.
* 이동 횟수는 최대 80회까지로 제한한다.

## 🔖구현한 기능

- [x] 자동차 이름 입력과 분석(빈 입력, 공백 이름, 중복 이름, 이름 길이)
- [x] 이동 횟수 입력과 분석(숫자가 아닌 문자열 입력, <= 0회, >= 80회)
- [x] 자동차 전진, 멈춤을 랜덤 숫자로 결정(각각의 자동차들 따로 계산)
- [x] 전진 결과를 출력
- [x] 최종 우승자 출력

## 📦️구현한 클래스

* Car 클래스
    * 자동차의 이름과 위치를 갖는 클래스
    * 객체를 생성할 때 이름이 알맞는지 확인


* CompeteCars 클래스
    * 경주에 참여할 자동차들을 생성하고 관리하는 클래스
    * 객체를 생성할 때 중복되는지 확인


* Round 클래스
    * 경주를 진행하는 클래스
    * 자동차들의 움직임을 설정


* RacingInputView 클래스
    * 경주할 자동차들을 입력
    * 이동 횟수를 입력
    * 입력이 알맞는지 확인


* RacingOutputView 클래스
    * 경주의 결과와 최종 우승자를 출력


* RacingGame 클래스
    * 게임을 진행하는 클래스
    * 입력, 경주 자동차들 생성, 라운드 진행, 출력을 실행