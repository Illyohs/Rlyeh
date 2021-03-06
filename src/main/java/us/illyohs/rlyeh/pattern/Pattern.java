package us.illyohs.rlyeh.pattern;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public abstract class Pattern {

    public String  name = null;
    public boolean isFlat;
    public boolean canPlayerActivate;

    public Pattern() {}
    
    protected abstract Block[][][] template();
    
    public void execute(BlockPos coords, EntityPlayer player, EnumFacing facing) {
        
    }
    
    public abstract void execute(BlockPos coords, EntityPlayer player);

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return is flat
     */
    public boolean getIsFlat() {
        return isFlat;
    }
    
    /**
     * @param isFlat the isFlat to set
     */
    public void setFlat(boolean isFlat) {
        this.isFlat = isFlat;
    }
    
    /**
     * @return canPlayerActivate
     */
    
    public boolean getCanPlayerActivate() {
        return canPlayerActivate;
    }
    
    /**
     * @param canPlayerActivate the canPlayerActivate to set
     */
    public void setCanPlayerActivate(boolean canPlayerActivate) {
        this.canPlayerActivate = canPlayerActivate;
    }
    
    
}
