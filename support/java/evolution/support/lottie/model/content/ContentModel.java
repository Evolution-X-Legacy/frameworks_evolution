package evolution.support.lottie.model.content;


import android.support.annotation.Nullable;

import evolution.support.lottie.LottieDrawable;
import evolution.support.lottie.animation.content.Content;
import evolution.support.lottie.model.layer.BaseLayer;

public interface ContentModel {
  @Nullable Content toContent(LottieDrawable drawable, BaseLayer layer);
}
