package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.printf("active %s \nstatus %s \nmessage %s \n\n",
                this.active, this.status, this.message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        Error errorLog = new Error(true, 5, "Внимание ошибка!");
        Error warning = new Error(true, 4, "Предупреждение!");
        Error info = new Error(false, 3, "Информационное сообщение!");
        errorLog.printInfo();
        warning.printInfo();
        info.printInfo();
    }
}
