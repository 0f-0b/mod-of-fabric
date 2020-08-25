package io.github.sjx233.modoffabric.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.sjx233.modoffabric.Of;
import net.minecraft.text.LiteralText;

@Mixin(LiteralText.class)
public abstract class MixinLiteralText {
  @Shadow
  @Final
  private String string;

  @Inject(method = "asString", at = @At("RETURN"), cancellable = true)
  public void asString(CallbackInfoReturnable<String> ci) {
    ci.setReturnValue(Of.transform(ci.getReturnValue()));
  }
}
