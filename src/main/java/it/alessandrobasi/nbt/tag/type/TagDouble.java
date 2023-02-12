package it.alessandrobasi.nbt.tag.type;

import it.alessandrobasi.nbt.reader.NBTReader;

public class TagDouble extends BaseType<Double> {
    public TagDouble() {
        super(TagType.TAG_DOUBLE, 8);
    }

    @Override
    protected Double getPayload(NBTReader reader) {
        return BEDoubleFromByteArray(reader.read(byteSize));
    }
}
