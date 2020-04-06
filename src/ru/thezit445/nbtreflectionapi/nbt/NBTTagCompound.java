package ru.thezit445.nbtreflectionapi.nbt;

import ru.thezit445.nbtreflectionapi.util.NMSInstance;
import ru.thezit445.nbtreflectionapi.util.NMSMethod;

/**
 * <i>Created on 05.04.2020.</i>
 * A stripped down version of NMS NBTTagCompound.
 * @author Titov Kirill <thezit445@yandex.ru>
 * @see NBTBase
 * @version 1.1.0
 */
public class NBTTagCompound implements NBTBase {

    /**
     * NMS NBTTagCompound field.
     */
    private Object nms;

    /**
     * Constructor with no parameters.
     * Creates an empty NBTTagCompound.
     */
    public NBTTagCompound() {
        nms = NMSInstance.NBT_TAG_COMPOUND.callConstructor();
    }

    /**
     * Creates a clone of NBTTagCompound.
     * @param nmsNbtTagCompound - NMS versiob of NBTTagCompound
     */
    public NBTTagCompound(Object nmsNbtTagCompound) {
        nms = nmsNbtTagCompound;
    }

    /**
     * @return NMS version of NBTBase object.
     */
    @Override
    public Object asNMS() {
        return nms;
    }

    /**
     * @return NBTTagCompound in string form.
     */
    public String asString() {
        return (String) NMSMethod.NBT_TAG_COMPOUND_TO_STRING.invoke(nms);
    }

    /**
     * Sets a value into section.
     * @param section - Name of sub tag.
     * @param value - Integer.
     */
    public void setInt(String section, int value) {
        NMSMethod.NBT_TAG_COMPOUND_SET_INT.invoke(nms, section, value);
    }

    /**
     * Sets a integer array into section.
     * @param section - Name of sub tag.
     * @param array - Integer array.
     */
    public void setIntArray(String section, int[] array) {
        NMSMethod.NBT_TAG_COMPOUND_SET_INT_ARRAY.invoke(nms, section, array);
    }

    /**
     * Sets a value into section.
     * @param section - Name of sub tag.
     * @param value - Short.
     */
    public void setShort(String section, short value) {
        NMSMethod.NBT_TAG_COMPOUND_SET_SHORT.invoke(nms, section, value);
    }

    /**
     * Sets a value into section.
     * @param section - Name of sub tag.
     * @param value - Byte.
     */
    public void setByte(String section, byte value) {
        NMSMethod.NBT_TAG_COMPOUND_SET_BYTE.invoke(nms, section, value);
    }

    /**
     * Sets a byte array into section.
     * @param section - Name of sub tag.
     * @param array - Byte array.
     */
    public void setByteArray(String section, byte[] array) {
        NMSMethod.NBT_TAG_COMPOUND_SET_BYTE_ARRAY.invoke(nms, section, array);
    }

    /**
     * Sets a value into section.
     * @param section - Name of sub tag.
     * @param value - Long.
     */
    public void setLong(String section, long value) {
        NMSMethod.NBT_TAG_COMPOUND_SET_LONG.invoke(nms, section, value);
    }

    /**
     * Sets a value into section.
     * @param section - Name of sub tag.
     * @param value - Boolean.
     */
    public void setBoolean(String section, boolean value) {
        NMSMethod.NBT_TAG_COMPOUND_SET_BOOLEAN.invoke(nms, section, value);
    }

    /**
     * Sets a value into section.
     * @param section - Name of sub tag.
     * @param value - String.
     */
    public void setString(String section, String value) {
        NMSMethod.NBT_TAG_COMPOUND_SET_STRING.invoke(nms, section, value);
    }

    /**
     * Sets a value into section.
     * @param section - Name of sub tag.
     * @param value - Double.
     */
    public void setDouble(String section, double value) {
        NMSMethod.NBT_TAG_COMPOUND_SET_DOUBLE.invoke(nms, section, value);
    }

    /**
     * Sets a value into section.
     * @param section - Name of sub tag.
     * @param value - Float.
     */
    public void setFloat(String section, float value) {
        NMSMethod.NBT_TAG_COMPOUND_SET_FLOAT.invoke(nms, section, value);
    }

    /**
     * Inserts tag into section.
     * @param section - Name of sub tag.
     * @param nbt - Reflection version of NBTTagCompound or {@link NBTTagList}.
     */
    public void set(String section, NBTBase nbt) {
        NMSMethod.NBT_TAG_COMPOUND_SET.invoke(nms, section, nbt.asNMS());
    }

    /**
     * Gets a tag from section.
     * @param section - Name of key.
     * @return NBTTagCompound
     */
    public NBTTagCompound get(String section) {
        Object nmsNbtTagCompound = NMSMethod.NBT_TAG_COMPOUND_GET.invoke(nms, section);
        return new NBTTagCompound(nmsNbtTagCompound);
    }
}
