package lambdamagic.sql;

import lambdamagic.NullArgumentException;

public final class SQLType {

	private String name;
	private int size;

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

	public SQLType(String name, int size) {
		if (name == null)
			throw new NullArgumentException("name");
		
		this.name = name;
		this.size = size;
	}

	public SQLType(String name) {
		this(name, -1);
	}
}