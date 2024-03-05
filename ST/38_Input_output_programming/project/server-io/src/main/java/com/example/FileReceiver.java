package com.example;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class FileReceiver {
    private int port1;
    private int port2;
    private String destinationFile;
    private ExecutorService executorService;
    private CountDownLatch latch;
    private long startTimeNio, endTimeNio, startTimeIo, endTimeIo;

    public FileReceiver() {
        loadProperties();
        executorService = Executors.newFixedThreadPool(2);
        latch = new CountDownLatch(2);
    }

    private void loadProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/filereceiver.properties"));
            port1 = Integer.parseInt(properties.getProperty("server.port1"));
            port2 = Integer.parseInt(properties.getProperty("server.port2"));
            destinationFile = properties.getProperty("file.destination");
        } catch (IOException e) {
            System.err.println("Error loading properties: " + e.getMessage());
            System.exit(1);
        }
    }

    public void start() {
        executorService.submit(() -> acceptFile(port1, "_nio", true));
        executorService.submit(() -> acceptFile(port2, "_io", false));
        try {
            latch.await();
            System.out.println("Both files received, server is shutting down.");

            long nioTime = endTimeNio - startTimeNio;
            long ioTime = endTimeIo - startTimeIo;
            long fileSize = new File(destinationFile + "_nio").length(); // Assuming both files have the same size
            createAndDisplayChart(nioTime, ioTime, fileSize);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Server interrupted: " + e.getMessage());
        } finally {
            executorService.shutdown();
        }
    }

    private void acceptFile(int port, String suffix, boolean isNio) {
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.bind(new java.net.InetSocketAddress(port));
            System.out.println("Server listening on port " + port);

            try (SocketChannel socketChannel = serverSocketChannel.accept();
                 FileChannel fileChannel = FileChannel.open(Paths.get(destinationFile + suffix), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                long startTime = System.currentTimeMillis();
                while (socketChannel.read(buffer) != -1) {
                    buffer.flip();
                    fileChannel.write(buffer);
                    buffer.clear();
                }
                long endTime = System.currentTimeMillis();
                System.out.println("File received and saved with" + suffix + " in " + (endTime - startTime) + " ms");

                if (isNio) {
                    startTimeNio = startTime;
                    endTimeNio = endTime;
                } else {
                    startTimeIo = startTime;
                    endTimeIo = endTime;
                }
            }
        } catch (IOException e) {
            System.err.println("Server error on port " + port + ": " + e.getMessage());
        } finally {
            latch.countDown();
        }
    }

    public void createAndDisplayChart(long nioTime, long ioTime, long fileSize) {
        String fileName = "chart_" + fileSize+ ".png";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(nioTime, "NIO", "Time (ms)");
        dataset.addValue(ioTime, "IO", "Time (ms)");

        JFreeChart barChart = ChartFactory.createBarChart(
                "File Transfer Performance" + " (" + fileSize + " bytes)",
                "Method",
                "Time (ms)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        try {
            ChartUtils.saveChartAsPNG(new File(fileName), barChart, 560, 367);
            System.out.println("Chart saved as " + fileName + " with file size " + fileSize + " bytes.");
        } catch (IOException e) {
            System.err.println("Error saving chart: " + e.getMessage());
        }

        System.out.println("File size: " + fileSize + " bytes");
    }

    public static void main(String[] args) {
        FileReceiver server = new FileReceiver();
        server.start();
    }
}
