package ru.thezit445.nbtreflectionapi.reflection;

import org.bukkit.Bukkit;
import ru.thezit445.nbtreflectionapi.NBTReflectionAPI;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <i>Created on 05.04.2020.</i>
 * Enum with necessary NMS classes.
 * @author Kirill Titov <thezit445@yandex.ru>
 * @version 1.1.0
 */
public enum ClassWrapper {

    BASE_BLOCK_POSITION("net.minecraft.server.%VERSION%.BaseBlockPosition"),
    BLOCK_POSITION("net.minecraft.server.%VERSION%.BlockPosition"),
    WORLD("net.minecraft.server.%VERSION%.World"),
    WORLD_SERVER("net.minecraft.server.%VERSION%.WorldServer"),
    CRAFT_WORLD("org.bukkit.craftbukkit.%VERSION%.CraftWorld"),
    ITEM_STACK("net.minecraft.server.%VERSION%.ItemStack"),
    TILE_ENTITY("net.minecraft.server.%VERSION%.TileEntity"),
    CRAFT_ENTITY("org.bukkit.craftbukkit.%VERSION%.entity.CraftEntity"),
    ENTITY("net.minecraft.server.%VERSION%.Entity"),
    CRAFT_ITEM_STACK("org.bukkit.craftbukkit.%VERSION%.inventory.CraftItemStack"),
    NBT_TAG_COMPOUND("net.minecraft.server.%VERSION%.NBTTagCompound"),
    NBT_BASE("net.minecraft.server.%VERSION%.NBTBase"),
    MOJANGSON_PARSER("net.minecraft.server.%VERSION%.MojangsonParser"),
    NBT_TAG_LIST("net.minecraft.server.%VERSION%.NBTTagList"),
    NBT_COMPRESSED_STREAM_TOOLS("net.minecraft.server.%VERSION%.NBTCompressedStreamTools");

    private static final String versionTag = "%VERSION%";
    private static String nmsPackage = "net.minecraft.server.%VERSION%";

    private String className;
    private Class<?> clazz;

    ClassWrapper(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    /**
     * Gets NMS class.
     * @return Class
     */
    public Class<?> get() {
        return clazz;
    }

    public static String getNMSPackage() {
        return nmsPackage;
    }

    public static void initialize() {
        String version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
        ClassWrapper.nmsPackage = ClassWrapper.nmsPackage.replace(versionTag, version);
        for (ClassWrapper clazzNameNMS : ClassWrapper.values()) {
            clazzNameNMS.className = clazzNameNMS.className.replace(versionTag, version);
            try {
                clazzNameNMS.clazz = Class.forName(clazzNameNMS.className);
            } catch (ClassNotFoundException e) {
                Logger.getLogger(NBTReflectionAPI.class.getName()).log(Level.SEVERE, "Error: ", e);
            }
        }
    }

}
