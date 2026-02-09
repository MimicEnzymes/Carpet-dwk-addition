package com.dwk.addition.mixin;
import com.dwk.addition.DwkSettings;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.fluid.Fluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
@Mixin(LavaFluid.class)
public class LavaFluidMixin {
    @Redirect(method = "flow", at = @At(value = "INVOKE", target = "Lnet/minecraft/fluid/FluidState;isIn(Lnet/minecraft/registry/tag/TagKey;)Z"))
    private boolean interceptWaterCheck(FluidState instance, TagKey<Fluid> tag) {
        if (tag == FluidTags.WATER && DwkSettings.preventFluidInteraction) return false;
        return instance.isIn(tag);
    }
}