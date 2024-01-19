package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class BaseballGame {

    private static final int BALL_LENGTH = 3;
    private static final String START_COMMENT = "숫자를 입력해주세요 : ";
    private static final String END_COMMENT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RE_START_COMMET = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String START_NUMBER = "1";


    private List<Integer> answer;

    public String restart = START_NUMBER;

    private BaseBall baseBall;

    public BaseballGame(){
        baseBall = new BaseBall();
    }

    public BaseBall getBaseBall(){
        return this.baseBall;
    }

    public void calculateScore(String input){
        calculateBall(input);

        calculateStrike(input);

        calculateNone(input);
    }

    public void processStartGame(){
        init();
        startComment();
    }

    private void init(){
        this.answer = Randoms.pickUniqueNumbersInRange(1,9,3);
    }

    public boolean restartEquals1(){
        return restart.equals(START_NUMBER);
    }

    private void calculateBall(String input){
        for(int i=0; i<BALL_LENGTH; i++){
            if(isContainAnswer(input,i) && checkEqualNumber(input,i)){
                baseBall.increaseBall();
            }
        }
    }

    private void calculateStrike(String input){
        for(int i=0; i<BALL_LENGTH; i++){
            if(checkEqualNumber(input,i)){
                baseBall.increaseStrike();
            }
        }
    }

    private void calculateNone(String input){
        for(int i=0; i<BALL_LENGTH; i++){
           if(!isContainAnswer(input, i)){
               baseBall.increaseNone();
           }
        }
    }

    private boolean isContainAnswer(String input, int index){
        return answer.contains(charToInt(input.charAt(index)));
    }

    private int charToInt(char input){
        return Integer.parseInt(String.valueOf(input));
    }

    private boolean checkEqualNumber(String input,int index){
        return charToInt(input.charAt(index)) == answer.get(index);
    }

    private void startComment(){
        System.out.print(START_COMMENT);
    }

    public void endComment(){
        System.out.println(END_COMMENT);
    }

    public void generateResultComment(){
        baseBall.printCurrentScore();
    }

    public void processEndGame(String restart){
        if(baseBall.has3Strike()){
            endComment();
            restartComment();
        }
        this.restart = restart;
    }

    public void restartComment(){
        System.out.println(RE_START_COMMET);
    }

    public void checkInputData(String input){
        if(!isInteger(input) || !has3Length(input)){
            throw new IllegalArgumentException();
        }
    }

    private boolean isInteger(String req){
        return req.matches("-?\\d+");
    }

    private boolean has3Length(String req){
        return req.length()==3;
    }


}
