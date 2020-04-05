package ru.thezit445.nbtreflectionapi.nbt;

/**
 * <i>Created on 05.04.2020.</i>
 * Interface for grouping {@link NBTTagCompound} and {@link NBTTagList}.
 * @author Titov Kirill <thezit445@yandex.ru>
 * @version 1.0.0
 */
public interface NBTBase {

    /**
     * @return NMS version of NBTBase object.
     */
    Object asNMS();

}
