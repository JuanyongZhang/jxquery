package jxquery.google.utils;

import org.apache.commons.logging.Log;

/**
 * @author <a href="mailto:Juanyong.zhang@gmail.com">Juanyong Zhang</a>
 * @date Nov 21, 2011
 */
public class LogWrapper {
	private Log log;

	public LogWrapper(Log log) {
		this.log = log;
	}

	/**
	 * <p>
	 * Log a message with trace log level.
	 * </p>
	 * 
	 * @param message
	 *            log this message
	 */
	public void trace(Object message) {
		if (log.isTraceEnabled())
			log.trace(message);
	}

	/**
	 * <p>
	 * Log an error with trace log level.
	 * </p>
	 * 
	 * @param message
	 *            log this message
	 * @param t
	 *            log this cause
	 */
	public void trace(Object message, Throwable t) {
		if (log.isTraceEnabled())
			log.trace(message, t);
	}

	/**
	 * <p>
	 * Log a message with debug log level.
	 * </p>
	 * 
	 * @param message
	 *            log this message
	 */
	public void debug(Object message) {
		if (log.isDebugEnabled())
			log.debug(message);
	}

	/**
	 * <p>
	 * Log an error with debug log level.
	 * </p>
	 * 
	 * @param message
	 *            log this message
	 * @param t
	 *            log this cause
	 */
	public void debug(Object message, Throwable t) {
		if (log.isDebugEnabled())
			log.debug(message, t);
	}

	/**
	 * <p>
	 * Log a message with info log level.
	 * </p>
	 * 
	 * @param message
	 *            log this message
	 */
	public void info(Object message) {
		if (log.isInfoEnabled())
			log.info(message);
	}

	/**
	 * <p>
	 * Log an error with info log level.
	 * </p>
	 * 
	 * @param message
	 *            log this message
	 * @param t
	 *            log this cause
	 */
	public void info(Object message, Throwable t) {
		if (log.isInfoEnabled())
			log.info(message, t);
	}

	/**
	 * <p>
	 * Log a message with warn log level.
	 * </p>
	 * 
	 * @param message
	 *            log this message
	 */
	public void warn(Object message) {
		if (log.isWarnEnabled())
			log.warn(message);
	}

	/**
	 * <p>
	 * Log an error with warn log level.
	 * </p>
	 * 
	 * @param message
	 *            log this message
	 * @param t
	 *            log this cause
	 */
	public void warn(Object message, Throwable t) {
		if (log.isWarnEnabled())
			log.warn(message, t);
	}

	/**
	 * <p>
	 * Log a message with error log level.
	 * </p>
	 * 
	 * @param message
	 *            log this message
	 */
	public void error(Object message) {
		if (log.isErrorEnabled())
			log.error(message);
	}

	/**
	 * <p>
	 * Log an error with error log level.
	 * </p>
	 * 
	 * @param message
	 *            log this message
	 * @param t
	 *            log this cause
	 */
	public void error(Object message, Throwable t) {
		if (log.isErrorEnabled())
			log.error(message, t);
	}

	/**
	 * <p>
	 * Log a message with fatal log level.
	 * </p>
	 * 
	 * @param message
	 *            log this message
	 */
	public void fatal(Object message) {
		if (log.isFatalEnabled())
			log.fatal(message);
	}

	/**
	 * <p>
	 * Log an error with fatal log level.
	 * </p>
	 * 
	 * @param message
	 *            log this message
	 * @param t
	 *            log this cause
	 */
	public void fatal(Object message, Throwable t) {
		if (log.isFatalEnabled())
			log.fatal(message, t);
	}
}
