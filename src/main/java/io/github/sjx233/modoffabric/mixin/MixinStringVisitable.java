package io.github.sjx233.modoffabric.mixin;

import java.util.Optional;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import io.github.sjx233.modoffabric.Of;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Style;

@Mixin(StringVisitable.class)
public interface MixinStringVisitable {
  /**
   * @author sjx233
   * @reason Cannot {@code @ModifyVariable} in interface
   */
  @Overwrite
  static StringVisitable plain(String str) {
    return new StringVisitable() {
      public <T> Optional<T> visit(StringVisitable.Visitor<T> visitor) {
        return visitor.accept(str);
      }

      public <T> Optional<T> visit(StringVisitable.StyledVisitor<T> styledVisitor, Style parentStyle) {
        return styledVisitor.accept(parentStyle, Of.transform(str));
      }
    };
  }

  /**
   * @author sjx233
   * @reason Cannot {@code @ModifyVariable} in interface
   */
  @Overwrite
  static StringVisitable styled(String str, Style style) {
    return new StringVisitable() {
      public <T> Optional<T> visit(StringVisitable.Visitor<T> visitor) {
        return visitor.accept(str);
      }

      public <T> Optional<T> visit(StringVisitable.StyledVisitor<T> styledVisitor, Style parentStyle) {
        return styledVisitor.accept(style.withParent(parentStyle), Of.transform(str));
      }
    };
  }
}
