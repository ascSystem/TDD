package bowling;

public class Frame {
	private int firstPins;
	private int secondPins;
	private int bonus;
	private int shotCounts = 0;
	private int needBonus;

	public void shot(int pins) {
		if(this.shotCounts == 0){
			this.firstPins = pins;
		}else{
			this.secondPins = pins;
		}
		if(judgeSpare())this.needBonus = 1;
		if(judgeStrike()){
			this.needBonus = 2;
			this.shotCounts = 2;
		}else{
			this.shotCounts++;
		}
	}

	public int frameScore() {
		return this.firstPins + this.secondPins + this.bonus;
	}

	public boolean checkFinished() {
		return (this.shotCounts == 2);
	}

	public boolean judgeSpare() {
		return (this.firstPins + this.secondPins ==10)&&(!(judgeStrike()));
	}
	public boolean judgeStrike() {
		return (this.firstPins  == 10);
	}

	public void addBonus(int pins) {
		if(this.needBonus > 0){
			this.bonus = this.bonus + pins;
			this.needBonus--;
		}
	}

}
