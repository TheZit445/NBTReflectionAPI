package ru.thezit445.nbtreflectionapi.util;

import ru.thezit445.nbtreflectionapi.nbt.NBTTagCompound;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * <i>Created on 05.04.2020.</i>
 * API part for work with streams and parsing nbt.
 * @author Titov Kirill <thezit445@yandex.ru>
 * @version 1.0.0
 */
public final class NBTUtils {

    /**
     * Parses string to NBTTagCompound.
     * @param tag
     * @return NBTTagCompound
     */
    public static NBTTagCompound parse(String tag) {
        Object nmsNbtTag = NMSMethod.MOJANGSON_PARSER_PARSE.invoke(null, tag);
        return new NBTTagCompound(nmsNbtTag);
    }

    /**
     * Writes NBTTagCompound to file in compressed form.
     * @param stream
     */
    public static void write(OutputStream stream) {
        NMSMethod.NBT_COMPRESSED_STREAM_TOOLS_WRITE_COMPRESSED.invoke(null, stream);
    }

    /**
     * Reads NBTTagCompound from file.
     * @param stream
     * @return NBTTagCompound
     */
    public static NBTTagCompound read(InputStream stream) {
        Object nmsNbtTag = NMSMethod.NBT_COMPRESSED_STREAM_TOOLS_READ_COMPRESSED.invoke(null, stream);
        return new NBTTagCompound(nmsNbtTag);
    }

}
