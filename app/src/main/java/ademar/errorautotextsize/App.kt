package ademar.errorautotextsize

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.provider.FontRequest
import androidx.emoji.text.EmojiCompat
import androidx.emoji.text.FontRequestEmojiCompatConfig

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        EmojiCompat.init(
            FontRequestEmojiCompatConfig(
                this,
                FontRequest(
                    "com.google.android.gms.fonts",
                    "com.google.android.gms",
                    "Noto Color Emoji Compat",
                    R.array.com_google_android_gms_fonts_certs
                )
            ).setReplaceAll(true)
                .setUseEmojiAsDefaultStyle(true)
                .setEmojiSpanIndicatorEnabled(true)
                .registerInitCallback(object : EmojiCompat.InitCallback() {
                    override fun onFailed(throwable: Throwable?) {
                        throw Exception(throwable)
                    }
                })
        )
    }
}
