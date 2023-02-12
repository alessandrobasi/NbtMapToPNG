package it.alessandrobasi.nbt.tag.type;

import it.alessandrobasi.nbt.reader.NBTReader;
import lombok.Getter;

public class TagByteArray extends BaseType<byte[]>{
    public TagByteArray() {
        super(TagType.TAG_BYTE_ARRAY, 4);
    }

    @Getter
    private int arrSize;

    @Override
    protected byte[] getPayload(NBTReader reader) {
        arrSize = BEIntFromByteArray(reader.read(byteSize));

        return reader.read(arrSize);
    }
}
