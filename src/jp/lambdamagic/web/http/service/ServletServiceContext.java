package jp.lambdamagic.web.http.service;

import java.io.InputStream;
import java.util.Date;
import java.util.Optional;

import javax.servlet.ServletContext;

import jp.lambdamagic.NullArgumentException;
import jp.lambdamagic.event.log.LoggedEventType;


public class ServletServiceContext implements ServiceContext {

	private ServletContext baseObject;
		
	public ServletServiceContext(ServletContext baseObject) {
		if (baseObject == null) {
			throw new NullArgumentException("baseObject");
		}
		
		this.baseObject = baseObject;
	}

	@Override
	public void log(LoggedEventType type, String format, Object... args) {
		String message = String.format("%tc [%s] %s%n", new Date(), type, String.format(format, args));
		System.err.println(message);
		baseObject.log(message);
	}

	@Override
	public String getResourceAbsolutePath(String path) {
		return baseObject.getRealPath(path);
	}

	@Override
	public InputStream getResourceAsStream(String path) {
		InputStream stream = baseObject.getResourceAsStream(path);
		return stream;
	}
	
}
