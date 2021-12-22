package hamcrest;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;

class HamcrestStringComparisonAssertions {

    @Test
    void starts_with() {
        assertThat("Hello World!", org.hamcrest.Matchers.startsWith("Hello"));
        assertThat("Hello World!", org.hamcrest.CoreMatchers.startsWith("Hello"));
        assertThat("Hello World!", org.hamcrest.core.StringStartsWith.startsWith("Hello"));

        assertThat("reason", "Hello World!", org.hamcrest.Matchers.startsWith("Hello"));
        assertThat("reason", "Hello World!", org.hamcrest.CoreMatchers.startsWith("Hello"));
        assertThat("reason", "Hello World!", org.hamcrest.core.StringStartsWith.startsWith("Hello"));
    }

    @Disabled("No direct conversion possible")
    @Test
    void starts_with_ignoring_case() {
        assertThat("Hello World!", org.hamcrest.Matchers.startsWithIgnoringCase("hello"));
        assertThat("Hello World!", org.hamcrest.CoreMatchers.startsWithIgnoringCase("hello"));
        assertThat("Hello World!", org.hamcrest.core.StringStartsWith.startsWithIgnoringCase("hello"));

        assertThat("reason", "Hello World!", org.hamcrest.Matchers.startsWithIgnoringCase("hello"));
        assertThat("reason", "Hello World!", org.hamcrest.CoreMatchers.startsWithIgnoringCase("hello"));
        assertThat("reason", "Hello World!", org.hamcrest.core.StringStartsWith.startsWithIgnoringCase("hello"));
    }

    @Test
    void ends_with() {
        assertThat("Hello World!", org.hamcrest.Matchers.endsWith("World!"));
        assertThat("Hello World!", org.hamcrest.CoreMatchers.endsWith("World!"));
        assertThat("Hello World!", org.hamcrest.core.StringEndsWith.endsWith("World!"));

        assertThat("reason", "Hello World!", org.hamcrest.Matchers.endsWith("World!"));
        assertThat("reason", "Hello World!", org.hamcrest.CoreMatchers.endsWith("World!"));
        assertThat("reason", "Hello World!", org.hamcrest.core.StringEndsWith.endsWith("World!"));
    }

    @Disabled("No direct conversion possible")
    @Test
    void ends_with_ignoring_case() {
        assertThat("Hello World!", org.hamcrest.Matchers.endsWithIgnoringCase("world!"));
        assertThat("Hello World!", org.hamcrest.CoreMatchers.endsWithIgnoringCase("world!"));
        assertThat("Hello World!", org.hamcrest.core.StringEndsWith.endsWithIgnoringCase("world!"));

        assertThat("reason", "Hello World!", org.hamcrest.Matchers.endsWithIgnoringCase("world!"));
        assertThat("reason", "Hello World!", org.hamcrest.CoreMatchers.endsWithIgnoringCase("world!"));
        assertThat("reason", "Hello World!", org.hamcrest.core.StringEndsWith.endsWithIgnoringCase("world!"));
    }

    @Test
    void contains_string() {
        assertThat("Hello World!", org.hamcrest.Matchers.containsString("lo Wo"));
        assertThat("Hello World!", org.hamcrest.CoreMatchers.containsString("lo Wo"));
        assertThat("Hello World!", org.hamcrest.core.StringContains.containsString("lo Wo"));

        assertThat("reason", "Hello World!", org.hamcrest.Matchers.containsString("lo Wo"));
        assertThat("reason", "Hello World!", org.hamcrest.CoreMatchers.containsString("lo Wo"));
        assertThat("reason", "Hello World!", org.hamcrest.core.StringContains.containsString("lo Wo"));
    }

