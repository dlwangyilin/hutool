package cn.hutool.core.date;

import cn.hutool.core.date.BetweenFormater.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * Partitioned by level and MaxLevel
 * **/
public class MyBetweenFormaterTest {
    @ParameterizedTest(name = "{0}")
    @CsvSource({
            "'level = MaxLevel','2020-01-01 22:59:59','2020-01-01 22:59:58',1,'1秒'",
            "'level < MaxLevel','2020-01-01 22:59:59','2020-01-01 22:59:58',2,'1秒'",
            "'level > MaxLevel(1)','2020-01-02 22:59:59','2020-01-01 22:59:58',1,'1天'",
            "'level > MaxLevel(2)','2020-01-02 22:59:59.111','2020-01-01 22:59:58.112',1,'1天'",
            "'level > MaxLevel(3)','2021-01-02 22:59:59','2020-01-01 22:59:58',1,'367天'",
            "'level < MaxLevel(1)','2020-01-01 20:00:00.111','2020-01-01 20:00:00.112',2,'1毫秒'",
            "'level < MaxLevel(2)','2020-01-01 20:00:01.111','2020-01-01 20:00:00.111',3,'1秒'",
            "'day-level','2020-01-05 20:00:01.111','2020-01-02 20:00:00.111',1,'3天'",
            "'hour-level','2020-01-01 21:00:21.111','2020-01-01 20:00:21.111',1,'1小时'",
            "'minute-level','2020-01-01 20:28:01.111','2020-01-01 20:14:00.111',1,'14分'",
            "'second-level','2020-01-01 20:00:19.111','2020-01-01 20:00:39.111',1,'20秒'",
            "'millisecond-level','2020-01-01 20:00:01.000','2020-01-01 20:00:01.002',5,'2毫秒'"
    })
    public void testAlgorithm(String hint, String date1, String date2, int levelMaxCount, String expected) {
        long betweenMs = DateUtil.betweenMs(DateUtil.parse(date1), DateUtil.parse(date2));
        BetweenFormater formater = new BetweenFormater(betweenMs, Level.MILLSECOND, levelMaxCount);
        Assertions.assertEquals(formater.toString(), expected);
    }
}
