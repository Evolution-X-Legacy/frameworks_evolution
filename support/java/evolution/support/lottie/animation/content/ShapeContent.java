package evolution.support.lottie.animation.content;

import android.graphics.Path;
import android.support.annotation.Nullable;

import evolution.support.lottie.LottieDrawable;
import evolution.support.lottie.animation.keyframe.BaseKeyframeAnimation;
import evolution.support.lottie.model.content.ShapePath;
import evolution.support.lottie.model.content.ShapeTrimPath;
import evolution.support.lottie.model.layer.BaseLayer;
import evolution.support.lottie.utils.Utils;

import java.util.List;

public class ShapeContent implements PathContent, BaseKeyframeAnimation.AnimationListener {
  private final Path path = new Path();

  private final String name;
  private final LottieDrawable lottieDrawable;
  private final BaseKeyframeAnimation<?, Path> shapeAnimation;

  private boolean isPathValid;
  @Nullable private TrimPathContent trimPath;

  public ShapeContent(LottieDrawable lottieDrawable, BaseLayer layer, ShapePath shape) {
    name = shape.getName();
    this.lottieDrawable = lottieDrawable;
    shapeAnimation = shape.getShapePath().createAnimation();
    layer.addAnimation(shapeAnimation);
    shapeAnimation.addUpdateListener(this);
  }

  @Override public void onValueChanged() {
    invalidate();
  }

  private void invalidate() {
    isPathValid = false;
    lottieDrawable.invalidateSelf();
  }

  @Override public void setContents(List<Content> contentsBefore, List<Content> contentsAfter) {
    for (int i = 0; i < contentsBefore.size(); i++) {
      Content content = contentsBefore.get(i);
      if (content instanceof TrimPathContent &&
          ((TrimPathContent) content).getType() == ShapeTrimPath.Type.Simultaneously) {
        // Trim path individually will be handled by the stroke where paths are combined.
        trimPath = (TrimPathContent) content;
        trimPath.addListener(this);
      }
    }
  }

  @Override public Path getPath() {
    if (isPathValid) {
      return path;
    }

    path.reset();

    path.set(shapeAnimation.getValue());
    path.setFillType(Path.FillType.EVEN_ODD);

    Utils.applyTrimPathIfNeeded(path, trimPath);

    isPathValid = true;
    return path;
  }

  @Override public String getName() {
    return name;
  }
}
