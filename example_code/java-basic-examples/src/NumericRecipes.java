import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NumericRecipes {
    public static void main(String[] args) {
        double primDouble = 0.1;
        Double boxedPrimDouble = 0.1;
        Double fromStrDouble = Double.parseDouble("0.1");

        float primFloat = 0.1f;
        Float boxedPrimFloat = 0.1f;
        Float fromStrFloat = Float.parseFloat("0.1");

        List<BigDecimal> decimals = new ArrayList<>();

        // Picked up by IntelliJ
        decimals.add(new BigDecimal(0.1));  // 0.1000000000000000055511151231257827021181583404541015625
        decimals.add(new BigDecimal(0.1f)); // 0.100000001490116119384765625

        // Can be detected, but no analysis can be done on whether the value has been altered
        // In particular we want to know whether the value can be represented as intended,
        // but we have no way of knowing this using current analysis
        decimals.add(new BigDecimal(primDouble)); // 0.1000000000000000055511151231257827021181583404541015625
        decimals.add(new BigDecimal(primFloat)); // 0.100000001490116119384765625
        decimals.add(new BigDecimal(boxedPrimDouble)); // 0.1000000000000000055511151231257827021181583404541015625
        decimals.add(new BigDecimal(boxedPrimFloat)); // 0.100000001490116119384765625
        decimals.add(new BigDecimal(fromStrDouble)); // 0.1000000000000000055511151231257827021181583404541015625
        decimals.add(new BigDecimal(fromStrFloat)); // 0.100000001490116119384765625

        // Correct usage
        decimals.add(new BigDecimal("0.1")); // 0.1


    }
}
