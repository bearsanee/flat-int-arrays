package it.gov.pagopa.exercise.intarrays;

import it.gov.pagopa.exercise.intarrays.bean.NestedIntArray;
import it.gov.pagopa.exercise.intarrays.tail.TailCall;

import java.util.List;
import java.util.Optional;

import static it.gov.pagopa.exercise.intarrays.tail.TailCall.done;

public class NestedIntArrayFlatter {

    public TailCall<List<Integer>> flat(NestedIntArray nestedIntArray, List<Integer> beforeResult, List<Integer> afterResult) {

        Optional.ofNullable(nestedIntArray.getBeforeInts())
                .map(l ->beforeResult.addAll(l));

        if (nestedIntArray.isLeaf()) {
            Optional.ofNullable(nestedIntArray.getAfterInts())
                    .map(l -> beforeResult.addAll(l));

            beforeResult.addAll(afterResult);
            return done(beforeResult);
        }

        Optional.ofNullable(nestedIntArray.getAfterInts())
                .map(l -> afterResult.addAll(0,l));

        return () -> flat(nestedIntArray.getNestedIntArray(), beforeResult, afterResult);
    }
}
