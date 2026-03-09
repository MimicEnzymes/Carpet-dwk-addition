package com.dwk.addition.mixin;

import com.dwk.addition.DwkSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FluidBlock.class)
public class FluidBlockMixin {
    @Inject(method = "receiveNeighborFluids", at = @At("HEAD"), cancellable = true)
    private void onReceiveNeighborFluids(World world, BlockPos pos, BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (DwkSettings.preventFluidInteraction) {
            cir.setReturnValue(true);
        }
    }
}
