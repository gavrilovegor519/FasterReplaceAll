package org.egor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReplaceAllTest {
    @Test
    void test1() {
        Assertions.assertEquals(
                "'{}''{}'",
                ReplaceAll.replaceAll("\"[]\"\n\"[]\"\n"));
    }

    @Test
    void test2() {
        Assertions.assertEquals(
                "",
                ReplaceAll.replaceAll("\n\n\n\n\n"));
    }

    @Test
    void test3() {
        Assertions.assertEquals(
                "''''",
                ReplaceAll.replaceAll("\"\"\n\"\"\n"));
    }

    @Test
    void test4() {
        Assertions.assertEquals(
                "'[1]''[3]'",
                ReplaceAll.replaceAll("\"[1]\"\n\"[3]\"\n"));
    }

    @Test
    void test5() {
        Assertions.assertEquals(
                "[shshhsjs]",
                ReplaceAll.replaceAll("[shshhsjs]"));
    }

    @Test
    void test6() {
        Assertions.assertEquals(
                "a[",
                ReplaceAll.replaceAll("a["));
    }
}
