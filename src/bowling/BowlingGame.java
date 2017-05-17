package bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	private List<Frame> frames = new ArrayList<>();

	public BowlingGame(){
		this.frames.add(new Frame());
	}

	public void shot(int pins) {
		addBonus(pins);
		lastFrame().shot(pins);

		if(lastFrame().checkFinished()){
			this.frames.add(new Frame());
		}
	}

	public int getScore() {
		int totalScore = 0;
		for(Frame frame:this.frames){
			totalScore = totalScore + frame.frameScore();
		}
		return totalScore;
	}
	public int frameScore(int i) throws IllegalArgumentException{
		if(i < 1) throw new IllegalArgumentException("引数は1以上にすること");
		return frames.get(i-1).frameScore();
	}
	public void addBonus(int pins) {
		beforeFrameAddBonus(pins,1);
		beforeFrameAddBonus(pins,2);
	}


	private Frame lastFrame() {
		return this.frames.get(this.frames.size()-1);
	}
	public int beforeFrameNeedBonus(int frameCounts) {
		if(beforeFrameIndex(frameCounts) >= 0)
			return this.frames.get(beforeFrameIndex(frameCounts)).needBonus();
		return 0;
	}
	private int beforeFrameIndex(int frameCounts){
		return this.frames.size() - frameCounts -1;
	}
	private void beforeFrameAddBonus(int pins,int frameCounts){
		if(beforeFrameNeedBonus(frameCounts)>0){
			this.frames.get(beforeFrameIndex(frameCounts)).addBonus(pins);
		}
	}
}
