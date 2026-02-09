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
            // 【修正】这里必须返回 true！
            // 返回 true 代表 "我还是流体，请继续计算我的流动 tick"
            // 返回 false 会导致游戏以为它变成了石头，从而停止流动
            cir.setReturnValue(true);
        }
    }
}