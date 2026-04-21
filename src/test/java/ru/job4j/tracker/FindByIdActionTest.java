package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindByIdActionTest {
    @Test
    void whenFindByIdItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input input = new MockInput(
                new String[]{"0", String.valueOf(one.getId()), "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindByIdAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод заявки по id ===" + ln
                        + one + ln
                        + "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }
}
