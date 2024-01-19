package baseball;

public class BaseBall {

    private static final String BALL_NAME = "볼";
    private static final String STRIKE_NAME = "스트라이크";
    private static final String ALL_NONE = "낫싱";

    private int ball;
    private int strike;
    private int none;

    public BaseBall() {
        this.ball = 0;
        this.strike = 0;
        this.none = 0;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getNone() {
        return none;
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

    public boolean has3Strike(){
        return strike == 3;
    }

    public boolean has3None(){
        return none == 3;
    }

    public void printCurrentScore(){
        StringBuilder result = new StringBuilder();
        if(has3Strike()) {
            result.append(strike).append(STRIKE_NAME);
        }
        if(has3None()){
            result.append(ALL_NONE);
        }
        if(ball > 0){
            result.append(ball).append(BALL_NAME).append(" ");
        }
        if(strike > 0){
            result.append(strike).append(STRIKE_NAME).append(" ");
        }
        System.out.println(result);
    }


}


