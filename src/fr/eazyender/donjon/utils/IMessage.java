package fr.eazyender.donjon.utils;

public class IMessage {

    private int cooldown;
    private int timer;
    private String message;
    private boolean enable;

    public IMessage(String message, int cooldown){
        this.cooldown = cooldown;
        this.message = message;
        enable = true;
        timer = 0;
    }
    
    public IMessage(String message, int cooldown, int timer){
        this.cooldown = cooldown;
        this.message = message;
        enable = true;
        this.timer = timer;
    }

    public IMessage(String message, int cooldown, boolean enable){
        this.cooldown = cooldown;
        this.message = message;
        this.enable = enable;
        timer = 0;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public String getMessage() {
        return message;
    }

    public int getCooldown() {
        return cooldown;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
