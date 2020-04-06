package ru.thezit445.nbtreflectionapi.nms;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import ru.thezit445.nbtreflectionapi.nbt.NBTTagCompound;
import ru.thezit445.nbtreflectionapi.reflection.ClassWrapper;
import ru.thezit445.nbtreflectionapi.util.NMSInstance;
import ru.thezit445.nbtreflectionapi.util.NMSMethod;

/**
 * <i>Created on 05.04.2020.</i>
 * A stripped down version of NMS TileEntity.
 * @author Titov Kirill <thezit445@yandex.ru>
 * @version 1.1.0
 */
public class NMSTileEntity {

    /**
     * NMS version of TileEntity.
     */
    private Object nms;

    /**
     * Returns a clone if block on this location is TileEntity, else returns null.
     * @param location
     */
    public NMSTileEntity(Location location) {
        Block block = location.getBlock();
        if (!(block.getState().getClass().getName().endsWith("CraftBlockState"))) {
            Object craftWorld = ClassWrapper.CRAFT_WORLD.get().cast(location.getWorld());
            Object worldServer = NMSMethod.CRAFT_WORLD_GET_HANDLE.invoke(craftWorld);
            Object blockPosition = NMSInstance.BLOCK_POSITION.callConstructor(location.getBlockX(), location.getBlockY(), location.getBlockZ());
            nms = NMSMethod.WORLD_GET_TILE_ENTITY.invoke(worldServer, blockPosition);
        } else {
            nms = null;
        }
    }

    /**
     * Gets tile entity NBTTagCompound.
     * @return NBTTagCompound
     */
    public NBTTagCompound getNBT() {
        NBTTagCompound nbt = new NBTTagCompound();
        if (nms == null) return nbt;
        NMSMethod.TILE_ENTITY_GET_NBT.invoke(nms, nbt.asNMS());
        return nbt;
    }

    /**
     * Sets NBTTagCompound for the tile entity.
     * @param nbt
     */
    public void setNBT(NBTTagCompound nbt) {
        NMSMethod.TILE_ENTITY_SET_NBT.invoke(nms, nbt.asNMS());
    }

    /**
     * Updates tile entity data.
     */
    public void update(){
        NMSMethod.TILE_ENTITY_UPDATE.invoke(nms);
    }

    /**
     * Converts TileEntity to bukkit BlockState.
     * @return BlockState
     */
    public BlockState toBukkit() {
        Object position = NMSMethod.TILE_ENTITY_GET_POSITION.invoke(nms);
        int x = (int) NMSMethod.BASE_BLOCK_POSITION_GET_X.invoke(position);
        int y = (int) NMSMethod.BASE_BLOCK_POSITION_GET_Y.invoke(position);
        int z = (int) NMSMethod.BASE_BLOCK_POSITION_GET_Z.invoke(position);
        Object worldServer = NMSMethod.TILE_ENTITY_GET_WORLD.invoke(nms);
        World world = (World) NMSMethod.WORLD_GET_WORLD.invoke(worldServer);
        Location location = new Location(world, x,y,z);
        return location.getBlock().getState();
    }

}
