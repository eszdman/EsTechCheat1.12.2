package com.eszdman.eshax.Wrapper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class Wrapper {
    public static Minecraft mc;
    public static void init(){
        mc = Minecraft.getMinecraft();
    }
    public static EntityPlayerSP PlayerMP(){ return mc.player; }
    public static PlayerControllerMP PlayerConMP(){
        return mc.playerController;
    }
    public static List<Field> getPrivateFields(Class SomeClass){
        List<Field> privateFields = new ArrayList<>();
        Field[] allFields = SomeClass.getDeclaredFields();
        for (Field field : allFields) {
            if (Modifier.isPrivate(field.getModifiers())) {
                privateFields.add(field);
            }
        }
        return privateFields;
    }
}
