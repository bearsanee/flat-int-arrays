package it.gov.pagopa.exercise.intarrays.tail;

import java.util.function.Supplier;
import java.util.stream.Stream;

public interface TailCall<T> extends Supplier<TailCall<T>> {

    default boolean isComplete() {
        return false;
    }

    default T results() {
        throw new UnsupportedOperationException();
    }

    default T invoke() {
        return Stream.iterate(this, TailCall::get)
                .filter(TailCall::isComplete)
                .findFirst()
                .get()
                .results();
    }

    static <T> TailCall<T> done(T result) {
        return new TerminalCall<T>(result);
    }
}
