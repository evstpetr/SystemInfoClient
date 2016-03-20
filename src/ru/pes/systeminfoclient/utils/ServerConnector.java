package ru.pes.systeminfoclient.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.swing.JTextArea;
import org.apache.log4j.Logger;

public class ServerConnector implements Runnable {

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private final int PORT = 8080;
    private final String HOST = "109.123.160.7";
    private final SystemInformationUtil SI;
    private final SoftInformationUtil SOFT;
    private final JTextArea JTA;
    private static final Logger logger = Logger.getLogger(ServerConnector.class);

    public ServerConnector(SystemInformationUtil si, SoftInformationUtil soft, JTextArea JTA) {
        this.SI = si;
        this.SOFT = soft;
        this.JTA = JTA;
    }

    @Override
    public void run() {
        logger.info("Start sending to server...");
        String line;
        listenSocket();
        
        out.println(createSystemInformationJSON());
        out.println(createSoftInformationJSON());

        try {
            line = in.readLine();
            if (line.equals("0")) {
                JTA.append("\nСервер: OK!");
            } else {
                JTA.append("\nСервер: NOT OK!");
            }
        } catch (IOException e) {
            logger.error("Can't read...", e);

            if (out != null) {
                out.close();
            }

            System.exit(1);
        }
        closeConnection();
        logger.info("End sending to server...");
    }

    // Пытаемся открыть сокет и создать входящий/исходящий поток
    private void listenSocket() {
        try {
            socket = new Socket(HOST, PORT);
        } catch (IOException ex) {
            logger.error("Can't create Socket...", ex);
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ex1) {
                    logger.error("Can't close Socket...", ex1);
                }
            }
        }
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException ex) {
            logger.error("Can't create OutputStream...", ex);
            if (out != null) {
                out.close();
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ex1) {
                    logger.error("Can't close Socket...", ex1);
                }
            }

            System.exit(1);
        }
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            logger.error("Can't create InputStream...", ex);
            if (out != null) {
                out.close();
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ex1) {
                    logger.error("Can't close Socket...", ex1);
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex1) {
                    logger.error("Can't close InputStream...", ex);
                }
            }

            System.exit(1);
        }
    }

    // Заканчиваем обмен с сервером
    private void closeConnection() {
        try {
            out.println("off");
            out.close();
            in.close();
            socket.close();
        } catch (IOException ex) {
            logger.error("Can't close Connection...", ex);
        }
    }

    // Формируем сообщение серверу, prefix - sys
    private String createSystemInformationJSON() {
        String res;
        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder()
                .add("loc", SI.getLOCATION())
                .add("dep", SI.getDEPARTMENT())
                .add("os_name", SI.getOsName())
                .add("arch", SI.getArch())
                .add("mb_vendor", SI.getMotherBoardVendor())
                .add("mb_name", SI.getMotherBoardName())
                .add("cpu_vendor", SI.getCpuVendor())
                .add("cpu_model", SI.getCpuModel())
                .add("cores", SI.getCpuCores())
                .add("frequency", SI.getCpuMhz())
                .add("ram", SI.getRam())
                .add("ip", SI.getIpAddr())
                .add("mac", SI.getMacAddr())
                .add("name", SI.getPcName())
                .add("inv_n", SI.getInventoryNumber());
        JsonArrayBuilder jsonHDDs = Json.createArrayBuilder();
        SI.getHDDs().stream().forEach((hdd) -> {
            jsonHDDs.add(hdd);
        });

        jsonBuilder.add("hdds", jsonHDDs.build());
        JsonObject json = jsonBuilder.build();

        logger.info(json.toString());
        res = "sys" + json.toString();
        return res;
    }

    // Формируем сообщение серверу, prefix - soft
    private String createSoftInformationJSON() {
        String res;
        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
        JsonArrayBuilder jsonHDDs = Json.createArrayBuilder();
        JsonArrayBuilder jsonSOFT = Json.createArrayBuilder();
        JsonArrayBuilder jsonSOFT86 = Json.createArrayBuilder();
        SOFT.getSoft().getSoft().stream().forEach((soft) -> {
            jsonSOFT.add(soft);
        });

        if (SOFT.getSoft().getSoft86() != null) {
            SOFT.getSoft().getSoft86().stream().forEach((soft) -> {
                jsonSOFT86.add(soft);
            });
            jsonBuilder.add("soft86", jsonSOFT86.build());
        } else {
            jsonSOFT86.add("null");
            jsonBuilder.add("soft86", jsonSOFT86.build());
        }

        jsonBuilder.add("soft", jsonSOFT.build());
        JsonObject json = jsonBuilder.build();
        logger.info(json.toString());
        res = "soft" + json.toString();
        return res;
    }

}
