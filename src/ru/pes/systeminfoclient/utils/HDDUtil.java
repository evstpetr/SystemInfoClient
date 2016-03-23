package ru.pes.systeminfoclient.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
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

        for (File path : paths) {
            if (fsv.getSystemTypeDescription(path).equals("Локальный диск")) {
                free = path.getFreeSpace() / (1024 * 1024 * 1024);
                total = path.getTotalSpace() / (1024 * 1024 * 1024);
                resarr.add(new HardDrive(path.toString(), Files.getFileStore(path.toPath()).type(), String.valueOf(free), String.valueOf(total)));

            }
        }

        return resarr;
    }
}
