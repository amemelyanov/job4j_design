package ru.job4j.template;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GeneratorTest {

    @Test
    public void normalArgsAndTemplate() {
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        Generator generator = new StringGenerator();
        String template = "I am a ${name}, Who are ${subject}? ";
        String expected = "I am a Petr Arsentev, Who are you? ";
        assertThat(generator.produce(template, args), is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void argsLessThanParamsTemplate() {
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        Generator generator = new StringGenerator();
        String template = "I am a ${name}, I am ${years} years old, Who are ${subject}? ";
        generator.produce(template, args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void argsMoreThanParamsTemplate() {
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        args.put("years", "34");
        Generator generator = new StringGenerator();
        String template = "I am a ${name}, Who are ${subject}? ";
        generator.produce(template, args);
    }
}
