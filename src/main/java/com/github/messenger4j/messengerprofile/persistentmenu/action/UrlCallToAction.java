package com.github.messenger4j.messengerprofile.persistentmenu.action;

import static java.util.Optional.empty;

import com.github.messenger4j.common.WebviewHeightRatio;
import com.github.messenger4j.common.WebviewShareButtonState;
import com.google.gson.annotations.SerializedName;
import java.net.URL;
import java.util.Optional;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * @author Max Grabenhorst
 * @since 1.0.0
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public final class UrlCallToAction extends CallToAction {

  private final URL url;
  private final Optional<WebviewHeightRatio> webviewHeightRatio;
  private final Optional<Boolean> messengerExtensions;
  private final Optional<URL> fallbackUrl;

  @SerializedName("webview_share_button")
  private final Optional<WebviewShareButtonState> webviewShareButtonState;

  private UrlCallToAction(
      String title,
      URL url,
      Optional<WebviewHeightRatio> webviewHeightRatio,
      Optional<Boolean> messengerExtensions,
      Optional<URL> fallbackUrl,
      Optional<WebviewShareButtonState> webviewShareButtonState) {
    super(Type.WEB_URL, title);
    this.url = url;
    this.webviewHeightRatio = webviewHeightRatio;
    this.messengerExtensions = messengerExtensions;
    this.fallbackUrl = fallbackUrl;
    this.webviewShareButtonState = webviewShareButtonState;
  }

  public static UrlCallToAction create(@NonNull String title, @NonNull URL url) {
    return create(title, url, empty());
  }

  public static UrlCallToAction create(
      @NonNull String title,
      @NonNull URL url,
      @NonNull Optional<WebviewHeightRatio> webviewHeightRatio) {
    return create(title, url, webviewHeightRatio, empty(), empty(), empty());
  }

  public static UrlCallToAction create(
      @NonNull String title,
      @NonNull URL url,
      @NonNull Optional<WebviewHeightRatio> webviewHeightRatio,
      @NonNull Optional<Boolean> messengerExtensions,
      @NonNull Optional<URL> fallbackUrl,
      @NonNull Optional<WebviewShareButtonState> webviewShareButtonState) {
    return new UrlCallToAction(
        title, url, webviewHeightRatio, messengerExtensions, fallbackUrl, webviewShareButtonState);
  }

    public static URL getUrl(URL url) {
        return url;
    }

    public static Optional<WebviewHeightRatio> getWebviewHeightRatio(Optional<WebviewHeightRatio> webviewHeightRatio) {
        return webviewHeightRatio;
    }

    public static Optional<Boolean> getMessengerExtensions(Optional<Boolean> messengerExtensions) {
        return messengerExtensions;
    }

    public static Optional<URL> getFallbackUrl(Optional<URL> fallbackUrl) {
        return fallbackUrl;
    }

    public static Optional<WebviewShareButtonState> getWebviewShareButtonState(Optional<WebviewShareButtonState> webviewShareButtonState) {
        return webviewShareButtonState;
    }
}
