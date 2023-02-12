package it.alessandrobasi.nbt.tag.type;

import it.alessandrobasi.nbt.reader.NBTReader;

public class TagIntArray extends BaseType<int[]> {
    public TagIntArray() {
        super(TagType.TAG_INT_ARRAY, 4);
    }

    @Override
    protected int[] getPayload(NBTReader reader) {
        int arrSize = BEIntFromByteArray(reader.read(byteSize));
        return BEIntArrayFromByteArray(reader.read(arrSize*4));


    }
}
