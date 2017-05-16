package bowling;

public class BowlingGame {
	private int score;
	private int oldPins;
	private boolean spairFlag;

	public void shot(int pins) {
		this.score = this.score + pins;
		if(this.spairFlag){
			this.score = this.score + pins;
		}
		judgeSpare(pins);
	}

	public int getScore() {
		return this.score;
	}
	public void judgeSpare(int pins){
		this.spairFlag =(this.oldPins + pins == 10);
		this.oldPins = pins;
	}

}
