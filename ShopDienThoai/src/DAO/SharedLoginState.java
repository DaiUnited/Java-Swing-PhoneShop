/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author daiun
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SharedLoginState {

    private static final String FILE_PATH = "user_status.txt";

    public static void writeStatus(String status) throws IOException {
        Files.write(Paths.get(FILE_PATH), status.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public static String readStatus() throws IOException {
        return new String(Files.readAllBytes(Paths.get(FILE_PATH)));
    }
}

