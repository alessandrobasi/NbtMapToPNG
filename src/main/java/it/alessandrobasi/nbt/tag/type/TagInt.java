package it.alessandrobasi.nbt.tag.type;

import it.alessandrobasi.nbt.reader.NBTReader;

public class TagInt extends BaseType<Integer> {
    public TagInt() {
        super(TagType.TAG_INT, 4);
    }

    @Override
    protected Integer getPayload(NBTReader reader) {
        return BEIntFromByteArray(reader.read(byteSize));
    }
}
