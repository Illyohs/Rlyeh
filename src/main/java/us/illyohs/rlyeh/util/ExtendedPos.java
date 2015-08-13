package us.illyohs.rlyeh.util;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3i;
import net.minecraft.world.World;

import java.util.ArrayList;

public class ExtendedPos extends BlockPos {

    private transient World world = null;
    private int             demId;
    private EnumFacing      face;

    public ExtendedPos(int x, int y, int z) {
        super(x, y, z);
        this.setWorld(defualtWorld());
    }

    public ExtendedPos(World world, int x, int y, int z) {
        super(x, y, z);
        this.setWorld(world);
    }

    public ExtendedPos(EntityPlayer player) {
        super((int) (player.posX + .5), (int) (player.posY - 1), (int) (player.posZ + .5));
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

    public ExtendedPos offsetWorld(World world, EnumFacing facing, int offset) {
        return new ExtendedPos(world, this.getX() + facing.getFrontOffsetX() * offset,
                this.getY() + facing.getFrontOffsetY() * offset, this.getZ() + facing.getFrontOffsetZ() * offset);
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

//    public ExtendedPos(ExtendedPos refrence, boolean counterClockwise) {
//        Vec3i d = new Vec3i(refrence.getX(), refrence.getY(), refrence.getZ());
//        int direction = counterClockwise ? -1 : 1;
//        EnumFacing facing;
//        if (refrence.face == facing.UP || refrence.face == facing.DOWN) return refrence.offsetWorld(getWorld(), facing,d.getX() * refrence)
//    }

    public World getWorld() {
        return world;
    }

    public void setDemId(int demId) {
        this.demId = demId;
    }

    public int getDemId() {
        return this.getWorld().provider.getDimensionId();
    }

    public World defualtWorld() {
        return MinecraftServer.getServer().worldServerForDimension(0);
    }

    public Block getBlock() {
        return this.getWorld().getBlockState(new ExtendedPos(getX(), getY(), getZ())).getBlock();
    }

    public IBlockState getState() {
        return getWorld().getBlockState(new ExtendedPos(getX(), getY(), getZ()));
    }

    public SigBlock getSigBlock() {
        return new SigBlock(getBlock(), getState());
    }

    public boolean setBlockStateUpdate(IBlockState blockState) {
        if (blockState == Blocks.bedrock || getBlock() == Blocks.bedrock) {
            return false;
        } else {
            return this.getWorld().setBlockState(new ExtendedPos(getX(), getY(), getZ()), blockState);
        }
    }

    public boolean setBlockSig(SigBlock sigBlock) {
        if (sigBlock.equals(Blocks.bedrock) || getBlock() == Blocks.bedrock) {
            return false;
        } else {
            return this.getWorld().setBlockState(new ExtendedPos(getX(), getY(), getZ()), sigBlock.state);
        }
    }

    public double getDistance(ExtendedPos ePos) {
        double dist = (getX() - ePos.getX()) * (getY() - ePos.getY()) * (getZ() - ePos.getZ());
        return Math.sqrt(dist + (getY() - ePos.getY()) * (getY() - ePos.getY()));
    }

    public ArrayList<BlockPos> getDirectNeighbors() {
        ArrayList<BlockPos> neighbores = new ArrayList<BlockPos>();
        neighbores.add(offset(EnumFacing.UP));
        neighbores.add(offset(EnumFacing.DOWN));
        neighbores.add(offset(EnumFacing.EAST));
        neighbores.add(offset(EnumFacing.WEST));
        neighbores.add(offset(EnumFacing.NORTH));
        neighbores.add(offset(EnumFacing.SOUTH));

        return neighbores;
    }

}
