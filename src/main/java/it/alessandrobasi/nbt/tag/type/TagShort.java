package it.alessandrobasi.nbt.tag.type;

import it.alessandrobasi.nbt.reader.NBTReader;

public class TagShort extends BaseType<Short>{
    public TagShort() {
        super(TagType.TAG_SHORT, 2);
    }

    @Override
    protected Short getPayload(NBTReader reader) {
        return BEShortFromByteArray(reader.read(byteSize));
    }
}
