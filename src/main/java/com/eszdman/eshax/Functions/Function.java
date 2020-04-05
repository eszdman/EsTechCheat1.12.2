package com.eszdman.eshax.Functions;

import com.eszdman.eshax.EsHax;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Function {
    public boolean active = false;
    public String name = "Defaulttt";
    public KeyBinding keybind;
    public boolean AddBind = false;
    public Function(){
        override();
    }
    public void override(){}
    public void turn(){
        active = !active;
        if(active) enable();
        else disable();
    }
    public void enable(){}
    public void disable(){}
    public void onTicks(TickEvent.ClientTickEvent event){}
    public void onLiving(LivingEvent.LivingUpdateEvent event) {}
    public void addkeybind(int key){
        KeyBinding keyb =  new KeyBinding(name, key,EsHax.MODID);
        if(AddBind) ClientRegistry.registerKeyBinding(keyb);
        keybind = keyb;
    }
}
