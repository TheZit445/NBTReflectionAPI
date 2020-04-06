package ru.thezit445.nbtreflectionapi.util;

import org.bukkit.inventory.ItemStack;
import ru.thezit445.nbtreflectionapi.reflection.ClassWrapper;
import ru.thezit445.nbtreflectionapi.reflection.ReflectionAPI;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * <i>Created on 05.04.2020.</i>
 * Enum with necessary methods.
 * @author Kirill Titov <thezit445@yandex.ru>
 * @version 1.1.0
 */
public enum NMSMethod {

    BASE_BLOCK_POSITION_GET_X(ClassWrapper.BASE_BLOCK_POSITION, "getX",null),
    BASE_BLOCK_POSITION_GET_Y(ClassWrapper.BASE_BLOCK_POSITION, "getY",null),
    BASE_BLOCK_POSITION_GET_Z(ClassWrapper.BASE_BLOCK_POSITION, "getZ",null),
    WORLD_GET_WORLD(ClassWrapper.WORLD,"getWorld",null),
    WORLD_GET_TILE_ENTITY(ClassWrapper.WORLD,"getTileEntity", new Class[]{ClassWrapper.BLOCK_POSITION.get()}),
    CRAFT_WORLD_GET_HANDLE(ClassWrapper.CRAFT_WORLD, "getHandle", null),
    TILE_ENTITY_GET_WORLD(ClassWrapper.TILE_ENTITY, "getWorld",null),
    TILE_ENTITY_GET_POSITION(ClassWrapper.TILE_ENTITY, "getPosition",null),
    TILE_ENTITY_UPDATE(ClassWrapper.TILE_ENTITY, "update", null),
    TILE_ENTITY_SET_NBT(ClassWrapper.TILE_ENTITY, "load", new Class[]{ClassWrapper.NBT_TAG_COMPOUND.get()}),
    TILE_ENTITY_GET_NBT(ClassWrapper.TILE_ENTITY,"save", new Class[]{ClassWrapper.NBT_TAG_COMPOUND.get()}),
    ENTITY_SET_NBT(ClassWrapper.ENTITY,"f", new Class[]{ClassWrapper.NBT_TAG_COMPOUND.get()}),
    ENTITY_GET_NBT(ClassWrapper.ENTITY, "save", new Class[]{ClassWrapper.NBT_TAG_COMPOUND.get()}),
    ENTITY_GET_BUKKIT_ENTITY(ClassWrapper.ENTITY, "getBukkitEntity", null),
    CRAFT_ENTITY_GET_HANDLE(ClassWrapper.CRAFT_ENTITY, "getHandle", null),
    CRAFT_ITEM_STACK_AS_BUKKIT_COPY(ClassWrapper.CRAFT_ITEM_STACK, "asBukkitCopy", new Class[]{ClassWrapper.ITEM_STACK.get()}),
    CRAFT_ITEM_STACK_AS_NMS_COPY(ClassWrapper.CRAFT_ITEM_STACK, "asNMSCopy", new Class[]{ItemStack.class}),
    ITEM_STACK_GET_NBT(ClassWrapper.ITEM_STACK,"save", new Class[]{ClassWrapper.NBT_TAG_COMPOUND.get()}),
    ITEM_STACK_SET_NBT_TAG_COMPOUND(ClassWrapper.CRAFT_ITEM_STACK,"a", new Class[]{ClassWrapper.NBT_TAG_COMPOUND.get()}),
    ITEM_STACK_GET_FROM_NBT(ClassWrapper.CRAFT_ITEM_STACK,"a", new Class[]{ClassWrapper.NBT_TAG_COMPOUND.get()}),
    NBT_TAG_COMPOUND_TO_STRING(ClassWrapper.NBT_TAG_COMPOUND,"toString", null),
    NBT_TAG_COMPOUND_GET(ClassWrapper.NBT_TAG_COMPOUND,"get", new Class[]{String.class}),
    NBT_TAG_COMPOUND_SET(ClassWrapper.NBT_TAG_COMPOUND,"set", new Class[]{String.class, ClassWrapper.NBT_BASE.get()}),
    NBT_TAG_COMPOUND_SET_BOOLEAN(ClassWrapper.NBT_TAG_COMPOUND,"setBoolean", new Class[]{String.class, boolean.class}),
    NBT_TAG_COMPOUND_SET_BYTE(ClassWrapper.NBT_TAG_COMPOUND,"setByte", new Class[]{String.class, byte.class}),
    NBT_TAG_COMPOUND_SET_BYTE_ARRAY(ClassWrapper.NBT_TAG_COMPOUND,"setByteArray", new Class[]{String.class, byte[].class}),
    NBT_TAG_COMPOUND_SET_DOUBLE(ClassWrapper.NBT_TAG_COMPOUND,"setDouble", new Class[]{String.class, double.class}),
    NBT_TAG_COMPOUND_SET_FLOAT(ClassWrapper.NBT_TAG_COMPOUND,"setFloat", new Class[]{String.class, float.class}),
    NBT_TAG_COMPOUND_SET_INT(ClassWrapper.NBT_TAG_COMPOUND,"setInt", new Class[]{String.class, int.class}),
    NBT_TAG_COMPOUND_SET_INT_ARRAY(ClassWrapper.NBT_TAG_COMPOUND,"setIntArray", new Class[]{String.class, int[].class}),
    NBT_TAG_COMPOUND_SET_LONG(ClassWrapper.NBT_TAG_COMPOUND,"setLong", new Class[]{String.class, long.class}),
    NBT_TAG_COMPOUND_SET_SHORT(ClassWrapper.NBT_TAG_COMPOUND,"setShort", new Class[]{String.class, short.class}),
    NBT_TAG_COMPOUND_SET_STRING(ClassWrapper.NBT_TAG_COMPOUND,"setString", new Class[]{String.class, String.class}),
    NBT_COMPRESSED_STREAM_TOOLS_READ_COMPRESSED(ClassWrapper.NBT_COMPRESSED_STREAM_TOOLS,"a", new Class[]{InputStream.class}),
    NBT_COMPRESSED_STREAM_TOOLS_WRITE_COMPRESSED(ClassWrapper.NBT_COMPRESSED_STREAM_TOOLS,"a", new Class[]{OutputStream.class}),
    NBT_TAG_LIST_ADD(ClassWrapper.NBT_TAG_LIST,"add", new Class[]{int.class, ClassWrapper.NBT_BASE.get()}),
    NBT_TAG_LIST_SIZE(ClassWrapper.NBT_TAG_LIST,"size", null),
    MOJANGSON_PARSER_PARSE(ClassWrapper.MOJANGSON_PARSER,"parse", new Class[]{String.class});

    private ClassWrapper clazz = null;
    private String methodName = null;
    private Class<?>[] typeArgs = new Class[0];

    NMSMethod(ClassWrapper clazz, String methodName, Class<?>[] typeArgs) {
        this.clazz = clazz;
        this.methodName = methodName;
        this.typeArgs = typeArgs;
    }

    /**
     * Invokes method.
     * @param instance - the instance that invokes method. May be null, if you need invoke static method.
     * @param args - arguments for invoke method. See classes of parameters in the third parameter of enum constructor.
     * @return Object - nms object (Example: NBTTagCompound). May be null, if method return void.
     */
    public Object invoke(Object instance, Object... args) {
        return ReflectionAPI.invokeMethod(clazz.get(), instance, methodName, typeArgs, args);
    }

}
