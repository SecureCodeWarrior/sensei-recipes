# Joda to Java Time Recipes

The examples in this module are used to demonstrate the Joda-Time to java.time migration recipes that are available in 
the **Standardisation on java.time JSR-310** cookbook available via Sensei Hub.

## Feedback / Corrections / Recipe Suggestions

We have done our best effort to ensure these recipes are accurate transformations from Joda-Time to java.time.
However, if you notice something obviously wrong with one of our recipes please reach out and create an issue on the
[Sensei-Recipes github issues page][5]

Recipe suggestions and improvements are also welcome!

## How to use these recipes?

Unfortunately, the recipes are not powerful enough to migrate your code in one fell swoop. 
They must be used in a step-by-step fashion. This means, after using a recipe quickfix, your code may be in a 
'broken' state, and you will need to use further recipes to finish the migration.

1. Find the places in your code where Joda-Time classes are instantiated, for example:
   1. Assigned to a local variable
   2. Assigned to a field
   3. Declared as a method parameter
   4. Declared as a method return type
2. Use a Sensei quickfix to migrate to the corresponding java.time class
3. After applying the quickfix, there may be new problem markers which show further migrations are needed.
   Check any new problem markers to see further migrations available. If you have a use-case that hasn't been covered
   then please reach out using the github isses page.

In some cases, you may need to migrate certain classes before others if they are use as arguments in constructors and 
methods.
For example, org.joda.time.DateTimeZone, Chronology, DateTimeField

## Migration Limitations

Whilst these recipes are designed to assist in many common use-cases of Joda-Time, it is still recommended that you gain
a full understanding of the new api and its differences from Joda-Time. 

### Recommended Reading

* [Javadoc for JSR-310][6]
* [Threeten Project Page][3]
  * Includes [links to various articles videos][4] 
* From Stephen Colebourne:
  * [Intuitive, Robust Date and Time Handling, Finally Comes to Java][2]
  * [Converting from Joda-Time to Java-time][1]

The following table was extracted from one of the [Intuitive, Robust Date and Time Handling, Finally Comes to Java][2] 
article. This is useful explanation of the method prefixes used within the api, and their corresponding
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
[2]: https://www.infoq.com/articles/java.time
[3]: https://www.threeten.org
[4]: https://www.threeten.org/links.html
[5]: https://github.com/SecureCodeWarrior/sensei-recipes/issues
[6]: https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html
