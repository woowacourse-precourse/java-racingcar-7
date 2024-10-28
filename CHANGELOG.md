#  (2024-10-28)


### Features

* **GameClient:** 전체적인 게임 로직을 담당하는 클래스 구현 ([bccd0bb](https://github.com/GiHwan2/java-racingcar-7/commit/bccd0bb371daa6a66aec0e530721ccde1f48ac11))
* **InputView:** 입력을 받는 클래스 구현 ([e780318](https://github.com/GiHwan2/java-racingcar-7/commit/e780318382349573223b23d3a64023cecb5f52b5))
* **OutputView:** 출력 메시지를 관리하는 클래스 구현 ([2be23a7](https://github.com/GiHwan2/java-racingcar-7/commit/2be23a700f6ccfbb6d88ed25d58690976c1e4ffe))
* **RacingCarList:** 자동차 관리를 진행할 클래스 구현 ([4ee9fc3](https://github.com/GiHwan2/java-racingcar-7/commit/4ee9fc3fefdf4168a7c2475bf0a5d9774068b89d))
* **RacingCar:** 자동차 이동 로직과 이름 유효성 검증 구현 ([64c1d0c](https://github.com/GiHwan2/java-racingcar-7/commit/64c1d0c9521c51f67a6b295cc383997a72c06cb3))
* setup project ([5ec1344](https://github.com/GiHwan2/java-racingcar-7/commit/5ec134471d4ad7798af498020b4179d887b21a52))



* refactor(InputViewTest): 불필요한 import문 제거
* refactor(View): InputView 와 OutputView DI형식으로 변경
* refactor(OutputView): if문 제거하여 가독성 향상
* refactor(GameClient): run 메서드 책임 분리
* refactor(InputView): getCarNames 메서드 책임 분리 적용
* refactor(RacingCarList): racingCars 리스트 의존성 주입 수정
* feat(GameClient): 전체적인 게임 로직을 담당하는 클래스 구현
* feat(OutputView): 출력 메시지를 관리하는 클래스 구현
* refactor(RacingCar): 자동차 상태 정보를 담은 클래스 구현
* refactor(InputView): 시도 횟수 검증 메서드 분리
* feat(InputView): 입력을 받는 클래스 구현
* feat(RacingCarList): 자동차 관리를 진행할 클래스 구현
* test(RacingCarTest): 자동차 이동 로직과 이름 유효성 검증 구현 테스트 코드 추가
* feat(RacingCar): 자동차 이동 로직과 이름 유효성 검증 구현
* docs(README): 구현할 기능 목록 작성
* feat: setup project