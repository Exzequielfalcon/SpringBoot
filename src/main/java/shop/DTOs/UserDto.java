package shop.DTOs;

public class UserDto {
    private int id;
    private String nick;
    private String pass;

    public UserDto(){}

    public UserDto(String nick, String pass) {
        this.nick = nick;
        this.pass = pass;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
