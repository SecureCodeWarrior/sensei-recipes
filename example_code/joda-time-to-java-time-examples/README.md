Joda to Java Time Recipes

This set of recipes is designed to help migrate from Joda Time to Java Time

see the Joda Blog post - [Coverting from Joda-Time to Java-time][1]

and also elastic search's notes on [migrating to java-time][2] 

Also this excellent article [Intuitive, Robust Date and Time Handling, Finally Comes to Java][3] by Stephen Colebourne

Within the above article is this useful explanation of the method prefixes used within the api, and their corresponding
description:

| Prefix    | Description
|-----------|--------------
| of        | Static factory methods that create an instance from constituent parts.
| from      | Static factory methods that try to extract an instance from a similar object. A from() method is less type-safe than an of() method.
| now       | Static factory method that obtains an instance at the current time.
| parse     | Static factory method that allows a string to be parsed into an instance of the object.
| get       | Gets part of the state of the date-time object.
| is        | Checks if something is true or false about the date-time object.
| with      | Returns a copy of the date-time object with part of the state changed.
| plus      | Returns a copy of the date-time object with an amount of time added.
| minus     | Returns a copy of the date-time object with an amount of time subtracted.
| to        | Converts this date-time object to another, which may represent part or all of the state of the original object.
| at        | Combines this date-time object with additional data to create a larger or more complex date-time object.
| format    | Provides the ability to format this date-time object.


[1]: https://blog.joda.org/2014/11/converting-from-joda-time-to-javatime.html
[2]: https://www.elastic.co/guide/en/elasticsearch/reference/7.x/migrate-to-java-time.html
[3]: https://www.infoq.com/articles/java.time