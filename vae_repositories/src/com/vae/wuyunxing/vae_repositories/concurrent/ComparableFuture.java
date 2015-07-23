package com.vae.wuyunxing.vae_repositories.concurrent;

import java.util.concurrent.RunnableFuture;

public interface ComparableFuture<V> extends RunnableFuture<V>, Comparable<V> {

}
