package com.dwk.addition.mixin;

import com.dwk.addition.DwkSettings;
import net.minecraft.block.BlockState; // 【新增】必须引入 BlockState
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
    // 【关键修复】
    // 旧写法: onTick(ServerWorld world, BlockPos pos, FluidState state, CallbackInfo ci)
    // 新写法: onTick(ServerWorld world, BlockPos pos, BlockState blockState, FluidState state, CallbackInfo ci)
    // 中间加了一个 BlockState blockState，顺序必须严格匹配游戏底层代码！
    
    @Inject(method = "onScheduledTick", at = @At("HEAD"), cancellable = true)
    private void onTick(ServerWorld world, BlockPos pos, BlockState blockState, FluidState state, CallbackInfo ci) {
        if (DwkSettings.stopFluidFlow) ci.cancel();
    }
}