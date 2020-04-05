package ru.thezit445.nbtreflectionapi.reflection;

import ru.thezit445.nbtreflectionapi.NBTReflectionAPI;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <i>Created on 05.04.2020.</i>
 * A stripped down version of NMS TileEntity.
 * @author Titov Kirill <thezit445@yandex.ru>
 * @version 1.0.0
 */
public class ReflectionAPI {

    private ReflectionAPI() {

    }

    public static <T> T getNewInstanceFromClass(Class<T> clazz, Class<?>[] typeArgs, Object... args) {
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor(typeArgs);
            constructor.setAccessible(true);
            T newInstance = (T) constructor.newInstance(args);
            return newInstance;
        } catch (Exception e) {
            Logger.getLogger(NBTReflectionAPI.class.getName()).log(Level.SEVERE, "Reflection error: ", e);
        }
        return null;
    }

    public static <T> Object invokeMethod(Class<T> clazz, Object instance, String methodName, Class<?>[] typeArgs, Object... args) {
        try {
            Method method = clazz.getDeclaredMethod(methodName, typeArgs);
            method.setAccessible(true);
            Object object = method.invoke(instance, args);
            return object;
        } catch (Exception e) {
            Logger.getLogger(NBTReflectionAPI.class.getName()).log(Level.SEVERE, "Reflection error: ", e);
        }
        return null;
    }

}
