package bowling;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class BowlingGameTest {
	public 	BowlingGame sut = new BowlingGame();

	@Test
	public void フレーム1が5_5_フレーム2が1_1_残りガターのテストで13() {
		sut.shot(5);
		sut.shot(5);
		sut.shot(1);
		sut.shot(1);
		sameShots(0,16);
		int actual		= sut.getScore();
		int expected	= 13;
		assertThat(actual,is(expected));
	}
	@Test
	public void フレーム1が5_5_フレーム2が5_1_残りガターのテストで21() {
		sut.shot(5);
		sut.shot(5);
		sut.shot(5);
		sut.shot(1);
		sameShots(0,16);
		int actual		= sut.getScore();
		int expected	= 21;
		assertThat(actual,is(expected));
	}



	@DataPoints
	public static Fixture[] param = {
			new Fixture("全投球ガターのテスト",0,0),
			new Fixture("全投球１のテスト",1,20)
	};

	public static class Fixture{
		String msg;
		int pins;
		int expected;
		Fixture(String msg,int pins, int expected) {
			this.msg = msg;
			this.pins = pins;
			this.expected = expected;
		}

	}

	@Theory
	public void 全フレーム同じ投球の場合の組み合わせテスト(Fixture param) {
		sameShots(param.pins,20);
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
