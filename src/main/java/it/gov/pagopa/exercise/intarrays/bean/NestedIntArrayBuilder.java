package it.gov.pagopa.exercise.intarrays.bean;

import java.util.List;

public class NestedIntArrayBuilder {
    private List<Integer> beforeInts;
    private NestedIntArray nestedIntArray;
    private List<Integer> afterInts;

    public NestedIntArrayBuilder withBeforeInts(List<Integer> beforeInts) {
        this.beforeInts = beforeInts;
        return this;
    }

    public NestedIntArrayBuilder withNestedIntArray(NestedIntArray nestedIntArray) {
        this.nestedIntArray = nestedIntArray;
        return this;
    }

    public NestedIntArrayBuilder withAfterInts(List<Integer> afterInts) {
        this.afterInts = afterInts;
        return this;
    }

    public NestedIntArray build() {
        return new NestedIntArray(beforeInts, nestedIntArray, afterInts);
    }
}