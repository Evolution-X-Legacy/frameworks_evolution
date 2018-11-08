package evolution.support.lottie.model.animatable;

import android.graphics.Path;

import evolution.support.lottie.value.Keyframe;
import evolution.support.lottie.animation.keyframe.BaseKeyframeAnimation;
import evolution.support.lottie.animation.keyframe.ShapeKeyframeAnimation;
import evolution.support.lottie.model.content.ShapeData;

import java.util.List;

public class AnimatableShapeValue extends BaseAnimatableValue<ShapeData, Path> {

  public AnimatableShapeValue(List<Keyframe<ShapeData>> keyframes) {
    super(keyframes);
  }

  @Override public BaseKeyframeAnimation<ShapeData, Path> createAnimation() {
    return new ShapeKeyframeAnimation(keyframes);
  }
}
