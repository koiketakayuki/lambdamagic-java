package lambdamagic.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.Optional;

import lambdamagic.NullArgumentException;
import lambdamagic.data.functional.Either;
import lambdamagic.pipeline.DataSource;
import lambdamagic.text.Encodings;

public class JSONDataSource implements DataSource<Object> {

	private JSONParser parser;

	public JSONDataSource(String filePath, String encoding) throws IOException {
		if (filePath == null) {
			throw new NullArgumentException("filePath");
		}
		
		if (encoding == null) {
			throw new NullArgumentException("encoding");
		}
		
		Reader reader = new BufferedReader(
							new InputStreamReader(
								new FileInputStream(new File(filePath)), encoding));

		parser = new JSONParser(reader);
	}

	public JSONDataSource(String filePath) throws IOException {
		this(filePath, Encodings.UTF_8);
	}
	
	public JSONDataSource(Reader reader) throws IOException {
		parser = new JSONParser(reader);
	}
	
	public static JSONDataSource fromString(String string) throws IOException {
		if (string == null) {
			throw new NullArgumentException("string");
		}
		
		return new JSONDataSource(new StringReader(string));
	}

	@Override
	public Optional<Object> readData() {
		Either<Object, Exception> resultOrException = parser.parse();
		
		if (resultOrException.isRight()) {
			return Optional.empty();
		}
		
		return Optional.of(resultOrException.getLeft());
	}

}
