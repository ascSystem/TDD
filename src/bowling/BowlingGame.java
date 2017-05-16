package bowling;

public class BowlingGame {
	private int score;
	private int oldPins;
	private boolean spairFlag;

	public void shot(int pins) {
		this.score = this.score + pins;
		addSpairBonus(pins);
		judgeSpare(pins);
	}
	public int getScore() {
		return this.score;
	}

	private void addSpairBonus(int pins) {
		if(this.spairFlag){
			this.score = this.score + pins;
		}
	}

	private void judgeSpare(int pins){
		this.spairFlag =(this.oldPins + pins == 10);
		this.oldPins = pins;
	}

}
