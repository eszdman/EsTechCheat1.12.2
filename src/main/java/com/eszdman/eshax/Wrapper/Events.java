package com.eszdman.eshax.Wrapper;
import com.eszdman.eshax.Functions.Function;
import com.eszdman.eshax.Functions.Functions;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

public class Events {
    @SubscribeEvent
    public void onGuiScreenDraw(GuiScreenEvent.DrawScreenEvent.Pre event) {
            if (event.getGui() instanceof GuiMainMenu) {
            GuiMainMenu menu = (GuiMainMenu) event.getGui();
            try {
                ReflectionHelper.setPrivateValue(GuiMainMenu.class, menu, "Eszdman's Technologies", Wrapper.getPrivateFields(GuiMainMenu.class).get(3).getName());
            } catch (Exception e){}
        }
    }
    @SubscribeEvent
    public void tick(InputEvent.KeyInputEvent event){
        for(Function func : Functions.functionList){
            if(func.AddBind && func.keybind.isPressed()) func.turn();
        }
    }
    @SubscribeEvent
    public void onTicks(TickEvent.ClientTickEvent event) {
        for(Function func : Functions.functionList){
            func.onTicks(event);
        }
    }
    @SubscribeEvent
    public void onLiving(LivingEvent.LivingUpdateEvent event) {
        for(Function func : Functions.functionList){
            func.onLiving(event);
        }
    }
}
