package us.illyohs.rlyeh.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ExtendedPos extends BlockPos {

    private transient World world = null;
    private int demId;

    public ExtendedPos(int x, int y, int z) {
        super(x, y, z);
        this.setWorld(defualtWorld());
    }

    public ExtendedPos(World world, int x, int y, int z) {
        super(x, y, z);
        this.setWorld(world);
    }

    public ExtendedPos(EntityPlayer player) {
        super((int)(player.posX + .5),(int)(player.posY - 1),(int)(player.posZ + .5));
        this.setWorld(player.worldObj);
    }

    public ExtendedPos(int x, int y, int z, int demId) {
        super(x, y, z);
        this.setDemId(demId);
    }

    public ExtendedPos(World worldObj, int x, int y, int z, EnumFacing face) {
        super(x, y, z);
    }

    public void setWorld(World world) {
        this.world = world;
//        demId =
    }

    public World getWorld() {
        return world;
    }

    public void setDemId(int demId) {
        this.demId = demId;
    }

    public int getDemId() {
        return demId;
    }

    public static World defualtWorld() {
        return MinecraftServer.getServer().worldServerForDimension(0);
    }

//    public Ex

}
