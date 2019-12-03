package it.gov.pagopa.exercise.intarrays.tail;

public class TerminalCall<T> implements TailCall<T> {

    private final T result;

    public TerminalCall(T result) {
        this.result = result;
    }

    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public T results() {
        return result;
    }

    @Override
    public TailCall<T> get() {
        throw new UnsupportedOperationException();
    }
}
