package dk.sdu.cbse.common;

import dk.sdu.cbse.common.services.IPluginService;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GameInput {
    private HashSet<Integer> pressed = new HashSet<>();

    public HashSet<Integer> getPressed() {
        return pressed;
    }

    public void setPressed(int pressed, boolean state) {
        if (state) {
            this.pressed.add(pressed);
        } else {
            this.pressed.remove(pressed);
        }
    }
    public String getKeyName(int key) {
        // Why is there no standard method for this T-T
        for (KeyCode kc : KeyCode.values()) {
            if (kc.getCode() == key) {
                return kc.getName();
            }
        }
        return null;
    }
    public int getKeyNumber(String key) {
        return KeyCode.valueOf(key).getCode();
    }


    public boolean isPressed(int k) {
        return getPressed().contains(k);
    }

}
