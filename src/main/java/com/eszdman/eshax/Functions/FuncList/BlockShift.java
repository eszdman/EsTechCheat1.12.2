package com.eszdman.eshax.Functions.FuncList;

import com.eszdman.eshax.Functions.Function;
import com.eszdman.eshax.Wrapper.Datatypes.Vec3;
import com.eszdman.eshax.Wrapper.Wrapper;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class BlockShift extends Function {
    Vec3 coords;
    Vec3d camera;
    boolean start = true;
    boolean shift = false;
    float oldR =0;
    float oldL = 0;
    long cnt = 0;
    double shiftspeed = 0.1;
    @Override
    public void override() {
        name = "BlockShift";
        AddBind = false;
        addkeybind(Keyboard.KEY_G);
    }

    @Override
    public void onTicks(TickEvent.ClientTickEvent event) {
        if(keybind.isKeyDown()){
            if(start){
                cnt = 0;
                oldR = Wrapper.PlayerMP().rotationPitch;
                oldL = Wrapper.PlayerMP().rotationYaw;
            try {
                coords = new Vec3(Wrapper.PlayerMP().posX,Wrapper.PlayerMP().posY,Wrapper.PlayerMP().posZ);
            } catch (Exception e){}
            }
            Wrapper.PlayerMP().rotationPitch = oldR;
            Wrapper.PlayerMP().rotationYaw = oldL;

            if(cnt % 12 < 9) { shift = true;} else shift = false;
                if(shift)Wrapper.PlayerMP().rotationPitch = -69.9911f*2f*((cnt%2)-0.5f);
                camera = Wrapper.PlayerMP().getLookVec();
                //System.out.println("Vector:"+camera.x+" "+camera.y+" "+camera.z);
                //System.out.println("pitch" + Wrapper.PlayerMP().rotationPitch);
                //System.out.println("yaw" + Wrapper.PlayerMP().rotationYaw);
                camera.normalize();

                Wrapper.PlayerMP().motionX = 0;
                Wrapper.PlayerMP().motionY = 0;
                Wrapper.PlayerMP().motionZ = 0;
                coords.x += camera.x * shiftspeed;
                if(!shift)coords.y += camera.y * shiftspeed;
                else coords.y += camera.y * shiftspeed;
                coords.z += camera.z * shiftspeed;
                Wrapper.PlayerMP().setPosition(coords.x, coords.y, coords.z);
                Wrapper.PlayerMP().entityCollisionReduction = 0;
            if(start){ start = false;}
            cnt++;
        }
        if(!keybind.isKeyDown() && !start) {
            Wrapper.PlayerMP().rotationPitch =oldR;
            Wrapper.PlayerMP().rotationYaw = oldL;
            start = true;}
    }
}
