import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * Created by root on 16-6-25.
 * mailto:blusto@gmail.com
 */
 class ReflectionTest {

    /**
     * @param args 入参
     */
    public static void main(final String[] args) {

        String name;

        if (args.length > 0) {
            name = args[0];
        } else {
            Scanner in = new Scanner(System.in);
            System.out.println("输入类名（例如： java.util.Data）:");
            name = in.next();
        }

        try {
            Class cl = Class.forName(name);
            Class supercl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print("Class " + name);
            if (supercl != null && supercl != Object.class) {
                System.out.print(" extends " + supercl.getName());
            }
            System.out.println("{");
            printContructors(cl);
            System.out.println();
            printMethods(cl);
            System.out.println();
            printFields(cl);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * 输出类中所有的构造器。
     * @param cl 传入的类
     */
    public static void  printContructors(final Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();
        for (Constructor c:constructors) {
            String name = c.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + "  ");
            }
            System.out.print(name + "(");

            Class[] paramType = c.getParameterTypes();
            for (int i = 0; i < paramType.length; i++) {
                if (i > 0) {
                    System.out.print(",  ");
                }
                System.out.print(paramType[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * 输出类中所有的方法。
     * @param cl    传入的类
     */
    public static void printMethods(Class cl){
        Method[] methods = cl.getDeclaredMethods();
        for (Method m:methods){
            Class retType = m.getReturnType();
            String name = m.getName();

            System.out.print("  ");
            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0){
                System.out.print(modifiers + "  ");
            }
            System.out.print(retType.getName() + "  " + name +"(");

            Class[] paramTypes = m.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0)
                    System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    public static void printFields(Class cl){
        Field[] fields = cl.getFields();

        for (Field f:fields){
            Class type = f.getType();
            String name = f.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + "  ");
            System.out.println(type.getName() + "   " + name + ";");
        }
    }
}
