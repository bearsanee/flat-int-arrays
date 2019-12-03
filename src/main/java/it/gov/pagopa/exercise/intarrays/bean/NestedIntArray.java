package it.gov.pagopa.exercise.intarrays.bean;

import java.util.List;

public class NestedIntArray {

    private List<Integer> beforeInts;
    private NestedIntArray nestedIntArray;
    private List<Integer> afterInts;

    NestedIntArray(List<Integer> beforeInts, NestedIntArray nestedIntArray, List<Integer> afterInts) {
        this.beforeInts = beforeInts;
        this.nestedIntArray = nestedIntArray;
        this.afterInts = afterInts;
    }

    public List<Integer> getBeforeInts() {
        return beforeInts;
    }

    public NestedIntArray getNestedIntArray() {
        return nestedIntArray;
    }

    public List<Integer> getAfterInts() {
        return afterInts;
    }

    public Boolean isLeaf() {
        return nestedIntArray == null;
    }
}
