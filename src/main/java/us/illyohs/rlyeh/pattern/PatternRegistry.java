package us.illyohs.rlyeh.pattern;

import java.util.ArrayList;

import us.illyohs.rlyeh.util.ExtendedPos;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PatternRegistry {
    
    public PatternRegistry() {
        MinecraftForge.EVENT_BUS.register(this);
    }
    public static ArrayList<PatternMeta> patReg = new ArrayList<PatternMeta>();

    public static void registerPattern(String modId, Pattern pattern) {
        patReg.add(new PatternMeta(modId, pattern));
    }
    
    @SubscribeEvent
    public void playerInteractEvent(PlayerInteractEvent event) {
        
        //Check to see if the player has punched a block
        if(event.entityPlayer.worldObj.isRemote && event.action == Action.RIGHT_CLICK_BLOCK && event.action != Action.RIGHT_CLICK_AIR) {
            //Search the surrounding blocks for a pattern
            patternMatcher(event.entityPlayer, new ExtendedPos(event.entityPlayer.worldObj, event.pos.getX(), event.pos.getY(),event.pos.getZ(), event.face));
            
        }
                //Do nothing if no pattern is found
    }

    public  void patternMatcher(EntityPlayer entityPlayer, ExtendedPos extendedPos) {
        
        //Fire event and execute patter if pattern is found
            
        // TODO Auto-generated method stub
        
    }
}
