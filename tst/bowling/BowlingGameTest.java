package bowling;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class BowlingGameTest {
	public 	BowlingGame sut = new BowlingGame();

	@DataPoints
	public static Fixture[] param = {
			new Fixture("全投球ガターのテスト",new int[]{},0,20,0),
			new Fixture("全投球１のテスト",new int[]{},1,20,20),
			new Fixture("フレーム1が5_5_フレーム2が1_1_残りガターのテストで13",
					new int[]{5,5,1,1},0,16,13),
			new Fixture("フレーム1が5_5_フレーム2が5_1_残りガターのテストで21",
					new int[]{5,5,5,1},0,16,21),
	};

	public static class Fixture{
		String msg;
		int pins[];
		int samePins;
		int times;
		int expected;
		Fixture(String msg,int pins[],int samePins,int times, int expected) {
			this.msg 		= msg;
			this.pins		= pins;
			this.samePins 	= samePins;
			this.times 		= times;
			this.expected 	= expected;
		}

	}

	@Theory
	public void 全フレーム同じ投球の場合の組み合わせテスト(Fixture param) {
		for(int pins:param.pins){
			sut.shot(pins);
		}
		sameShots(param.samePins,param.times);
		int actual		= sut.getScore();
		int expected	= param.expected;
		assertThat(param.msg,actual,is(expected));
	}
	private void sameShots(int pins,int times) {
		for (int i = 0; i < times; i++) {
			sut.shot(pins);
		}
	}

}
