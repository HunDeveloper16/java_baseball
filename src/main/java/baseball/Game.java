package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    /**
     * 플레이어의 입력값을 받아옵니다.
     */
    public String getUserInput(){
        return Console.readLine();
    }


    /**
     * 야구 게임을 시작합니다.
     */
    public void playBaseballGame(){
        BaseballGame ballGame = new BaseballGame();

        String input;
        while(ballGame.restartEquals1()){
            ballGame.processStartGame();
            // 외부 값을 입력받습니다.
            input = getUserInput();

            ballGame.checkInputData(input);
            ballGame.calculateScore(input);
            ballGame.generateResultComment();

            ballGame.processEndGame(input);

            // 외부 값을 입력받습니다.
            if(ballGame.getBaseBall().has3Strike()){
                input = getUserInput();
            }
        }
    }


}
