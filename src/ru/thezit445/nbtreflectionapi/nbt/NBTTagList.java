package ru.thezit445.nbtreflectionapi.nbt;

import ru.thezit445.nbtreflectionapi.util.NMSInstance;
import ru.thezit445.nbtreflectionapi.util.NMSMethod;

/**
 * <i>Created on 05.04.2020.</i>
 * A stripped down version of NMS NBTTagList.
 * @author Titov Kirill <thezit445@yandex.ru>
 * @see NBTBase
 * @version 1.0.0
 */
public class NBTTagList implements NBTBase {

    /**
     * NMS NBTTagList field.
     */
    private Object nbt;

    /**
     * Constructor with no parameters.
     * Creates an empty NBTTagList.
     */
    public NBTTagList() {
        nbt = NMSInstance.NBT_TAG_LIST.callConstructor();
    }

    /**
     * Creates a clone of NBTTagList.
     * @param nmsNbtListTag - NMS version of NBTTagList.
     */
    public NBTTagList(Object nmsNbtListTag) {
        nbt = nmsNbtListTag;
    }

    /**
     * Adds NBTBase object to an index location.
     * @param base
     * @param index
     */
    public void add(NBTBase base, int index){
        NMSMethod.NBT_TAG_LIST_ADD.invoke(nbt, index, base.asNMS());
    }

    /**
     * Adds NBTBase object.
     * @param base
     */
    public void add(NBTBase base) {
        add(base, size());
    }

    /**
     * @return size of list.
     */
    public int size() {
        return (int) NMSMethod.NBT_TAG_LIST_SIZE.invoke(nbt);
    }

    /**
     * @return NMS version of NBTBase object.
     */
    @Override
    public Object asNMS() {
        return nbt;
    }

}
