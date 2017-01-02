package lambdamagic.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import java.util.Optional;

import lambdamagic.NullArgumentException;
import lambdamagic.data.functional.Either;
import lambdamagic.pipeline.DataSource;
import lambdamagic.text.Encodings;

public class CSVDataSource implements DataSource<List<String>> {

	private CSVParser parser;

	public CSVDataSource(String filePath, String encoding) throws IOException {
		if (filePath == null) {
			throw new NullArgumentException("filePath");
		}
		
		if (encoding == null) {
			throw new NullArgumentException("encoding");
		}
		
		Reader reader = new BufferedReader(
							new InputStreamReader(
								new FileInputStream(new File(filePath)), encoding));

		parser = new CSVParser(reader);
	}

	public CSVDataSource(String filePath) throws IOException {
		this(filePath, Encodings.UTF_8);
	}
	
	public CSVDataSource(Reader reader) throws IOException {
		parser = new CSVParser(reader);
	}
	
	public static CSVDataSource fromString(String string) throws IOException {
		if (string == null) {
			throw new NullArgumentException("string");
		}
		
		return new CSVDataSource(new StringReader(string));
	}

	@Override
	public Optional<List<String>> readData() {

		Either<List<String>, ? extends Exception> resultOrException = parser.parse();

		if (resultOrException.isRight()) {
			return Optional.empty();
		}

		return Optional.of(resultOrException.getLeft());
	}

	@Override
	public void close() throws IOException {
		parser.close();
	}
	
}