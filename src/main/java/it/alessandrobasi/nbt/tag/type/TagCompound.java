package it.alessandrobasi.nbt.tag.type;

import it.alessandrobasi.nbt.reader.NBTReader;
import it.alessandrobasi.nbt.tag.Tag;

import java.util.HashMap;

public class TagCompound extends BaseType<HashMap<String, Tag>>{
    public TagCompound() {
        super(TagType.TAG_COMPOUNT, 0);
    }

    @Override
    public HashMap<String, Tag> getPayload(NBTReader reader) {

        HashMap<String, Tag> tags = new HashMap<>();
        boolean isend = false;

        while (!isend) {

            Tag elem = reader.readtagID();
            if(elem.getID() == TagType.TAG_END)
                isend = true;

            tags.put(elem.getName(), elem);
        }
        return tags;
    }
}
