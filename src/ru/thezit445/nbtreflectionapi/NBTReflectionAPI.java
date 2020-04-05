package ru.thezit445.nbtreflectionapi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.thezit445.nbtreflectionapi.reflection.ClassWrapper;

/**
 * <i>Created on 05.04.2020.</i>
 * A stripped down version of NMS TileEntity.
 * @author Titov Kirill <thezit445@yandex.ru>
 * @version 1.0.0
 */
public class NBTReflectionAPI extends JavaPlugin {

    public static JavaPlugin instance;

    @Override
    public void onLoad() {
        instance = this;
        ClassWrapper.initialize();
    }

    @Override
    public void onEnable() {
        infoMessages();
    }

    @Override
    public void onDisable() {

    }

    public JavaPlugin getInstance() {
        return instance;
    }

    private void infoMessages() {
        String tag = "[NBTReflectionAPI]";
        String[] messages = new String[] {
                tag + " NBT API loaded for minecraft server 1.13.2 - 1.15.2",
                tag + " Dependent plugins by developer:",
                "            - CraftingAPI",
                "            - ExploreMapCreator"
        };
        for (String msg : messages) {
            Bukkit.getLogger().info(msg);
        }
    }

}
