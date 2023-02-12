package it.alessandrobasi.nbt.tag;

import it.alessandrobasi.nbt.reader.NBTReader;
import it.alessandrobasi.nbt.tag.type.BaseType;
import it.alessandrobasi.nbt.tag.type.TagType;
import lombok.Getter;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Tag {
    @Getter
    private TagType ID;

    @Getter
    private String Name;

    private NBTReader reader;

    @Getter
    private BaseType payload;

    public Tag(NBTReader reader, int id, byte[] uintBeNameLenght){
        this.reader = reader;
        ID = TagType.values()[id];

        int namelenght = ByteBuffer.wrap(uintBeNameLenght).order(ByteOrder.BIG_ENDIAN).asShortBuffer().get();
        Name = new String(reader.read(namelenght));

        getValue();

    }

    /*public Tag(NBTReader reader, TagType idType, String nameTag) {
        ID = idType;
        Name = nameTag;
    }*/

    protected void getValue() {
        try {
            payload = ID.type.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        payload.getValue(reader);
    }

    public String toString() {
        return ""+getName()+": "+getID().toString();
    }


}
