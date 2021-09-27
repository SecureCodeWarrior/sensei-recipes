package util;

import org.joda.time.DurationFieldType;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;

import java.lang.reflect.*;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GenerateExamples {

    public static void main(String[] args) {

        generateTestCode(LocalDateTime.class);
    }

    private static String params(Parameter[] parameters) {
        List<String> parameterNames = Arrays.stream(parameters).map(p -> p.getType().getSimpleName().toLowerCase() + "Arg").collect(Collectors.toList());
        return String.join(",", parameterNames);
    }

    private static String nextVar(String prefix, Map<String, Integer> map) {

        if (map.containsKey(prefix)) {
            Integer i = map.get(prefix) + 1;
            map.put(prefix, i);
            return prefix + i;
        }

        map.put(prefix, 1);

        return prefix + 1;

    }

    private static void generateTestCode(Class<?> clazz) {

        String varName = String.format("test%s", clazz.getSimpleName());

        Map<String, Integer> vars = new HashMap<>();

        StringBuilder constructors = new StringBuilder("public void constructors() { \n");
        StringBuilder staticMethods = new StringBuilder("public void staticMethods() {\n");
        StringBuilder staticFields = new StringBuilder("public void staticFields() {\n");
        StringBuilder instanceMethods = new StringBuilder("public void instanceMethods() {\n");
        StringBuilder instanceFields = new StringBuilder("public void instanceFields() {\n");

        for (Constructor<?> c : clazz.getConstructors()) {

            if (Modifier.isPublic(c.getModifiers())) {

                String constructor = String.format("%1$s %2$s = new %1$s(%3$s);\n", clazz.getSimpleName(), nextVar(clazz.getSimpleName(), vars), params(c.getParameters()));
                constructors.append(constructor);

            }

        }

        for (Field field : clazz.getFields()) {

            Class<?> fieldType = field.getType();

            if (Modifier.isPublic(field.getModifiers())) {

                String callOnMe = (Modifier.isStatic(field.getModifiers())) ? clazz.getSimpleName() : varName;
                StringBuilder sb = (Modifier.isStatic(field.getModifiers())) ? staticFields : instanceFields;

                String assignment = String.format("%s.%s;\n", callOnMe, field.getName());

                sb.append(String.format("%s my%s = ", fieldType.getName(), field.getName()));

                sb.append(assignment);

            }


        }

        for (Method m : clazz.getMethods()) {

            Class<?> returnType = m.getReturnType();

            if (Modifier.isPublic(m.getModifiers())) {

                String callOnMe = (Modifier.isStatic(m.getModifiers())) ? clazz.getSimpleName() : varName;
                StringBuilder sb = (Modifier.isStatic(m.getModifiers())) ? staticMethods : instanceMethods;

                String methodCall = String.format("%s.%s(%s);\n", callOnMe, m.getName(), params(m.getParameters()));

                if (!returnType.equals(Void.TYPE)) {
                    sb.append(String.format("%s %s = ", returnType.getName(), m.getName()));
                }

                sb.append(methodCall);

            }

        }

        constructors.append("\n}\n");
        staticMethods.append("\n}\n");
        staticFields.append("\n}\n");
        instanceMethods.append("\n}\n");
        instanceFields.append("\n}\n");

        System.out.println(constructors.toString());
        System.out.println(staticMethods.toString());
        System.out.println(staticFields.toString());
        System.out.println(instanceMethods.toString());
        System.out.println(instanceFields.toString());

    }

    private GenerateExamples() {}

}
