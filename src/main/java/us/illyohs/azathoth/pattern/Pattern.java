package us.illyohs.azathoth.pattern;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import us.illyohs.azathoth.math.Vector3;
import us.illyohs.azathoth.util.ExtendedPos;
import us.illyohs.azathoth.util.SigBlock;

public abstract class Pattern {

    public String  name = null;
    public boolean isFlat;
    public boolean canPlayerActivate;

    public Pattern() {}
    
    protected abstract Block[][][] template();
    
    public void execute(BlockPos coords, EntityPlayer player, Vector3 forward) {
        
    }
    
    public abstract void execute(BlockPos coords, EntityPlayer player);
    
    protected HashMap<ExtendedPos, SigBlock> runicFormulae(ExtendedPos coords){
        if(getIsFlat()) {
            coords = coords.copyWithNewFacing(1); //we need a new object so we don't side-effect other runes            
        }
        return patternToShape(template(), coords); 
    }
    
    private HashMap<ExtendedPos, SigBlock> patternToShape(Block[][][] template, ExtendedPos coords) {
        // TODO Auto-generated method stub
        return null;
    }

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
