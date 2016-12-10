package lambdamagic.data;

import java.io.Serializable;

public final class Tuple2<T, S> implements Serializable {

	private static final long serialVersionUID = 692990897984802517L;

	private T firstValue;
	private S secondValue;

	public T getFirstValue() {
		return firstValue;
	}

	public S getSecondValue() {
		return secondValue;
	}

	public Tuple2(T firstValue, S secondValue) {
		this.firstValue = firstValue;
		this.secondValue = secondValue;
	}

	@Override
	public String toString() {
		return "Tuple2(" + firstValue + ", "+ secondValue + ")";
	}
}