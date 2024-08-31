package dev.alizaarour.objectInspector;

import dev.alizaarour.util.formater.JsonComposite;
import dev.alizaarour.util.formater.JsonLeaf;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Scanner;

public class InspectClass {

    private String className;

    private Class<?> clazz;

    private JsonComposite info;

    public InspectClass() {
    }


    public void start() {
        getClassNameFromUser();
        if (validateClassExistence()) {
            initializeClassInfo();
            gatherClassDetails();
            System.out.println(info.toJson());
        }
    }

    private void getClassNameFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the fully qualified class name: ");
        this.className = scanner.nextLine();
    }

    private boolean validateClassExistence() {
        try {
            clazz = Class.forName(this.className);
            System.out.println("Class found : [ " + clazz.getName() + " ]");
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("Class with name  [ " + className + " ] doesn't exist.");
            return false;
        }
    }

    private void initializeClassInfo() {
        info = new JsonComposite("classInfo");
    }

    private void gatherClassDetails() {
        addClassInfo();
        addFieldsInfo();
        addConstructorsInfo();
        addMethodsInfo();
    }

    private void addClassInfo() {
        info.addChild(new JsonLeaf<>("name", clazz.getName()));
        info.addChild(new JsonLeaf<>("simpleName", clazz.getSimpleName()));
        info.addChild(new JsonLeaf<>("canonicalName", clazz.getCanonicalName()));
        info.addChild(new JsonLeaf<>("package", clazz.getPackageName()));
        info.addChild(new JsonLeaf<>("superClass", String.valueOf(clazz.getSuperclass())));
        info.addChild(new JsonLeaf<>("modifiers", Arrays.stream(Modifier.toString(clazz.getModifiers()).split(" ")).toList()));
        info.addChild(new JsonLeaf<>("interfaces", Arrays.stream(clazz.getInterfaces()).map(Class::getName).toList()));
    }

    private void addFieldsInfo() {
        var fields = new JsonComposite("fields");
        var declaredFields = clazz.getDeclaredFields();
        fields.addChild(new JsonLeaf<>("count", declaredFields.length));
        Arrays.stream(declaredFields).forEach(field -> {
            JsonComposite fieldInfo = new JsonComposite(field.getName());
            fieldInfo.addChild(new JsonLeaf<>("type", field.getType().getName()));
            fieldInfo.addChild(new JsonLeaf<>("genericType", field.getGenericType().getTypeName()));
            fieldInfo.addChild(new JsonLeaf<>("modifiers", Arrays.stream(Modifier.toString(field.getModifiers()).split(" ")).toList()));
            fields.addChild(fieldInfo);
        });
        info.addChild(fields);
    }

    private void addConstructorsInfo() {
        var constructors = new JsonComposite("constructors");
        var declaredConstructors = clazz.getDeclaredConstructors();
        constructors.addChild(new JsonLeaf<>("count", declaredConstructors.length));
        Arrays.stream(declaredConstructors).forEach(constructor -> {
            JsonComposite constructorInfo = new JsonComposite(constructor.getName());
            constructorInfo.addChild(new JsonLeaf<>("parameterCount", constructor.getParameterCount()));
            constructorInfo.addChild(new JsonLeaf<>("parameterTypes", Arrays.stream(constructor.getParameterTypes()).map(Class::getName).toList()));
            constructorInfo.addChild(new JsonLeaf<>("genericParameterTypes", Arrays.stream(constructor.getGenericParameterTypes()).map(Type::getTypeName).toList()));
            constructorInfo.addChild(new JsonLeaf<>("annotations", Arrays.stream(constructor.getAnnotations()).map(Object::toString).toList()));
            constructorInfo.addChild(new JsonLeaf<>("modifiers", Arrays.stream(Modifier.toString(constructor.getModifiers()).split(" ")).toList()));
            constructors.addChild(constructorInfo);
        });
        info.addChild(constructors);
    }

    private void addMethodsInfo() {
        var methods = new JsonComposite("methods");
        var declaredMethods = clazz.getDeclaredMethods();
        methods.addChild(new JsonLeaf<Integer>("count", declaredMethods.length));
        Arrays.stream(declaredMethods).forEach(method -> {
            JsonComposite methodInfo = new JsonComposite(method.getName());
            methodInfo.addChild(new JsonLeaf<>("parameterCount", method.getParameterCount()));
            methodInfo.addChild(new JsonLeaf<>("parameterTypes", Arrays.stream(method.getParameterTypes()).map(Class::getName).toList()));
            methodInfo.addChild(new JsonLeaf<>("genericParameterTypes", Arrays.stream(method.getGenericParameterTypes()).map(Type::getTypeName).toList()));
            methodInfo.addChild(new JsonLeaf<>("returnType", method.getReturnType().getName()));
            methodInfo.addChild(new JsonLeaf<>("genericReturnType", method.getGenericReturnType().getTypeName()));
            methodInfo.addChild(new JsonLeaf<>("annotations", Arrays.stream(method.getAnnotations()).map(Annotation::toString).toList()));
            methodInfo.addChild(new JsonLeaf<>("modifiers", Arrays.stream(Modifier.toString(method.getModifiers()).split(" ")).toList()));
            methods.addChild(methodInfo);
        });
        info.addChild(methods);
    }

}
