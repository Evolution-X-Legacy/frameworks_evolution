package evolution.support.lottie.model.animatable;

import evolution.support.lottie.value.Keyframe;
import evolution.support.lottie.animation.keyframe.BaseKeyframeAnimation;
import evolution.support.lottie.animation.keyframe.GradientColorKeyframeAnimation;
import evolution.support.lottie.model.content.GradientColor;

import java.util.List;

public class AnimatableGradientColorValue extends BaseAnimatableValue<GradientColor,
    GradientColor> {
  public AnimatableGradientColorValue(
      List<Keyframe<GradientColor>> keyframes) {
    super(keyframes);
  }

  @Override public BaseKeyframeAnimation<GradientColor, GradientColor> createAnimation() {
    return new GradientColorKeyframeAnimation(keyframes);
  }
}
