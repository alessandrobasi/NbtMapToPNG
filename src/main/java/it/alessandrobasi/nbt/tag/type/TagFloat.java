package it.alessandrobasi.nbt.tag.type;

import it.alessandrobasi.nbt.reader.NBTReader;

public class TagFloat extends BaseType<Float> {
    public TagFloat() {
        super(TagType.TAG_FLOAT, 4);
    }

    @Override
    protected Float getPayload(NBTReader reader) {
        return BEFloatFromByteArray(reader.read(byteSize));
    }
}
