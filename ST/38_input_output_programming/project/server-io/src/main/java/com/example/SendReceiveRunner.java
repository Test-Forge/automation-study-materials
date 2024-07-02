package com.example;

public class SendReceiveRunner {
    public static void main(String[] args) {
        Thread serverThread = new Thread(() -> {
            FileReceiver server = new FileReceiver();
            server.start();
        });

        Thread clientThread = new Thread(() -> {
            // A small delay to ensure that the server is started before the client is launched.
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            FileSender client = new FileSender();
            client.sendFiles();
        });

        serverThread.start();
        clientThread.start();

        try {
            // Waiting for the client and server to finish their work.
            clientThread.join();
            serverThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Client and server have finished their work.");
    }
}
