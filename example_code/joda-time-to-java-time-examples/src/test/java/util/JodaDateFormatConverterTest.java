package util;

import util.JodaDateFormatTestUtil;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JodaDateFormatConverterTest extends JodaDateFormatTestUtil {

    java.time.ZonedDateTime zdt = ZonedDateTime.of(2021, 10, 8, 0, 0, 0, 0, ZoneId.systemDefault());

    public JodaDateFormatConverterTest() {
        super();
    }

    @Test
    public void joda_era_format_is_converted() {

        // Java has extra formatting display options, Joda only seem to do short version so we will just translate
        // to the shortest Java Version no matter how many GGGGG's were in Joda

        testJodaFormatRange('G',1,15, "AD", "G", "AD",zdt);
        testJodaFormatRange('G', 1,15,"BC", "G", "BC",zdt.minusYears(3000));

    }

    @Test
    public void joda_century_of_era_throws_error() {

        jodaDateFormatIsUnsupported("C", "20", zdt);
        jodaDateFormatIsUnsupported("CC",  "20", zdt);
        jodaDateFormatIsUnsupported("CCC",  "020", zdt);
        jodaDateFormatIsUnsupported("CCCC",  "0020", zdt);
        jodaDateFormatIsUnsupported("CCCCC",  "00020", zdt);
        jodaDateFormatIsUnsupported("CCCCC",  "00320", zdt.plusYears(30000));

    }

    @Test
    public void joda_year_of_era() {

        //Y -> y
        testJodaPatternConversion("Y","2021","y","2021",zdt);
        testJodaPatternConversion("YY","21","yy","21",zdt);
        testJodaPatternConversion("YYY","2021","yyy","2021",zdt);
        testJodaPatternConversion("YYYY","2021","yyyy","2021",zdt);
        testJodaPatternConversion("YYYYY","02021","yyyyy","02021",zdt);
        testJodaPatternConversion("YYYYYY","002021","yyyyyy","002021",zdt);

    }

    @Test
    public void weekyear() {

        // x is no longer used as weekyear, I think Y is the new one
        testJodaPatternConversion("x","2021","Y","2021",zdt);
        testJodaPatternConversion("xx","21","YY","21",zdt);
        testJodaPatternConversion("xxx","2021","YYY","2021",zdt);
        testJodaPatternConversion("xxxx","2021","YYYY","2021",zdt);
        testJodaPatternConversion("xxxxx","02021","YYYYY","02021",zdt);
        testJodaPatternConversion("xxxxxx","002021","YYYYYY","002021",zdt);

    }

    @Test
    public void week_of_weekyear() {

        // Week of Week year is 1-based now?
        // IS there a 2 limit on w in java-time
        // More than this is no longer supported
        jodaDateFormatIsUnsupported("www","040",zdt);
    }

    @Test
    public void day_of_week_number() {

        // Day of week uses a different Index!
        //Friday = 6
        // more than 2 would convert to text

        jodaDateFormatIsUnsupported("eee", "005", zdt);

        assertTrue(false);

    }

    @Test
    public void day_of_week_text() {

        testJodaPatternConversion("E","Fri.","E","Fri.",zdt);
        testJodaPatternConversion("EE","Fri.","EE","Fri.",zdt);
        testJodaPatternConversion("EEE","Fri.","EEE","Fri.",zdt);
        testJodaPatternConversion("EEEE","Friday","EEEE","Friday",zdt);
        // Limit the conversion to 4 E's so we don't introduce new format option
        testJodaPatternConversion("EEEEE","Friday","EEEE","Friday",zdt);

    }

    @Test
    public void year() {
        jodaDateFormatShouldRemainTheSame("y", "2021", zdt);
        jodaDateFormatShouldRemainTheSame("yy", "21", zdt);
        jodaDateFormatShouldRemainTheSame("yyy", "2021", zdt);
        jodaDateFormatShouldRemainTheSame("yyyy", "2021", zdt);
        // Following should be padded with zeros
        jodaDateFormatShouldRemainTheSame("yyyyy", "02021", zdt);
        jodaDateFormatShouldRemainTheSame("yyyyyy", "002021", zdt);
        jodaDateFormatShouldRemainTheSame("yyyyyyy", "0002021", zdt);
        jodaDateFormatShouldRemainTheSame("yyyyyyyy", "00002021", zdt);

    }

    @Test
    public void joda_day_of_year() {

        jodaDateFormatShouldRemainTheSame("D", "5", zdt.withDayOfYear(5));
        jodaDateFormatShouldRemainTheSame("DD", "05", zdt.withDayOfYear(5));
        jodaDateFormatShouldRemainTheSame("DDD", "005", zdt.withDayOfYear(5));

        jodaDateFormatIsUnsupported("DDDD", "0300", zdt.withDayOfYear(300));
        jodaDateFormatIsUnsupported("DDDDD", "00300", zdt.withDayOfYear(300));
        jodaDateFormatIsUnsupported("DDDDDD", "000300", zdt.withDayOfYear(300));

        jodaPatternConversionNotStrict("DDDD", "0005","DDD", "005", zdt.withDayOfYear(5));
        jodaPatternConversionNotStrict("DDDDD", "00300","DDD", "300", zdt.withDayOfYear(300));

    }

    @Test
    public void month_of_year() {

        //JodaDateFormatTestUtil.debugJodaFormat('M',1,15,zdt.withMonth(5));

        jodaDateFormatShouldRemainTheSame("M","5",zdt.withMonth(5));
        jodaDateFormatShouldRemainTheSame("MM","05",zdt.withMonth(5));
        jodaDateFormatShouldRemainTheSame("MMM","May",zdt.withMonth(5));
        jodaDateFormatShouldRemainTheSame("MMMM","May",zdt.withMonth(5));

        jodaDateFormatShouldRemainTheSame("M","10",zdt);
        jodaDateFormatShouldRemainTheSame("MM","10",zdt);
        jodaDateFormatShouldRemainTheSame("MMM","Oct.",zdt);
        jodaDateFormatShouldRemainTheSame("MMMM","October",zdt);

        testJodaPatternConversion("MMMMM","October", "MMMM", "October", zdt);
        testJodaPatternConversion("MMMMMM","October", "MMMM", "October", zdt);

    }

    @Test
    public void day_of_month() {

        jodaDateFormatShouldRemainTheSame("d","8",zdt);
        jodaDateFormatShouldRemainTheSame("dd","08",zdt);

        // Can't pad the day of month in java-time
        jodaDateFormatIsUnsupported("ddd", "008", zdt);

        // Test Conversion with side effects
        jodaPatternConversionNotStrict("ddd","008","dd","08",zdt);
        jodaPatternConversionNotStrict("dddd","0008","dd","08",zdt);

    }

    @Test
    public void halfday_of_day() {

        //am
        jodaDateFormatShouldRemainTheSame("a","am",zdt);

        jodaDateFormatIsUnsupported("aa", "am",zdt);

        jodaPatternConversionNotStrict("aa","am","a","am",zdt);
        jodaPatternConversionNotStrict("aaa","am","a","am",zdt);

        // pm
        jodaDateFormatShouldRemainTheSame("a","pm",zdt.withHour(15));

        jodaDateFormatIsUnsupported("aa", "pm",zdt.withHour(15));

        jodaPatternConversionNotStrict("aa","pm","a","pm",zdt.withHour(15));
        jodaPatternConversionNotStrict("aaa","pm","a","pm",zdt.withHour(15));

    }

    @Test
    public void hour_of_halfday() {

        // This is 0-11
        jodaDateFormatShouldRemainTheSame("K","4",zdt.withHour(16));
        jodaDateFormatShouldRemainTheSame("KK","04",zdt.withHour(16));

        jodaDateFormatIsUnsupported("KKK", "004",zdt.withHour(16));

        jodaPatternConversionNotStrict("KKK","004","KK","04",zdt.withHour(16));
        jodaPatternConversionNotStrict("KKKK","0004","KK","04",zdt.withHour(16));

        // Test Midday (0)
        jodaDateFormatShouldRemainTheSame("K","0",zdt.withHour(12));
        jodaDateFormatShouldRemainTheSame("KK","00",zdt.withHour(12));

        jodaDateFormatIsUnsupported("KKK", "000",zdt.withHour(12));

        jodaPatternConversionNotStrict("KKK","000","KK","00",zdt.withHour(12));
        jodaPatternConversionNotStrict("KKKK","0000","KK","00",zdt.withHour(12));

    }

    @Test
    public void clockhour_of_halfday() {

        // This is 1-12

        jodaDateFormatShouldRemainTheSame("h","4",zdt.withHour(16));
        jodaDateFormatShouldRemainTheSame("hh","04",zdt.withHour(16));

        jodaDateFormatIsUnsupported("hhh", "004",zdt.withHour(16));

        jodaPatternConversionNotStrict("hhh","004","hh","04",zdt.withHour(16));
        jodaPatternConversionNotStrict("hhhh","0004","hh","04",zdt.withHour(16));

        // Test Midday (0)
        jodaDateFormatShouldRemainTheSame("h","12",zdt.withHour(12));
        jodaDateFormatShouldRemainTheSame("hh","12",zdt.withHour(12));

        jodaDateFormatIsUnsupported("hhh", "012",zdt.withHour(12));

        jodaPatternConversionNotStrict("hhh","012","hh","12",zdt.withHour(12));
        jodaPatternConversionNotStrict("hhhh","0012","hh","12",zdt.withHour(12));

    }

    @Test
    public void hour_of_day() {

        // hour-of-day is 0-23

        jodaDateFormatShouldRemainTheSame("H","16",zdt.withHour(16));
        jodaDateFormatShouldRemainTheSame("HH","16",zdt.withHour(16));

        jodaDateFormatIsUnsupported("HHH", "016",zdt.withHour(16));

        jodaPatternConversionNotStrict("HHH","016","HH","16",zdt.withHour(16));
        jodaPatternConversionNotStrict("HHHH","0016","HH","16",zdt.withHour(16));

        // Test Midnight
        jodaDateFormatShouldRemainTheSame("H","0",zdt);
        jodaDateFormatShouldRemainTheSame("HH","00",zdt);

        jodaDateFormatIsUnsupported("HHH", "000",zdt);

        jodaPatternConversionNotStrict("HHH","000","HH","00",zdt);
        jodaPatternConversionNotStrict("HHHH","0000","HH","00",zdt);

    }

    @Test
    public void clockhour_of_day() {

        // clockhour of day is 1-24

        // Test 4am
        jodaDateFormatShouldRemainTheSame("k","4",zdt.withHour(4));
        jodaDateFormatShouldRemainTheSame("kk","04",zdt.withHour(4));

        jodaDateFormatIsUnsupported("kkk", "004",zdt.withHour(4));

        jodaPatternConversionNotStrict("kkk","004","kk","04",zdt.withHour(4));
        jodaPatternConversionNotStrict("kkkk","0004","kk","04",zdt.withHour(4));

        // Test 4pm
        jodaDateFormatShouldRemainTheSame("k","16",zdt.withHour(16));
        jodaDateFormatShouldRemainTheSame("kk","16",zdt.withHour(16));

        jodaDateFormatIsUnsupported("kkk", "016",zdt.withHour(16));

        jodaPatternConversionNotStrict("kkk","016","kk","16",zdt.withHour(16));
        jodaPatternConversionNotStrict("kkkk","0016","kk","16",zdt.withHour(16));

        // Test Midnight
        jodaDateFormatShouldRemainTheSame("k","24",zdt);
        jodaDateFormatShouldRemainTheSame("kk","24",zdt);

        jodaDateFormatIsUnsupported("kkk", "024",zdt);

        jodaPatternConversionNotStrict("kkk","024","kk","24",zdt);
        jodaPatternConversionNotStrict("kkkk","0024","kk","24",zdt);

    }

    @Test
    public void minute_of_hour() {

        // Test single digit
        jodaDateFormatShouldRemainTheSame("m","5",zdt.withMinute(5));
        jodaDateFormatShouldRemainTheSame("mm","05",zdt.withMinute(5));

        jodaDateFormatIsUnsupported("mmm", "005",zdt.withMinute(5));

        jodaPatternConversionNotStrict("mmm","005","mm","05",zdt.withMinute(5));
        jodaPatternConversionNotStrict("mmmm","0005","mm","05",zdt.withMinute(5));

        // Test double digit
        jodaDateFormatShouldRemainTheSame("m","51",zdt.withMinute(51));
        jodaDateFormatShouldRemainTheSame("mm","51",zdt.withMinute(51));

        jodaDateFormatIsUnsupported("mmm", "051",zdt.withMinute(51));

        jodaPatternConversionNotStrict("mmm","051","mm","51",zdt.withMinute(51));
        jodaPatternConversionNotStrict("mmmm","0051","mm","51",zdt.withMinute(51));

    }

    @Test
    public void second_of_minute() {

        // Test single digit
        jodaDateFormatShouldRemainTheSame("s","5",zdt.withSecond(5));
        jodaDateFormatShouldRemainTheSame("ss","05",zdt.withSecond(5));

        jodaDateFormatIsUnsupported("sss", "005",zdt.withSecond(5));

        jodaPatternConversionNotStrict("sss","005","ss","05",zdt.withSecond(5));
        jodaPatternConversionNotStrict("ssss","0005","ss","05",zdt.withSecond(5));

        // Test double digit
        jodaDateFormatShouldRemainTheSame("s","51",zdt.withSecond(51));
        jodaDateFormatShouldRemainTheSame("ss","51",zdt.withSecond(51));

        jodaDateFormatIsUnsupported("sss", "051",zdt.withSecond(51));

        jodaPatternConversionNotStrict("sss","051","ss","51",zdt.withSecond(51));
        jodaPatternConversionNotStrict("ssss","0051","ss","51",zdt.withSecond(51));
        
    }

    @Test
    public void fraction_of_second() {

        // Test double digit
        jodaDateFormatShouldRemainTheSame("S","1",zdt.withNano(123456789));
        jodaDateFormatShouldRemainTheSame("SS","12",zdt.withNano(123456789));
        jodaDateFormatShouldRemainTheSame("SSS","123",zdt.withNano(123456789));

        // Java Time has greater precision so the number will be more precise
        jodaDateFormatIsUnsupported("SSSS", "1230",zdt.withNano(123456789));

        // Different output but same length
        jodaPatternConversionNotStrict("SSSS","1230","SSSS","1234",zdt.withNano(123456789));
        jodaPatternConversionNotStrict("SSSSS","12300","SSSSS","12345",zdt.withNano(123456789));

    }

    @Test
    public void time_zone() {

        debugJodaFormat('z',1,15,zdt);

        String shortZone = zoneDisplay(TimeZone.SHORT, zdt);
        String longZone = zoneDisplay(TimeZone.LONG, zdt);

        jodaDateFormatShouldRemainTheSame("z",shortZone, zdt);
        jodaDateFormatShouldRemainTheSame("zz",shortZone, zdt);
        jodaDateFormatShouldRemainTheSame("zzz",shortZone, zdt);
        jodaDateFormatShouldRemainTheSame("zzzz",longZone, zdt);

        jodaDateFormatIsUnsupported("zzzzz",longZone,zdt);

        jodaPatternConversionNotStrict("zzzzz", longZone, "zzzz", longZone,zdt);
        jodaPatternConversionNotStrict("zzzzzz", longZone, "zzzz", longZone,zdt);

    }

    @Test
    public void time_zone_offset_id() {

        String zoneOffsetNoColon = zoneOffset(false, zdt);
        String zoneOffsetWithColon = zoneOffset(true, zdt);
        String zoneID = zoneId();

        // Z = Z
        jodaDateFormatShouldRemainTheSame("Z",zoneOffsetNoColon, zdt);


        // ZZ = ZZZZZ
        jodaPatternConversionNotStrict("ZZ", zoneOffsetWithColon, "ZZZZZ", zoneOffsetWithColon, zdt);
        // ZZZ = VV
        jodaPatternConversionNotStrict("ZZZ", zoneID, "VV", zoneID, zdt);
        jodaPatternConversionNotStrict("ZZZZZ", zoneID, "VV", zoneID, zdt);

        // These are supported but will have different results
        jodaDateFormatIsUnsupported("ZZ", zoneOffsetWithColon, zdt);
        jodaDateFormatIsUnsupported("ZZZ", zoneID, zdt);


    }

    @Test
    public void escape_for_text() {

        String az09 = "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789";

        jodaDateFormatShouldRemainTheSame("'" + az09 + "'",az09,zdt);


    }

    @Test
    public void single_quote() {

        jodaDateFormatShouldRemainTheSame("'this '' is'","this ' is",zdt);

    }

    @Test
    public void unsupported_characters() {
        String characters = "gr";
        assertTrue(false);

    }

    private String zoneDisplay(int style, ZonedDateTime zdt) {

        long epochMilli = Instant.from(zdt).toEpochMilli();
        boolean daylightSavings = TimeZone.getDefault().inDaylightTime(new Date(epochMilli));
        return TimeZone.getDefault().getDisplayName(daylightSavings, style);

    }

    private String zoneId() {

        return TimeZone.getDefault().getID();

    }

    private String zoneOffset(boolean withColon, ZonedDateTime zdt) {

        ZoneOffset offset = zdt.getOffset();
        return (withColon) ? offset.toString() : offset.toString().replaceAll(":","");

    }


}
