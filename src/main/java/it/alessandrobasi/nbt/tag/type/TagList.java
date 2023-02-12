package it.alessandrobasi.nbt.tag.type;

import it.alessandrobasi.nbt.reader.NBTReader;

public class TagList extends BaseType<BaseType[]>{
    public TagList() {
        super(TagType.TAG_LIST, 1);
    }

    @Override
    protected BaseType[] getPayload(NBTReader reader) {

        int tagId = reader.read(1)[0];
        int arrSize = BEIntFromByteArray(reader.read(4));

        int bytesize = TagType.values()[tagId].byteSize;


        // TODO implement

        return null;


    }
}
