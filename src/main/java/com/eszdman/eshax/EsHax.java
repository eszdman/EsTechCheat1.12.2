package com.eszdman.eshax;

import com.eszdman.eshax.Functions.Functions;
import com.eszdman.eshax.Wrapper.Events;
import com.eszdman.eshax.Wrapper.Wrapper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.common.MinecraftForge;

@SideOnly(Side.CLIENT)
@Mod(modid = EsHax.MODID, name = EsHax.MODID, version = EsHax.VERSION)
public class EsHax {
    public static final String MODID = "eshax";
    public static final String VERSION = "1.0";
    @Mod.Instance(value = EsHax.MODID)
    public static EsHax INSTANCE;
    public static boolean loaded = false;
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        INSTANCE = this;
        Wrapper.init();
        Functions.InitAll();
        EventRegister.register(MinecraftForge.EVENT_BUS,new Events());
        EventRegister.register(FMLCommonHandler.instance().bus(), new Events());
        loaded = true;
    }
}