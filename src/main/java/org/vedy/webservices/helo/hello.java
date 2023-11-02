package org.vedy.webservices.helo;

public class hello {
    private String name;
    private String message;

    public hello(String name, String Message) {
        this.name = name;
        this.message = Message;
    }

    @Override
    public String toString() {
        return "hello{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
