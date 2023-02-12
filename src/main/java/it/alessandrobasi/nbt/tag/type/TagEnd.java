package it.alessandrobasi.nbt.tag.type;

import it.alessandrobasi.nbt.reader.NBTReader;

public class TagEnd extends BaseType<Void> {
    public TagEnd() {
        super(TagType.TAG_END, 0);
    }

    @Override
    protected Void getPayload(NBTReader reader) {
        return null;
    }
}
