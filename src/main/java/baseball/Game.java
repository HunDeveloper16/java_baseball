package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    public String getUserInput(){
        return Console.readLine();
    }

    public void playBaseballGame(){
        BaseballGame ballGame = new BaseballGame();

        String input;
        while(ballGame.restartEquals1()){
            // 외부 값을 입력받습니다.
            input = getUserInput();

            ballGame.processStartGame(input);

            ballGame.calculateScore(input);
            ballGame.generateResultComment();

            // 외부 값을 입력받습니다.
            input = getUserInput();

            ballGame.processEndGame(input);
        }
    }


}
