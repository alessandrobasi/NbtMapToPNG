package it.alessandrobasi.nbt.tag.type;

import it.alessandrobasi.nbt.reader.NBTReader;

public class TagLongArray extends BaseType<long[]> {
    public TagLongArray() {
        super(TagType.TAG_LONG_ARRAY, 4);
    }

    @Override
    protected long[] getPayload(NBTReader reader) {
        int arrSize = BEIntFromByteArray(reader.read(byteSize));

        return BELongArrayFromByteArray(reader.read(arrSize*8));
    }
}
