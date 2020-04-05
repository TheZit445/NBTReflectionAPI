package ru.thezit445.nbtreflectionapi.util;

import ru.thezit445.nbtreflectionapi.reflection.ClassWrapper;
import ru.thezit445.nbtreflectionapi.reflection.ReflectionAPI;

public enum NMSInstance {

    NBT_TAG_COMPOUND(ClassWrapper.NBT_TAG_COMPOUND.get(), null),
    NBT_TAG_LIST(ClassWrapper.NBT_TAG_LIST.get(), null),
    BLOCK_POSITION(ClassWrapper.BLOCK_POSITION.get(), new Class[]{int.class, int.class, int.class});

    private Class<?> clazz = null;
    private Class<?>[] typeArgs = new Class[0];

    NMSInstance(Class<?> clazz, Class<?>[] typeArgs) {
        this.clazz = clazz;
        this.typeArgs = typeArgs;
    }

    public Object callConstructor(Object... args) {
        return ReflectionAPI.getNewInstanceFromClass(clazz, typeArgs, args);
    }

}
