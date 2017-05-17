package bowling;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class FrameTest {
	public 	Frame sut = new Frame();


	@Test
	public void 全投球ガターのフレームTest() {
		sut.shot(0);
		sut.shot(0);

		int actual = sut.frameScore();
		int expected = 0;

		assertThat(actual,is(expected));
	}

	@Test
	public void フレーム完了のテスト(){
		sut.shot(0);
		sut.shot(0);

		boolean actual = sut.checkFinished();
		boolean expected = true;

		assertThat(actual,is(expected));
	}
	@Test
	public void フレーム未完了のテスト(){
		sut.shot(0);

		boolean actual = sut.checkFinished();
		boolean expected = false;

		assertThat(actual,is(expected));
	}
	@Test
	public void ストライク時のフレーム完了のテスト(){
		sut.shot(10);

		boolean actual = sut.checkFinished();
		boolean expected = true;

		assertThat(actual,is(expected));
	}
	@Test
	public void スペア判定テスト(){
		sut.shot(3);
		sut.shot(7);

		boolean actual = sut.judgeSpare();
		boolean expected = true;

		assertThat(actual,is(expected));
	}
	@Test
	public void ストライク判定テスト(){
		sut.shot(10);

		boolean actual = sut.judgeStrike();
		boolean expected = true;

		assertThat(actual,is(expected));
	}
	@Test
	public void スペア時にneedBonusが1のテスト(){
		sut.shot(3);
		sut.shot(7);

		int actual = sut.needBonus();
		int expected = 1;
		assertThat(actual,is(expected));
	}
	@Test
	public void ストライク時にneedBonusが2のテスト(){
		sut.shot(10);

		int actual = sut.needBonus();
		int expected = 2;
		assertThat(actual,is(expected));
	}

	@Test
	public void ボーナス加算時にneedBonusが減っているかのテスト(){
		sut.shot(3);
		sut.shot(7);
		sut.addBonus(5);

		int actual = sut.needBonus();
		int expected = 0;
		assertThat(actual,is(expected));
	}


}
