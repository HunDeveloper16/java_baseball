package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private static final int BALL_LENGTH = 3;
    private static final String START_COMMENT = "숫자를 입력해주세요 : ";
    private static final String COMPLATE_COMMENT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RE_START_COMMENT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String START_NUMBER = "1";
    private static final String END_NUMBER = "2";

    private List<Integer> answer = new ArrayList<>();
    private String restart = START_NUMBER;
    private BaseBall baseBall = new BaseBall();

    public BaseballGame(){
    }

    public void init(){
       answer = Randoms.pickUniqueNumbersInRange(1,9,3);
    }

    public boolean restartEquals1(){
        return restart.equals(START_NUMBER);
    }

    private void calculateScore(String input){
        for(int i=0; i<BALL_LENGTH; i++){
            if(isContainAnswer(input,i) && !checkEqualNumber(input,i)){
                baseBall.increaseBall();
            }
            if(checkEqualNumber(input,i)){
                baseBall.increaseStrike();
            }
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

    public void startProcess(){
        startComment();
    }

    public void middleProcess(String input){
        validateInputData(input);

        calculateScore(input);

        generateResultComment();
    }

    private void complateComment(){
        System.out.println(COMPLATE_COMMENT);
    }

    public void generateResultComment(){
        baseBall.printCurrentScore();
    }

    public void resetBallScore(){
        baseBall.resetScore();
    }

    public void endComment(){
        complateComment();

        restartComment();
    }

    public void generateNextGame(String input){
        if(input.equals(START_NUMBER)){
            answer.clear();
            init();
        }else{
            restart = END_NUMBER;
        }
    }

    private void restartComment(){
        System.out.println(RE_START_COMMENT);
    }

    private void validateInputData(String input){
        if(!isInteger(input) || !has3Length(input)){
            throw new IllegalArgumentException();
        }
    }


    public boolean has3Strike(){
        return baseBall.has3Strike();
    }

    private boolean isInteger(String req){
        return req.matches("-?\\d+");
    }

    private boolean has3Length(String req){
        return req.length()==3;
    }


}
