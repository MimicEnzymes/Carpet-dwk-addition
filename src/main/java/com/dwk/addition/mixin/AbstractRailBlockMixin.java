package com.dwk.addition.mixin;

import com.dwk.addition.DwkSettings;
import net.minecraft.block.AbstractRailBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractRailBlock.class)
public class AbstractRailBlockMixin {
    @Inject(method = "updateCurves", at = @At("HEAD"), cancellable = true)
    private void onUpdateCurves(BlockState state, World world, BlockPos pos, boolean notify, CallbackInfoReturnable<BlockState> cir) {
        if (DwkSettings.preventRailAutoConnection) {
            cir.setReturnValue(state);
        }
    }
}