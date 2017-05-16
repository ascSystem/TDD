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
	@Test
	public void フレーム1が5_5_フレーム2が1_1_残りガターのテストで13() {
		BowlingGame sut = new BowlingGame();
		sut.shot(5);
		sut.shot(5);
		sut.shot(1);
		sut.shot(1);
		for (int i = 0; i < 16; i++) {
			sut.shot(0);
		}
		int actual		= sut.getScore();
		int expected	= 13;
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
		BowlingGame sut = new BowlingGame();
		for (int i = 0; i < 20; i++) {
			sut.shot(param.pins);
		}
		int actual		= sut.getScore();
		int expected	= param.expected;
		assertThat(param.msg,actual,is(expected));
	}

}
