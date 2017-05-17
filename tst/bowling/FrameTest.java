package bowling;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class FrameTest {

	@Test
	public void 全投球ガターのフレームTest() {
		Frame sut = new Frame();
		sut.shot(0);
		sut.shot(0);

		int actual = sut.frameScore();
		int expected = 0;

		assertThat(actual,is(expected));
	}

}
