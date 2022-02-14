package me.toto7735.totoMod.mixin;

import net.minecraft.client.gui.AbstractParentElement;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Screen.class)
public abstract class ScreenMixin extends AbstractParentElement implements Drawable {
    @Inject(
            method = "renderBackground(Lnet/minecraft/client/util/math/MatrixStack;I)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/screen/Screen;fillGradient(Lnet/minecraft/client/util/math/MatrixStack;IIIIII)V"
            ),
            cancellable = true
    )
    
    public void renderBackground(MatrixStack stack, int vOffset, CallbackInfo ci) {
        ci.cancel();
    }
}