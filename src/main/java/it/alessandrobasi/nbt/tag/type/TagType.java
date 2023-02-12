package it.alessandrobasi.nbt.tag.type;

import it.alessandrobasi.nbt.tag.Tag;

public enum TagType {
    TAG_END(TagEnd.class, Void.class, 0), // 0
    TAG_BYTE(TagByte.class, byte.class, 1), // 1
    TAG_SHORT(TagShort.class, short.class, 2), // 2
    TAG_INT(TagInt.class, int.class, 4), // 3
    TAG_LONG(TagLong.class, long.class, 8), // 4
    TAG_FLOAT(TagFloat.class, float.class, 4), // 5
    TAG_DOUBLE(TagDouble.class, double.class, 8), // 6
    TAG_BYTE_ARRAY(TagByteArray.class, byte[].class, 4), // 7
    TAG_STRING(TagString.class, String.class, 2), // 8
    TAG_LIST(TagList.class, BaseType[].class, 1), // 9
    TAG_COMPOUNT(TagCompound.class, Tag[].class, 0), // 10
    TAG_INT_ARRAY(TagIntArray.class, int[].class, 4), // 11
    TAG_LONG_ARRAY(TagLongArray.class, long[].class, 4); // 12

    public final Class<? extends BaseType> type;
    public final Class<?> conversionType;

    public final int byteSize;
    TagType(Class<? extends BaseType> type, Class<?> conversionType, int byteSize) {
        this.type = type;
        this.conversionType = conversionType;
        this.byteSize = byteSize;
    }

}
