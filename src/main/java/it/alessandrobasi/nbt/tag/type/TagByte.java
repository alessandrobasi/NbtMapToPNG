package it.alessandrobasi.nbt.tag.type;

import it.alessandrobasi.nbt.reader.NBTReader;

public class TagByte extends BaseType<Byte>{
    public TagByte() {
        super(TagType.TAG_BYTE, 1);
    }

    @Override
    protected Byte getPayload(NBTReader reader) {
        return reader.read(byteSize)[0];
    }
}
