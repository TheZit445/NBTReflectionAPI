package ru.thezit445.nbtreflectionapi.nms;

import org.bukkit.entity.Entity;
import ru.thezit445.nbtreflectionapi.nbt.NBTBase;
import ru.thezit445.nbtreflectionapi.nbt.NBTTagCompound;
import ru.thezit445.nbtreflectionapi.reflection.ClassWrapper;
import ru.thezit445.nbtreflectionapi.util.NMSMethod;

/**
 * <i>Created on 05.04.2020.</i>
 * A stripped down version of NMS Entity.
 * @author Titov Kirill <thezit445@yandex.ru>
 * @version 1.0.0
 */
public class NMSEntity {

    /**
     * NMS version of Entity.
     */
    private Object nms;

    /**
     * Creates a clone of Entity.
     * @param entity - bukkit version.
     */
    public NMSEntity(Entity entity) {
        Object craftEntity = ClassWrapper.CRAFT_ENTITY.get().cast(entity);
        nms = NMSMethod.CRAFT_ENTITY_GET_HANDLE.invoke(craftEntity);
    }

    /**
     * Sets NBTTagCompound for the entity.
     * @param nbt
     */
    public void setNBT(NBTTagCompound nbt) {
        NMSMethod.ENTITY_SET_NBT.invoke(nms, nbt.asNMS());
    }

    /**
     * Gets entity NBTTagCompound.
     * @return NBTTagCompound
     */
    public NBTTagCompound getNBT() {
        NBTTagCompound nbt = new NBTTagCompound();
        Object nmsNbtTagCompound = NMSMethod.ENTITY_GET_NBT.invoke(nms, nbt.asNMS());
        return nbt;
    }

    /**
     * @return Bukkit version of entity.
     */
    public Entity asBukkit() {
        Object craftEntity = NMSMethod.ENTITY_GET_BUKKIT_ENTITY.invoke(nms);
        return (Entity) craftEntity;
    }
}
