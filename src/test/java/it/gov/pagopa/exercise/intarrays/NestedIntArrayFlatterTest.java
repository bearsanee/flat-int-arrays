package it.gov.pagopa.exercise.intarrays;

import it.gov.pagopa.exercise.intarrays.bean.NestedIntArray;
import it.gov.pagopa.exercise.intarrays.bean.NestedIntArrayBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NestedIntArrayFlatterTest {

    @Test
    public void shouldReturnFlattedIntArrayNoRecursion() {
        NestedIntArray nestedIntArray = new NestedIntArrayBuilder()
                .withBeforeInts(Arrays.asList(1,2,3,4))
                .withAfterInts(Arrays.asList(5,6,7,8))
                .build();

        NestedIntArrayFlatter flatter = new NestedIntArrayFlatter();
        List<Integer> results = flatter.flat(nestedIntArray, new ArrayList<>(), new ArrayList<>()).invoke();

        assertEquals(results, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
    }

    @Test
    public void shouldReturnFlattedIntArrayOnlyBefore() {
        NestedIntArray nestedIntArray = new NestedIntArrayBuilder()
                .withBeforeInts(Arrays.asList(1,2,3,4))
                .build();

        NestedIntArrayFlatter flatter = new NestedIntArrayFlatter();
        List<Integer> results = flatter.flat(nestedIntArray, new ArrayList<>(), new ArrayList<>()).invoke();

        assertEquals(results, Arrays.asList(1, 2, 3, 4));
    }

    @Test
    public void shouldReturnFlattedIntArrayOnlyAfter() {
        NestedIntArray nestedIntArray = new NestedIntArrayBuilder()
                .withAfterInts(Arrays.asList(1,2,3,4))
                .build();

        NestedIntArrayFlatter flatter = new NestedIntArrayFlatter();
        List<Integer> results = flatter.flat(nestedIntArray, new ArrayList<>(), new ArrayList<>()).invoke();

        assertEquals(results, Arrays.asList(1, 2, 3, 4));
    }

    @Test
    public void shouldReturnFlattedIntArrayOneRecursion() {
        NestedIntArray nestedIntArray = new NestedIntArrayBuilder()
                .withBeforeInts(Arrays.asList(1, 2, 3, 4))
                .withNestedIntArray(new NestedIntArrayBuilder()
                        .withBeforeInts(Arrays.asList(5, 6))
                        .withAfterInts(Arrays.asList(7, 8))
                        .build())
                .withAfterInts(Arrays.asList(9, 10, 11))
                .build();

        NestedIntArrayFlatter flatter = new NestedIntArrayFlatter();
        List<Integer> results = flatter.flat(nestedIntArray, new ArrayList<>(), new ArrayList<>()).invoke();

        assertEquals(results, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
    }

    @Test
    public void shouldReturnFlattedIntArrayOneRecursionOnlyBefore() {
        NestedIntArray nestedIntArray = new NestedIntArrayBuilder()
                .withBeforeInts(Arrays.asList(1, 2, 3, 4))
                .withNestedIntArray(new NestedIntArrayBuilder()
                        .withBeforeInts(Arrays.asList(5, 6))
                        .build())
                .withAfterInts(Arrays.asList(7, 8, 9))
                .build();

        NestedIntArrayFlatter flatter = new NestedIntArrayFlatter();
        List<Integer> results = flatter.flat(nestedIntArray, new ArrayList<>(), new ArrayList<>()).invoke();

        assertEquals(results, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    @Test
    public void shouldReturnFlattedIntArrayOneRecursionOnlyAfter() {
        NestedIntArray nestedIntArray = new NestedIntArrayBuilder()
                .withBeforeInts(Arrays.asList(1, 2, 3, 4))
                .withNestedIntArray(new NestedIntArrayBuilder()
                        .withAfterInts(Arrays.asList(5, 6))
                        .build())
                .withAfterInts(Arrays.asList(7))
                .build();

        NestedIntArrayFlatter flatter = new NestedIntArrayFlatter();
        List<Integer> results = flatter.flat(nestedIntArray, new ArrayList<>(), new ArrayList<>()).invoke();

        assertEquals(results, Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    }

    @Test
    public void shouldReturnFlattedIntArrayDoubleRecursion() {
        NestedIntArray nestedIntArray = new NestedIntArrayBuilder()
                .withBeforeInts(Arrays.asList(1, 2, 3, 4))
                .withNestedIntArray(new NestedIntArrayBuilder()
                        .withBeforeInts(Arrays.asList(5, 6))
                        .withNestedIntArray(new NestedIntArrayBuilder()
                                .withBeforeInts(Arrays.asList(7, 8))
                                .withAfterInts(Arrays.asList(9, 10))
                                .build())
                        .withAfterInts(Arrays.asList(11, 12))
                        .build())
                .withAfterInts(Arrays.asList(13,14,15))
                .build();

        NestedIntArrayFlatter flatter = new NestedIntArrayFlatter();
        List<Integer> results = flatter.flat(nestedIntArray, new ArrayList<>(), new ArrayList<>()).invoke();

        assertEquals(results, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
    }

    @Test
    public void shouldReturnFlattedIntArrayDoubleRecursionNoBeforeValues() {
        NestedIntArray nestedIntArray = new NestedIntArrayBuilder()
                .withNestedIntArray(new NestedIntArrayBuilder()
                        .withNestedIntArray(new NestedIntArrayBuilder()
                                .withAfterInts(Collections.singletonList(1))
                                .build())
                        .withAfterInts(Arrays.asList(2,3))
                        .build())
                .withAfterInts(Arrays.asList(4,5))
                .build();

        NestedIntArrayFlatter flatter = new NestedIntArrayFlatter();
        List<Integer> results = flatter.flat(nestedIntArray, new ArrayList<>(), new ArrayList<>()).invoke();

        assertEquals(results, Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    public void shouldReturnFlattedIntArrayDoubleRecursionNoAfterValues() {
        NestedIntArray nestedIntArray = new NestedIntArrayBuilder()
                .withBeforeInts(Arrays.asList(1, 2, 3))
                .withNestedIntArray(new NestedIntArrayBuilder()
                        .withBeforeInts(Arrays.asList(4, 5))
                        .withNestedIntArray(new NestedIntArrayBuilder()
                                .withBeforeInts(Collections.singletonList(6))
                                .build())
                        .build())
                .build();

        NestedIntArrayFlatter flatter = new NestedIntArrayFlatter();
        List<Integer> results = flatter.flat(nestedIntArray, new ArrayList<>(), new ArrayList<>()).invoke();

        assertEquals(results, Arrays.asList(1, 2, 3, 4, 5, 6));
    }


}