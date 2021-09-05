package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class WebEchoServer {
    public static void main(String[] args) throws IOException {
        boolean online = true;
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String msg = null;
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        System.out.println(str);
                        if (str.contains("msg")) {
                            msg = str;
                        }
                    }
                    if (msg != null) {
                        if (msg.contains("Hello")) {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write("Hello, dear friend.".getBytes());
                        } else if (msg.contains("Exit")) {
                            out.write("HTTP/1.1 510 SERVER OFFLINE\r\n\r\n".getBytes());
                            online = false;
                        } else {
                            String[] msgs = msg.split("msg=");
                            msgs = msgs[1].split(" ");
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write(msgs[0].getBytes());
                        }
                        out.flush();
                    }
                }
                if (!online) {
                    server.close();
                }
            }
        }
    }
}
