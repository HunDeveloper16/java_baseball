package baseball;

public class BaseBall {

    private static final String BALL_NAME = "볼";
    private static final String STRIKE_NAME = "스트라이크";
    private static final String ALL_NONE = "낫싱";
    private static final Integer START_INDEX = 0;

    private int ball;
    private int strike;
    private int none;

    private StringBuilder result = new StringBuilder();

    public BaseBall() {
        this.ball = 0;
        this.strike = 0;
        this.none = 0;
    }

    public void increaseBall(){
        this.ball += 1;
    }

    public void increaseStrike(){
        this.strike += 1;
    }

    public void increaseNone(){
        this.none += 1;
    }

    public void resetScore(){
        this.ball = 0;
        this.strike = 0;
        this.none = 0;
    }

    public boolean has3Strike(){
        return strike == 3;
    }

    public boolean has3None(){
        return none == 3;
    }

    public void printCurrentScore(){
        if(has3Strike()) {
            generateResult(strike, STRIKE_NAME);

            printResult(result.toString());

            resetResult();
            return;
        }
        if(has3None()){
            generateResult(ALL_NONE);

            printResult(result.toString());

            resetResult();
            return;
        }
        if(ball > 0){
            generateResult(ball, BALL_NAME);
        }
        if(strike > 0){
            generateResult(strike, STRIKE_NAME);
        }
        printResult(result.toString());
        resetResult();
    }


    public void resetResult(){
        result.delete(START_INDEX, result.length());
    }

    private void generateResult(int count,String type){
        result.append(count).append(type).append(" ");
    }

    private void generateResult(String type){
        result.append(type);
    }

    private void printResult(String result){
        System.out.println(result);
    }


}