    @Test
    void contains_string_ignoring_case() {
        assertThat("Hello World!", org.hamcrest.Matchers.containsStringIgnoringCase("lo wo"));
        assertThat("Hello World!", org.hamcrest.CoreMatchers.containsStringIgnoringCase("lo wo"));
        assertThat("Hello World!", org.hamcrest.core.StringContains.containsStringIgnoringCase("lo wo"));

        assertThat("reason", "Hello World!", org.hamcrest.Matchers.containsStringIgnoringCase("lo wo"));
        assertThat("reason", "Hello World!", org.hamcrest.CoreMatchers.containsStringIgnoringCase("lo wo"));
        assertThat("reason", "Hello World!", org.hamcrest.core.StringContains.containsStringIgnoringCase("lo wo"));
    }

    @Test
    void matches_regex_string() {
        assertThat("Hello World!", org.hamcrest.Matchers.matchesRegex("([A-Za-z]+ ([A-Za-z]+!))"));
        assertThat("Hello World!", org.hamcrest.core.StringRegularExpression.matchesRegex("([A-Za-z]+ ([A-Za-z]+!))"));

        assertThat("reason", "Hello World!", org.hamcrest.Matchers.matchesRegex("([A-Za-z]+ ([A-Za-z]+!))"));
        assertThat("reason", "Hello World!", org.hamcrest.core.StringRegularExpression.matchesRegex("([A-Za-z]+ ([A-Za-z]+!))"));
    }

    @Test
    void matches_regex_pattern() {
        assertThat("Hello World!", org.hamcrest.Matchers.matchesRegex(Pattern.compile("([A-Za-z]+ ([A-Za-z]+!))")));
        assertThat("Hello World!", org.hamcrest.core.StringRegularExpression.matchesRegex(Pattern.compile("([A-Za-z]+ ([A-Za-z]+!))")));

        assertThat("reason", "Hello World!", org.hamcrest.Matchers.matchesRegex(Pattern.compile("([A-Za-z]+ ([A-Za-z]+!))")));
        assertThat("reason", "Hello World!", org.hamcrest.core.StringRegularExpression.matchesRegex(Pattern.compile("([A-Za-z]+ ([A-Za-z]+!))")));
    }

    @Test
    void matches_pattern_string() {
        assertThat("Hello World!", org.hamcrest.Matchers.matchesPattern("([A-Za-z]+ ([A-Za-z]+!))"));
        assertThat("Hello World!", org.hamcrest.text.MatchesPattern.matchesPattern("([A-Za-z]+ ([A-Za-z]+!))"));

        assertThat("reason", "Hello World!", org.hamcrest.Matchers.matchesPattern("([A-Za-z]+ ([A-Za-z]+!))"));
        assertThat("reason", "Hello World!", org.hamcrest.text.MatchesPattern.matchesPattern("([A-Za-z]+ ([A-Za-z]+!))"));
    }

    @Test
    void matches_pattern_pattern() {
        assertThat("Hello World!", org.hamcrest.Matchers.matchesPattern(Pattern.compile("([A-Za-z]+ ([A-Za-z]+!))")));
        assertThat("Hello World!", org.hamcrest.text.MatchesPattern.matchesPattern(Pattern.compile("([A-Za-z]+ ([A-Za-z]+!))")));

        assertThat("reason", "Hello World!", org.hamcrest.Matchers.matchesPattern(Pattern.compile("([A-Za-z]+ ([A-Za-z]+!))")));
        assertThat("reason", "Hello World!", org.hamcrest.text.MatchesPattern.matchesPattern(Pattern.compile("([A-Za-z]+ ([A-Za-z]+!))")));
    }

    @Test
    void has_length() {
        assertThat("abc", org.hamcrest.Matchers.hasLength(3));
        assertThat("abc", org.hamcrest.text.CharSequenceLength.hasLength(3));

        assertThat("reason", "abc", org.hamcrest.Matchers.hasLength(3));
        assertThat("reason", "abc", org.hamcrest.text.CharSequenceLength.hasLength(3));
    }

