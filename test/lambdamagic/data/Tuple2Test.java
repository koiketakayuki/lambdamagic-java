package lambdamagic.data;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import lambdamagic.NullArgumentException;


public class Tuple2Test {

	@Test(expected=NullArgumentException.class)
	public void Tuple2_mustThrowExceptionWhenNullFirstValueIsGiven() {
		new Tuple2<Object, Integer>(null, 1);
	}

	@Test(expected=NullArgumentException.class)
	public void Tuple2_mustThrowExceptionWhenNullSecondValueIsGiven() {
		new Tuple2<Integer, Object>(1, null);
	}
	
	@Test
	public void getFirstValue_returnTheFirstValue() {
		Tuple2<Integer, Integer> t = new Tuple2<Integer, Integer>(1, 2);
		assertThat(t.getFirstValue(), is(1));
	}

	@Test
	public void getFirstValue_returnTheSecondValue() {
		Tuple2<Integer, Integer> t = new Tuple2<Integer, Integer>(1, 2);
		assertThat(t.getSecondValue(), is(2));
	}
}
