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
        ballGame.init();

        while(ballGame.restartEquals1()){
            ballGame.startProcess();

            ballGame.middleProcess(getUserInput());

            if(ballGame.has3Strike()){
                ballGame.endComment();
                ballGame.generateNextGame(getUserInput());
            }
            ballGame.resetBallScore();
        }
    }


}
