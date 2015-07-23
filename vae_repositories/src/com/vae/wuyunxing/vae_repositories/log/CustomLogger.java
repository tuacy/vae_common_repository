package com.vae.wuyunxing.vae_repositories.log;

public interface CustomLogger {

	public boolean isDebugEnabled();

	public void d(Class<?> clazz, String format, Object... args);

	public void e(Class<?> clazz, String format, Object... args);

	public void e(Class<?> clazz, Throwable t, String format, Object... args);
	
}
