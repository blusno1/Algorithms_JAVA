package objectAnalyzer;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * Created by root on 16-6-26.
 * mailto:blusto@gmail.com
 */
public class ObjectAnalyzer {

    private ArrayList<Object> visited = new ArrayList<>();

    public String toString(Object obj){

        if (obj == null)
            return "null";
        if (visited.contains(obj))
            return "...";

        visited.add(obj);
        Class cl = obj.getClass();

        if (cl == String.class)
            return (String) obj;
        if (cl.isArray()) {
            String s = cl.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0)
                    s += ",";
                Object val = Array.get(obj,i);
                if (cl.getComponentType().isPrimitive()) {
                    s += val;
                } else {
                    s += toString(val);
                }
            }
            return s + "}";
        }

        String s = cl.getName();

        do {
            s += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields,true);
            for (Field f : fields) {
                if (!Modifier.isStatic(f.getModifiers())) {
                    if (!s.endsWith("["))
                        s += ",";
                    s += f.getName() + "=";
                    try {
                        Class t = f.getType();
                        Object val = f.get(obj);
                        if (t.isPrimitive()) {
                            s += val;
                        }
                        else {
                            s += toString(val);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            s += "]";
            cl = cl.getSuperclass();
        } while (cl != null);

        return s;
    }
}
