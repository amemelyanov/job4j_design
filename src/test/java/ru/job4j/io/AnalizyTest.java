package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {
    @Test
    public void whenLogWithServerDown() {
        String source = "./data/source_log_with_server_down.log";
        String target = "./data/target_log_with_server_down.log";
        Analizy analizy = new Analizy();
        analizy.unavailable(source, target);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader read = new BufferedReader(new FileReader(target))) {
            read.lines().forEach(builder::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(builder.toString(), is("10:57:01;10:59:0111:01:02;11:02:02"));
    }

    @Test
    public void whenLogIsEmpty() {
        String source = "./data/source_log_is_empty.log";
        String target = "./data/target_log_is_empty.log";
        Analizy analizy = new Analizy();
        analizy.unavailable(source, target);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader read = new BufferedReader(new FileReader(target))) {
            read.lines().forEach(builder::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(builder.toString(), is(""));
    }

    @Test
    public void whenServerWorksFullTime() {
        String source = "./data/source_server_works_full_time.log";
        String target = "./data/target_server_works_full_time.log";
        Analizy analizy = new Analizy();
        analizy.unavailable(source, target);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader read = new BufferedReader(new FileReader(target))) {
            read.lines().forEach(builder::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(builder.toString(), is(""));
    }
}
