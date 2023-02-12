package it.alessandrobasi;

import it.alessandrobasi.nbt.reader.NBTReader;
import it.alessandrobasi.nbt.tag.Tag;
import it.alessandrobasi.nbt.tag.type.TagByteArray;
import it.alessandrobasi.nbt.tag.type.TagCompound;
import it.alessandrobasi.nbt.tag.type.TagShort;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import java.util.List;

public class Main {

    private static String filename = "map_177.nbt";

    public static void main(String[] args) {

        NBTReader filenbt;

        if(Objects.equals(args[0], "") || Objects.equals(args[0], null)) {
            filenbt = new NBTReader(filename);
        }
        else {
            filenbt = new NBTReader(args[0]);
        }


        // root
        Tag root = filenbt.readtagID();
        TagCompound rootPayload = (TagCompound) root.getPayload();
        HashMap<String, Tag> rootTags = rootPayload.getValue();

        // data
        TagCompound dataPayload = (TagCompound) rootTags.get("data").getPayload();

        // width * height
        TagShort width = (TagShort) dataPayload.getValue().get("width").getPayload();
        int widthValue = width.getValue();
        TagShort height = (TagShort) dataPayload.getValue().get("height").getPayload();
        int heightValue = height.getValue();

        // colors
        TagByteArray colors = (TagByteArray) dataPayload.getValue().get("colors").getPayload();

        assert colors.getArrSize() == width.getValue() * height.getValue();

        ArrayList<Integer> lb = new ArrayList<>();

        for(Byte b : colors.getValue()) {
            lb.add(Byte.toUnsignedInt(b));
        }

        List<Color> canvas = lb.stream().map(colorTable::get).toList();

        BufferedImage img = new BufferedImage(widthValue, heightValue, BufferedImage.TYPE_INT_ARGB);

        for(int y=0; y<heightValue; y++) {
            for(int x = 0; x < widthValue; x++) {

                int p = (canvas.get(x + y * heightValue).getAlpha()<<24) | canvas.get(x + y * heightValue).getRGB();
                img.setRGB(x, y, p);
            }
        }

        try {
            ImageIO.write(img, "PNG", new File(args[0]+"_map.png"));
        }
        catch(Exception error) {
            error.printStackTrace();
        }

    }

