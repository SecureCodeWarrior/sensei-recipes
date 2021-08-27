import java.util.Objects;

public class OverridingClass {

    private String prop;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OverridingClass that = (OverridingClass) o;
        return Objects.equals(prop, that.prop);
    }

    public int hashCodes() {
        return Objects.hash(prop);
    }
}
