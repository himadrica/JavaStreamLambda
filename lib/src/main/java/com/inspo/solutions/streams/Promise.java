package com.inspo.solutions.streams;

import java.util.Objects;
import java.util.function.Function;
//V = result
// U = value input
public interface Promise<T, R> {
	R apply(T t);
	
	default <V> Function<T, V> then(Promise<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }
	
}