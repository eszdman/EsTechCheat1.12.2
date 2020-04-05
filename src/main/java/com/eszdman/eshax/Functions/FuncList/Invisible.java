package com.eszdman.eshax.Functions.FuncList;

import com.eszdman.eshax.Functions.Function;
import com.eszdman.eshax.Wrapper.Wrapper;
import org.lwjgl.input.Keyboard;

public class Invisible extends Function {
    @Override
    public void override() {
        name = "Invisible";
        AddBind = true;
        addkeybind(Keyboard.KEY_B);
    }

    @Override
    public void turn() {
        active = !active;
        Wrapper.PlayerMP().setInvisible(active);
    }
}
