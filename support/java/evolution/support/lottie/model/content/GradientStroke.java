package evolution.support.lottie.model.content;

import android.support.annotation.Nullable;

import evolution.support.lottie.LottieDrawable;
import evolution.support.lottie.animation.content.Content;
import evolution.support.lottie.animation.content.GradientStrokeContent;
import evolution.support.lottie.model.animatable.AnimatableFloatValue;
import evolution.support.lottie.model.animatable.AnimatableGradientColorValue;
import evolution.support.lottie.model.animatable.AnimatableIntegerValue;
import evolution.support.lottie.model.animatable.AnimatablePointValue;
import evolution.support.lottie.model.layer.BaseLayer;

import java.util.List;

public class GradientStroke implements ContentModel {

  private final String name;
  private final GradientType gradientType;
  private final AnimatableGradientColorValue gradientColor;
  private final AnimatableIntegerValue opacity;
  private final AnimatablePointValue startPoint;
  private final AnimatablePointValue endPoint;
  private final AnimatableFloatValue width;
  private final ShapeStroke.LineCapType capType;
  private final ShapeStroke.LineJoinType joinType;
  private final List<AnimatableFloatValue> lineDashPattern;
  @Nullable private final AnimatableFloatValue dashOffset;

  public GradientStroke(String name, GradientType gradientType,
      AnimatableGradientColorValue gradientColor,
      AnimatableIntegerValue opacity, AnimatablePointValue startPoint,
      AnimatablePointValue endPoint, AnimatableFloatValue width, ShapeStroke.LineCapType capType,
      ShapeStroke.LineJoinType joinType, List<AnimatableFloatValue> lineDashPattern,
      @Nullable AnimatableFloatValue dashOffset) {
    this.name = name;
    this.gradientType = gradientType;
    this.gradientColor = gradientColor;
    this.opacity = opacity;
    this.startPoint = startPoint;
    this.endPoint = endPoint;
    this.width = width;
    this.capType = capType;
    this.joinType = joinType;
    this.lineDashPattern = lineDashPattern;
    this.dashOffset = dashOffset;
  }

  public String getName() {
    return name;
  }

  public GradientType getGradientType() {
    return gradientType;
  }

  public AnimatableGradientColorValue getGradientColor() {
    return gradientColor;
  }

  public AnimatableIntegerValue getOpacity() {
    return opacity;
  }

  public AnimatablePointValue getStartPoint() {
    return startPoint;
  }

  public AnimatablePointValue getEndPoint() {
    return endPoint;
  }

  public AnimatableFloatValue getWidth() {
    return width;
  }

  public ShapeStroke.LineCapType getCapType() {
    return capType;
  }

  public ShapeStroke.LineJoinType getJoinType() {
    return joinType;
  }

  public List<AnimatableFloatValue> getLineDashPattern() {
    return lineDashPattern;
  }

  @Nullable public AnimatableFloatValue getDashOffset() {
    return dashOffset;
  }

  @Override public Content toContent(LottieDrawable drawable, BaseLayer layer) {
    return new GradientStrokeContent(drawable, layer, this);
  }
}
