package bowling;

public class BowlingGame {
	private int score;
	private int oldPins;
	private boolean spairFlag;
	private int strikeFlag;
	private int doubleFlag;
	private boolean now2ndShot = false;

	public void shot(int pins) {
		this.score = this.score + pins;
		addSpairBonus(pins);
		addStrikeBonus(pins);
		addDoubleBonus(pins);
		judgeSpare(pins);
		judgeStrike(pins);
		judgeNow2ndShot();
	}
	public int getScore() {
		return this.score;
	}

	private void addSpairBonus(int pins) {
		if(this.spairFlag){
			this.score = this.score + pins;
		}
	}
	private void addStrikeBonus(int pins) {
		if(this.strikeFlag > 0){
			this.score = this.score + pins;
			this.strikeFlag--;
		}
	}
	private void addDoubleBonus(int pins) {
		if(this.doubleFlag > 0){
			this.score = this.score + pins;
			this.doubleFlag--;
		}
	}
	private void judgeSpare(int pins){
		this.spairFlag =(this.oldPins + pins == 10)&&this.now2ndShot;
		this.oldPins = pins;
	}
	private void judgeStrike(int pins){
		if((pins == 10)&&(!(this.now2ndShot))){
			if(this.strikeFlag == 0){
				this.strikeFlag = 2;
			}else{
				this.doubleFlag = 2;
			}
		}
	}
	private void judgeNow2ndShot() {
		this.now2ndShot = !(this.now2ndShot);
		if((this.strikeFlag == 2)||(this.doubleFlag == 2)) this.now2ndShot = false;
	}



}
