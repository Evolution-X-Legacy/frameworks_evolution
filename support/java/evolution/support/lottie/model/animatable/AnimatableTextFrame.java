package evolution.support.lottie.model.animatable;

import evolution.support.lottie.value.Keyframe;
import evolution.support.lottie.animation.keyframe.TextKeyframeAnimation;
import evolution.support.lottie.model.DocumentData;

import java.util.List;

public class AnimatableTextFrame extends BaseAnimatableValue<DocumentData, DocumentData> {

  public AnimatableTextFrame(List<Keyframe<DocumentData>> keyframes) {
    super(keyframes);
  }

  @Override public TextKeyframeAnimation createAnimation() {
    return new TextKeyframeAnimation(keyframes);
  }
}
