package ru.thezit445.nbtreflectionapi.nms;

import org.bukkit.inventory.ItemStack;
import ru.thezit445.nbtreflectionapi.nbt.NBTTagCompound;
import ru.thezit445.nbtreflectionapi.util.NMSMethod;

/**
 * <i>Created on 05.04.2020.</i>
 * A stripped down version of NMS Item.
 * @author Titov Kirill <thezit445@yandex.ru>
 * @version 1.0.0
 */
public class NMSItem {

    /**
     * NMS version of ItemStack.
     */
    private Object nms;

    /**
     * Creates a clone of ItemStack.
     * @param item - bukkit version.
     */
    public NMSItem(ItemStack item) {
        nms = NMSMethod.CRAFT_ITEM_STACK_AS_NMS_COPY.invoke(null, item);
    }

    /**
     * Creates a clone of NMS ItemStack.
     * @param nmsItem - NMS version.
     */
    public NMSItem(Object nmsItem) {
        nms = nmsItem;
    }

    /**
     * Creates a clone from NBTTagCompound version.
     * @param nbt
     */
    public NMSItem(NBTTagCompound nbt) {
        nms = NMSMethod.ITEM_STACK_GET_FROM_NBT.invoke(null, nbt);
    }

    /**
     * Sets NBTTagCompound for the item.
     * @param nbt
     */
    public void setNBT(NBTTagCompound nbt) {
        NMSMethod.ITEM_STACK_SET_NBT_TAG_COMPOUND.invoke(nms, nbt.asNMS());
    }

    /**
     * Gets item NBTTagCompound.
     * @return NBTTagCompound
     */
    public NBTTagCompound getNBT() {
        NBTTagCompound nmsNbtTagCompound = new NBTTagCompound();
        NMSMethod.ITEM_STACK_GET_NBT.invoke(nms, nmsNbtTagCompound.asNMS());
        return nmsNbtTagCompound;
    }

    /**
     * @return Bukkit version of item.
     */
    public ItemStack asBukkit() {
        ItemStack stack = (ItemStack) NMSMethod.CRAFT_ITEM_STACK_AS_BUKKIT_COPY.invoke(null, nms);
        return stack;
    }

}
