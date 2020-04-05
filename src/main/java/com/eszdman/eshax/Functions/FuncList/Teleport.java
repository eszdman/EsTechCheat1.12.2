package com.eszdman.eshax.Functions.FuncList;

import com.eszdman.eshax.Functions.Function;
import com.eszdman.eshax.Wrapper.Datatypes.Vec3;
import com.eszdman.eshax.Wrapper.Wrapper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.event.entity.living.LivingEvent;
import org.lwjgl.input.Keyboard;

public class Teleport extends Function {
    int length = 4;
    int height = 64;
    int cnt = 0;
    int times = 0;
    int stage = 0;
    Vec3d vec;
    @Override
    public void override() {
        name = "Teleport";
        AddBind = true;
        addkeybind(Keyboard.KEY_Y);

    }

    @Override
    public void turn() {
        move(Wrapper.PlayerMP().getLookVec());
    }

    void setPos(Vec3d newPos){
        Wrapper.PlayerMP().setPosition(newPos.x,newPos.y,newPos.z);
    }
    void move(Vec3d vector){
        Wrapper.PlayerMP().setPosition(Wrapper.PlayerMP().posX+vector.x*length,Wrapper.PlayerMP().posY+vector.y*length,Wrapper.PlayerMP().posZ+vector.z*length);
    }
    void LegalTeleport(Vec3d vector){
        vector.normalize();
        //movetimes(new Vec3d(0,1,0),256);
        times = 256;
        for(int i = 0; i<length; i++){
            move(vector);
        }
        //movetimes(new Vec3d(0,-1,0),256);
    }
}
