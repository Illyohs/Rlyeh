package us.illyohs.rlyeh.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3i;
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

    public ExtendedPos(World world, int x, int y, int z, EnumFacing face) {
        super(x, y, z);
        this.setWorld(world);
    }

    public ExtendedPos offsetWorld(World world, EnumFacing facing,  int offset) {
        return new ExtendedPos(world, this.getX() + facing.getFrontOffsetX() * offset, this.getY() + facing.getFrontOffsetY() * offset, this.getZ() + facing.getFrontOffsetZ() * offset);
    }

    public ExtendedPos add(World world, int add) {
        return new ExtendedPos(world, this.getX() + add, this.getY() + add, this.getZ() + add);
    }

    public ExtendedPos add(World world, Vec3i vec) {
        return new ExtendedPos(world, vec.getX(), vec.getY(), vec.getZ());
    }

    public ExtendedPos offsetWorldUp(World world, int offset) {
       return this.offsetWorld(world, EnumFacing.UP, offset);
    }

    public ExtendedPos offsetWorldDown(World world, int offset) {
        return this.offsetWorld(world, EnumFacing.DOWN, offset);
    }

    public ExtendedPos offsetWorldNorth(World world, int offset) {
        return this.offsetWorld(world, EnumFacing.NORTH, offset);
    }

    public ExtendedPos offsetWorldSouth(World world, int offset) {
        return this.offsetWorld(world, EnumFacing.SOUTH, offset);
    }

    public ExtendedPos offsetWorldEast(World world, int offset) {
        return this.offsetWorld(world, EnumFacing.EAST, offset);
    }

    public ExtendedPos offsetWorldWest(World world, int offset) {
        return this.offsetWorld(world, EnumFacing.WEST, offset);
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
