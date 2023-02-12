package it.alessandrobasi.nbt.tag.type;

import it.alessandrobasi.nbt.reader.NBTReader;

public class TagLong extends BaseType<Long>{
    public TagLong() {
        super(TagType.TAG_LONG, 8);
    }

    @Override
    protected Long getPayload(NBTReader reader) {
        return BELongFromByteArray(reader.read(byteSize));
    }
}
