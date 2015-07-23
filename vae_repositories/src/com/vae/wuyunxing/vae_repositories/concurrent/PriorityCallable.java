package com.vae.wuyunxing.vae_repositories.concurrent;

import java.util.concurrent.Callable;

public interface PriorityCallable<T> extends Callable<T>, Comparable<PriorityCallable<T>> {

	public int getPriority();
	
}
