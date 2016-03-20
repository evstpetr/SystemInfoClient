package ru.pes.systeminfoclient.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import javax.swing.filechooser.FileSystemView;
import ru.pes.systeminfoclient.objects.HardDrive;


public class HDDUtil {

    public static ArrayList<HardDrive> getHDDs() throws IOException {
        ArrayList<HardDrive> resarr = new ArrayList<>();
        HardDrive hdd;
        File[] paths;
        FileSystemView fsv = FileSystemView.getFileSystemView();
        paths = File.listRoots();
        long free, total;
        int i = 0;
        for (FileStore fs : FileSystems.getDefault().getFileStores()) {
            if (fsv.getSystemTypeDescription(paths[i]).equals("Локальный диск")) {
                free = fs.getUsableSpace() / (1024 * 1024 * 1024);
                total = fs.getTotalSpace() / (1024 * 1024 * 1024);
                resarr.add(new HardDrive(paths[i].toString(), fs.type(), String.valueOf(free), String.valueOf(total)));

            }

            i++;

        }

        return resarr;
    }
}