    private static final HashMap<Integer, Color> colorTable = new HashMap<>() {{
        put(0, new Color(0, 0, 0, 0));
        put(1, new Color(0, 0, 0, 0));
        put(2, new Color(0, 0, 0, 0));
        put(3, new Color(0, 0, 0, 0));
        put(4, new Color(89, 125, 39, 255));
        put(5, new Color(109, 153, 48, 255));
        put(6, new Color(127, 178, 56, 255));
        put(7, new Color(67, 94, 29, 255));
        put(8, new Color(174, 164, 115, 255));
        put(9, new Color(213, 201, 140, 255));
        put(10, new Color(247, 233, 163, 255));
        put(11, new Color(130, 123, 86, 255));
        put(12, new Color(140, 140, 140, 255));
        put(13, new Color(171, 171, 171, 255));
        put(14, new Color(199, 199, 199, 255));
        put(15, new Color(105, 105, 105, 255));
        put(16, new Color(180, 0, 0, 255));
        put(17, new Color(220, 0, 0, 255));
        put(18, new Color(255, 0, 0, 255));
        put(19, new Color(135, 0, 0, 255));
        put(20, new Color(112, 112, 180, 255));
        put(21, new Color(138, 138, 220, 255));
        put(22, new Color(160, 160, 255, 255));
        put(23, new Color(84, 84, 135, 255));
        put(24, new Color(117, 117, 117, 255));
        put(25, new Color(144, 144, 144, 255));
        put(26, new Color(167, 167, 167, 255));
        put(27, new Color(88, 88, 88, 255));
        put(28, new Color(0, 87, 0, 255));
        put(29, new Color(0, 106, 0, 255));
        put(30, new Color(0, 124, 0, 255));
        put(31, new Color(0, 65, 0, 255));
        put(32, new Color(180, 180, 180, 255));
        put(33, new Color(220, 220, 220, 255));
        put(34, new Color(255, 255, 255, 255));
        put(35, new Color(135, 135, 135, 255));
        put(36, new Color(115, 118, 129, 255));
        put(37, new Color(141, 144, 158, 255));
        put(38, new Color(164, 168, 184, 255));
        put(39, new Color(86, 88, 97, 255));
        put(40, new Color(106, 76, 54, 255));
        put(41, new Color(130, 94, 66, 255));
        put(42, new Color(151, 109, 77, 255));
        put(43, new Color(79, 57, 40, 255));
        put(44, new Color(79, 79, 79, 255));
        put(45, new Color(96, 96, 96, 255));
        put(46, new Color(112, 112, 112, 255));
        put(47, new Color(59, 59, 59, 255));
        put(48, new Color(45, 45, 180, 255));
        put(49, new Color(55, 55, 220, 255));
        put(50, new Color(64, 64, 255, 255));
        put(51, new Color(33, 33, 135, 255));
        put(52, new Color(100, 84, 50, 255));
        put(53, new Color(123, 102, 62, 255));
        put(54, new Color(143, 119, 72, 255));
        put(55, new Color(75, 63, 38, 255));
        put(56, new Color(180, 177, 172, 255));
        put(57, new Color(220, 217, 211, 255));
        put(58, new Color(255, 252, 245, 255));
        put(59, new Color(135, 133, 129, 255));
        put(60, new Color(152, 89, 36, 255));
        put(61, new Color(186, 109, 44, 255));
        put(62, new Color(216, 127, 51, 255));
        put(63, new Color(114, 67, 27, 255));
        put(64, new Color(125, 53, 152, 255));
        put(65, new Color(153, 65, 186, 255));
        put(66, new Color(178, 76, 216, 255));
        put(67, new Color(94, 40, 114, 255));
        put(68, new Color(72, 108, 152, 255));
        put(69, new Color(88, 132, 186, 255));
        put(70, new Color(102, 153, 216, 255));
        put(71, new Color(54, 81, 114, 255));
        put(72, new Color(161, 161, 36, 255));
        put(73, new Color(197, 197, 44, 255));
        put(74, new Color(229, 229, 51, 255));
        put(75, new Color(121, 121, 27, 255));
        put(76, new Color(89, 144, 17, 255));
        put(77, new Color(109, 176, 21, 255));
        put(78, new Color(127, 204, 25, 255));
        put(79, new Color(67, 108, 13, 255));
        put(80, new Color(170, 89, 116, 255));
        put(81, new Color(208, 109, 142, 255));
        put(82, new Color(242, 127, 165, 255));
        put(83, new Color(128, 67, 87, 255));
        put(84, new Color(53, 53, 53, 255));
        put(85, new Color(65, 65, 65, 255));
        put(86, new Color(76, 76, 76, 255));
        put(87, new Color(40, 40, 40, 255));
        put(88, new Color(108, 108, 108, 255));
        put(89, new Color(132, 132, 132, 255));
        put(90, new Color(153, 153, 153, 255));
        put(91, new Color(81, 81, 81, 255));
        put(92, new Color(53, 89, 108, 255));
        put(93, new Color(65, 109, 132, 255));
        put(94, new Color(76, 127, 153, 255));
        put(95, new Color(40, 67, 81, 255));
        put(96, new Color(89, 44, 125, 255));
        put(97, new Color(109, 54, 153, 255));
        put(98, new Color(127, 63, 178, 255));
        put(99, new Color(67, 33, 94, 255));
        put(100, new Color(36, 53, 125, 255));
        put(101, new Color(44, 65, 153, 255));
        put(102, new Color(51, 76, 178, 255));
        put(103, new Color(27, 40, 94, 255));
        put(104, new Color(72, 53, 36, 255));
        put(105, new Color(88, 65, 44, 255));
        put(106, new Color(102, 76, 51, 255));
        put(107, new Color(54, 40, 27, 255));
        put(108, new Color(72, 89, 36, 255));
        put(109, new Color(88, 109, 44, 255));
        put(110, new Color(102, 127, 51, 255));
        put(111, new Color(54, 67, 27, 255));
        put(112, new Color(108, 36, 36, 255));
        put(113, new Color(132, 44, 44, 255));
        put(114, new Color(153, 51, 51, 255));
        put(115, new Color(81, 27, 27, 255));
        put(116, new Color(17, 17, 17, 255));
        put(117, new Color(21, 21, 21, 255));
        put(118, new Color(25, 25, 25, 255));
        put(119, new Color(13, 13, 13, 255));
        put(120, new Color(176, 168, 54, 255));
        put(121, new Color(215, 205, 66, 255));
        put(122, new Color(250, 238, 77, 255));
        put(123, new Color(132, 126, 40, 255));
        put(124, new Color(64, 154, 150, 255));
        put(125, new Color(79, 188, 183, 255));
        put(126, new Color(92, 219, 213, 255));
        put(127, new Color(48, 115, 112, 255));
        put(128, new Color(52, 90, 180, 255));
        put(129, new Color(63, 110, 220, 255));
        put(130, new Color(74, 128, 255, 255));
        put(131, new Color(39, 67, 135, 255));
        put(132, new Color(0, 153, 40, 255));
        put(133, new Color(0, 187, 50, 255));
        put(134, new Color(0, 217, 58, 255));
        put(135, new Color(0, 114, 30, 255));
        put(136, new Color(91, 60, 34, 255));
        put(137, new Color(111, 74, 42, 255));
        put(138, new Color(129, 86, 49, 255));
        put(139, new Color(68, 45, 25, 255));
        put(140, new Color(79, 1, 0, 255));
        put(141, new Color(96, 1, 0, 255));
        put(142, new Color(112, 2, 0, 255));
        put(143, new Color(59, 1, 0, 255));
        put(144, new Color(147, 124, 113, 255));
        put(145, new Color(180, 152, 138, 255));
        put(146, new Color(209, 177, 161, 255));
        put(147, new Color(110, 93, 85, 255));
        put(148, new Color(112, 57, 25, 255));
        put(149, new Color(137, 70, 31, 255));
        put(150, new Color(159, 82, 36, 255));
        put(151, new Color(84, 43, 19, 255));
        put(152, new Color(105, 61, 76, 255));
        put(153, new Color(128, 75, 93, 255));
        put(154, new Color(149, 87, 108, 255));
        put(155, new Color(78, 46, 57, 255));
        put(156, new Color(79, 76, 97, 255));
        put(157, new Color(96, 93, 119, 255));
        put(158, new Color(112, 108, 138, 255));
        put(159, new Color(59, 57, 73, 255));
        put(160, new Color(131, 93, 25, 255));
        put(161, new Color(160, 114, 31, 255));
        put(162, new Color(186, 133, 36, 255));
        put(163, new Color(98, 70, 19, 255));
        put(164, new Color(72, 82, 37, 255));
        put(165, new Color(88, 100, 45, 255));
        put(166, new Color(103, 117, 53, 255));
        put(167, new Color(54, 61, 28, 255));
        put(168, new Color(112, 54, 55, 255));
        put(169, new Color(138, 66, 67, 255));
        put(170, new Color(160, 77, 78, 255));
        put(171, new Color(84, 40, 41, 255));
        put(172, new Color(40, 28, 24, 255));
        put(173, new Color(49, 35, 30, 255));
        put(174, new Color(57, 41, 35, 255));
        put(175, new Color(30, 21, 18, 255));
        put(176, new Color(95, 75, 69, 255));
        put(177, new Color(116, 92, 84, 255));
        put(178, new Color(135, 107, 98, 255));
        put(179, new Color(71, 56, 51, 255));
        put(180, new Color(61, 64, 64, 255));
        put(181, new Color(75, 79, 79, 255));
        put(182, new Color(87, 92, 92, 255));
        put(183, new Color(46, 48, 48, 255));
        put(184, new Color(86, 51, 62, 255));
        put(185, new Color(105, 62, 75, 255));
        put(186, new Color(122, 73, 88, 255));
        put(187, new Color(64, 38, 46, 255));
        put(188, new Color(53, 43, 64, 255));
        put(189, new Color(65, 53, 79, 255));
        put(190, new Color(76, 62, 92, 255));
        put(191, new Color(40, 32, 48, 255));
        put(192, new Color(53, 35, 24, 255));
        put(193, new Color(65, 43, 30, 255));
        put(194, new Color(76, 50, 35, 255));
        put(195, new Color(40, 26, 18, 255));
        put(196, new Color(53, 57, 29, 255));
        put(197, new Color(65, 70, 36, 255));
        put(198, new Color(76, 82, 42, 255));
        put(199, new Color(40, 43, 22, 255));
        put(200, new Color(100, 42, 32, 255));
        put(201, new Color(122, 51, 39, 255));
        put(202, new Color(142, 60, 46, 255));
        put(203, new Color(75, 31, 24, 255));
        put(204, new Color(26, 15, 11, 255));
        put(205, new Color(31, 18, 13, 255));
        put(206, new Color(37, 22, 16, 255));
        put(207, new Color(19, 11, 8, 255));


    }};
}