    @Test
    void blank_string() {
        assertThat("   ", org.hamcrest.Matchers.blankString());
        assertThat("   ", org.hamcrest.text.IsBlankString.blankString());

        assertThat("reason", "   ", org.hamcrest.Matchers.blankString());
        assertThat("reason", "   ", org.hamcrest.text.IsBlankString.blankString());
    }

    @Test
    void is_blank_string() {
        assertThat("   ", org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.blankString()));
        assertThat("   ", org.hamcrest.CoreMatchers.is(org.hamcrest.text.IsBlankString.blankString()));

        assertThat("   ", org.hamcrest.core.Is.is(org.hamcrest.Matchers.blankString()));
        assertThat("   ", org.hamcrest.core.Is.is(org.hamcrest.text.IsBlankString.blankString()));

        assertThat("   ", org.hamcrest.Matchers.is(org.hamcrest.Matchers.blankString()));
        assertThat("   ", org.hamcrest.Matchers.is(org.hamcrest.text.IsBlankString.blankString()));

        assertThat("reason", "   ", org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.blankString()));
        assertThat("reason", "   ", org.hamcrest.CoreMatchers.is(org.hamcrest.text.IsBlankString.blankString()));

        assertThat("reason", "   ", org.hamcrest.core.Is.is(org.hamcrest.Matchers.blankString()));
        assertThat("reason", "   ", org.hamcrest.core.Is.is(org.hamcrest.text.IsBlankString.blankString()));

        assertThat("reason", "   ", org.hamcrest.Matchers.is(org.hamcrest.Matchers.blankString()));
        assertThat("reason", "   ", org.hamcrest.Matchers.is(org.hamcrest.text.IsBlankString.blankString()));
    }

    @Disabled("No direct conversion possible") // could convert to "isEmptyOrNull()" but not necessarily the same thing
    @Test
    void blank_or_null_string() {
        assertThat("   ", org.hamcrest.Matchers.blankOrNullString());
        assertThat("   ", org.hamcrest.text.IsBlankString.blankOrNullString());

        assertThat("reason", "   ", org.hamcrest.Matchers.blankOrNullString());
        assertThat("reason", "   ", org.hamcrest.text.IsBlankString.blankOrNullString());
    }

    @Disabled("No direct conversion possible") // could convert to "isEmptyOrNull()" but not necessarily the same thing
    @Test
    void is_blank_or_null_string() {
        assertThat("   ", org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.blankOrNullString()));
        assertThat("   ", org.hamcrest.CoreMatchers.is(org.hamcrest.text.IsBlankString.blankOrNullString()));

        assertThat("   ", org.hamcrest.core.Is.is(org.hamcrest.Matchers.blankOrNullString()));
        assertThat("   ", org.hamcrest.core.Is.is(org.hamcrest.text.IsBlankString.blankOrNullString()));

        assertThat("   ", org.hamcrest.Matchers.is(org.hamcrest.Matchers.blankOrNullString()));
        assertThat("   ", org.hamcrest.Matchers.is(org.hamcrest.text.IsBlankString.blankOrNullString()));

        assertThat("reason", "   ", org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.blankOrNullString()));
        assertThat("reason", "   ", org.hamcrest.CoreMatchers.is(org.hamcrest.text.IsBlankString.blankOrNullString()));

        assertThat("reason", "   ", org.hamcrest.core.Is.is(org.hamcrest.Matchers.blankOrNullString()));
        assertThat("reason", "   ", org.hamcrest.core.Is.is(org.hamcrest.text.IsBlankString.blankOrNullString()));

        assertThat("reason", "   ", org.hamcrest.Matchers.is(org.hamcrest.Matchers.blankOrNullString()));
        assertThat("reason", "   ", org.hamcrest.Matchers.is(org.hamcrest.text.IsBlankString.blankOrNullString()));
    }

    @Test
    void empty_string() {
        assertThat("", org.hamcrest.Matchers.emptyString());
        assertThat("", org.hamcrest.text.IsEmptyString.emptyString());

        assertThat("reason", "", org.hamcrest.Matchers.emptyString());
        assertThat("reason", "", org.hamcrest.text.IsEmptyString.emptyString());
    }

    @Test
    void is_empty_string() {
        assertThat("", org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.emptyString()));
        assertThat("", org.hamcrest.CoreMatchers.is(org.hamcrest.text.IsEmptyString.emptyString()));

        assertThat("", org.hamcrest.core.Is.is(org.hamcrest.Matchers.emptyString()));
        assertThat("", org.hamcrest.core.Is.is(org.hamcrest.text.IsEmptyString.emptyString()));

        assertThat("", org.hamcrest.Matchers.is(org.hamcrest.Matchers.emptyString()));
        assertThat("", org.hamcrest.Matchers.is(org.hamcrest.text.IsEmptyString.emptyString()));

        assertThat("reason", "", org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.emptyString()));
        assertThat("reason", "", org.hamcrest.CoreMatchers.is(org.hamcrest.text.IsEmptyString.emptyString()));

        assertThat("reason", "", org.hamcrest.core.Is.is(org.hamcrest.Matchers.emptyString()));
        assertThat("reason", "", org.hamcrest.core.Is.is(org.hamcrest.text.IsEmptyString.emptyString()));

        assertThat("reason", "", org.hamcrest.Matchers.is(org.hamcrest.Matchers.emptyString()));
        assertThat("reason", "", org.hamcrest.Matchers.is(org.hamcrest.text.IsEmptyString.emptyString()));
    }

    @Test
    void empty_or_null_string() {
        assertThat("", org.hamcrest.Matchers.emptyOrNullString());
        assertThat("", org.hamcrest.text.IsEmptyString.emptyOrNullString());

        assertThat("reason", "", org.hamcrest.Matchers.emptyOrNullString());
        assertThat("reason", "", org.hamcrest.text.IsEmptyString.emptyOrNullString());
    }

    @Test
    void is_empty_or_null_string() {
        assertThat("", org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.emptyOrNullString()));
        assertThat("", org.hamcrest.CoreMatchers.is(org.hamcrest.text.IsEmptyString.emptyOrNullString()));

        assertThat("", org.hamcrest.core.Is.is(org.hamcrest.Matchers.emptyOrNullString()));
        assertThat("", org.hamcrest.core.Is.is(org.hamcrest.text.IsEmptyString.emptyOrNullString()));

        assertThat("", org.hamcrest.Matchers.is(org.hamcrest.Matchers.emptyOrNullString()));
        assertThat("", org.hamcrest.Matchers.is(org.hamcrest.text.IsEmptyString.emptyOrNullString()));

        assertThat("reason", "", org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.emptyOrNullString()));
        assertThat("reason", "", org.hamcrest.CoreMatchers.is(org.hamcrest.text.IsEmptyString.emptyOrNullString()));

        assertThat("reason", "", org.hamcrest.core.Is.is(org.hamcrest.Matchers.emptyOrNullString()));
        assertThat("reason", "", org.hamcrest.core.Is.is(org.hamcrest.text.IsEmptyString.emptyOrNullString()));

        assertThat("reason", "", org.hamcrest.Matchers.is(org.hamcrest.Matchers.emptyOrNullString()));
        assertThat("reason", "", org.hamcrest.Matchers.is(org.hamcrest.text.IsEmptyString.emptyOrNullString()));
    }

    @Test
    void equal_compressing_white_space() {
        assertThat(" string   with   spaces ", org.hamcrest.Matchers.equalToCompressingWhiteSpace("string with spaces"));
        assertThat(" string   with   spaces ", org.hamcrest.text.IsEqualCompressingWhiteSpace.equalToCompressingWhiteSpace("string with spaces"));
        assertThat(" string   with   spaces ", org.hamcrest.text.IsEqualCompressingWhiteSpace.equalToIgnoringWhiteSpace("string with spaces"));

        assertThat("reason", " string   with   spaces ", org.hamcrest.Matchers.equalToCompressingWhiteSpace("string with spaces"));
        assertThat("reason", " string   with   spaces ", org.hamcrest.text.IsEqualCompressingWhiteSpace.equalToCompressingWhiteSpace("string with spaces"));
        assertThat("reason", " string   with   spaces ", org.hamcrest.text.IsEqualCompressingWhiteSpace.equalToIgnoringWhiteSpace("string with spaces"));
    }

    @Test
    void is_equal_compressing_white_space() {
        assertThat(" string   with   spaces ", org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.equalToCompressingWhiteSpace("string with spaces")));
        assertThat(" string   with   spaces ", org.hamcrest.CoreMatchers.is(org.hamcrest.text.IsEqualCompressingWhiteSpace.equalToCompressingWhiteSpace("string with spaces")));
        assertThat(" string   with   spaces ", org.hamcrest.CoreMatchers.is(org.hamcrest.text.IsEqualCompressingWhiteSpace.equalToIgnoringWhiteSpace("string with spaces")));

        assertThat(" string   with   spaces ", org.hamcrest.core.Is.is(org.hamcrest.Matchers.equalToCompressingWhiteSpace("string with spaces")));
        assertThat(" string   with   spaces ", org.hamcrest.core.Is.is(org.hamcrest.text.IsEqualCompressingWhiteSpace.equalToCompressingWhiteSpace("string with spaces")));
        assertThat(" string   with   spaces ", org.hamcrest.core.Is.is(org.hamcrest.text.IsEqualCompressingWhiteSpace.equalToIgnoringWhiteSpace("string with spaces")));

        assertThat(" string   with   spaces ", org.hamcrest.Matchers.is(org.hamcrest.Matchers.equalToCompressingWhiteSpace("string with spaces")));
        assertThat(" string   with   spaces ", org.hamcrest.Matchers.is(org.hamcrest.text.IsEqualCompressingWhiteSpace.equalToCompressingWhiteSpace("string with spaces")));
        assertThat(" string   with   spaces ", org.hamcrest.Matchers.is(org.hamcrest.text.IsEqualCompressingWhiteSpace.equalToIgnoringWhiteSpace("string with spaces")));

        assertThat("reason", " string   with   spaces ", org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.equalToCompressingWhiteSpace("string with spaces")));
        assertThat("reason", " string   with   spaces ", org.hamcrest.CoreMatchers.is(org.hamcrest.text.IsEqualCompressingWhiteSpace.equalToCompressingWhiteSpace("string with spaces")));
        assertThat("reason", " string   with   spaces ", org.hamcrest.CoreMatchers.is(org.hamcrest.text.IsEqualCompressingWhiteSpace.equalToIgnoringWhiteSpace("string with spaces")));

        assertThat("reason", " string   with   spaces ", org.hamcrest.core.Is.is(org.hamcrest.Matchers.equalToCompressingWhiteSpace("string with spaces")));
        assertThat("reason", " string   with   spaces ", org.hamcrest.core.Is.is(org.hamcrest.text.IsEqualCompressingWhiteSpace.equalToCompressingWhiteSpace("string with spaces")));
        assertThat("reason", " string   with   spaces ", org.hamcrest.core.Is.is(org.hamcrest.text.IsEqualCompressingWhiteSpace.equalToIgnoringWhiteSpace("string with spaces")));

        assertThat("reason", " string   with   spaces ", org.hamcrest.Matchers.is(org.hamcrest.Matchers.equalToCompressingWhiteSpace("string with spaces")));
        assertThat("reason", " string   with   spaces ", org.hamcrest.Matchers.is(org.hamcrest.text.IsEqualCompressingWhiteSpace.equalToCompressingWhiteSpace("string with spaces")));
        assertThat("reason", " string   with   spaces ", org.hamcrest.Matchers.is(org.hamcrest.text.IsEqualCompressingWhiteSpace.equalToIgnoringWhiteSpace("string with spaces")));
    }

    @Test
    void equal_ignoring_case() {
        assertThat("HeLlO wOrLd!", org.hamcrest.Matchers.equalToIgnoringCase("Hello World!"));
        assertThat("HeLlO wOrLd!", org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase("Hello World!"));

        assertThat("reason", "HeLlO wOrLd!", org.hamcrest.Matchers.equalToIgnoringCase("Hello World!"));
        assertThat("reason", "HeLlO wOrLd!", org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase("Hello World!"));
    }

    @Test
    void is_equal_ignoring_case() {
        assertThat("HeLlO wOrLd!", org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.equalToIgnoringCase("Hello World!")));
        assertThat("HeLlO wOrLd!", org.hamcrest.CoreMatchers.is(org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase("Hello World!")));

        assertThat("HeLlO wOrLd!", org.hamcrest.core.Is.is(org.hamcrest.Matchers.equalToIgnoringCase("Hello World!")));
        assertThat("HeLlO wOrLd!", org.hamcrest.core.Is.is(org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase("Hello World!")));

        assertThat("HeLlO wOrLd!", org.hamcrest.Matchers.is(org.hamcrest.Matchers.equalToIgnoringCase("Hello World!")));
        assertThat("HeLlO wOrLd!", org.hamcrest.Matchers.is(org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase("Hello World!")));

        assertThat("reason", "HeLlO wOrLd!", org.hamcrest.CoreMatchers.is(org.hamcrest.Matchers.equalToIgnoringCase("Hello World!")));
        assertThat("reason", "HeLlO wOrLd!", org.hamcrest.CoreMatchers.is(org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase("Hello World!")));

        assertThat("reason", "HeLlO wOrLd!", org.hamcrest.core.Is.is(org.hamcrest.Matchers.equalToIgnoringCase("Hello World!")));
        assertThat("reason", "HeLlO wOrLd!", org.hamcrest.core.Is.is(org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase("Hello World!")));

        assertThat("reason", "HeLlO wOrLd!", org.hamcrest.Matchers.is(org.hamcrest.Matchers.equalToIgnoringCase("Hello World!")));
        assertThat("reason", "HeLlO wOrLd!", org.hamcrest.Matchers.is(org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase("Hello World!")));
    }

    @Disabled("No direct conversion possible") // could convert to .contains(args) but it is a weaker assertions
    @Test
    void string_contains_in_order() {
        assertThat("The quick brown fox jumps over the lazy dog", org.hamcrest.Matchers.stringContainsInOrder(List.of("fox", "dog")));
        assertThat("The quick brown fox jumps over the lazy dog", org.hamcrest.text.StringContainsInOrder.stringContainsInOrder(List.of("fox", "dog")));
        assertThat("The quick brown fox jumps over the lazy dog", org.hamcrest.Matchers.stringContainsInOrder("fox", "dog"));
        assertThat("The quick brown fox jumps over the lazy dog", org.hamcrest.text.StringContainsInOrder.stringContainsInOrder("fox", "dog"));

        assertThat("reason", "The quick brown fox jumps over the lazy dog", org.hamcrest.Matchers.stringContainsInOrder(List.of("fox", "dog")));
        assertThat("reason", "The quick brown fox jumps over the lazy dog", org.hamcrest.text.StringContainsInOrder.stringContainsInOrder(List.of("fox", "dog")));
        assertThat("reason", "The quick brown fox jumps over the lazy dog", org.hamcrest.Matchers.stringContainsInOrder("fox", "dog"));
        assertThat("reason", "The quick brown fox jumps over the lazy dog", org.hamcrest.text.StringContainsInOrder.stringContainsInOrder("fox", "dog"));
    }
}
