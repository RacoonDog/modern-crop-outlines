package io.github.racoondog.crop.mixin;

import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(CropBlock.class)
public class CropBlockMixin extends PlantBlock {
    @Unique
    private static final float DELTA = 1f / 8f;

    @Unique
    private static final float OFFSET = 1f / 16f;

    @Override
    public Box getSelectionBox(World world, BlockPos pos) {
        this.setBoundingBox(world, pos);
        return super.getSelectionBox(world, pos);
    }

    @Override
    public void setBoundingBox(BlockView view, BlockPos pos) {
        BlockState blockState = view.getBlockState(pos);
        int age = blockState.get(CropBlock.AGE);
        this.setBoundingBox(0f, -OFFSET, 0f, 1f, DELTA * (age + 1), 1f);
    }
}
