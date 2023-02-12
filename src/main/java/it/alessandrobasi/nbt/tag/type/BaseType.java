package it.alessandrobasi.nbt.tag.type;

import it.alessandrobasi.nbt.reader.NBTReader;
import lombok.Getter;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class BaseType<T> {
    @Getter
    protected TagType tagType;

    protected int byteSize;

    @Getter
    protected T value;

    protected BaseType(TagType type, int size) {
        tagType = type;
        byteSize = size;
    }

    public String toString() {
        return ""+tagType.name()+": "+value;
    }


    protected abstract T getPayload(NBTReader reader);

    public void getValue(NBTReader reader) {
        value = getPayload(reader);
    }


    protected int BEIntFromByteArray(byte[] bytes) {
        /*int res = 0;
        if (bytes == null)
            return res;
        // big endian
        for (int i = bytes.length-1; i >= 0; i--) {
            res = (res *10) + ((bytes[i] & 0xff));
        }
        return res;*/

        return ByteBuffer.wrap(bytes)
            .order(ByteOrder.BIG_ENDIAN)
            .asIntBuffer()
            .get();
    }

    protected short BEShortFromByteArray(byte[] bytes) {
        return ByteBuffer.wrap(bytes)
            .order(ByteOrder.BIG_ENDIAN)
            .asShortBuffer()
            .get();
    }

    protected long BELongFromByteArray(byte[] bytes) {
        return ByteBuffer.wrap(bytes)
            .order(ByteOrder.BIG_ENDIAN)
            .asLongBuffer()
            .get();
    }

    protected double BEDoubleFromByteArray(byte[] bytes) {

        return ByteBuffer.wrap(bytes)
            .order(ByteOrder.BIG_ENDIAN)
            .asDoubleBuffer()
            .get();
    }

    protected float BEFloatFromByteArray(byte[] bytes) {

        return ByteBuffer.wrap(bytes)
            .order(ByteOrder.BIG_ENDIAN)
            .asFloatBuffer()
            .get();
    }

    protected int[] BEIntArrayFromByteArray(byte[] bytes) {
        return ByteBuffer.wrap(bytes)
            .order(ByteOrder.BIG_ENDIAN)
            .asIntBuffer()
            .array();
    }

    protected long[] BELongArrayFromByteArray(byte[] bytes) {
        return ByteBuffer.wrap(bytes)
            .order(ByteOrder.BIG_ENDIAN)
            .asLongBuffer()
            .array();
    }

}
