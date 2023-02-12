package it.alessandrobasi.nbt.reader;

import it.alessandrobasi.nbt.tag.Tag;

import java.io.FileInputStream;
import java.util.zip.GZIPInputStream;

public class NBTReader {

    private String filename;
    byte[] filecontent = null;
    int fileIndex = 0;
    int fileLenght;

    public NBTReader(String filename) {
        this.filename = filename;
        FileInputStream f;
        GZIPInputStream q;
        try {
            f = new FileInputStream(filename);
            q = new GZIPInputStream(f);
            filecontent = q.readAllBytes();
        }
        catch (Exception e) {
            throw new IllegalStateException("Error opening file");
        }

        fileLenght = filecontent.length;

    }
    public byte[] readall() {
        return filecontent;
    }

    public byte[] read(int ammount) {
        byte[] result = new byte[ammount];

        for (int i = 0; i < ammount && fileIndex+i < fileLenght; i++) {
            result[i] = filecontent[fileIndex+i];
        }

        fileIndex += ammount;

        return result;
    }


    public Tag readtagID() {

        byte tagid = read(1)[0];
        int id = Byte.toUnsignedInt(tagid);

        byte[] uintBeNameLenght = read(2);
        return new Tag(this, id, uintBeNameLenght);
    }

}
