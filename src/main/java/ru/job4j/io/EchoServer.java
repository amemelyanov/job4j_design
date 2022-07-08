package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (in.ready()) {
                        str = in.readLine();
                        String textInput;
                        if (str.contains("msg=")) {
                            textInput = str.split(" ")[1].split("=")[1];
                            if (textInput.equals("Exit")) {
                                out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                                out.write("Завершить работу сервера.".getBytes("WINDOWS-1251"));
                                server.close();
                            } else if (textInput.equals("Hello")) {
                                out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                                out.write("Hello.".getBytes());
                            } else {
                                out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                                out.write(textInput.getBytes());
                            }
                        }
                        System.out.println(str);
                    }
                }
            }
        } catch (IOException e) {
            LOG.error("IOException in EchoServer", e);
        }
    }
}