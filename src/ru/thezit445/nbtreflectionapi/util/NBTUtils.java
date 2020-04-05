package ru.thezit445.nbtreflectionapi.util;

import ru.thezit445.nbtreflectionapi.nbt.NBTTagCompound;

import java.io.InputStream;
import java.io.OutputStream;

public final class NBTUtils {

    public static NBTTagCompound parse(String tag) {
        Object nmsNbtTag = NMSMethod.MOJANGSON_PARSER_PARSE.invoke(null, tag);
        return new NBTTagCompound(nmsNbtTag);
    }

    public static void write(OutputStream stream) {
        NMSMethod.NBT_COMPRESSED_STREAM_TOOLS_WRITE_COMPRESSED.invoke(null, stream);
    }

    public static NBTTagCompound read(InputStream stream) {
        Object nmsNbtTag = NMSMethod.NBT_COMPRESSED_STREAM_TOOLS_READ_COMPRESSED.invoke(null, stream);
        return new NBTTagCompound(nmsNbtTag);
    }

}
