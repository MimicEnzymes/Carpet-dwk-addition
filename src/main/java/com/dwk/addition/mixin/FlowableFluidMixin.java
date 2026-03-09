package com.dwk.addition.mixin;

import com.dwk.addition.DwkSettings;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FlowableFluid.class)
public class FlowableFluidMixin {
        @Inject(method = "onScheduledTick", at = @At("HEAD"), cancellable = true)
    private void onTick(ServerWorld world, BlockPos pos, BlockState blockState, FluidState state, CallbackInfo ci) {
        if (DwkSettings.stopFluidFlow) ci.cancel();
    }
}
