package com.eszdman.eshax.Functions.FuncList;

import com.eszdman.eshax.Functions.Function;
import com.eszdman.eshax.Wrapper.Wrapper;
import org.lwjgl.input.Keyboard;

public class FullBright extends Function {
    private float oldbr;
    @Override
    public void override() {
        name = "FullBright";
        AddBind = true;
        addkeybind(Keyboard.KEY_C);

    }

    @Override
    public void enable() {
        oldbr = Wrapper.mc.gameSettings.gammaSetting;
        Wrapper.mc.gameSettings.gammaSetting = 100;
    }

    @Override
    public void disable() {
        Wrapper.mc.gameSettings.gammaSetting = oldbr;
    }
}
