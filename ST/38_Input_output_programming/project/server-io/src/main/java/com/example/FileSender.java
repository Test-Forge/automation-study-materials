package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.util.Properties;

public class FileSender {
    private String serverAddress;
    private int port1;
    private int port2;
    private String sourceFile1;
    private String sourceFile2;

    public FileSender() {
        loadProperties();
    }
    public static void createLargeFile(String fileName, long size) {
        try (RandomAccessFile file = new RandomAccessFile(fileName, "rw")) {
            file.setLength(size);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("File " + fileName + " deleted successfully.");
        } else {
            System.out.println("Failed to delete file " + fileName + ".");
        }
    }


    private void loadProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/filesender.properties"));
            serverAddress = properties.getProperty("server.address");
            port1 = Integer.parseInt(properties.getProperty("server.port1"));
            port2 = Integer.parseInt(properties.getProperty("server.port2"));
            sourceFile1 = properties.getProperty("file.source1");
            sourceFile2 = properties.getProperty("file.source2");
        } catch (IOException e) {
            System.err.println("Error loading properties: " + e.getMessage());
            System.exit(1);
        }
    }

    public void sendFiles() {

//        long size = 1024; // 1 KB
//        long size = 1024 * 1024; // 1 MB
            long size = 1024 * 1024 * 1024; // 1 GB
        createLargeFile(sourceFile1, size);

        sendFile(port1, sourceFile1);
        sendFile(port2, sourceFile2);
        deleteFile(sourceFile1);
    }

    private void sendFile(int port, String sourceFile) {
        try (SocketChannel socketChannel = SocketChannel.open(new java.net.InetSocketAddress(serverAddress, port));
             FileChannel fileChannel = FileChannel.open(Paths.get(sourceFile))) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (fileChannel.read(buffer) != -1) {
                buffer.flip();
                socketChannel.write(buffer);
                buffer.clear();
            }
            System.out.println("File " + sourceFile + " sent successfully to port " + port);
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {


        FileSender client = new FileSender();
        client.sendFiles();

    }
}