package bowling;

public class BowlingGame {
	private int score;
	private int oldPins;
	private boolean spairFlag;
	private boolean flameEnd = false;
	private int strikeFlag;


	public void shot(int pins) {
		this.score = this.score + pins;
		addSpairBonus(pins);
		addStrikeBonus(pins);
		judgeSpare(pins);
		judgeStrike(pins);
		judgeFlameEnd();
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
			strikeFlag--;
		}
	}
	private void judgeSpare(int pins){
		this.spairFlag =(this.oldPins + pins == 10)&&this.flameEnd;
		this.oldPins = pins;
	}
	private void judgeStrike(int pins){
		if((pins == 10)&&(!(this.flameEnd))){
			this.strikeFlag = 2;
		}
	}
	private void judgeFlameEnd() {
		this.flameEnd = !(this.flameEnd);
		if(this.strikeFlag == 2) this.flameEnd = false;
	}



}
