package com.github.messenger4j.send.message.template.common;

import static com.github.messenger4j.send.message.template.button.Button.Type.WEB_URL;
import static java.util.Optional.empty;

import com.github.messenger4j.common.WebviewHeightRatio;
import com.github.messenger4j.common.WebviewShareButtonState;
import com.github.messenger4j.send.message.template.button.Button;
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
@ToString
@EqualsAndHashCode
public final class DefaultAction {

  private final Button.Type type;
  private final URL url;
  private final Optional<WebviewHeightRatio> webviewHeightRatio;
  private final Optional<Boolean> messengerExtensions;
  private final Optional<URL> fallbackUrl;

  @SerializedName("webview_share_button")
  private final Optional<WebviewShareButtonState> webviewShareButtonState;

  private DefaultAction(
      URL url,
      Optional<WebviewHeightRatio> webviewHeightRatio,
      Optional<Boolean> messengerExtensions,
      Optional<URL> fallbackUrl,
      Optional<WebviewShareButtonState> webviewShareButtonState) {
    this.type = WEB_URL;
    this.url = url;
    this.webviewHeightRatio = webviewHeightRatio;
    this.messengerExtensions = messengerExtensions;
    this.fallbackUrl = fallbackUrl;
    this.webviewShareButtonState = webviewShareButtonState;
  }

  public static DefaultAction create(@NonNull URL url) {
    return create(url, empty());
  }

  public static DefaultAction create(
      @NonNull URL url, @NonNull Optional<WebviewHeightRatio> webviewHeightRatio) {
    return create(url, webviewHeightRatio, empty(), empty(), empty());
  }

  public static DefaultAction create(
      @NonNull URL url,
      @NonNull Optional<WebviewHeightRatio> webviewHeightRatio,
      @NonNull Optional<Boolean> messengerExtensions,
      @NonNull Optional<URL> fallbackUrl,
      @NonNull Optional<WebviewShareButtonState> webviewShareButtonState) {
    return new DefaultAction(
        url, webviewHeightRatio, messengerExtensions, fallbackUrl, webviewShareButtonState);
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
