package it.alessandrobasi.nbt.tag.type;

import it.alessandrobasi.nbt.reader.NBTReader;

public class TagString extends BaseType<String>{
    public TagString() {
        super(TagType.TAG_STRING, 2);
    }

    @Override
    protected String getPayload(NBTReader reader) {
        int stringSize = Short.toUnsignedInt(BEShortFromByteArray(reader.read(byteSize)));
        byte[] rawString = reader.read(stringSize*2);

        return new String(rawString);
    }
}
