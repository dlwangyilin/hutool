package cn.hutool.core.comparator;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * Partitioned by input format
 * **/
public class MyVersionComparatorTest {
    @ParameterizedTest(name = "{0}")
    @CsvSource({
            "'Pure number(1)','1.2.3','1.2.2', '1'",
            "'Pure number(2)','1.2.1','1.3.1', '-1'",
            "'Pure number(3)','2.2.2','1.2.2', '1'",
            "'Pure letters(1)','b','a', '1'",
            "'Pure letters(1)','ba','bc', '-1'",
            "'Pure letters(1)','bbb','bab', '1'",
            "'First version is null','','1.2.2', '-1'",
            "'Second version is null','1.1.1','', '1'",
            "'Two version both null','','', '0'",
            "'Two same version','1.2','1.2', '0'",
            "'Both version contain letter','1.2.3a','1.2.3b', '-1'",
            "'First version contain letter','1.2.3a','1.2.3', '1'",
            "'Second version contain letter','1.2.3','1.2.3b', '-1'",
            "'Different format','V1.2.3','1.2.2', '1'"
    })
    public void testAlgorithm(String hint, String v1, String v2, int expected) {
        int compare = VersionComparator.INSTANCE.compare(v1, v2);
        if (expected>0){
            Assert.assertTrue(compare > 0);
        }
        else if (expected == 0){
            Assert.assertTrue(compare == 0);
        }
        else{
            Assert.assertTrue(compare < 0);
        }
    }
}
