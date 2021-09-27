Copied from the Joda Blog post - [Coverting from Joda-Time to Java-time][1]

What steps are needed to upgrade from Joda-Time to Java SE 8 date and time (JSR-310)?

## From Joda-Time to java.time
Joda-Time has been a very successful date and time library, widely used and making a real difference to many applications over the past 12 years or so. But if you are moving your application to Java SE 8, its time to consider moving on to java.time, formerly known as JSR-310.

The java.time library contains many of the lessons learned from Joda-Time, including stricter null handling and a better approach to multiple calendar systems. I use the phraseology that java.time is "inspired by Joda-Time", rather than an exact derivation, however many concepts will be familiar.

## Converting types
### Classes not including a time-zone:

Joda-Time	java.time	Notes
LocalDate	LocalDate	Same concept - date without time or time-zone
YearMonthDayLocalDate	Same concept - date without time or time-zone
LocalTime	LocalTime	Same concept - time without date or time-zone
TimeOfDay   LocalTime	Same concept - time without date or time-zone
LocalDateTime	LocalDateTime	Same concept - date and time without time-zone
MonthDay	MonthDay	Same concept - month and day without time-zone
YearMonth	YearMonth	Same concept - year and month without time-zone
- Year	New concept - a value type for the year
- Month	New concept - an enum for the month-of-year
- DayOfWeek	New concept - an enum for the day-of-week
     Partial	-	Not included in java.time

### Classes including a time-zone or representing an instant:

Joda-Time	java.time	Notes
DateTime	ZonedDateTime	Same concept - Date and time with time-zone
OffsetDateTime	New concept - Date and time with offset from Greenwich/UTC
MutableDateTime	-	Not included in java.time, use immutable ZonedDateTime instead
DateMidnight	-	Deprecated as a bad idea in Joda-Time, Use LocalDate or ZonedDateTime
- OffsetTime	New concept - Time with offset from Greenwich/UTC
     Instant	Instant	Same concept - Instantaneous point on timeline
     DateTimeZone	ZoneId	Same concept - Identifier for a time-zone, such as Europe/Paris
     ZoneOffset	New concept - An offset from Greenwich/UTC, such as +02:00
     

### Amounts of time:

Joda-Time	java.time	Notes
Duration	Duration	Same concept - Amount of time, based on fractional seconds
Period	Period and/or Duration	Similar concept - Amount of time
Joda-Time Period includes years to milliseconds, java.time only year/month/day (see also (ThreeTen-Extra PeriodDuration)
MutablePeriod	-	Not included in java.time, use immutable Period or Duration instead
Years	-	Not included in java.time, use Period instead (or ThreeTen-Extra)
Months
Weeks
Days
Hours	-	Not included in java.time, use Duration instead (or ThreeTen-Extra)
Minutes
Seconds
Interval	-	Not included in java.time (see ThreeTen-Extra)
MutableInterval	-	Not included in java.time

### Formatting:

Joda-Time	java.time	Notes
DateTimeFormatter	DateTimeFormatter	Same concept - an immutable formatter
DateTimeFormatterBuilder	DateTimeFormatterBuilder	Same concept - a builder of the formatter
DateTimeFormat	DateTimeFormatter	Concepts exposed as static methods on DateTimeFormatter
ISODateTimeFormat
PeriodFormatter	-	Not included in java.time (see ThreeTen-Extra for limited support)
PeriodFormatterBuilder
PeriodFormat
ISOPeriodFormat

### Other classes and interfaces:

Joda-Time	java.time	Notes
- Clock	New concept - Standard way to pass around the current time
     Chronology	Chronology	Similar concept - Very different API and implementation
     ISOChronology	IsoChronology	Similar concept - Very different API and implementation
     DateTimeFieldType	ChronoField	Similar concept - Very different API and implementation
     DateTimeField
     DurationFieldType	ChronoUnit	Similar concept - Very different API and implementation
     DurationField
     PeriodType	-	Not included in java.time
     Readable*	Temporal*	The Readable* interfaces are most closely replaced by the Temporal* interfaces
     It is strongly recommended to use the value types, not the temporal interfaces
     
### Odds and Ends

In most cases, the table above will be sufficient to identify the class to convert to. After that, in most cases the method needed will be obvious. Some special cases are noted below.

#### Rounding. 

Joda-Time has considerable support for rounding, java.time has less, based only on truncation. See the truncatedTo() methods.

#### End of month

Joda-Time has the withMaximumValue() method on the property object to change a field to the last day of the month. java.time has a more general mechanism, see TemporalAdjusters.lastDayOfMonth().

#### Nulls

Joda-Time accepts null as an input and handles it with a sensible default value. java.time rejects null on input.

#### Construction

Joda-Time has a constructor that accepts an Object and performs type conversion. java.time only has factory methods, so conversion is a user problem, although a parse() method is provided for strings.

#### Time between

Joda-Time provides methods on amount classes such as Days.between(a, b). java.time provides a similar method on the ChronoUnit classes - ChronoUnuit.DAYS.between(a, b).

#### Additional fields

Joda-Time provides a fixed set of fields in DateTimeFieldType. java.time allows the set of fields to be extended by implementing TemporalUnit, see IsoFields, JulianFields and WeekFields.

## Summary

This blog post has outlined the key mappings between Joda-Time and java.time in Java SE 8. If you are writing code in Java SE 8, its time to migrate to java.time, perhaps using ThreeTen-Extra to fill any gaps.

[1]: https://blog.joda.org/2014/11/converting-from-joda-time-to-javatime.html 