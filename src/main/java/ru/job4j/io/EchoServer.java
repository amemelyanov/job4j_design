package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (in.ready()) {
                        str = in.readLine();
                        if (str.contains("=") && str.split("=")[1].startsWith("Bye")) {
                            return;
                        }
                        System.out.println(str);
                    }
                    out.write("HTTP/1.1 200 OK\r\n".getBytes());
                }
            }
        }
    }
}